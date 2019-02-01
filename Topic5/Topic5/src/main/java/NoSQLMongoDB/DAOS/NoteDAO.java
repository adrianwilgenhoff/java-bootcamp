/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NoSQLMongoDB.DAOS;

/**
 *
 * @author Adrian
 */
import NoSQLMongoDB.Entity.Notes;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;
import com.mongodb.MongoClient;

public class NoteDAO extends BasicDAO<Notes,String>{

	public NoteDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
		super(mongoClient, morphia, dbName);
	}

}