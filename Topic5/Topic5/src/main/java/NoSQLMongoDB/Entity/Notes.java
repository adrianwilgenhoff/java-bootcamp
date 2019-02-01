/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NoSQLMongoDB.Entity;

/**
 *
 * @author Adrian
 */
import org.bson.types.ObjectId;

public class Notes extends BaseEntity {

    private ObjectId id_course;
    private ObjectId id_student;
    private int first_note;
    private int second_note;
    private int third_note;
    private int final_note;

    public Notes() {
    }

    public Notes(ObjectId id_course, ObjectId id_student, int first_note, int second_note, int third_note, int final_note) {
        this.id_course = id_course;
        this.id_student = id_student;
        this.first_note = first_note;
        this.second_note = second_note;
        this.third_note = third_note;
        this.final_note = final_note;
    }

    public ObjectId getStudent() {
        return id_student;
    }

    public void setStudent(ObjectId id_student) {
        this.id_student = id_student;
    }

    public ObjectId getCourse() {
        return id_course;
    }

    public void setCourse(ObjectId course) {
        this.id_course = course;
    }

    public int getFirst_note() {
        return first_note;
    }

    public void setFirst_note(int first_note) {
        this.first_note = first_note;
    }

    public int getSecond_note() {
        return second_note;
    }

    public void setSecond_note(int second_note) {
        this.second_note = second_note;
    }

    public int getThird_note() {
        return third_note;
    }

    public void setThird_note(int third_note) {
        this.third_note = third_note;
    }

    public int getFinal_note() {
        return final_note;
    }

    public void setFinal_note(int final_note) {
        this.final_note = final_note;
    }

}
