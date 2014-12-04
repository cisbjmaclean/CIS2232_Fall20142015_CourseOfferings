<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<spring:nestedPath path="courseList">
    ${academicYear}<br/>
    
    <c:choose>
        <c:when test="${numCourses == 0}">
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
                        <td><c:out value="${course.getMemberId()}"/></td>
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