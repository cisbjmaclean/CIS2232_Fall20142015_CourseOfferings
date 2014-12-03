package controller;

import util.Util;
import beans.ChangePassword;
import beans.CodeValue;
import beans.Notification;
import business.MemberBO;
import business.NotificationBO;
import database.CourseDAO;
import forms.Menu;
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
@RequestMapping("menu")
public class MenuController {
    private Object CoursesDAO;

    @RequestMapping(method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("menu") Menu menu, HttpServletRequest request) {
        //pass validation if they enter "TEST" and "TEST"
        System.out.println("Menu post invoked");
        ModelAndView mv = null;
        /**
         * Logout
         */
        if (menu.getAction().equalsIgnoreCase("Logout")) {
            mv = new ModelAndView("welcome");
        /**
         * User Profile
         */
        } else if (menu.getAction().equalsIgnoreCase("User Profile")) {
            if (Util.debugOn){
                System.out.println("Display User Profile");
            }
            mv = new ModelAndView("main");
        /**
         * Change Password
         */
        } else if(menu.getAction().equalsIgnoreCase("Change Password")) {
            if (Util.debugOn) {
                System.out.println("Change password");
            }
            mv = new ModelAndView("changePassword");
            ChangePassword cp = new ChangePassword();
            cp.setMemberId((String)request.getSession().getAttribute("loggedInUserId"));
            mv.addObject("changePassword",cp);
        /**
         * Courses
         */
        } else if(menu.getAction().equalsIgnoreCase("Courses")) {
            if (Util.debugOn) {
                System.out.println("Display courses");
            }
            mv = new ModelAndView("viewCourses");
            mv.addObject("courses", CourseDAO.getAllCourses());

        /**
         * User Directory
         */
        } else if(menu.getAction().equalsIgnoreCase("User Directory")) {
            if (Util.debugOn) {
                System.out.println("View User Directory");
            }
            mv = new ModelAndView("viewMembers");
            mv.addObject("members",MemberBO.getAllActiveMembers());
        /**
         * Edit Users
         */
        } else if(menu.getAction().equalsIgnoreCase("Edit Users")) {
            if (Util.debugOn) {
                System.out.println("Edit a user");
            }
            mv = new ModelAndView("main");
        /**
         * Reports
         */
        } else if (menu.getAction().equalsIgnoreCase("Reports")) {
            if (Util.debugOn) {
                System.out.println("Display Report Options");
            }
            Menu reportMenu = new Menu();
            mv = new ModelAndView("report");
            mv.addObject("message", "Export Report");
            mv.addObject("menu", reportMenu);
        /**
         * Add Notification
         */
        } else if (menu.getAction().equalsIgnoreCase("Add Notification")) {
            if (Util.debugOn) {
                System.out.println("User wants to add a notification");
            }
            mv = new ModelAndView("notificationAdd");
            mv.addObject("notification",new Notification());
        /**
         * View Codes
         */
        } else if (menu.getAction().equalsIgnoreCase("View Codes")) {
            if (Util.debugOn) {
                System.out.println("User wants to view the codes");
            }
            mv = new ModelAndView("viewCodes");
            mv.addObject("message", "User selected view codes");
            mv.addObject("codeValue", new CodeValue());
        /**
         * Notifications
         */
        } else if (menu.getAction().equalsIgnoreCase("Notifications")) {
            if (Util.debugOn) {
                System.out.println("User wants to view the notifications");
            }
            mv = new ModelAndView("notification");
            mv.addObject("notifications",NotificationBO.getNotifications());
            mv.addObject("menu", new Menu());
        } else {
            mv = new ModelAndView("welcome");
        }

        return mv;
    }
}
