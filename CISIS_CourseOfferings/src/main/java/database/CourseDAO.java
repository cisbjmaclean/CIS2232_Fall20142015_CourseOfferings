package database;

import beans.Course;
import beans.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author knjackson
 */
public class CourseDAO {

    //method for adding courses to the database.
    public static void addCourse(Course course, Member member) throws Exception {
        
        
        System.out.println("inserting a new course");
        
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        conn = ConnectionUtils.getConnection();
        try {
           //sql for inserting new course
            sql = "INSERT INTO course "
                    + "  (`course_id`, `academic_year`,`course_start_date`, `course_end_date`, "
                    + "   `course_prerequisites`, `course_capacity`, `course_co_requisites`, `instructor`,`location`, `room_number`, `course_days`,`course_times`,`created_date_time`,`created_user_id`,`updated_date_time`) "
                    + "  VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, sysdate(),?, sysdate())";

            ps = conn.prepareStatement(sql);
            //setting prepared statment values
            ps.setString(1, course.getCourseID());
            ps.setString(2, course.getYear());
            ps.setString(3, course.getCourseStart());
            ps.setString(4, course.getCourseEnd());
            ps.setString(5, course.getPreReqs());
            ps.setInt(6, course.getCourseCap());
            ps.setString(7, course.getCoReqs());
            ps.setString(8, course.getInstructor());
            ps.setString(9, course.getLocation());
            ps.setString(10, course.getRoomNo());
            ps.setString(11, course.getDays());
            ps.setString(12, course.getTimes());
            ps.setString(13, member.getUserId());
            ps.executeUpdate();
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
            throw e;
        } finally {
            DbUtils.close(ps, conn);
        }
        return;
    }
    
    //Method for retreiving course information using courseID
    public static Course getCourse(String courseID) {
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        Course aCourse = new Course();
        aCourse.setCourseID(courseID);
        try {
            conn = ConnectionUtils.getConnection();
            sql = "SELECT * FROM course WHERE course_id = " + courseID;
            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                aCourse.setCourseID(courseID);
                aCourse.setYear(rs.getString("academic_year"));
                aCourse.setCourseStart(rs.getString("course_start_date"));
                aCourse.setCourseEnd(rs.getString("course_end_date"));
                aCourse.setPreReqs(rs.getString("course_prerequisites"));
                aCourse.setCourseCap(rs.getInt("course_capacity"));
                aCourse.setCoReqs(rs.getString("course_co_requisites"));
                aCourse.setInstructor(rs.getString("instructor"));
                aCourse.setLocation(rs.getString("location"));
                aCourse.setRoomNo(rs.getString("room_number"));
                aCourse.setDays(rs.getString("course_days"));
                aCourse.setTimes(rs.getString("course_times"));
            }
        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(ps, conn);
        }
        return aCourse;
    }


    public static void deleteCourse(String courseID) {
        //method for deleting a course from the database.
 

        System.out.println("deleting course");
        PreparedStatement psMember = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row (based on update flag).
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "DELETE FROM course WHERE course_id = ?";

            psMember = conn.prepareStatement(sql);
            psMember.setString(1, courseID);
            psMember.executeUpdate();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            e.printStackTrace();
        } finally {
            DbUtils.close(psMember, conn);
        }
    }

    public static ArrayList<Course> getAllCourses() {
        //method for getting all existing courses and returning them in an arraylist. 
        System.out.println("Get All Courses ");

        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;

        ArrayList<Course> courses = new ArrayList();

        try {
            conn = ConnectionUtils.getConnection();

            sql = "SELECT * FROM course";

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

                Course newCourse = new Course();
                //set course values to the db values while there until there are no more results
                newCourse.setCourseID(rs.getString("course_id"));
                newCourse.setYear(rs.getString("academic_year"));               
                newCourse.setCourseStart(rs.getString("course_start_date"));
                newCourse.setCourseEnd(rs.getString("course_end_date"));
                newCourse.setPreReqs(rs.getString("course_prerequisites"));
                newCourse.setCourseCap(rs.getInt("course_capacity"));
                newCourse.setCoReqs(rs.getString("course_co_requisites"));
                newCourse.setInstructor(rs.getString("instructor"));
                newCourse.setLocation(rs.getString("location"));
                newCourse.setRoomNo(rs.getString("room_number"));
                newCourse.setDays(rs.getString("course_days"));
                newCourse.setTimes(rs.getString("course_times"));     
                //add created course item to the arraylist
                courses.add(newCourse);

            }

        } catch (Exception e) {
            String errorMessage = e.getMessage();
        } finally {
            DbUtils.close(ps, conn);
        }
        return courses;
    }

    public static void updateCourse(Course course) throws Exception {
        //Have to update the member based on member id.

        System.out.println("updating course");
        PreparedStatement psCourse = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row (based on update flag).
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "UPDATE course "
                    + "SET academic_year=?,course_start_date=?,"
                    + "course_end_date=?,course_prerequisites=?,course_capacity=?,"
                    + "course_co_requisites=?,instructor=?,location=?,room_number=?,course_days=?,"
                    + "course_times=?,updated_date_time=sysdate() "
                    + "WHERE course_id=?";

            psCourse = conn.prepareStatement(sql);
            //psCourse.setString(1, course.getCourseID());
            psCourse.setString(1, course.getYear());
            psCourse.setString(2, course.getCourseStart());
            psCourse.setString(3, course.getCourseEnd());
            psCourse.setString(4, course.getPreReqs());
            psCourse.setInt(5, course.getCourseCap());
            psCourse.setString(6, course.getCoReqs());
            psCourse.setString(7, course.getInstructor());
            psCourse.setString(8, course.getLocation());
            psCourse.setString(9, course.getRoomNo());
            psCourse.setString(10, course.getDays());
            psCourse.setString(11, course.getTimes());
            psCourse.setString(12, course.getCourseID());

            psCourse.executeUpdate();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            throw e;
        } finally {
            DbUtils.close(psCourse, conn);
        }

    }
}
