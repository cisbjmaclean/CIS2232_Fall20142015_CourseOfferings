<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<spring:nestedPath path="menu">
    <form action="" method="post">
        <h2>Welcome to CISIS</h2>
        <table>
            <tr>
                <td><h2>Choose an option</h2>
                </td>
            </tr>
                <c:forEach var="course" items="${courses}" varStatus="loopCounter">
                <tr>
                    <td><c:out value="${loopCounter.count}" /></td>
                    <td><c:out value="${course.courseID}" /></td>
                    <td><c:out value="${course.yearCode}" /></td>
                    <td><c:out value="${course.courseStart}" /></td>
                    <td><c:out value="${course.courseEnd}" /></td>
                    <td><c:out value="${course.preReqs}" /></td>
                    <td><c:out value="${course.courseCap}" /></td>
                    <td><c:out value="${course.coReqs}" /></td>
                    <td><c:out value="${course.memberID}" /></td>
                    <td><c:out value="${course.location}" /></td>
                    <td><c:out value="${course.roomNo}" /></td>
                    <td><c:out value="${course.days}" /></td>
                    <td><c:out value="${course.times}" /></td>
                    <a href = "courseCalendar?action = edit&courseID=${course.courseID}">Edit Course</a>
                    <a href = "courseCalendar?action = delete&courseID=${course.courseID}">Delete Course</a>
                </tr>
            </c:forEach>
            <tr>
                <td><a href = "courseCalendar?action=add">Add Course</a></td>
                       
            </tr>


        </table>
    </form>
</spring:nestedPath>


