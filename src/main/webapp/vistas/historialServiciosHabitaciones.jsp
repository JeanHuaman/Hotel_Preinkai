<%@page import="modelo.Usuario"%>
<%@page import="dao.ReservaDAO"%>
<%@page import="modelo.Reserva"%>
<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/estilos/style.css" rel="stylesheet" type="text/css" />
        <title>Historial</title>
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
                                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/UsuarioControlador?accion=historial">Historial</a></li>
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
        <div class="text-center">
            <h1>Historial de Servicios y Habitaciones</h1>
        </div>
        <header class="p-3">
            <nav>
                <div class="row mx-2">
                    <h3 align="left">Historial:</h3>
                </div>
            </nav>
        </header>
        <div class="container mt-1">
            <% List<Reserva> historial = (List<Reserva>) session.getAttribute("historial");
                if (historial != null) {
                    for (Reserva reserva : historial) {
            %>
            <section class="historialFondo">
                
                <h2><%= reserva.getTipoReserva()%></h2>
                <div class="historial">
                    <div class="cabeza">idReserva</div>
                    <div class="cabeza">Importe Total</div>
                    <div class="cabeza">Tipo de pago</div>
                    <div class="cabeza">Tipo de tarjeta</div>
                    <div class="cabeza">Fecha de Entrada</div>
                    <div class="cabeza">Fecha de Salida</div>
                    <div class="cabeza">Cantidad de Personas</div>
                    <div><%= reserva.getIdReserva() %></div>
                    <div><%= reserva.getImporteTotal() %></div>
                    <div><%= reserva.getTipoPago() %></div>
                    <div><%= reserva.getTipoTarjeta() %></div>
                    <div><%= reserva.getFechaEntrada() %></div>
                    <div><%= reserva.getFechaSalida()%></div>
                    <div><%= reserva.getCantidadPersonas() %></div>
                </div>
            </section>
            <% }
                }%>
        </div>
        <!-- Page level custom scripts -->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>

        <!-- Bootstrap core JavaScript-->
        <script src="../vendor/jquery/jquery.min.js"></script>
        <script src="../vendor/bootstrap/js/bootstrap.bundle.min.js"></script>

        <!-- Core plugin JavaScript-->
        <script src="../vendor/jquery-easing/jquery.easing.min.js"></script>

        <!-- Page level plugins -->
        <script src="../vendor/datatables/jquery.dataTables.min.js"></script>
        <script src="../vendor/datatables/dataTables.bootstrap4.min.js"></script>

        <!-- Page level custom scripts -->
        <script src="../js/demo/datatables-demo.js"></script>
    </body>
</html>
