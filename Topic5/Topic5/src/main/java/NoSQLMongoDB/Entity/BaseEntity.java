/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NoSQLMongoDB.Entity;

import org.bson.types.ObjectId;
import org.mongodb.morphia.annotations.Id;
import org.mongodb.morphia.annotations.Property;

/**
 *
 * @author Adrian
 */
public abstract class BaseEntity {
	 
    @Id
    @Property("_id")
    protected ObjectId _id;
 
    public BaseEntity() {
        super();
    }
 
    public ObjectId getId() {
        return _id;
    }
 
    public void setId(String i) {
        this._id = new ObjectId(i);
    }
 

 
}