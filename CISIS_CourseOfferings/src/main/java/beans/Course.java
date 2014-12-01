/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package beans;

/**
 *
 * @author Chase
 */
public class Course {
    private String courseID = "";
    private int yearCode = 0;
    private String courseStart= "";
    private String courseEnd= "";
    private String preReqs= "";
    private int courseCap= 0;
    private String coReqs= "";
    private int instructor= 0;
    private int location= 0;
    private String roomNo= "";

    public int getInstructor() {
        return instructor;
    }

    public void setInstructor(int instructor) {
        this.instructor = instructor;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
    private String days= "";
    private String times= "";

    public int getYearCode() {
        return yearCode;
    }

    public void setYearCode(int yearCode) {
        this.yearCode = yearCode;
    }
    

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getCourseStart() {
        return courseStart;
    }

    public void setCourseStart(String courseStart) {
        this.courseStart = courseStart;
    }

    public String getCourseEnd() {
        return courseEnd;
    }

    public void setCourseEnd(String courseEnd) {
        this.courseEnd = courseEnd;
    }

    public String getPreReqs() {
        return preReqs;
    }

    public void setPreReqs(String preReqs) {
        this.preReqs = preReqs;
    }

    public int getCourseCap() {
        return courseCap;
    }

    public void setCourseCap(int courseCap) {
        this.courseCap = courseCap;
    }

    public String getCoReqs() {
        return coReqs;
    }

    public void setCoReqs(String coReqs) {
        this.coReqs = coReqs;
    }

  
    public String getRoomNo() {
        return roomNo;
    }

    public void setRoomNo(String roomNo) {
        this.roomNo = roomNo;
    }

    public String getDays() {
        return days;
    }

    public void setDays(String days) {
        this.days = days;
    }

    public String getTimes() {
        return times;
    }

    public void setTimes(String times) {
        this.times = times;
    }
}
    