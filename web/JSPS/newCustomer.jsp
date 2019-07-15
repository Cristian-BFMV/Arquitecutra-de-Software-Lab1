<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Head.jsp"></jsp:include>
    </head>
    <body>
        <main>
            <div class="d-flex justify-content-center align-content-center flex-wrap my-5">
                <form id="registro" class="w-50" action="../CustomerServlet?action=register" method="post" enctype ="multipart/form-data">
                    <div class="form-group">
                        <label for="exampleInputEmail1">Nombre</label>
                        <input type="text" class="form-control" aria-describedby="emailHelp" placeholder="Nombre" name="name" required="">                    
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Número de documento</label>
                        <input type="text" class="form-control" placeholder="Número de documento" name="documentNumber" required="">
                    </div>
                    
                    <div class="form-group">
                        <label for="exampleInputPassword1">email</label>
                        <input type="email" class="form-control" placeholder="Enter email" name="email" required=""> 
                        <small id="emailHelp" class="form-text text-muted">We'll never share your email with anyone
                            else.</small>
                    </div>
                    <div class="form-group">
                        <label for="exampleInputPassword1">Password</label>
                        <input type="password" class="form-control" placeholder="Password" name="password" required="">                    
                    </div>                
                    <button class="btn btn-primary  w-100" type="submit" name="action" value="register">Registrarse</button>

                </form>
            </div>
        </main>
    </body>
</html>

