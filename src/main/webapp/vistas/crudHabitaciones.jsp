<%@page import="modelo.Usuario"%>
<%@page import="dao.PisoDAO"%>
<%@page import="modelo.Piso"%>
<%@page import="dao.TipoHabitacionDAO"%>
<%@page import="modelo.TipoHabitacion"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page import="modelo.Habitacion"%>
<%@page import="java.util.List"%>
<%@page import="modelo.Servicio"%>
<%@page import="dao.ServicioDAO"%>
<%@page import="dao.HabitacionDAO"%>
<%

    List<Habitacion> habitaciones = new HabitacionDAO().listar();
    List<Servicio> servicios = new ServicioDAO().listar();
    List<TipoHabitacion> tiposhabitacion = new TipoHabitacionDAO().getListaTipoHabitacion();
    List<Piso> pisos = new PisoDAO().getListaPiso();

%>

<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <title>Crud de Habitaciones y Servicios</title>
        <!-- Custom fonts for this template-->
        <link href="../vendor/fontawesome-free/css/all.min.css" rel="stylesheet" type="text/css">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <!-- Custom styles for this page -->
        <link href="../vendor/datatables/dataTables.bootstrap4.min.css" rel="stylesheet">
        <link href="${pageContext.request.contextPath}/estilos/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <header>
            <nav class="p-3 d-md-flex justify-content-md-between align-items-md-center bg-light">
                <div class="text-center">                    
                    <a href="${pageContext.request.contextPath}/index.jsp"><p class="fs-2 link-secondary">HOTEL PREINKAI</p></a> 
                </div>
                <div class="d-flex justify-content-around">
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
        <div class="container mt-1">
            <div class="row">
                <ul class="nav nav-tabs" id="myTab" role="tablist">
                    <li class="nav-item" role="presentation">
                        <button class="nav-link active" id="home-tab" data-bs-toggle="tab" data-bs-target="#home-tab-pane" type="button" role="tab" aria-controls="home-tab-pane" aria-selected="true">Habitaciones</button>
                    </li>
                    <li class="nav-item" role="presentation">
                        <button class="nav-link" id="profile-tab" data-bs-toggle="tab" data-bs-target="#profile-tab-pane" type="button" role="tab" aria-controls="profile-tab-pane" aria-selected="false">Servicios</button>
                    </li>
                </ul>
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="home-tab-pane" role="tabpanel" aria-labelledby="home-tab" tabindex="0">
                        <br>
                        <h1>
                            Listado de Habitaciones
                        </h1>
                        <div class="card shadow mb-4">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead class="text-center">
                                            <tr>
                                                <th>Código</th>
                                                <th>Tipo de Habitación</th>
                                                <th>Disponibilidad</th>
                                                <th>Piso</th>
                                                <th>Precio</th>
                                                <th>Descripción</th>
                                                <th>Personas Máximas</th>
                                                <th>Estrellas</th>
                                                <th>Acción</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (Habitacion habitacion : habitaciones) {%>
                                            <tr>
                                                <td class="text-center"><%= habitacion.getId_habitacion()%></td>
                                                <td><%= habitacion.getTipohabitacion()%></td>
                                                <td><%= habitacion.getDisponibilidad()%></td>
                                                <td class="text-center"><%= habitacion.getId_piso()%></td>
                                                <td class="text-center"><%= habitacion.getPrecio()%></td>
                                                <td><%= habitacion.getDescripcion()%></td>
                                                <td class="text-center"><%= habitacion.getPersonas_maximas()%></td>
                                                <td class="text-center"><%= habitacion.getEstrellas()%></td>
                                                <td style="text-align: center;">
                                                    <a class="btn btn-success w-100" href="${pageContext.request.contextPath}/HabitacionControlador?accion=EditRoom&id=<%= habitacion.getId_habitacion()%>">Editar</a> <br>
                                                    <a class="btn btn-danger w-100" href="${pageContext.request.contextPath}/HabitacionControlador?accion=eliminar&id_habitacion=<%= habitacion.getId_habitacion()%>">Eliminar</a>
                                                </td>
                                            </tr>
                                            <% }%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <br>
                        <h1>
                            Agregar Habitación
                        </h1>
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="card-body shadow mb-4">
                                    <div class="container-fluid">
                                        <div class="row justify-content-between my-4">
                                            <form action="${pageContext.request.contextPath}/HabitacionControlador?accion=AddRoom" method="POST">
                                                <br>
                                                <label class="form-label" for="id_tipohabitacion">Tipo de Habitación</label>
                                                <select class="form-select" name="id_tipohabitacion">
                                                    <% for (TipoHabitacion tipo_habitacion : tiposhabitacion) {%>
                                                    <option value="<%= tipo_habitacion.getIdTipoHabitacion()%>"><%= tipo_habitacion.getNombreH()%></option>
                                                    <% }%>
                                                </select> <br>

                                                <label class="form-label" for="piso">Piso</label>
                                                <select class="form-select" name="id_piso">     
                                                    <% for (Piso piso : pisos) {%>
                                                    <option value="<%= piso.getIdPiso()%>"><%= piso.getIdPiso()%></option>
                                                    <% }%>
                                                </select> <br>

                                                <label class="form-label" for="precio">Precio</label>
                                                <input class="form-control" type="number" name="precio"/> <br>

                                                <label class="form-label" for="imagen">Imagen</label>
                                                <select class="form-select" name="imagen">
                                                    <option value="habitacion-1.jpg">Habitación Clásica - 1 cama extragrande</option>
                                                    <option value="habitacion-2.jpg">Suite Presidencial con cama extragrande</option>
                                                    <option value="habitacion-3.jpg">Suite Executive Le Meridien - Cama extragrande</option>
                                                </select>    <br>

                                                <label class="form-label">Descripción</label>
                                                <textarea class="col-12 form-control" for="descripcion" name="descripcion" placeholder="Escribe una descripción"></textarea><br>

                                                <label class="form-label">Personas Máximas</label>
                                                <input class="form-control" type="number" name="personas_maximas"/> <br>

                                                <label class="form-label">Disponibilidad</label>
                                                <select class="form-select" name="disponibilidad">           
                                                    <option value="Disponible">Disponible</option>
                                                    <option value="Ocupado">Ocupado</option>
                                                    <option value="Limpieza">En Limpieza</option>
                                                </select> <br>

                                                <label class="form-label">Estrellas</label>
                                                <select class="form-select" name="estrellas">           
                                                    <option value="1">1</option>
                                                    <option value="2">2</option>
                                                    <option value="3">3</option>
                                                    <option value="4">4</option>
                                                </select> <br>

                                                <input class="btn btn-primary col-12 mx-auto" type="submit" value="Agregar"/>
                                                <br><br>
                                            </form> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <img src="../img/banner_agregar_habitacion.png" alt="" width="100%"/>
                            </div>
                        </div>
                    </div>
                    <div class="tab-pane fade" id="profile-tab-pane" role="tabpanel" aria-labelledby="profile-tab" tabindex="0">
                        <br>
                        <h1>Listado de Servicios</h1>
                        <div class="card shadow mb-4">
                            <div class="card-body">
                                <div class="table-responsive">
                                    <table class="table table-bordered" id="dataTable" width="100%" cellspacing="0">
                                        <thead class="text-center">
                                            <tr>
                                                <th>Código</th>
                                                <th>Nombre</th>
                                                <th>Precio</th>
                                                <th>Horario Inicio</th>
                                                <th>Horario Fin</th>
                                                <th>Ambiente</th>
                                                <th>Estado</th>
                                                <th>Personas Máximas</th>
                                                <th>Acción</th>
                                            </tr>
                                        </thead>
                                        <tbody>
                                            <% for (Servicio servicio : servicios) {%> 
                                            <tr>
                                                <td class="text-center"><%= servicio.getId_servicio()%></td>
                                                <td><%= servicio.getNombreServicio()%></td>
                                                <td><%= servicio.getPrecio()%></td>
                                                <td><%= servicio.getHorariInicio()%></td>
                                                <td><%= servicio.getHorarioFinal()%></td>
                                                <td><%= servicio.getAmbiente()%></td>
                                                <td><%= servicio.getEstado()%></td>
                                                <td class="text-center"><%= servicio.getPersonasMaximas()%></td>
                                                <td style="text-align: center;">
                                                    <a class="btn btn-success w-100" href="${pageContext.request.contextPath}/ServicioControlador?accion=EditService&id=<%= servicio.getId_servicio()%>">Editar</a> <br>
                                                    <a class="btn btn-danger w-100" href="${pageContext.request.contextPath}/ServicioControlador?accion=eliminar&id_servicio=<%= servicio.getId_servicio()%>">Eliminar</a>
                                                </td>
                                            </tr>
                                            <% }%>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <br>
                        <h1>Agregar Servicio</h1>    
                        <div class="row">
                            <div class="col-sm-6">
                                <div class="card-body shadow mb-4">
                                    <div class="container-fluid">
                                        <div class="row justify-content-between my-4">
                                            <form action="${pageContext.request.contextPath}/ServicioControlador?accion=AddService" method="POST">
                                                <br>
                                                <label class="form-label" for="nombre">Nombre</label>
                                                <input class="form-control" type="text" name="nombre_servicio"/>
                                                <br>  
                                                <label class="form-label" for="precio">Precio</label>
                                                <input class="form-control" type="number" name="precio"/><br>

                                                <label class="form-label" for="nombre">Horario Inicio</label>
                                                <input class="form-control" type="text" name="horario_inicio"/>
                                                <br> 
                                                <label class="form-label" for="nombre">Horario Fin</label>
                                                <input class="form-control" type="text" name="horario_fin"/> <br>

                                                <label class="form-label" for="nombre">Ambiente</label>
                                                <input class="form-control" type="text" name="ambiente"/> <br>

                                                <label class="form-label">Estado</label>
                                                <select class="form-select" name="estado">           
                                                    <option value="Disponible">Disponible</option>
                                                    <option value="Ocupado">Ocupado</option>
                                                    <option value="Limpieza">En Limpieza</option>
                                                </select><br>

                                                <label class="form-label">Personas Máximas</label>
                                                <input class="form-control" type="number" name="personas_maximas"/> <br>

                                                <input class="btn btn-primary col-12 mx-auto" type="submit" value="Agregar"/>
                                                <br><br>
                                            </form> 
                                        </div>
                                    </div>
                                </div>
                            </div>
                            <div class="col-sm-6">
                                <img src="../img/banner_agregar_habitacion.png" alt="" width="100%"/>
                            </div>
                        </div>    

                    </div>
                </div>
            </div>     
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
