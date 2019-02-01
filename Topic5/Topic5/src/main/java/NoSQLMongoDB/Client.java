/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NoSQLMongoDB;

import NoSQLMongoDB.DAOS.NoteDAO;
import NoSQLMongoDB.DAOS.StudentDAO;
import NoSQLMongoDB.Entity.Notes;
import NoSQLMongoDB.Entity.Student;
import com.mongodb.MongoClient;
import org.bson.types.ObjectId;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.QueryResults;

/**
 *
 * @author Adrian
 */
public class Client {

    public static void main(String[] args) {
        String dbName = new String("high_school");
        MongoClient mongo = new MongoClient();
        Morphia morphia = new Morphia();
        Datastore datastore = morphia.createDatastore(mongo, dbName);
        morphia.mapPackage("NoSQLMongoDB/*");

        //------------------- QUERY --------------------//
        // Fetch all students whose notes in a specific course were greater than 4
        NoteDAO noteDAO = new NoteDAO(mongo, morphia, dbName);
        Query<Notes> query = datastore.createQuery(Notes.class);
        query.and(query.criteria("final_note").greaterThan(4),
                query.criteria("id_course").equal(new ObjectId("000000000000000000000001")));

        QueryResults<Notes> notesGreaterThanFour = noteDAO.find(query);

        StudentDAO studentDAO = new StudentDAO(mongo, morphia, dbName);

        for (Notes notes : notesGreaterThanFour) {
            Query<Student> query2 = datastore.createQuery(Student.class);
            query2.and(query2.criteria("_id").equal(notes.getStudent()));
            QueryResults<Student> student = studentDAO.find(query2);
            System.out.println("First name: " + student.get().getFirst_name() + " Last name: " + student.get().getLast_name() + " Final note: " + notes.getFinal_note());
        }
    }
}
