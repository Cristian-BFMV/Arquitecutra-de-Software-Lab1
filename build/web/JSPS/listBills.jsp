<%-- 
    Document   : listBills
    Author     : CamilitoFeliz
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
        <main>
            <h1>Facturas</h1>
            <table class="table w-100">
                    <thead class="thead-dark">
                        <tr>                            
                            <th scope="col">Número factura</th>
                            <th scope="col">Documento cliente</th>
                            <th scope="col">Vehiculos</th>
                            <th scope="col">Total</th>                            
                        </tr>
                    </thead>
                    <tbody>
                    <c:forEach var="b" items="${bills}">
                        <tr>                                
                            <td>${b.billNumber}</td>
                            <td>${b.customerDocumentNumber}</td>
                            <td>${b.vehiclesLicenses}</td>
                            <td>${b.total}</td>                                              
                        </tr>
                    </c:forEach> 
                </tbody>
            </table>
        </main>                                                     
    </body>
</html>
