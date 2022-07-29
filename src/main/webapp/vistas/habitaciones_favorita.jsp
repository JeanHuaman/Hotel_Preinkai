<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modelo.HabitacionFavorita"%>
<%@page import="modelo.Usuario"%>
<%@page import="java.util.List"%>
<%@page import="dao.HabitacionFavoritaDAO"%>
<%

    List<HabitacionFavorita> habitacionesFavoritas = new HabitacionFavoritaDAO().listar();


%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>Habitaciones Favoritas</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/estilos/style.css" rel="stylesheet" type="text/css" />
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
                                        <%                                    Usuario usuario = (Usuario) session.getAttribute("usuario");
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
        <div class="container">
            <div class="row mt-3">
                <h1 class="text-center">Habitaciones Favoritas</h1>

                <main class="mt-3">
                    <div class="row row-cols-1 row-cols-md-3 g-4" style="padding: 25px;">
                        <% for (HabitacionFavorita habitacionFavorita : habitacionesFavoritas) {%>
                        <div class="col">
                            <div class="card">
                                <img src="${pageContext.request.contextPath}/img/<%= habitacionFavorita.getImagen()%>" class="card-img-top" style="width: 100%;">
                                <div class="card-body">
                                    <h5 class="card-title"><%= habitacionFavorita.getDescripcion()%></h5>
                                    <p class="card-text">S/.<%= habitacionFavorita.getPrecio()%>0</p>
                                    <a href="#" class="btn btn-primary">Reservar</a>
                                </div>
                            </div>

                        </div>
                        <% }%>
                    </div>
                </main>
            </div>
        </div>
         <br><br><br><br><br>
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
    </body>
</html>
