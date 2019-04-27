<%--
  Created by IntelliJ IDEA.
  User: xiaoaxiao
  Date: 2019/4/25
  Time: 23:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>MainTest</title>
</head>
<body>
<form action="search" method="get">
    <table>
        <tr>
            <td>Build:</td>
            <td><input type="text" name="build" value=""/></td>
        </tr>
        <tr>
            <td>BuildNumber:</td>
            <td><input type="text" name="buildnumber" value=""/></td>
        </tr>
        <tr>
            <td>BuildLevel:</td>
            <td><input type="text" name="buildlevel"/></td>
        </tr>
        <tr>
            <td>Week:</td>
            <td><input type="text" name="week"/></td>
        </tr>
        <tr>
            <td>Day:</td>
            <td><input type="text" name="day"/></td>
        </tr>
        <tr>
            <td>Time:</td>
            <td><input type="text" name="time"/></td>
        </tr>



        <tr>
            <td><input type="submit" value="submit"/></td>
        </tr>
    </table>
</form>
</body>
</html>
