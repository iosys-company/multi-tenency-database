<!-- JSP -->
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <!-- Dashboard page -->
    <!DOCTYPE html>
    <html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Spring Boot Application</title>
    </head>
    <body>
        <h1>Dashboard</h1>
        <p>Dashboard page</p>
        <p>${username}님 ${message} (${systemTime})</p>
    </body>
    </html>
