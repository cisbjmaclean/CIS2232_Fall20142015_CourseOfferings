package controller;

import beans.Course;
import beans.Member;
import database.CourseDAO;
import forms.Login;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import static sun.security.jgss.GSSUtil.login;

/**
 * Controller for the Welcome
 *
 * @author bjmaclean
 */
@Controller
@RequestMapping("addCourse")

public class AddCourseController {

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("course") Course course, Member member, HttpServletRequest request) {
        String message = "";

        if (!"".equals(course.getCourseID())) {
            try {
                CourseDAO.addCourse(course, member);
                System.out.println("Course added.");
                message = "Course was added";

            } catch (Exception ex) {
                Logger.getLogger(AddCourseController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error Adding course");
                message = "Course was  not added";
            }
        } else {
            message = "Course was not added";
        }
        Course theCourse = new Course();
        ModelAndView mv;
        mv = new ModelAndView("addCourse");
        mv.addObject("message", message);        
        mv.addObject("course", theCourse);
        return mv;
    }
}
