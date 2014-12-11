<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<spring:nestedPath path="menu">
    <h2><fmt:message key="welcome.heading" /></h2>
    <form action="report" method="post">
        ${message}:
        
        <form:select path="action">
            <c:forEach var="thisCode" items="${sessionScope.academic_year}" varStatus="loopCounter">
                <form:option value="${thisCode.codeValueSequence}"><c:out value="${thisCode.description}" /></form:option>
            </c:forEach>
        </form:select>
        <input type="submit" value="Export" />
    </form>
</spring:nestedPath>
    <h3>2014-2015 Academic Year</h3>
<spring:nestedPath path="courseList">
    <c:choose>
        <c:when test="${courseList.size() == 0}">
            No courses to display
        </c:when>
        <c:otherwise> 
            <table>
                <tr>
                    <th>ID</th>
                    <th>Start Date</th>
                    <th>End Date</th>
                    <th>Prerequisites</th>
                    <th>Corequisites</th>
                    <th>Capacity</th>
                    <th>Member</th>
                    <th>Location Code</th>
                    <th>Room Number</th>
                    <th>Days</th>
                    <th>Times</th>
                </tr>
                <c:forEach var="course" items="${courseList}" varStatus="loopCounter">
                    <tr>
                        <td><c:out value="${course.getCourseId()}"/></td>
                        <td><c:out value="${course.getCourseStartDate()}"/></td>
                        <td><c:out value="${course.getCourseEndDate()}"/></td>
                        <td><c:out value="${course.getCoursePrereqs()}"/></td>
                        <td><c:out value="${course.getCourseCoreqs()}"/></td>
                        <td><c:out value="${course.getCourseCapacity()}"/></td>
                        <td><c:out value="${course.getInstructor()}"/></td>
                        <td><c:out value="${course.getLocationCode()}"/></td>
                        <td><c:out value="${course.getRoomNumber()}"/></td>
                        <td><c:out value="${course.getCourseDays()}"/></td>
                        <td><c:out value="${course.getCourseTimes()}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</spring:nestedPath>
