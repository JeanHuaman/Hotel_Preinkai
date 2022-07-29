
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page import="modelo.Usuario"%>
<%
    Usuario usuario = (Usuario) session.getAttribute("usuario");
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>Hotel PREINKAI</title>
        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <div class="header_top">
                <nav class="navbar navbar-expand-lg bg-light">
                    <div class="container-fluid d-flex justify-content-between">
                        <div>
                            <a class="navbar-brand" href="#">HOTEL PREINKAI</a>
                        </div>
                        <div>
                            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                                <span class="navbar-toggler-icon"></span>
                            </button>
                            <div class="collapse navbar-collapse" id="navbarScroll">
                                <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                                    <li class="nav-item">
                                        <a class="nav-link" href="#contactanos">Contactanos</a>
                                    </li>                                      
                                        <% 
                                            if (usuario != null) {
                                        %>
                                    <li class="nav-item">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/vistas/servicios.jsp">
                                            Servicios
                                        </a>
                                    </li>
                                    <li  class="nav-item">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/vistas/pago.jsp">Ver Reservacion</a>
                                    </li>
                                    <li class="nav-item dropdown">
                                        <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                            <%= usuario.getEmail()%>
                                        </a>
                                        <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/vistas/pago.jsp">Favoritos</a></li>
                                            <li><a class="dropdown-item" href="#historial">Historial</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/UsuarioControlador?accion=cerrarSesion">Cerrar Sesión</a></li>
                                        </ul>
                                    </li>
                                    <%
                                    } else {
                                    %>
                                    <li class="nav-item">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/UsuarioControlador?accion=GoToLogin">Iniciar Sesión</a>
                                    </li>
                                    <%
                                        }
                                    %>                                
                                </ul>

                            </div>
                        </div>
                    </div>
                </nav>
            </div>
        </header>
        <br>

        <div class="container">
            <a href="index.jsp" class="btn btn-danger">Regresar</a>
            <h2>Habitación</h2>            
            <div class="row mt-3">
                <div class="col-sm-6">
                    <section>
                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <!--<div class="card-header py-3">Habitaciones de PREINKAI</div>-->
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead>
                                            <tr>
                                                <th>Imagen</th>
                                                <th>Descripción</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <c:forEach var="habitacion" items="${habitaciones_recomendadas}">
                                                <tr>
                                                    <td> <img src="${pageContext.request.contextPath}/img/${habitacion.imagen}" class="img-fluid rounded-start"></td>
                                                        <td><h5>${habitacion.descripcion}</h5>
                                                            <p class="card-text">Elige tu habitación favorita y haz tu reserva. 
                                                                Fácil, sencillo y muy cómodo a través de nuestra web. 
                                                                Solamente haciendo clic en Añadir a mis favoritos.</p>
                                                            <h5 style="color: red;"><b>S/.<c:out value="${habitacion.precio}"></c:out>0</b></h5>
                                                            <form action="UsuarioControlador" method="post">
                                                                <input type="hidden" name="accion" value="SaveFavoriteRoom">
                                                            <input type="number" name="id_habitacion" value="${habitacion.id_habitacion}" hidden="true">
                                                                <center><input type="submit" class="btn btn-success w-100" value="+ Agregar a mis favoritos"></center>
                                                            </form>
                                                <center><a href="${pageContext.request.contextPath}/UsuarioControlador?accion=seleccionarHabitacion&idHabitacion=${habitacion.id_habitacion}" class="btn btn-primary w-100" style="float: center;width: 50%;margin: 1px;">Reservar</a></center>
                                               
                                                </td>
                                                </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </section>
                </div>
                <div class="col-sm-6">
                    <img src="img/banner_ver_habitaciones_recomendadas.png" width="100%">
                </div>
            </div>
        </div>

        <br><br><br><br>
        <footer id="contactanos">
            <div class="footer-bottom text-center" style="background-color: black;color:white;padding: 10px">
                <div class="container">
                    <div class="row">
                        <p class="pull-left">Copyright © 2022 PREINKAI. All rights reserved.</p>
                    </div>
                </div>
            </div>
        </footer><!--/Footer-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

        <!-- Bootstrap core JavaScript-->
        <script src="vendor/jquery/jquery.min.js"></script>
        <script src="vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugins -->
        <script src="vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="js/demo/datatables-demo.js"></script>
    </body>
</html>
