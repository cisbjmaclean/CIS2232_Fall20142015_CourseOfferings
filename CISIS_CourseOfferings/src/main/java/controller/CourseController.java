package controller;

import beans.Course;
import database.CourseDAO;
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
        
        Course aCourse = new Course();
        String actionSpecified = request.getParameter("action");
        String message = "";
        ModelAndView mv = null;
        

       if (actionSpecified != null && actionSpecified.equalsIgnoreCase("add")) {
            message = "add a course";
            mv = new ModelAndView("addCourse");
            mv.addObject("course", new Course());
        }
       if (actionSpecified != null && actionSpecified.equalsIgnoreCase("delete")) {
            message = "delete a course";
            aCourse = CourseDAO.getCourse(request.getParameter("courseID"));
            CourseDAO.deleteCourse(aCourse.getCourseID());
            mv.addObject("message", "Course Deleted");
            mv = new ModelAndView("viewCourses");
        }
       return mv;
    }
    
}
