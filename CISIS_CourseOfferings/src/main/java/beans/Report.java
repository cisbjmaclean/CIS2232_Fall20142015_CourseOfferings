/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import util.ConnectionUtils;
import util.Util;

/**
 *
 * @author Ryan
 */
public class Report {
    
    private String course_id;
    private Date course_start_date;
    private Date course_end_date;
    private String course_prereqs;
    private String course_co_reqs;
    private int course_capacity;
    private int member_id;
    private int location_code;
    private int room_number;
    private String course_days;
    private String course_times;
    private Date created_date_time;
    private String created_user_id;
    private String updated_user_id;
    private int academic_year_code;
    
    public Report() {
        
    }

    public Report(String course_id, Date course_start_date, Date course_end_date, String course_prereqs, String course_co_reqs, int course_capacity, int member_id, int location_code, int room_number, String course_days, String course_times, Date created_date_time, String created_user_id, String updated_user_id, int academic_year_code) {
        this.course_id = course_id;
        this.course_start_date = course_start_date;
        this.course_end_date = course_end_date;
        this.course_prereqs = course_prereqs;
        this.course_co_reqs = course_co_reqs;
        this.course_capacity = course_capacity;
        this.member_id = member_id;
        this.location_code = location_code;
        this.room_number = room_number;
        this.course_days = course_days;
        this.course_times = course_times;
        this.created_date_time = created_date_time;
        this.created_user_id = created_user_id;
        this.updated_user_id = updated_user_id;
        this.academic_year_code = academic_year_code;
    }
    
    

    /**
     * @return the course_id
     */
    public String getCourse_id() {
        return course_id;
    }

    /**
     * @param course_id the course_id to set
     */
    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    /**
     * @return the course_start_date
     */
    public Date getCourse_start_date() {
        return course_start_date;
    }

    /**
     * @param course_start_date the course_start_date to set
     */
    public void setCourse_start_date(Date course_start_date) {
        this.course_start_date = course_start_date;
    }

    /**
     * @return the course_end_date
     */
    public Date getCourse_end_date() {
        return course_end_date;
    }

    /**
     * @param course_end_date the course_end_date to set
     */
    public void setCourse_end_date(Date course_end_date) {
        this.course_end_date = course_end_date;
    }

    /**
     * @return the course_prereqs
     */
    public String getCourse_prereqs() {
        return course_prereqs;
    }

    /**
     * @param course_prereqs the course_prereqs to set
     */
    public void setCourse_prereqs(String course_prereqs) {
        this.course_prereqs = course_prereqs;
    }

    /**
     * @return the course_co_reqs
     */
    public String getCourse_co_reqs() {
        return course_co_reqs;
    }

    /**
     * @param course_co_reqs the course_co_reqs to set
     */
    public void setCourse_co_reqs(String course_co_reqs) {
        this.course_co_reqs = course_co_reqs;
    }

    /**
     * @return the course_capacity
     */
    public int getCourse_capacity() {
        return course_capacity;
    }

    /**
     * @param course_capacity the course_capacity to set
     */
    public void setCourse_capacity(int course_capacity) {
        this.course_capacity = course_capacity;
    }

    /**
     * @return the member_id
     */
    public int getMember_id() {
        return member_id;
    }

    /**
     * @param member_id the member_id to set
     */
    public void setMember_id(int member_id) {
        this.member_id = member_id;
    }

    /**
     * @return the location_code
     */
    public int getLocation_code() {
        return location_code;
    }

    /**
     * @param location_code the location_code to set
     */
    public void setLocation_code(int location_code) {
        this.location_code = location_code;
    }

    /**
     * @return the room_number
     */
    public int getRoom_number() {
        return room_number;
    }

    /**
     * @param room_number the room_number to set
     */
    public void setRoom_number(int room_number) {
        this.room_number = room_number;
    }

    /**
     * @return the course_days
     */
    public String getCourse_days() {
        return course_days;
    }

    /**
     * @param course_days the course_days to set
     */
    public void setCourse_days(String course_days) {
        this.course_days = course_days;
    }

    /**
     * @return the course_times
     */
    public String getCourse_times() {
        return course_times;
    }

    /**
     * @param course_times the course_times to set
     */
    public void setCourse_times(String course_times) {
        this.course_times = course_times;
    }

    /**
     * @return the created_date_time
     */
    public Date getCreated_date_time() {
        return created_date_time;
    }

    /**
     * @param created_date_time the created_date_time to set
     */
    public void setCreated_date_time(Date created_date_time) {
        this.created_date_time = created_date_time;
    }

    /**
     * @return the created_user_id
     */
    public String getCreated_user_id() {
        return created_user_id;
    }

    /**
     * @param created_user_id the created_user_id to set
     */
    public void setCreated_user_id(String created_user_id) {
        this.created_user_id = created_user_id;
    }

    /**
     * @return the updated_user_id
     */
    public String getUpdated_user_id() {
        return updated_user_id;
    }

    /**
     * @param updated_user_id the updated_user_id to set
     */
    public void setUpdated_user_id(String updated_user_id) {
        this.updated_user_id = updated_user_id;
    }

    /**
     * @return the academic_year_code
     */
    public int getAcademic_year_code() {
        return academic_year_code;
    }

    /**
     * @param academic_year_code the academic_year_code to set
     */
    public void setAcademic_year_code(int academic_year_code) {
        this.academic_year_code = academic_year_code;
    }
    
    public ArrayList viewCourseListings() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = null;
        
        try {
            conn = ConnectionUtils.getConnection();
        } catch (Exception e) {
            if (Util.debugOn) {
                System.out.println("Connection error: " + e.getMessage());
            }
        }
        
        sql = "SELECT * FROM course, code_type, code_value WHERE ";
        
        return new ArrayList();
    }
}
