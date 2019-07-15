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
                <h1>Vehiculo Encontrado</h1>
                <div class="col-xl-6 col-lg-6 col-md-6 col-sm-12 col-12 my-2 p-2">
                    <div class="card">
                        <img class="card-img-top" src="../VehiclesImages/${vehicle.image}" alt="Card image cap">
                        <div class="card-body">
                            <h5 class="card-title">Marca: &nbsp ${vehicle.brand}</h5>
                        <p class="card-text">Modelo: &nbsp ${vehicle.model}</p>
                    </div>
                    <ul class="list-group list-group-flush">
                        <li class="list-group-item">Matricula: &nbsp ${vehicle.license}</li>
                        <li class="list-group-item">Precio: &nbsp ${vehicle.price}</li>
                        <li class="list-group-item">Kilometraje: &nbsp ${vehicle.km}</li>
                        <li class="list-group-item">Estado: &nbsp ${vehicle.state}</li>
                    </ul>
                    <div class="card-body">
                        <a href="../VehicleServlet?action=formEdit&license=${vehicle.license}" class="card-link">Editar</a>
                        <a href="../VehicleServlet?action=delete&license=${vehicle.license}" class="card-link" onclick="return confirm('Esta seguro?')">Eliminar</a>
                    </div>
                </div>
            </div>    
        </main>        
</html>
