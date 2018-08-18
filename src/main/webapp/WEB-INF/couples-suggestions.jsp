<%@ page import="com.entities.Supplier" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: natalieeitan
  Date: 18/08/2018
  Time: 19:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html lang="he" dir="rtl">
<head>
    <title>Title</title>
</head>

<body>
<%List<Supplier> allSuppliers = (List<Supplier>) request.getAttribute("allSuppliers"); %>
<table border="1">
    <tr>
        <th>טלפון</th>
        <th>שם אולם</th>
    </tr>
    <%
        for (int i = 0; i < allSuppliers.size(); ++i) {
    %>
    <tr>
        <td><%= allSuppliers.get(i).getPhone() %>
        </td>
        <td><%= allSuppliers.get(i).getVenueName() %>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
