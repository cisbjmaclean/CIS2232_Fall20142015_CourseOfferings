/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import business.ReportBO;
import util.Util;
import forms.Menu;
import beans.Report;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import java.util.ArrayList;

/**
 *
 * @author dmaclean31977
 */

@Controller
public class ReportController {
    @RequestMapping(value = "report", method = RequestMethod.POST)
    public ModelAndView onSubmit(@ModelAttribute("report") Menu menu) {
        ModelAndView mv;
        if (Util.debugOn) {
            System.out.println("Report Exported academic year sequence code: " + menu.getAction());
        }
        
        // grab sequence code for academic year and grab a list of courses
        // that are listed for that selected year
        int sequenceCode = Integer.parseInt(menu.getAction());
        ArrayList<Report> courseList = ReportBO.getAcademicYearReport(sequenceCode);
        String academicYear = ReportBO.getAcademicYear(sequenceCode);
        System.out.println(courseList.size() + " courses found");
        mv = new ModelAndView("viewReport");
        mv.addObject("academicYear", academicYear);
        mv.addObject("numCourses", courseList.size());
        mv.addObject("courseList", courseList);
        return mv;
    }
}
