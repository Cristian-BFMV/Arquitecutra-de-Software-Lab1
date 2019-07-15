
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="Head.jsp"></jsp:include>
    </head>
    <body>
            <h1>Hello World!</h1>
        <c:if test="${param.error==1}">
            <font color="red">Usuario Invalido. Intentelo de nuevo</font>
        </c:if>     
        <main>
        <div class="d-flex justify-content-center align-content-center flex-wrap my-5">
            <form action="../CustomerServlet?action=login" method="post" >
                <div class="form-group">
                    <label for="exampleInputID">Cedula:</label>
                    <input type="text" class="form-control" aria-describedby="id" name="documentNumber" required="" placeholder="Enter Cedula">
                    <small id="IDHelp" class="form-text text-muted">We'll never share your ID with anyone
                        else.</small>
                </div>
                <div class="form-group">
                    <label for="exampleInputPassword">Password</label>
                    <input type="password" class="form-control" placeholder="Password" name="password" required="">
                </div>
                <button class="btn btn-primary  w-100" type="submit" name="action" value="login">LOGIN</button>
            </form>
        </div>
    </main>
    </body>
</html>



