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
                <tr>
                    <td><strong>Select Year and Semester</strong>
                    <select name="yearSemester"><option value="1" selected="selected">2014-2015 First Semester</option>
                        <option value="2">2014-2015 Second Semester</option>
                        <option value="3">2015-2016 First Semester</option>
                        <option value="4">2015-2016 Second Semester</option>                   
                        </td>

                </tr>
            </table>
            <table style = 'border:#000;'>
                <tr>
                    <th>
                    </th>
                    <th>
                    Monday  
                    </th>
                     <th>
                    Tuesday 
                    </th>
                     <th>
                    Wednesday
                    </th>
                     <th>
                    Thursday
                    </th>
                     <th>
                    Friday
                    </th>
                </tr>
                <tr>
                    <td>9:00am-10:30am</td>
                    <td>CIS1201A</td>
                    <td>CIS1280B<br />CIS1300A</td>
                    <td>CIS1201A</td>
                    <td>CIS1280B<br />CIS1300A</td>
                    <td>CIS1300B</td>
                </tr>
                <tr>
                    <td>10:30am-12:00pm</td>
                    <td>CIS1201B</td>
                    <td>CIS1280A<br />CIS1300B</td>
                    <td></td>
                    <td>CIS1360A</td>
                    <td></td>
                    <td>CIS1280A<br />CIS1360B</td>
                    
                    
                </tr>
                <tr>
                   <td>12:00pm-1:00pm</td> 
                   <td></td>
                   <td></td>
                   <td></td>
                   <td></td>
                   <td></td>
                </tr>
                <tr>
                    <td>1:00pm-2:30pm</td>
                    <td>CIS1150A<br />CIS1150B</td>
                    <td>CIS1160A<br />CIS1360B</td>
                    <td>CIS1150A<br />CIS1150B</td>
                    <td>CIS1150A<br />CIS1150B</td>
                    <td></td>
                </tr>
                <tr>
                    <td>2:30pm-4:00pm</td>
                    <td>CIS1360A</td>
                    <td></td>
                    <td></td>
                    <td>CIS1160A</td>
                    <td></td>
                </tr>
                
                
            </table>
    </form>
    </spring:nestedPath>


