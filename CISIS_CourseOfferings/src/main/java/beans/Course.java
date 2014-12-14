package beans;

import java.nio.file.Path;
import java.nio.file.Paths;

/**
 *
 * @author Kylea
 * Course bean containing getters and setters for course variables
 */
public class Course {
    //set the variables
    private String courseID = "";  
    private String year = "";
    private String courseStart= "";
    private String courseEnd= "";
    private String preReqs= "";
    private int courseCap= 0;
    private String coReqs= "";
    private String instructor="";
    private String location= "";
    private String roomNo= "";
    private String days= "";
    private String times= "";

    //getters and setters
    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
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
    