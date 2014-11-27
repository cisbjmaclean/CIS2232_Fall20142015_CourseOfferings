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
                        <td><c:out value="${course.course_id}"/></td>
                        <td><c:out value="${course.course_start_date}"/></td>
                        <td><c:out value="${course.course_end_date}"/></td>
                        <td><c:out value="${course.course_prereqs}"/></td>
                        <td><c:out value="${course.course_co_reqs}"/></td>
                        <td><c:out value="${course.course_capacity}"/></td>
                        <td><c:out value="${course.member_id}"/></td>
                        <td><c:out value="${course.location_code}"/></td>
                        <td><c:out value="${course.room_number}"/></td>
                        <td><c:out value="${course.course_days}"/></td>
                        <td><c:out value="${course.course_times}"/></td>
                    </tr>
                </c:forEach>
            </table>
        </c:otherwise>
    </c:choose>
</spring:nestedPath>