/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package NoSQLMongoDB.Entity;

import java.util.List;
import org.mongodb.morphia.annotations.Embedded;

/**
 *
 * @author Adrian
 */
public class Course extends BaseEntity {

    private String course_name;
    @Embedded
    private Teacher id_teacher;
    private Integer hours_by_week;
    @Embedded
    private List<Schedule> schedules;

    public Course() {
    }

    public Course(String course_name, Teacher id_teacher, Integer hours_by_week, List<Schedule> schedules) {
        this.course_name = course_name;
        this.id_teacher = id_teacher;
        this.hours_by_week = hours_by_week;
        this.schedules = schedules;
    }

    public String getCourse_Name() {
        return course_name;
    }

    public void setCourse_Name(String course_name) {
        this.course_name = course_name;
    }

    public Teacher getId_teacher() {
        return id_teacher;
    }

    public void setId_teacher(Teacher id_teacher) {
        this.id_teacher = id_teacher;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Integer getHours_by_week() {
        return hours_by_week;
    }

    public void setHours_by_week(Integer hours_by_week) {
        this.hours_by_week = hours_by_week;
    }

}
