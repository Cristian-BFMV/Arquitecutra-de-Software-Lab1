<%-- 
    Document   : shop
    Created on : Jul 11, 2019, 8:59:10 AM
    Author     : camiloa.mejia
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Bienvenido a la página ${login}</h1>
        <c:forEach var="v" items="${vehicles}">
            |${v.license}| |${v.brand}| |${v.model}| |${v.price}| |${v.km}| |${v.state}|  <img src="../VehiclesImages/${v.image}" height="200px" width="200px">  
           
           <hr/>
        </c:forEach>  
           <p>No se que carajos es esto</p>
    </body>
</html>
