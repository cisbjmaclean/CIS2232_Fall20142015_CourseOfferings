package database;

import beans.Course;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import util.ConnectionUtils;
import util.DbUtils;

/**
 *
 * @author BJ
 */
public class CourseDAO {

    public static void addCourse(Course course) throws Exception {

        System.out.println("inserting a new course");
        PreparedStatement ps = null;
        String sql = null;
        Connection conn = null;
        conn = ConnectionUtils.getConnection();
        try {
            sql = "SELECT max(course_id) FROM course";

            ps = conn.prepareStatement(sql);
            ResultSet rs = ps.executeQuery();

            sql = "INSERT INTO course "
                    + "  (`course_id`, `academic_year_code`, `course_start_date`, `course_end_date`, "
                    + "   `course_prerequisites`, `course_capacity`, `course_co_requisites`, `member_id`, `location_code`, `room_number`, `course_days`,`course_times`,`created_date_time`,`created_user_id`,`updated_date_time`,`updated_date_time`) "
                    + "  VALUES (?, ?, ?, ?, ?,"
                    + "  sysdate(), ?, sysdate(), ?)";

            ps = conn.prepareStatement(sql);
            ps.setString(1, course.getCourseID());
            ps.setInt(2, course.getYearCode());
            ps.setString(3, course.getCourseStart());
            ps.setString(4, course.getCourseEnd());
            ps.setString(5, course.getPreReqs());
            ps.setInt(6, course.getCourseCap());
            ps.setString(7, course.getCoReqs());
            ps.setInt(8, course.getInstructor());
            ps.setInt(9, course.getLocation());
            ps.setString(10, course.getRoomNo());
            ps.setString(11, course.getDays());
            ps.setString(12, course.getTimes());

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

    public static void deleteCourse(String courseID, String updatedUserId) {

        System.out.println("deleting course");
        PreparedStatement psMember = null;
        String sql = null;
        Connection conn = null;

        /*
         * Setup the sql to update or insert the row (based on update flag).
         */
        try {
            conn = ConnectionUtils.getConnection();

            sql = "DELETE course WHERE course_id = ?";

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
                newCourse.setCourseID(rs.getString("course_id"));
                newCourse.setYearCode(rs.getInt("academic_year_code"));
                newCourse.setCourseStart(rs.getString("course_start_date"));
                newCourse.setCourseEnd(rs.getString("course_end_date"));
                newCourse.setPreReqs(rs.getString("course_prerequisites"));
                newCourse.setCourseCap(rs.getInt("course_capacity"));
                newCourse.setCoReqs(rs.getString("course_co_requisites"));
                newCourse.setInstructor(rs.getInt("member_id"));
                newCourse.setLocation(rs.getInt("location_code"));
                newCourse.setRoomNo(rs.getString("room_number"));
                newCourse.setDays(rs.getString("course_days"));
                newCourse.setTimes(rs.getString("course_times"));
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
                    + "SET course_id=?,academic_year_code=?,course_start_date=?,"
                    + "course_end_date=?,course_prerequisites=?,=?,course_capacity=?,"
                    + "course_co_requisites=?,member_id=?,location_code=?,room_number=?,course_days=?,"
                    + "course_times=?,date_of_birth=?,gender_code=? "
                    + "WHERE member_id = ?";

            psCourse = conn.prepareStatement(sql);
            psCourse.setString(1, course.getCourseID());
            psCourse.setInt(2, course.getYearCode());
            psCourse.setString(3, course.getCourseStart());
            psCourse.setString(4, course.getCourseEnd());
            psCourse.setString(5, course.getPreReqs());
            psCourse.setInt(6, course.getCourseCap());
            psCourse.setString(7, course.getCoReqs());
            psCourse.setInt(8, course.getInstructor());
            psCourse.setInt(9, course.getLocation());
            psCourse.setString(10, course.getRoomNo());
            psCourse.setString(11, course.getDays());
            psCourse.setString(12, course.getTimes());

            psCourse.executeUpdate();

        } catch (Exception e) {
            String errorMessage = e.getMessage();
            throw e;
        } finally {
            DbUtils.close(psCourse, conn);
        }

    }
}
