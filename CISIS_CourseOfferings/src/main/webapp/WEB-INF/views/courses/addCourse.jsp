<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Course</title>
    </head>
    <body>
        <h1>Please enter course information</h1>
        <form action="addCourse"  method="post">
            <spring:nestedPath path="course">
                <table>
                    <tr>
                        <td>Course ID: <form:input type="text" path = "courseID"/></td>
                    </tr>
                    <tr>
                        <td>Academic Year Code: <form:input type="text" path = "yearCode"/></td>
                    </tr>
                    <tr>
                        <td>Course Start Date: <form:input type="date" path = "courseStart"/></td>
                    </tr>
                    <tr>
                        <td>Course End Date: <form:input type="date" path = "courseEnd"/></td>
                    </tr>
                    <tr>
                        <td>Prerequisites: <form:input type="text" path = "preReqs"/></td>
                    </tr>
                    <tr>
                        <td>Course Capacity: <form:input type="text" path = "courseCap"/></td>
                    </tr>
                    <tr>
                        <td>Co-requisites: <form:input type="text" path = "coReqs"/></td>
                    </tr>
                    <tr>
                        <td>Instructor ID: <form:input type="text" path = "instructor"/></td>
                    </tr>
                    <tr>
                        <td>Location Code: <form:input type="text" path = "location"/></td>
                    </tr>
                    <tr>
                        <td>Room Number: <form:input type="text" path = "roomNo"/></td>
                    </tr>
                    <tr>
                        <td>Days: <form:input type="text" path = "days"/></td>
                    </tr>
                    <tr>
                        <td>Times: <form:input type="text" path = "times"/></td>
                    </tr>
                    <tr>
                        <td><input type="submit" value = "Add Course"/></td>
                    </tr>
                    <tr>
                        <td>${message}</td>
                    </tr>

                </table>
   </spring:nestedPath>
            </form>
                </body>
                </html>
