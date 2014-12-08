<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<form action="memberBioUpdate" method="post">
    <spring:nestedPath path="member">

        <table>                

            <tr><td><h3>Member Information:</h3></td></tr>
            <tr>
                <td>
                    <h3><fmt:message key="label.information" /></h3>
                </td>
            </tr>

            <tr>
                <td><form:hidden path="memberId"/>
            <label class="alignCenter" for="firstName">
                <strong><fmt:message key="label.first.name" /></strong></label>
                <form:input path="firstName" size="20" />
            </td>
            </tr>
            
            <tr>
                <td>
                    <label class="alignCenter" for="middleName">
                        <strong><fmt:message key="label.middle.name" /></strong></label>
                        <form:input path="middleName" size="20" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="lastName">
                        <strong><fmt:message key="label.last.name" /></strong></label>
                        <form:input path="lastName" size="20" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="workPhone">
                        <strong><fmt:message key="label.work.phone" /></strong></label>
                        <form:input path="workPhone" size="10" />
                    <label class="alignCenter"  for="workPhoneExtension">
                        <strong><fmt:message key="label.work.phone.extension" /></strong></label>
                        <form:input path="workPhoneExtension" size="3" />
                </td>
            </tr>
            <tr>
                <td>
                    <label class="alignCenter"  for="emailAddress">
                        <strong><fmt:message key="label.email.address" /></strong></label>
                        <form:input path="emailAddress" size="25" />
                </td>
            </tr>
            <tr/>
            <tr align="center">
                <td colspan="2">
                    <input type="submit" value=<fmt:message key="label.save"/>
                </td>
            </tr>
            <tr>
                <td>${informationMessage}</td>
            </tr>
        </table>
    </spring:nestedPath>
</form>
