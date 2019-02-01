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
import NoSQLMongoDB.Entity.Student;
import org.mongodb.morphia.Morphia;
import org.mongodb.morphia.dao.BasicDAO;

import com.mongodb.MongoClient;

public class StudentDAO extends BasicDAO<Student,String> {

	public StudentDAO(MongoClient mongoClient, Morphia morphia, String dbName) {
		super(mongoClient, morphia, dbName);
	}

}