package controller;

import beans.Course;
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

    @RequestMapping(method = RequestMethod.GET)
    public ModelAndView onSubmit(@ModelAttribute("course") Course course, HttpServletRequest request) {

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
            try {
                CourseDAO.deleteCourse(request.getParameter("courseID"));
                System.out.println("Deleted Course");
            } catch (Exception ex) {
                Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("There was an error deleting the course.");
            }
            message = "Course Deleted";

            mv = new ModelAndView("viewCourses");
            mv.addObject("message", message);
            mv.addObject("courses", CourseDAO.getAllCourses());

        }
        return mv;
    }

}
