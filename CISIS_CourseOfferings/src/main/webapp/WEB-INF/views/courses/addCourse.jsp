<%-- 
    Document   : addCourse
    Created on : Dec 1, 2014, 10:48:30 PM
    Author     : Evan
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Course</title>
    </head>
    <body>
        <h1>Please enter course information</h1>
        <form action="addCourse"  method="post">
            <spring:nestedPath path="addCourse">
                <table>
                    <tr>
                        <td>Course ID: <input type="text" path = "courseID"/></td>
                    </tr>
                    <tr>
                        <td>Academic Year Code: <input type="text" path = "yearCode"/></td>
                    </tr>
                    <tr>
                        <td>Course Start Date: <input type="date" path = "courseStart"/></td>
                    </tr>
                    <tr>
                        <td>Course End Date: <input type="date" path = "courseEnd"/></td>
                    </tr>
                    <tr>
                        <td>Prerequisites: <input type="text" path = "preReqs"/></td>
                    </tr>
                    <tr>
                        <td>Course Capacity: <input type="text" path = "courseCap"/></td>
                    </tr>
                    <tr>
                        <td>Co-requisites: <input type="text" path = "coReqs"/></td>
                    </tr>
                    <tr>
                        <td>Instructor ID: <input type="text" path = "memberID"/></td>
                    </tr>
                    <tr>
                        <td>Location Code: <input type="text" path = "location"/></td>
                    </tr>
                    <tr>
                        <td>Room Number: <input type="text" path = "roomNo"/></td>
                    </tr>
                    <tr>
                        <td>Days: <input type="text" path = "days"/></td>
                    </tr>
                    <tr>
                        <td>Times: <input type="text" path = "times"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value = "Add Course"/></td>
                    </tr>
                    <tr>
                        <td>${message}</td>
                    </tr>

                </table>

                </body>
                </html>
