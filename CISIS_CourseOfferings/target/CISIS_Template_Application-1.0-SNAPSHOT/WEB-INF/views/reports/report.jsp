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
