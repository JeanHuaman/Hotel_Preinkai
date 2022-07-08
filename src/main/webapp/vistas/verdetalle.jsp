<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <section>
            <div class="container">
                <div class="row mt-3">
                    <div class="card mb-3">
                        <div class="row g-2">
                            <div class="col-md-4">
                                <img src="../img/habitacion 1.jpg" class="img-fluid rounded-start" style="width: 100%;">
                            </div>
                            <div class="col-md-8">
                                <div class="card-body">
                                    <h5 class="card-title">Habitación más pequeña - 2 camas - Planta principal</h5>
                                    <p class="card-text">1 habitación grande con una baño personal, además de dos camas grandes con polar para el frío, tv.</p>
                                    <p class="card-text"><a href="#" class="btn btn-success">+ Agregar a mis favoritos</a></p>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section>
            <div class="container">
                <h2>Características</h2>
                <br>
                <div class="row">
                    <div class="col-sm-6">
                        <table class="table table-bordered">
                            <tbody>
                                <tr>
                                    <th scope="row">Categoría</th>
                                    <td>3 estrellas</td>
                                </tr>
                                <tr>
                                    <th scope="row">Tipo Habitación</th>
                                    <td>Suit</td>
                                </tr>
                                <tr>
                                    <th scope="row">Precio</th>
                                    <td>$200.00</td>
                                </tr>
                                <tr>
                                    <th scope="row">Disponibilidad</th>
                                    <td>Habilitado</td>
                                </tr>
                                <tr>
                                    <th scope="row">Aforo</th>
                                    <td>3 personas</td>
                                </tr>
                            </tbody>
                        </table>
                        <a href="#" class="btn btn-primary">Seleccionar habitación</a>
                    </div>
                    <div class="col-sm-6">
                        <img src="../img/banner_ver_detalle.png" width="100%">
                    </div>
                </div>
            </div>
        </section>
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
