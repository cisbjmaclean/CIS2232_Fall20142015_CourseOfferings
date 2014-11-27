/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import database.ReportDAO;
import beans.Report;
import java.util.ArrayList;
/**
 *
 * @author Ryan
 */
public class ReportBO {
    public static ArrayList<Report> getAcademicYearReport(int academicYearCode) {
        return ReportDAO.getReport(academicYearCode);
    }
    
    public static String getAcademicYear(int academicYearCode) {
        return ReportDAO.getAcademicYear(academicYearCode);
    }
}
