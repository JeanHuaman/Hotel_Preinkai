<%@page import="modelo.Usuario"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>Reportes Preinkai</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/estilos/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <header class="py-3">
            <nav class="container d-md-flex justify-content-md-between align-items-md-center">
                <div class="text-center">
                    <img src="${pageContext.request.contextPath}/img/Logo.png" alt="logo">
                </div>
                <div class="d-flex justify-content-around">
                    <div class="px-2">
                        <a class="btn btn-primary" href="">Ver Reservación</a>
                    </div>
                    <%   Usuario usuario = (Usuario) session.getAttribute("usuario");
                        if (usuario != null) {
                    %>
                    <ul class="navbar-nav me-auto my-2 my-lg-0" style="--bs-scroll-height: 100px;">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                <%= usuario.getEmail()%>
                            </a>
                            <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                <li><a class="dropdown-item" href="${pageContext.request.contextPath}/UsuarioControlador?accion=cerrarSesion">Cerrar Sesión</a></li>
                            </ul>
                        </li>
                    </ul>
                    <%
                        }
                    %>
                </div>
            </nav>  
        </header>
        <main class="container mx-auto row flex-column flex-md-row">
            <section class="optionDashboard col-12 col-md-3">
                <div class="list-group">
                    <button type="button" class="option" aria-current="true">
                        DashBoard
                    </button>
                    <a class="option" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Mantenimiento</a>
                    <div class="collapse multi-collapse " id="multiCollapseExample1">
                        <div class="card card-body subOption">
                            <a href="">Habitaciones</a>
                            <a href="">Servicios</a>
                        </div>
                    </div> 
                    <div class="row text-center">
                        <a href = "reportes.jsp"><button type="button" class="option">Reportes</button></a>
                    </div>
                </div>                                  
            </section>
            <section class="col-12 col-md-9">
                <div class="row">
                    <h3 class="text-center"> Reportes </h3>
                    <div class="col-sm-6 text-center">   
                        <div class="card_item">
                            <div class="card-body">
                                <br><br>
                                <h4 style="color:blue;">Reserva de Habitaciones</h4>
                            </div></div>
                        <h5>La reserva hotelera es la obligación que asume un alojamiento turístico de guardar para una fecha o un periodo de tiempo determinado una o varias habitaciones o plazas, con la exigencia inmediata de pago de todo o parte del precio que éste supondrá, penalizando en caso de cancelación.</h5><br>
                        <a href="../UsuarioControlador?accion=GenerarReporteExcel" class="btn btn-success">Generar Reporte en Excel</a>
                        <a href="../vistas/pdfReservaHabitacion.jsp" target="_blank" class="btn btn-danger">Generar Reporte en Pdf</a>
                    </div>
                    <div class="col-sm-6">   
                        <br><br><br><br>
                        <img src="${pageContext.request.contextPath}/img/reserva_de_habitaciones.png" width="100%;">
                    </div>
                    <div class="col-sm-6">   
                        <br><br><br><br>
                        <img src="${pageContext.request.contextPath}/img/reserva_de_servicios.png" width="100%;">
                        <br><br><br><br>
                    </div>
                    <div class="col-sm-6 text-center">   
                        <div class="card_item">
                            <div class="card-body">
                                <br><br>
                                <h4 style="color:blue;">Reserva de Servicios</h4>
                            </div></div>
                        <h5>La reserva hotelera también se encuentra la reservación de servicios en el cual cada usuario ha realizado, por ello es importante un reporte en pdf de la reserva de servicios, de tal forma tener un mejor control de los servicios que brinda el hotel.</h5><br>
                        <a href="../vistas/pdfReservaServicio.jsp" target="_blank" class="btn btn-danger">Generar Reporte en Pdf</a>
                    </div>
                </div> 
            </section>
            <br>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>

    </body>
</html>
