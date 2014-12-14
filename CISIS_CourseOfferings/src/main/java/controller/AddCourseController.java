package controller;

import beans.Course;
import beans.Member;
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
 * Controller for the add course option
 *
 * @author knjackson
 */
@Controller
@RequestMapping("addCourse")

public class AddCourseController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("course") Course course, Member member, HttpServletRequest request) {
        String message = "";

        //make sure at least a courseID has been entered
        if (!"".equals(course.getCourseID())) {
            try {
                //add the member inputted course info
                CourseDAO.addCourse(course, member);
                System.out.println("Course added.");
                message = "Course was added";

            } catch (Exception ex) {
                //else alert error
                Logger.getLogger(AddCourseController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error Adding course");
                message = "Course was  not added";
            }
        } else {
            message = "Course was not added";
        }
        //return user to the add course view with a message and empty course class object. 
        Course theCourse = new Course();
        ModelAndView mv;
        mv = new ModelAndView("addCourse");
        mv.addObject("message", message);        
        mv.addObject("course", theCourse);
        return mv;
    }
}
