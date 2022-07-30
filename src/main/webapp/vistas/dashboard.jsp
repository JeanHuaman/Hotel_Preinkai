<%@page import="modelo.Usuario"%>
<%@page import="dao.MembresiaDAO"%>
<%@page import="dao.IMembresiaDAO"%>
<%@page import="dao.ServicioDAO"%>
<%@page import="dao.IServicioDAO"%>
<%@page import="dao.HabitacionDAO"%>
<%@page import="dao.IHabitacionDAO"%>
<%@page import="dao.ReservaDAO"%>
<%@page import="dao.IReservaDAO"%>
<%@page import="dao.IUsuarioDAO"%>
<%@page import="dao.UsuarioDAO"%>
<%
    IUsuarioDAO usuarioDao = new UsuarioDAO();
    int cantidadUsuario = usuarioDao.cantidadUsuario();
    
    IReservaDAO reservaDao = new ReservaDAO();
    int cantidadReservas = reservaDao.cantidadReservas();
    double totalReservas = reservaDao.totalVentas();
    
    IHabitacionDAO habitacionDao = new HabitacionDAO();
    int cantidadHabitaciones = habitacionDao.cantidadHabitaciones();
    
    IServicioDAO servicioDao = new ServicioDAO();
    int cantidadServicios = servicioDao.cantidadServicios();   
    
    
%>


<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>Dashboard</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/estilos/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <header>
            <nav class="p-3 d-md-flex justify-content-md-between align-items-md-center bg-light">
                <div class="text-center">                    
                    <a href="${pageContext.request.contextPath}/index.jsp"><p class="fs-2 link-secondary">HOTEL PREINKAI</p></a> 
                </div>
                <div class="d-flex justify-content-around">
                    <div class="px-2">
                        <a class="btn btn-primary" href="">Ver Reservaci�n</a>
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
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/ReservacionControlador?accion=VerReservacion&idUsuario=<%= usuario.getIdUsuario()%>">Ver Reservacion</a></li>
                            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/UsuarioControlador?accion=cerrarSesion">Cerrar Sesi�n</a></li>
                        </ul>
                    </li>
                    </ul>
                    <%
                    }
                    %>
                </div>
            </nav>  
        </header>
        <main class="container mx-auto row flex-column flex-md-row my-2">
            <section class="optionDashboard col-12 col-md-3">
                <div class="list-group">
                    <button type="button" class="option" aria-current="true">
                        DashBoard
                    </button>
                    <a class="option" data-bs-toggle="collapse" href="#multiCollapseExample1" role="button" aria-expanded="false" aria-controls="multiCollapseExample1">Mantenimiento</a>
                    <div class="collapse multi-collapse " id="multiCollapseExample1">
                        <div class="card card-body subOption">
                            <a href="${pageContext.request.contextPath}/vistas/crudHabitaciones.jsp">Habitaciones</a>
                            <a href="${pageContext.request.contextPath}/vistas/crudHabitaciones.jsp">Servicios</a>
                        </div>
                    </div> 
                        <a href="vistas/reportes.jsp" class="btn btn-primary">Reportes</a>
                </div>                                  
            </section>
            <section class="col-12 col-md-9 py-3">
                <div class="row justify-content-between text-center">
                    <div class="card_item">
                        <img src="${pageContext.request.contextPath}/img/logoUsuario.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Usuarios</h5>
                            <p class="card-text"><%= cantidadUsuario %></p>
                        </div>
                    </div>
                    <div class="card_item">
                        <img src="${pageContext.request.contextPath}/img/logoHabitacion.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Habitaciones</h5>
                            <p class="card-text"><%= cantidadHabitaciones %></p>
                        </div>
                    </div>
                    <div class="card_item">
                        <img src="${pageContext.request.contextPath}/img/logoServicios.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Servicios</h5>
                            <p class="card-text"><%= cantidadServicios %></p>
                        </div>
                    </div>
                    <div class="card_item">
                        <img src="${pageContext.request.contextPath}/img/logoReservacion.jpg" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Reservaciones</h5>
                            <p class="card-text"><%= cantidadReservas %></p>
                        </div>
                    </div>
                    <div class="card_item">
                        <img src="${pageContext.request.contextPath}/img/logoGanancia.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Ganancia</h5>
                            <p class="card-text"><%= totalReservas %></p>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>