<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modelo.Usuario"%>
<%@page import="modelo.Habitacion"%>
<%@page import="java.util.List"%>
<%@page import="dao.HabitacionDAO"%>
<%

    List<Habitacion> habitaciones = new HabitacionDAO().listar();


%>
<!doctype html>
<html lang="en">  
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Hotel PREINKAI</title>
        <!-- Custom fonts for this template-->
        <link href="vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <!-- Custom styles for this page -->
        <link href="vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
    </head>
    <body>
        <header>
            <div class="header_top">
                <nav class="navbar navbar-expand-lg bg-light">
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">HOTEL PREINKAI</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarScroll">
                            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="HabitacionControlador?accion=listarHabitaciones">Inicio</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#habitaciones">Habitaciones</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="${pageContext.request.contextPath}/vistas/servicios.jsp">
                                        Servicios
                                    </a>
                                    <!--<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                                        <li><a class="dropdown-item" href="#">Action</a></li>
                                        <li><a class="dropdown-item" href="#">Another action</a></li>
                                        <li><hr class="dropdown-divider"></li>
                                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                                    </ul>-->
                                </li>
                                <%                                    Usuario usuario = (Usuario) session.getAttribute("usuario");
                                    if (usuario != null) {
                                %>
                                <li class="nav-item dropdown">
                                    <a class="nav-link dropdown-toggle" href="#" id="navbarDropdown" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                                        <%= usuario.getEmail()%>
                                    </a>
                                    <ul class="dropdown-menu" aria-labelledby="navbarDropdown">
                                        <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ReservacionControlador?accion=VerReservacion&idUsuario=<%= usuario.getIdUsuario()%>">Ver Reservacion</a></li>
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
                                <li class="nav-item">
                                    <a class="nav-link" href="#contactanos">Contactanos</a>
                                </li>
                            </ul>

                        </div>
                    </div>
                </nav>
            </div>
        </header>
        <section style="background-image: url(img/banner_hotel.jpg);background-repeat: no-repeat;
                 background-position: center;background-attachment: fixed;" class="mt-3" id="inicio">
            <div class="container">
                <br>
                <div class="row">
                    <div class="col-sm-4">
                        <div class="card text-bg-dark text-center mb-3" style="max-width: 20rem;opacity: 94%;">
                            <div class="card-header">
                                Desde S/.100.00
                            </div>
                            <form action="HabitacionControlador" method="post">
                                <input type="hidden" name="accion" value="RoomsRecommendation">
                                <div class="card-body" style="text-align: left;">
                                    <h5 class="card-title">RESERVA ONLINE</h5>
                                    <p class="card-text">Mejor precio garantizado</p>
                                    <p class="card-text">--------------------------------------------</p>
                                    <div class="row">
                                        <div class="col-6">
                                            <p>Entrada</p> 
                                            <input type="date" class="form-control" name="fechaEntrada" required value="${fechaEntrada}">
                                        </div>
                                        <div class="col-6">
                                            <p>Salida</p> 
                                            <input type="date" class="form-control" name="fechaSalida" required value="${fechaSalida}">
                                        </div> 
                                    </div>
                                    <br>
                                    <p class="card-text">Su reserva será de 1 noche(s)</p>
                                    <div class="row">
                                        <div class="col-6">
                                            <p>Adulto(s)</p> 
                                            <input type="number" class="form-control" name="cantAdultos" min="0">
                                        </div>
                                        <div class="col-6">
                                            <p>Niño(s)</p> 
                                            <input type="number" class="form-control" name="cantNinos" min="0">
                                        </div> 
                                    </div>
                                </div>
                                <div class="card-footer text-muted">
                                    <input type="submit" class="btn btn-primary" value="Ver Precios">
                                </div>
                            </form> 
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <br> <br>
        ${carritoHabitacion}
        <section>
            <div class="container">
                <div class="row">
                    <div class="col-sm-6">
                        <h2>Habitaciones de PREINKAI</h2>
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
                                        <tfoot>
                                            <tr>
                                                <th>Imagen</th>
                                                <th>Descripción</th>
                                            </tr>
                                        </tfoot>
                                        <tbody>
                                            <% for (Habitacion habitacion : habitaciones) {%>
                                            <tr>
                                                <td><img src="<%= habitacion.getImagen()%>" class="card-img-top" alt="..."></td>
                                                <td><h5><%= habitacion.getDescripcion()%></h5>
                                                    <h5 style="color: red;"><b>S/.<%= habitacion.getPrecio()%>0</b></h5>
                                                    <br> 
                                                    <a href="${pageContext.request.contextPath}/HabitacionControlador?accion=RoomDetails&id=<%= habitacion.getId_habitacion()%>" class="btn btn-primary">Ver detalles</a>
                                                </td>
                                            </tr>
                                            <% }%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div> 

                    <div class="col-sm-6">
                        <h2>Servicios de PREINKAI</h2>
                        <!-- DataTales Example -->
                        <div class="card shadow mb-4">
                            <!--<div class="card-header py-3">Servicios de PREINKAI</div>-->
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table">
                                        <thead>
                                            <tr>
                                                <th scope="col">#</th>
                                                <th scope="col">Nombre</th>
                                                <th scope="col">Descripción</th>
                                            </tr>
                                        </thead>
                                        <tbody class="table-group-divider">
                                            <tr>
                                                <th scope="row">1</th>
                                                <td>Exteriores</td>
                                                <td>Terraza , Terraza, Jardí­n</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">2</th>
                                                <td>Mascotas</td>
                                                <td>Se admiten. Se pueden aplicar suplementos.</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">3</th>
                                                <td>Comida y bebida</td>
                                                <td>Bar, Restaurante</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">4</th>
                                                <td>Internet</td>
                                                <td>Hay conexión a internet Wi-Fi disponible en todo el establecimiento. Gratis.</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">5</th>
                                                <td>Aparcamiento</td>
                                                <td>Parking adaptado para personas de movilidad reducida, Parking en un garaje</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">6</th>
                                                <td>Servicios de recepción</td>
                                                <td>Guardaequipaje, Información turÃ­stica, Recepción 24 horas</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">7</th>
                                                <td>Servicios de limpieza</td>
                                                <td>Servicio de limpieza diario, Servicio de planchado De pago, Servicio de limpieza en seco De pago, Servicio de lavanderÃ­a De pago</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">8</th>
                                                <td>General</td>
                                                <td>Aire acondicionado, Prohibido fumar en todo el alojamiento, Ascensor, Habitaciones familiares, Adaptado personas de movilidad reducida, Servicio de habitaciones</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">9</th>
                                                <td>Instalaciones de negocios</td>
                                                <td>Fax / fotocopiadora, Centro de negocios, Salas de reuniones / banquetes De pago</td>
                                            </tr>
                                            <tr>
                                                <th scope="row">10</th>
                                                <td>Seguridad</td>
                                                <td>Extintores, Cámaras de seguridad en las zonas comunitarias, Detectores de humo, Alarma de seguridad, Tarjeta de acceso, Seguridad 24 horas, Caja fuerte</td>
                                            </tr>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </section>
    <br><br>  
    <footer id="contactanos">
        <div class="footer-top text-center">
            <div class="container">
                <h2>Â¿En quÃ© te podemos ayudar?</h2>
                <p>DÃ©janos tu email y un operador te ofrecerÃ¡ la mejor opciÃ³n disponible segÃºn tu bÃºsqueda</p>
                <div class="row">
                    <div class="col-sm-8">
                        <div class="card">
                            <div class="card-body">
                                <div class="row">
                                    <div class="col-sm-6">
                                        Nombre: <label style="color:red;">(*)</label>
                                        <input type="text" class="form-control">
                                    </div>
                                    <div class="col-sm-6">
                                        Apellidos: <label style="color:red;">(*)</label>
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-6">
                                        Correo: <label style="color:red;">(*)</label>
                                        <input type="text" class="form-control">
                                    </div>
                                    <div class="col-sm-6">
                                        TelÃ©fono: <label style="color:red;">(*)</label>
                                        <input type="text" class="form-control">
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-12">
                                        DescripciÃ³n: <label style="color:red;">(*)</label>
                                        <textarea class="form-control"></textarea>
                                    </div>
                                </div>
                                <br>
                                <div class="row">
                                    <div class="col-sm-12">
                                        <a href="#" class="btn btn-primary" style="float: right;">Enviar</a>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                    <div class="col-sm-4">
                        <img src="img/contactanos.png" width="100%">
                    </div>
                </div>
            </div>
        </div>
        <br><br> 
        <div class="footer-bottom text-center" style="background-color: black;color:white;padding: 10px">
            <div class="container">
                <div class="row">
                    <p class="pull-left">Copyright Â© 2022 PREINKAI. All rights reserved.</p>
                </div>
            </div>
        </div>

    </footer><!--/Footer-->

    <!-- Page level custom scripts -->
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
