
<%-- 
    Document   : listVehicles
    Created on : 01/07/2019, 08:52:24 PM
    Author     : Camilito
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

                <h1>VEHICULOS</h1>
                <div class="row">
                <c:forEach var="v" items="${vehicles}">            
                    <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12 my-2 p-2">
                        <div class="card">                            
                            <img class="card-img-top" src="../VehiclesImages/${v.image}" alt="Card image cap">
                            <div class="card-body">
                                <h5 class="card-title">Marca: &nbsp ${v.brand}</h5>
                                <p class="card-text">Modelo: &nbsp ${v.model}</p>
                            </div>
                            <ul class="list-group list-group-flush">
                                <li class="list-group-item">Matricula: &nbsp ${v.license}</li>
                                <li class="list-group-item">Precio: &nbsp ${v.price}</li>
                                <li class="list-group-item">Kilometraje: &nbsp ${v.km}</li>
                                <li class="list-group-item">Estado: &nbsp ${v.state}</li>
                            </ul>
                            <div class="card-body">
                                <c:if test="${empty login}">
                                <a href="../VehicleServlet?action=formEdit&license=${v.license}" class="card-link">Editar</a>
                                <a href="../VehicleServlet?action=delete&license=${v.license}" class="card-link" onclick="return confirm('Esta seguro?')">Eliminar</a>
                                </c:if>
                                <c:if test="${not empty login}">
                                <a href="../CartServlet?action=addVehicle&license=${v.license}">Anadir al carrito</a>
                                </c:if>
                            </div>
                        </div>
                    </div>       
                </c:forEach>
            </div>
             <c:if test="${empty login}">
            <h1>BUSCAR VEHÍCULO</h1>
            <div class="container">
                <form action="../VehicleServlet" method="post">                
                    <div class="form-group row">
                        <input class="btn icon-btn btn-primary" type="submit" name="action" value="find" >
                        <div class="col-md-10">
                            <input class="form-control" id="license" type="text" placeholder="License" name="license">               
                        </div> 
                    </div>    
                </form> 
            </div>
             </c:if>
        </main>
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
                integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
                integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
        crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
                integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
        crossorigin="anonymous"></script>
    </body>
</body>
</html>
