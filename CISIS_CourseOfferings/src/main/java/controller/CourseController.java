package controller;

import beans.Course;
import beans.Member;
import business.MemberBO;
import database.CourseDAO;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
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
    
    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView onSubmit(@ModelAttribute("course")Course course, HttpServletRequest request) {
        

        String actionSpecified = request.getParameter("action");
        String message = "";
        ModelAndView mv = null;
        

       if (actionSpecified != null && actionSpecified.equalsIgnoreCase("add")) {
            message = "add a member";
            mv = new ModelAndView("addCourse");
            mv.addObject("course", new Course());
        }
       return mv;
    }
    
}
