<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<spring:nestedPath path="menu">
    <form action="menu" method="post">
        <table>                     
            <tr>
                <td><input type="submit" name="action" value="User profile"></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Change Password"></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Course Calendar"></td></tr>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Add Course" /></td>
            </tr>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Edit Course" /></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Logout"></td>
            </tr>
            <tr>
                <td><fmt:message key="label.admin" /></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="User Directory"></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Edit Users" /></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Reports"></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="Notifications"></td>
            </tr>
            <tr>
                <td><input type="submit" name="action" value="View Codes"></td>
            </tr>
        </table>
    </form>
</spring:nestedPath>
