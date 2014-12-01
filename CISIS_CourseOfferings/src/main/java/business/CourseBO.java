//package business;
//
//import beans.Course;
//import static business.MemberBO.getAllActiveMembers;
//import database.CourseDAO;
//import exceptions.PasswordException;
//import java.sql.Connection;
//import java.sql.PreparedStatement;
//import java.sql.ResultSet;
//import java.util.ArrayList;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import util.ConnectionUtils;
//import util.DbUtils;
//import util.Mail;
//
///**
// * This class will handle the processing associated with a business object.  
// * 
// * @author BJ
// * @since 20140611
// */
//public class CourseBO {
//
//    public static void addCourse(Course course) {
//
//        System.out.println("inserting a new course");
//        PreparedStatement ps = null;
//        String sql = null;
//        Connection conn = null;
//        conn = ConnectionUtils.getConnection();
//
//        try {
//            //set the member username as the first initial first name, first initial middle name
//            //and the last lame
//            String middleInitial = "x";
//            if(member.getMiddleName().length()>0)
//                middleInitial = member.getMiddleName().substring(0,1).toLowerCase();
//           
//                
//            String username = member.getFirstName().substring(0, 1).toLowerCase()
//            + middleInitial
//            + member.getLastName().toLowerCase();
//            member.setNewUserId(username);
//            
//            MemberDAO.addMember(member);
//            String emailDetails = " You have been added to the Squash PEI Application.  \r\n User name="+member.getNewUserId()+"\r\n Password=rboard"
//                    + "\r\n \r\n Access details and change password at:  http://bjmac.hccis.info:8080/RegistrationBoard";
//            Mail mail = new Mail(member.getEmailAddress(), "squashpei@gmail.com", "Squash PEI new user", emailDetails);
//            mail.sendMail();
//
//        } catch (Exception ex) {
//            Logger.getLogger(CourseBO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return;
//    }
//    
//    }
//
//    public static void deleteCourse(String courseID, String updatedUserId) {
//
//        System.out.println("deleting course");
//        PreparedStatement psMember = null;
//        String sql = null;
//        Connection conn = null;
//
//        /*
//         * Setup the sql to update or insert the row (based on update flag).
//         */
//        try {
//            conn = ConnectionUtils.getConnection();
//
//            sql = "DELETE course "
//                    + "SET status_type=2,"
//                    + "    updated_user_id = ?, "
//                    + "    updated_date_time = sysdate() "
//                    + "WHERE course_id = ?";
//
//            psMember = conn.prepareStatement(sql);
//            psMember.setString(1, updatedUserId);
//            psMember.setString(2, courseID);
//            psMember.executeUpdate();
//
//        } catch (Exception e) {
//            String errorMessage = e.getMessage();
//            e.printStackTrace();
//        } finally {
//            DbUtils.close(psMember, conn);
//        }
//    }
//
//    public static String getAllActiveMembersEmails() {
//        String emails = "";
//        boolean first = true;
//        for (Member member : getAllActiveMembers()) {
//            if (!first) {
//                emails += "; ";
//            }
//            first = false;
//            emails += member.getEmailAddress();
//        }
//        return emails;
//    }
//
//    public static ArrayList<Course> getAllCourses() {
//
//        PreparedStatement ps = null;
//        String sql = null;
//        Connection conn = null;
//
//        ArrayList<Course> courses = new ArrayList();
//        try {
//            conn = ConnectionUtils.getConnection();
//
//            sql = "SELECT * FROM course";
//
//            ps = conn.prepareStatement(sql);
//            ResultSet rs = ps.executeQuery();
//            while (rs.next()) {
//                Member newMember = new Member();
//                newMember.setMemberId(rs.getInt("member_id"));
//                newMember.setFirstName(rs.getString("first_name"));
//                newMember.setMiddleName(rs.getString("middle_name"));
//                newMember.setLastName(rs.getString("last_name"));
//                newMember.setAddressLine1(rs.getString("address_1"));
//                newMember.setAddressLine2(rs.getString("address_2"));
//                newMember.setMunicipality(rs.getString("municipality"));
//                newMember.setProvinceCode(rs.getInt("province_code"));
//                newMember.setPostalCode(rs.getString("postal_code"));
//                newMember.setHomePhone(rs.getString("home_phone"));
//                newMember.setWorkPhone(rs.getString("work_phone"));
//                newMember.setWorkPhoneExtension(rs.getString("work_phone_extension"));
//                //newMember.setFax(rs.getString("fax_number"));
//                newMember.setEmailAddress(rs.getString("email_address"));
//                //newMember.setDateOfBirth(rs.getString("date_of_birth"));
//                //newMember.setGenderCode(rs.getInt("gender_code"));
//                members.add(newMember);
//            }
//        } catch (Exception e) {
//            String errorMessage = e.getMessage();
//            e.printStackTrace();
//        } finally {
//            DbUtils.close(ps, conn);
//        }
//        return members;
//    }
//
//
//    public static void updateMember(Member member) throws Exception {
//        //Have to update the member based on member id.
//
//        System.out.println("updating member");
//        PreparedStatement psMember = null;
//        String sql = null;
//        Connection conn = null;
//
//        /*
//         * Setup the sql to update or insert the row (based on update flag).
//         */
//        try {
//            conn = ConnectionUtils.getConnection();
//
//            sql = "UPDATE member_bio "
//                    + "SET first_name=?,middle_name=?,last_name=?,"
//                    + "address_1=?,address_2=?,municipality=?,province_code=?,"
//                    + "postal_code=?,home_phone=?,work_phone=?,work_phone_extension=?,fax_number=?,"
//                    + "email_address=?,date_of_birth=?,gender_code=? "
//                    + "WHERE member_id = ?";
//
//            psMember = conn.prepareStatement(sql);
//            psMember.setString(1, member.getFirstName());
//            psMember.setString(2, member.getMiddleName());
//            psMember.setString(3, member.getLastName());
//            psMember.setString(4, member.getAddressLine1());
//            psMember.setString(5, member.getAddressLine2());
//            psMember.setString(6, member.getMunicipality());
//            psMember.setInt(7, member.getProvinceCode());
//            psMember.setString(8, member.getPostalCode());
//            psMember.setString(9, member.getHomePhone());
//            psMember.setString(10, member.getWorkPhone());
//            psMember.setString(11, member.getWorkPhoneExtension());
//            // psMember.setString(12, member.getFax());
//            psMember.setString(13, member.getEmailAddress());
//            // psMember.setString(14, member.getDateOfBirth());
//            //psMember.setInt(15, member.getGenderCode());
//            psMember.setInt(16, member.getMemberId());
//
////            } else {
////                //Have to insert the new member.
////
////                sql = "INSERT INTO member(user_type, last_name, first_name, password, email, "
////                        + "phone_cell, phone_home, phone_work,"
////                        + " address, status, membership_type, member_id, membership_date) "
////                        + " values (?,?,?,?,?,?,?,?,?,?,?,?,?)";
////
////                psMember = conn.prepareStatement(sql);
////                psMember.setInt(1, memberForm.getUserType());
////                psMember.setString(2, memberForm.getLastName());
////                psMember.setString(3, memberForm.getFirstName());
////                psMember.setString(4, memberForm.getPassword());
////                psMember.setString(5, memberForm.getEmail());
////                psMember.setString(6, memberForm.getPhoneCell());
////                psMember.setString(7, memberForm.getPhoneHome());
////                psMember.setString(8, memberForm.getPhoneWork());
////                psMember.setString(9, memberForm.getAddress());
////                psMember.setInt(10, memberForm.getStatus());
////                psMember.setInt(11, memberForm.getMemberShipType());
////                psMember.setInt(12, memberForm.getNewMemberId());
////                psMember.setDate(13, null);
////
////            }
//            psMember.executeUpdate();
//
//        } catch (Exception e) {
//            String errorMessage = e.getMessage();
//            e.printStackTrace();
//            throw e;
//        } finally {
//            DbUtils.close(psMember, conn);
//        }
//
//    }
//  
//    public static void updateMember(Member member) throws Exception{
//        //Any validation?
//        
//        MemberDAO.updateMember(member);
//    }
//
//        public static void deleteMember(Member member, String updatedUserId) throws Exception{
//        //Any validation?
//        
//        MemberDAO.deleteMember(member.getMemberId(), updatedUserId);
//    }
//
//    
//    public static void addMember(Member member){
//        
//        try {
//            //set the member username as the first initial first name, first initial middle name
//            //and the last lame
//            String middleInitial = "x";
//            if(member.getMiddleName().length()>0)
//                middleInitial = member.getMiddleName().substring(0,1).toLowerCase();
//           
//                
//            String username = member.getFirstName().substring(0, 1).toLowerCase()
//            + middleInitial
//            + member.getLastName().toLowerCase();
//            member.setNewUserId(username);
//            
//            MemberDAO.addMember(member);
//            String emailDetails = " You have been added to the Squash PEI Application.  \r\n User name="+member.getNewUserId()+"\r\n Password=rboard"
//                    + "\r\n \r\n Access details and change password at:  http://bjmac.hccis.info:8080/RegistrationBoard";
//            Mail mail = new Mail(member.getEmailAddress(), "squashpei@gmail.com", "Squash PEI new user", emailDetails);
//            mail.sendMail();
//
//        } catch (Exception ex) {
//            Logger.getLogger(CourseBO.class.getName()).log(Level.SEVERE, null, ex);
//        }
//        
//        return;
//    }
//    
//    public static ArrayList<Member> getAllActiveMembers(){
//        
//        return MemberDAO.getAllActiveMembers();
//        
//        
//    }
//
//    public static String getAllActiveMembersEmails(){
//        
//        return MemberDAO.getAllActiveMembersEmails();
//        
//        
//    }
//
//        public static Member getMember(String memberId){
//            return MemberDAO.getMember(memberId);
//        }
//    
//        public static Member getMemberByUserid(String userId){
//            return MemberDAO.getMemberByUserid(userId);
//        }
//
//        public static String getMemberName(String memberId){
//            Member theMember = MemberDAO.getMember(memberId);
//            String name = theMember.getFirstName() + " " + theMember.getLastName();
//            return name;
//        }
//        
//}
