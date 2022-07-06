
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!doctype html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Hotel PREINKAI</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
    </head>
    <body>
        <header>
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
                        </ul>
                        <form class="d-flex" role="search">
                            <input class="form-control me-2" type="search" placeholder="Search" aria-label="Search">
                            <button class="btn btn-outline-success" type="submit">Search</button>
                        </form>
                    </div>
                </div>
            </nav>
        </header>
        <section style="background-image: url(img/banner_hotel.jpg);background-repeat: no-repeat;
                 background-position: center;background-attachment: fixed;" class="mt-3" id="inicio">
            <div class="container">
                <br>
                <div class="row">
                    <div class="col-sm-4">
                        <div class="card text-bg-dark text-center mb-3" style="max-width: 20rem;opacity: 94%;">
                            <div class="card-header">
                                DESDE 87,00 (USD $)
                            </div>
                            <div class="card-body" style="text-align: left;">
                                <h5 class="card-title">RESERVA ONLINE</h5>
                                <p class="card-text">Mejor precio garantizado</p>
                                <p class="card-text">--------------------------------------------</p>
                                <div class="row">
                                    <div class="col-6">
                                        <p>Entrada</p> 
                                        <input type="date" class="form-control">
                                    </div>
                                    <div class="col-6">
                                        <p>Salida</p> 
                                        <input type="date" class="form-control">
                                    </div> 
                                </div>
                                <br>
                                <p class="card-text">Su reserva será de 1 noche(s)</p>
                                <div class="row">
                                    <div class="col-6">
                                        <p>Adulto(s)</p> 
                                        <input type="number" class="form-control">
                                    </div>
                                    <div class="col-6">
                                        <p>Niño(s)</p> 
                                        <input type="number" class="form-control">
                                    </div> 
                                </div>
                            </div>

                            <div class="card-footer text-muted">
                                <a href="#" class="btn btn-primary">VER PRECIOS</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="mt-3" id="habitaciones">
            <div class="container">
                <br>
                <h2>Habitaciones de PREINKAI</h2>
                <br>
                <div class="row row-cols-1 row-cols-md-3 g-3">
                    <div class="col">
                        <div class="card">
                            <img src="img/habitacion 1.jpg" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Habitación más pequeña - 2 camas individuales - Planta principal</h5>
                                <br>
                                <a href="#" class="btn btn-primary form-control">Ver detalles</a>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card">
                            <img src="img/habitacion 2.jpg" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Habitación Doble Clásica - 2 camas - Planta principal</h5>
                                <br>
                                <a href="#" class="btn btn-primary form-control">Ver detalles</a>
                            </div>
                        </div>
                    </div>
                    <div class="col">
                        <div class="card">
                            <img src="img/habitacion 3.jpg" class="card-img-top" alt="...">
                            <div class="card-body">
                                <h5 class="card-title">Habitación esquinera con cama extragrande - Planta principal</h5>
                                <br>
                                <a href="#" class="btn btn-primary form-control">Ver detalles</a>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section class="mt-3" id="servicios">
            <div class="container">
                <br>
                <h2>Servicios de PREINKAI</h2>
                <br>
                <div class="row">
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
                                <td>Terraza / solárium, Terraza, Jardín</td>
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
                                <td>Guardaequipaje, Información turística, Recepción 24 horas</td>
                            </tr>
                            <tr>
                                <th scope="row">7</th>
                                <td>Servicios de limpieza</td>
                                <td>Servicio de limpieza diario, Servicio de planchado De pago, Servicio de limpieza en seco De pago, Servicio de lavandería De pago</td>
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
        </section>
        <br> 
        <footer id="contactanos">
            <div class="footer-top text-center">
                <div class="container">
                    <h2>¿En qué te podemos ayudar?</h2>
                    <p>Déjanos tu email y un operador te ofrecerá la mejor opción disponible según tu búsqueda</p>
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
                                            Teléfono: <label style="color:red;">(*)</label>
                                            <input type="text" class="form-control">
                                        </div>
                                    </div>
                                    <br>
                                    <div class="row">
                                        <div class="col-sm-12">
                                            Descripción: <label style="color:red;">(*)</label>
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
            <br>
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
