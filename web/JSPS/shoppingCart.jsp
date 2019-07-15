<%--
    Document   : shoppingCart
    Created on : 01/07/2019, 08:53:07 PM
    Author     : FelipeT
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Head.jsp"></jsp:include>
        </head>
        <body>
        <jsp:include page="menu.jsp"></jsp:include>
        <main class="justify-content-center">
                <h1>Carrito</h1>
                <table class="table w-100">
                    <thead class="thead-dark">
                        <tr>                            
                            <th scope="col">Matricula</th>
                            <th scope="col">Marca</th>
                            <th scope="col">Modelo</th>
                            <th scope="col">Precio</th>
                            <th scope="col">Kilometraje</th>                                                        
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="v" items="${vehiclesCart}">
                        <tr>                                
                            <td>${v.license}</td>
                            <td>${v.brand}</td>
                            <td>${v.model}</td>
                            <td>${v.price}</td>
                            <td>${v.km}</td>                            
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
                <a onclick="return confirm('Esta seguro de hacer la compra?')" href="../BillServlet?action=buy">Comprar</a>
        <%--<button onclick="return confirm('¿Está seguro de hacer la compra?')" type="submit" href="../BillServlet?action=buy" class="btn btn-outline-primary mx-5  w-50">Comprar</button>--%>
        </main>                 
    </body>
</html>
