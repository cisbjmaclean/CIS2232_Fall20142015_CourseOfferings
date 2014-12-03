package controller;

import beans.Course;
import database.CourseDAO;
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
@RequestMapping("addCourse")
public class AddCourseController {

//    @RequestMapping(method = RequestMethod.GET)
//    public String loadMember(ModelMap model) {
//        
//        model.addAttribute("memberBio", new Member());
//        
//        return "welcome";
//    }
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("addCourse") Course course) {

        if (course.getCourseID() != "") {
            try {
                CourseDAO.addCourse(course);
                System.out.println("Course added.");
            } catch (Exception ex) {
                Logger.getLogger(AddCourseController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error Adding course");
            }
        }

        ModelAndView mv;
        mv = new ModelAndView("addCourse");
        mv.addObject("courses", course);
        mv.addObject("message", "Course was added");
        
        return mv;
    }
}
