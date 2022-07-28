<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
                    <div class="container-fluid">
                        <a class="navbar-brand" href="#">HOTEL PREINKAI</a>
                        <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarScroll" aria-controls="navbarScroll" aria-expanded="false" aria-label="Toggle navigation">
                            <span class="navbar-toggler-icon"></span>
                        </button>
                        <div class="collapse navbar-collapse" id="navbarScroll">
                            <ul class="navbar-nav me-auto my-2 my-lg-0 navbar-nav-scroll" style="--bs-scroll-height: 100px;">
                                <li class="nav-item">
                                    <a class="nav-link active" aria-current="page" href="#inicio">Inicio</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#habitaciones">Habitaciones</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#servicios">
                                        Servicios
                                    </a>
                                    <!--<ul class="dropdown-menu" aria-labelledby="navbarScrollingDropdown">
                                        <li><a class="dropdown-item" href="#">Action</a></li>
                                        <li><a class="dropdown-item" href="#">Another action</a></li>
                                        <li><hr class="dropdown-divider"></li>
                                        <li><a class="dropdown-item" href="#">Something else here</a></li>
                                    </ul>-->
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#contactanos">Contáctanos</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="vistas/login.jsp">Iniciar sesión</a>
                                </li>
                            </ul>
                            <form class="d-flex" role="search">
                                <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                                <button class="btn btn-outline-success" type="submit">Search</button>
                            </form>
                        </div>
                    </div>
                </nav>
            </div>
        </header>
        <c:set var="habitacion" value="${habitacion}"> </c:set>
            <div class="container">
                <div class="row mt-3">
                    <h2>Habitación</h2>
                    <br>
                    <div class="col-sm-6">
                        <section>
                            <div class="card mb-3">
                                <div class="row g-0">
                                    <div class="col-md-4">
                                        <img src="${habitacion.imagen}" class="img-fluid rounded-start" style="width: 100%;height: 100%">
                                </div>
                                <div class="col-md-8">
                                    <div class="card-body">
                                        <h5 class="card-title">${habitacion.descripcion}</h5>
                                        <p class="card-text">Elige tu habitación favorita y haz tu reserva. 
                                            Fácil, sencillo y muy cómodo a través de nuestra web. 
                                            Solamente haciendo clic en Añadir a mis favoritos.</p>
                                        <form action="UsuarioControlador" method="post">
                                            <input type="hidden" name="accion" value="SaveFavoriteRoom">
                                            <input type="number" name="id_usuario" value="1" hidden="true">
                                            <input type="number" name="id_habitacion" value="${habitacion.id_habitacion}" hidden="true">
                                            <input type="submit" class="btn btn-success" value="+ Agregar a mis favoritos">
                                        </form>
                                    </div>
                                </div>
                            </div>
                        </div>

                    </section>
                    <section>
                        <h2>Características</h2>
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <th scope="row">Categoría</th>
                                    <td>${habitacion.estrellas} estrellas</td>
                                </tr>
                                <tr>
                                    <th scope="row">Tipo Habitación</th>
                                    <td>${habitacion.tipohabitacion}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Precio</th>
                                    <td>$${habitacion.precio}0</td>
                                </tr>
                                <tr>
                                    <th scope="row">Disponibilidad</th>
                                    <td>${habitacion.disponibilidad}</td>
                                </tr>
                                <tr>
                                    <th scope="row">Aforo</th>
                                    <td>${habitacion.personas_maximas} personas</td>
                                </tr>
                            </tbody>
                        </table>
                        <a href="index.jsp" class="btn btn-danger">Regresar</a>
                        <a href="${pageContext.request.contextPath}/UsuarioControlador?accion=seleccionarHabitacion&idHabitacion=${habitacion.id_habitacion}" class="btn btn-primary">Seleccionar habitación</a>

                    </section>
                    <br><br>
                </div>
                <div class="col-sm-6">
                    <img src="img/banner_ver_detalle.png" width="100%">
                </div>
            </div>
        </div>
        <br>
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
