/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ExerciseJDBC;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author Adrian
 */
public class Exercise7 {

    public static void main(String[] args) {

        try {
            Connection myConnection = DriverManager.getConnection("jdbc:mysql://localhost:3306/high_school", "root", "");

            System.out.println("CONNECTION SUCCESFULL");

            Statement myStatement = myConnection.createStatement();

            System.out.println("Execute Query");
            
            ResultSet myResulset = myStatement.executeQuery("SELECT t.firstname,t.lastname, c.name, s.days_on_week, s.schedule_Initial_time, s.schedule_final_time FROM course c"
			+" INNER JOIN teacher t ON c.id_teacher_assigned = t.id_teacher"
			+" INNER JOIN schedule s ON c.id_course = s.id_course"
                        +" WHERE t.lastname = 'ISLAS'"
                        +" ORDER BY FIELD (s.days_on_week,'Monday','Tuesday','Wednesday','Thursday','Friday','Saturday','Sunday')");
            
            myResulset.next();
            System.out.println("Teacher: " + myResulset.getString(1)+ " " + myResulset.getString(2) + "\nSchedule: ");
            myResulset.previous();
            while (myResulset.next()) {

                System.out.println(myResulset.getString(4) + " " + myResulset.getString(5) + " - " + myResulset.getString(6) + " : " + myResulset.getString(3));

            }

        } catch (SQLException e) {
            System.out.println("CONNECTION REFUSED");
            e.printStackTrace();
        }

    }

}
