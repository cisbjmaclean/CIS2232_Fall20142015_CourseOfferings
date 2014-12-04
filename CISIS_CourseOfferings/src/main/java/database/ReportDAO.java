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
    
    public static ArrayList<Report> getReport(int sequenceCodeValue) {
        ArrayList<Report> courses = new ArrayList();
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        
        try {
            conn = ConnectionUtils.getConnection();
            sql = "SELECT * FROM `course` WHERE academic_year_code = " + sequenceCodeValue;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                Report report = new Report();
                report.setAcademicYearCode(sequenceCodeValue);
                report.setCourseId(rs.getString("course_id"));
                report.setCourseStartDate(rs.getString("course_start_date"));
                report.setCourseEndDate(rs.getString("course_end_date"));
                report.setCoursePrereqs(rs.getString("course_prerequisites"));
                report.setCourseCoreqs(rs.getString("course_co_Requisites"));
                report.setCourseCapacity(rs.getInt("course_capacity"));
                report.setMemberId(rs.getInt("member_id"));
                report.setLocationCode(rs.getInt("location_code"));
                report.setRoomNumber(rs.getInt("room_number"));
                report.setCourseDays(rs.getString("course_days"));
                report.setCourseTimes(rs.getString("course_times"));
                report.setCreatedDateTime(rs.getString("created_date_time"));
                report.setCreatedUserId(rs.getString("created_user_id"));
                report.setUpdatedUserId(rs.getString("updated_user_id"));
                courses.add(report);
            }
        } catch (Exception e) {
            if (Util.debugOn) {
                System.out.println("Error");
            }
        } finally {
            DbUtils.close(rs, ps, conn);
        }
        
        return courses;
    }
    
    public static String getAcademicYear(int sequenceCode) {
        String academicYear = null;
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        
        try {
            conn = ConnectionUtils.getConnection();
            sql = "SELECT * FROM code_value, code_type WHERE code_type.code_type = 19 AND "
                    + "code_value.code_value_sequence = " + sequenceCode;
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                academicYear = rs.getString("english_description");
            }
        } catch (Exception e) {
            if (Util.debugOn) {
                System.out.println("Connection error: " + e.getMessage());
            }
        } finally {
            DbUtils.close(rs, ps, conn);
        }
        
        return academicYear;
    }
}
