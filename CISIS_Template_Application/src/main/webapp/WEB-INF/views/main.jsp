<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
    
<spring:nestedPath path="menu">
    <form action="" method="post">
            <h2>Welcome to CISIS</h2>
            <table>
                <tr>
                    <td><h2><fmt:message key="welcome.message" /></h2>
                    </td>
                </tr>
                   <tr>
                       <td><h3>Admin Page</h3>
                    </td>
                </tr>
               
                <tr>
                    <td>
                ${message}
                
                    </td>
                </tr>
              
               
                
                
                
            </table>
    </form>
    </spring:nestedPath>
