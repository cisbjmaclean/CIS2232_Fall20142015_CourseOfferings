package controller;

import beans.Course;
import beans.Member;
import business.MemberBO;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

/**
 * Controller for the Welcome
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("courseCalendar")
public class CourseController {
    
//    @RequestMapping(method = RequestMethod.GET)
//    public String loadMember(ModelMap model) {
//        
//        model.addAttribute("memberBio", new Member());
//        
//        return "welcome";
//    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("course")Course course) {
        //pass validation if they enter "TEST" and "TEST"
        //Use the model to update the database and then return back to the member page.
//        System.out.println("submitted member for update, name=" + member.getFirstName()+" "+member.getLastName());
//        System.out.println("Member id to add/edit="+member.getMemberId());
//        if (member.getMemberId() == 0) {
//            MemberBO.addMember(member);          
//            
//        } else {
//            try {
//                MemberBO.updateMember(member);
//            } catch (Exception ex) {
//                Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
//                System.out.println("There was an error updating the member");
//            }
//        }
//        
        ModelAndView mv;
        mv = new ModelAndView("memberBio");
        mv.addObject("informationMessage","course information saved");
        mv.addObject("course", course);
        return mv;
    }
}
