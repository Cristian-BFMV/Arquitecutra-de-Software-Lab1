
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<header>
    <nav id="navBar" class="navbar navbar-expand-md navbar-dark ">
        <a id="brand" class="navbar-brand" href="index.jsp">Deshuesadero</a>
        <button class="navbar-toggler " type="button" data-toggle="collapse" data-target="#navbarNav"
            aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
        </button>
            <div class="collapse navbar-collapse justify-content-end" id="navbarNav">
                <ul id="links" class="navbar-nav">                                        
                    
                    <c:if test="${rol eq 1}">                         
                        <li class="nav-item">
                            <a class="nav-link h-100" href="newVehicle.jsp">Registrar&nbsp&nbspvehiculos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link h-100" href="../VehicleServlet?action=list">Vehiculos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link h-100" href="../BillServlet?action=list">Facturas</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link h-100" href="indexUser.jsp">Logout</a>
                        </li>
                     </c:if>
                     <c:if test="${rol ne 1}">
                        <li class="nav-item">
                            <a class="nav-link h-100" href="../VehicleServlet?action=list">Vehiculos</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link h-100" href="../CartServlet?action=list">Compras</a>
                        </li>
                        <li class="nav-item">
                            <a class="nav-link h-100" href="../CustomerServlet?action=logout">Logout</a>
                        </li>
                     </c:if>
                </ul>
            </div>
    </nav>
</header>

