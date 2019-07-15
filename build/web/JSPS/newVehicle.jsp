<%-- 
    Document   : newVehicle
    Created on : 01/07/2019, 08:53:07 PM
    Author     : Camilito
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Head.jsp"></jsp:include>     
        </head>
        <body>
        <jsp:include page="menu.jsp"></jsp:include>        
           
        <main>
                <h1>Registro de vehiculos</h1>
                <div class="d-flex justify-content-center align-content-center flex-wrap my-5">
                    <form id="registro" class="w-50" action="../VehicleServlet?action=insert" method="post" enctype ="multipart/form-data">
                        <div class="form-group">
                            <label for="exampleInputEmail1">Marca</label>
                            <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="Marca" name="brand">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Modelo</label>
                            <input type="text" class="form-control" placeholder="Modelo" name="model">
                        </div>                
                        <div class="form-group">
                            <label for="exampleInputPassword1">Matricula</label>
                            <input type="text" class="form-control" placeholder="Matricula" name="license">                    
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Kilometraje</label>
                            <input type="text" class="form-control" placeholder="Kilometraje" name="km">
                        </div>
                        <div class="form-group">
                            <label for="exampleInputPassword1">Precio</label>
                            <input type="text" class="form-control" placeholder="Precio" name="price">
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
                                <input type="file"  name="image" class="custom-file-input" id="customFile">
                                <label class="custom-file-label" for="customFile">Choose file</label>
                            </div>
                        </div>                        
                        <button class="btn btn-primary  w-100" type="submit" name="action" value="insert">Registrar vehiculo</button>
                    </form>                    
                </div>
            </main>        
    </body>
</html>