package business;

import beans.ChangePassword;
import beans.Member;
import database.MemberDAO;
import exceptions.PasswordException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * This class will handle the processing associated with a business object.  
 * 
 * @author BJ
 * @since 20140611
 */
public class MemberBO {

    
    
    public static void changePassword(Member theMember, ChangePassword changePassword) throws PasswordException{
        
        
        //Check that the existing password matches their password
        if (!theMember.getPassword().equals(changePassword.getExistingPassword())){
            throw new PasswordException("Existing password does not match");
        }
        
        //If so then make sure that the confirm and new passwords match.
        if (!changePassword.getNewPassword().equals(changePassword.getConfirmPassword())){
            throw new PasswordException("New and confirm passwords do not match");
        }
        
        //If they do then update the user's password
        //Otherwise return an appropriate error message.
        System.out.println("Changing password, validation ok");
        MemberDAO.changePassword(theMember.getMemberId(), changePassword.getNewPassword(), theMember.getUserId());

    }
    
    public static void updateMember(Member member) throws Exception{
        //Any validation?
        
        MemberDAO.updateMember(member);
    }

        public static void deleteMember(Member member, String updatedUserId) throws Exception{
        //Any validation?
        
        MemberDAO.deleteMember(member.getMemberId(), updatedUserId);
    }

    
    public static void addMember(Member member){
        
        try {
            //set the member username as the first initial first name, first initial middle name
            //and the last lame
            String middleInitial = "x";
            if(member.getMiddleName().length()>0)
                middleInitial = member.getMiddleName().substring(0,1).toLowerCase();
           
                
            String username = member.getFirstName().substring(0, 1).toLowerCase()
            + middleInitial
            + member.getLastName().toLowerCase();
            member.setNewUserId(username);
            
            MemberDAO.addMember(member);

        } catch (Exception ex) {
            Logger.getLogger(MemberBO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return;
    }
    
    public static ArrayList<Member> getAllActiveMembers(){
        
        return MemberDAO.getAllActiveMembers();
        
        
    }

        public static Member getMember(String memberId){
            return MemberDAO.getMember(memberId);
        }
    
        public static Member getMemberByUserid(String userId){
            return MemberDAO.getMemberByUserid(userId);
        }

        public static String getMemberName(String memberId){
            Member theMember = MemberDAO.getMember(memberId);
            String name = theMember.getFirstName() + " " + theMember.getLastName();
            return name;
        }
        
}
