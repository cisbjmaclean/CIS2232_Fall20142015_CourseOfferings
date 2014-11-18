<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>


<spring:nestedPath path="menu">
    <form action="welcome" method="post">
        <h2><fmt:message key="welcome.heading" /></h2>
            <table>
                <tr>
                    <td>        UserName: <input type="text" value="knjackson">
                    </td>
                </tr>    
                <tr>
                    <td>        First Name: <input type="text"value="Kylea">
                    </td>
                </tr>  
                <tr>
                    <td>        Middle Name: <input type="text" value="N">
                    </td>
                </tr>  
                <tr>
                    <td>        Email: <input type="text" value="knjackson@upei.ca">
                    </td>
                </tr>
                <tr>
                    <td>       Address: <input type="text" value="2-288 Grafton St">
                    </td>
                </tr>  
                <tr>
                    <td>       City: <input type="text" value="Charlottetown">
                    </td>
                </tr>
                <tr>
                    <td><strong>Province</strong>
                    <select name="provinceCode"><option value="1">Yukon</option>
                        <option value="2">Saskatchewan</option>
                        <option value="3">Quebec</option>
                        <option value="4">Prince Edward Island</option>
                        <option value="5" selected="selected">Ontario</option>
                        <option value="6">Nunavut</option>
                        <option value="7">Nova Scotia</option>
                        <option value="8">Northwest Territories</option>
                        <option value="9">Newfoundland and Labrador</option>
                        <option value="10">New Brunswick</option>
                        <option value="11">Manitoba</option>
                        <option value="12">British Columbia</option>
                        <option value="13">Alberta</option></select>                         
                        </td>

                </tr>
                <tr>
                    <td>       Postal Code: <input type="text" value="C1A1L7">
                    </td>
                </tr>
                <tr>
                    <td>       Home Number: <input type="text" value="902-314-7899">
                    </td>
                </tr>
                <tr>
                    <td>       Work Number: <input type="text" value="902-368-2002">
                    </td>
                </tr>
                <tr>
                    <td>        <input type="submit" name="action" value="Edit Your Information">
                    </td>
                </tr>               
                
            </table>
    </form>
    </spring:nestedPath>
