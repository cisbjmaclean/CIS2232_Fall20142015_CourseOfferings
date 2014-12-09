/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package database;

import beans.Report;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.*;

/**
 *
 * @author dmaclean31977
 */
public class ReportDAO {
    
    /**
     * @return returns a collection of Report instances
     * @param sequenceCodeValue code value used to hold each academic year value
     * This method is used to obtain all courses in a given year.
     */
    public static ArrayList<Report> getReport(int sequenceCodeValue) {
        // variable courses is used to hold the collection and return the collection
        // to the reportbo
        ArrayList<Report> courses = new ArrayList();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        
        try {
            // connec to the database and search for all courses from the
            // academic year user chose
            conn = ConnectionUtils.getConnection();
            sql = "SELECT * FROM `course` WHERE academic_year = '" +sequenceCodeValue + "'";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            // loop through each row from query
            while (rs.next()) {
                // initialize a Report object and assign the attributes of the object
                Report report = new Report();
                report.setAcademicYearCode(sequenceCodeValue);
                report.setCourseId(rs.getString("course_id"));
                report.setCourseStartDate(rs.getString("course_start_date"));
                report.setCourseEndDate(rs.getString("course_end_date"));
                report.setCoursePrereqs(rs.getString("course_prerequisites"));
                report.setCourseCoreqs(rs.getString("course_co_requisites"));
                report.setCourseCapacity(rs.getInt("course_capacity"));
                report.setInstructor(rs.getString("instructor"));
                report.setLocationCode(Integer.parseInt(rs.getString("location")));
                report.setRoomNumber(Integer.parseInt(rs.getString("room_number")));
                report.setCourseDays(rs.getString("course_days"));
                report.setCourseTimes(rs.getString("course_times"));
                report.setCreatedDateTime(rs.getString("created_date_time"));
                report.setCreatedUserId(rs.getString("created_user_id"));
                report.setUpdatedUserId(rs.getString("updated_user_id"));
                courses.add(report);
            }
        } catch (Exception e) {
            // print out error message to console
            if (Util.debugOn) {
                System.out.println("Error");
            }
        } finally {
            // close connections to database
            DbUtils.close(rs, ps, conn);
        }
        
        return courses;
    }
    
    /**
     * @return used to return the description for academic year
     * Used to obtain the academic year value
     */
    public static String getAcademicYear(int sequenceCode) {
        String academicYear = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        
        try {
            // run a query that searches for the specified academic year
            conn = ConnectionUtils.getConnection();
            sql = "SELECT * FROM code_value, code_type WHERE code_type.code_type = 19 AND "
                    + "code_value.code_value_sequence = " + sequenceCode;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            // returns the description of the academic year
            while (rs.next()) {
                academicYear = rs.getString("english_description");
            }
        } catch (Exception e) {
            // print out any error message to console
            if (Util.debugOn) {
                System.out.println("Connection error: " + e.getMessage());
            }
        } finally {
            // close database connections
            DbUtils.close(rs, ps, conn);
        }
        
        return academicYear;
    }
}
