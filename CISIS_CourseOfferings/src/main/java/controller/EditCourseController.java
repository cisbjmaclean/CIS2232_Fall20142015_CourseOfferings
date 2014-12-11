/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
 *
 * @author Ryan
 */
@Controller
@RequestMapping("editCourse")
public class EditCourseController {
    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("course") Course course, Member member, HttpServletRequest request) {
        String message = "";

        // verify course id is not empty
        if (!course.getCourseID().equals("")) {
            // try to update course info
            try {
                CourseDAO.updateCourse(course);
                System.out.println("Course Update Successful.");
                message = "Update Successful";
            } catch (Exception ex) {
                Logger.getLogger(EditCourseController.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Error Updating course");
                message = "Course was  not updated";
            }
        } else {
            message = "Course was not updated";
        }
        ModelAndView mv;
        
        // bring user to list of courses and display message if update
        // was successful or not
        mv = new ModelAndView("viewCourses");
        mv.addObject("message", message);
        mv.addObject("courses", CourseDAO.getAllCourses());
        return mv;
    }
}
