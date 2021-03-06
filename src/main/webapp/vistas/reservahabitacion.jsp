<%@page import="modelo.Habitacion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="modelo.Usuario"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Hotel PREINKAI</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">

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
                                        <%  Usuario usuario = (Usuario) session.getAttribute("usuario");
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
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/vistas/habitaciones_favorita.jsp">Favoritos</a></li>
                                            <li><a class="dropdown-item" href="#historial">Historial</a></li>
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/UsuarioControlador?accion=cerrarSesion">Cerrar Sesi??n</a></li>
                                        </ul>
                                    </li>
                                    <%
                                    } else {
                                    %>
                                    <li class="nav-item">
                                        <a class="nav-link" href="${pageContext.request.contextPath}/UsuarioControlador?accion=GoToLogin">Iniciar Sesi??n</a>
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
        <section>
            <div class="container">
                <h1 class="text-center">Datos del Usuario:</h1>
            </div>                
        </section>
        <main>
            <form method="POST" action="${pageContext.request.contextPath}/UsuarioControlador?accion=agregarHabitacion&idHabitacion=${habitacion.id_habitacion}">
                <section class="row px-5 me-0 gap-2 justify-content-lg-between">
                    <div class="col-12 col-lg-5 ">
                        <% Habitacion habitacion = (Habitacion) request.getAttribute("habitacion");
                            if(habitacion!=null){
                            int iteracion = habitacion.getPersonas_maximas();                            
                            for (int i = 0; i <iteracion ; i++) {%>
                        <h3><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                            <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                            <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                            </svg> Huesped <%= i + 1%></h3>
                        <div class="mb-3">
                            <label class="form-label">Nombre</label>
                            <input type = "text" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Apellido</label>
                            <input type = "text" class="form-control">
                        </div>
                        <div class="mb-3">
                            <label class="form-label">Dni</label>
                            <input type = "text" class="form-control">
                        </div>
                        <% }}%>
                    </div>
                    <div class="col-12 col-lg-6 px-0 pb-1 fs-4">
                        <div>
                            <p>${habitacion.getDescripcion()}</p>
                            <div class="row text-center">
                                <div class ="col-sm-6">
                                    <span> Entrada </span>
                                    <p>${fechaEntrada}</p>   
                                </div>
                                <div class ="col-sm-6">
                                    <span> Salida </span>
                                    <p>${fechaSalida}</p> 
                                </div>
                            </div>
                            <br>
                            <h4 style ="color: red;"> Tarifa no se admite modificacion ni cancelaci??n </h4>
                            <br> 
                            <div class="row text-center">
                                <p>Detalle de la reserva</p> 
                            </div>
                            <br>
                            <div class="row text-center">
                                <div class ="col-sm-6">
                                    <p> Alojamiento: </p> 
                                    <p> Gastos Extra: </p>
                                    <p> Precio Total: </p>  
                                </div>
                                <div class ="col-sm-6">
                                    <p> $ ${habitacion.getPrecio()} </p>
                                    <p> $ 0 </p>
                                    <p> $ ${habitacion.getPrecio()} </p>
                                </div>
                                <button type="submit" class="btn btn-primary w-100">Reservar</button>

                            </div>
                            <br><br><br>
                            <div class="row text-center">
                                <h4><b>Todavia estas a tiempo ??RESERVA YA!</b></h4>
                            </div>
                        </div>
                    </div>
                </section>
            </form>
        </main>
    </body>
</html>
