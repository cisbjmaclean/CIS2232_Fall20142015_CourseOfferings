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

        // check what the "action" parameter equals
        if (actionSpecified != null && actionSpecified.equalsIgnoreCase("add")) {
            // bring user to the add course page
            message = "add a course";
            mv = new ModelAndView("addCourse");
            mv.addObject("course", new Course());
        }
        else if (actionSpecified != null && actionSpecified.equalsIgnoreCase("delete")) {
            // try to delete the selected course
            try {
                // delete record based on the courseID that was provided
                CourseDAO.deleteCourse(request.getParameter("courseID"));
                System.out.println("Deleted Course");
            } catch (Exception ex) {
                Logger.getLogger(CourseController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("There was an error deleting the course.");
            }
            message = "Course Deleted";

            // display list of courses and provide message that delete was successful
            mv = new ModelAndView("viewCourses");
            mv.addObject("message", message);
            mv.addObject("courses", CourseDAO.getAllCourses());
        } else {
            // bring user to edit form. and get all values for the selected course
            // and populate all fields on page
            message = "Edit Course";
            aCourse = CourseDAO.getCourse(request.getParameter("courseID"));
            mv = new ModelAndView("editCourse");
            mv.addObject("message", message);
            mv.addObject("course", aCourse);
        }
        return mv;
    }

}
