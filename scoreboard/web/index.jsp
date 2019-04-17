<%--
  Created by IntelliJ IDEA.
  User: xiaoaxiao
  Date: 2019/4/17
  Time: 22:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>scoreBoard</title>
    <script src="jquery-1.8.0.min.js"></script>
    <script src="index.js"></script>
  </head>
  <body>
    <form>
      <tr>
        <td>id:</td>
        <td><input type="text" name="id" value="" onchange="receiveId()"/></td>
      </tr>
      <br/>
      <tr>
        <td>name:</td>
        <td><input type="text" name="name" value=""/></td>
      </tr>
    </form>
  </body>
</html>
