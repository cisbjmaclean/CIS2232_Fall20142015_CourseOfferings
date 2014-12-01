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
                <td><h2><fmt:message key="welcome.message" /></h2>
                </td>
            <tr>
                <td><strong>Select Year and Semester</strong>
                    <select name="yearSemester"><option value="1" selected="selected">2014-2015 First Semester</option>
                        <option value="2">2014-2015 Second Semester</option>
                        <option value="3">2015-2016 First Semester</option>
                        <option value="4">2015-2016 Second Semester</option>                   
                </td>
            </tr>
            <tr>
                <td><input type="submit" value=<fmt:message key="label.add.course"/></td>
                <td><input type="submit" value=<fmt:message key="label.add.course"/></td>
            </tr>


        </table>
    </form>
</spring:nestedPath>


