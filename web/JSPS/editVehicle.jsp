<%@page import="com.udea.entity.Vehicle"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Head.jsp"></jsp:include>
    </head>
    
        <jsp:include page="menu.jsp"></jsp:include>
        <main>
            <h1>Editar vehiculo</h1>
            <div class="d-flex justify-content-center align-content-center flex-wrap my-5">
                    <form id="registro" class="w-50" action="../VehicleServlet?action=edit&license=${vehicle.license}" method="post" enctype ="multipart/form-data">
                        <div class="form-group">
                            <label for="exampleInputPassword1">Matricula</label>
                            <h1>${vehicle.license} </h1>                    
                        </div>
                        <div class="form-group">
                            <label for="exampleInputEmail1">Marca</label>
                            <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="${vehicle.brand}" name="brand">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Modelo</label>
                            <input type="text" class="form-control" placeholder="${vehicle.model}" name="model">
                        </div>                
                        
                        <div class="form-group">
                            <label for="exampleInputPassword1">Kilometraje</label>
                            <input type="text" class="form-control" placeholder="${vehicle.km}" name="km">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Precio</label>
                            <input type="text" class="form-control" placeholder="${vehicle.price}" name="price">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Estado</label>
                            <select name="state" class="custom-select">
                                
                                <option value="Disponible">Disponible</option>
                                <option value="Vendido">Vendido</option>                        
                            </select>
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Imagen</label>
                            <div class="custom-file">
                                <input type="file"  name="image" class="custom-file-input" id="customFile" value="${vehicle.image}" >
                                <label class="custom-file-label" for="customFile">Choose file</label>
                            </div>
                        </div>
                        
                        <button class="btn btn-primary  w-100" type="submit" name="action" value="edit">Editar vehiculo</button>
                    </form>                    
                </div>
        </main>                                               
</html>