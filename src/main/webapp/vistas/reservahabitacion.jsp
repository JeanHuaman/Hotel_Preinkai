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
                                    <h4 class="card-title">Datos del Usuario:</h4>


                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <section>
            <div class="container">
                <div class = "row">
                    <div class = "col-sm-6">  
                        <div class = "col-sm-5"> 
                            <h3><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                </svg> Huesped 1</h3> <br>

                            <form>
                                <h5> Nombre</h5> <input type = "text" class="form-control">  <br>                      
                                <h5> Apellido</h5>  <input type = "text" class="form-control">  <br>                      
                                <h5> Dni</h5> <input type = "number" class="form-control"> <br>

                                <h3><svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                    </svg> Huesped 2</h3> <br>     


                                <h5> Nombre </h5> <input type = "text" class="form-control">   <br>                       
                                <h5> Apellido </h5> <input type = "text" class="form-control">  <br>                         
                                <h5> Dni  </h5> <input type = "number" class="form-control"> <br>     

                                <h3> <svg xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-person-circle" viewBox="0 0 16 16">
                                    <path d="M11 6a3 3 0 1 1-6 0 3 3 0 0 1 6 0z"/>
                                    <path fill-rule="evenodd" d="M0 8a8 8 0 1 1 16 0A8 8 0 0 1 0 8zm8-7a7 7 0 0 0-5.468 11.37C3.242 11.226 4.805 10 8 10s4.757 1.225 5.468 2.37A7 7 0 0 0 8 1z"/>
                                    </svg> Huesped 3</h3> <br>   
                                <h5> Nombre </h5><input type = "text" class="form-control">   <br>                              
                                <h5> Apellido </h5><input type = "text" class="form-control">   <br>                              
                                <h5> Dni  </h5><input type = "number" class="form-control">   <br>      
                            </form>
                            <br>
                        </div>
                    </div>
                    <div class ="col-sm-6">
                        <h3>${habitacion.getDescripcion()}</h3><br><!-- comment -->
                        <h4>1 noche, Desayuno suite 2 Dormitorios</h4><br><!-- comment -->
                        <h4> 3 adultos Suite 2 Dormitorios 3 adultos </h4><br>
                        <br>
                        <div class="row text-center">
                            <div class ="col-sm-6">
                                <h5> Entrada </h5>
                                <p>${fechaEntrada}</p>   
                            </div>
                            <div class ="col-sm-6">
                                <h5> Salida </h5>
                                <p>${fechaSalida}</p> 
                            </div>
                        </div>
                        <br>
                        <h4 style ="color: red;"> Tarifa no se admite modificacion ni cancelacion </h4>
                        <br> 
                        <div class="row text-center">

                            <h4>Cambiar tu eleccion</h4> 
                        </div>
                        <br>
                        <div class="row text-center">
                            <div class ="col-sm-6">
                                <h5> Alojamiento: </h5> <br>  
                                <h5> Gastos Extra: </h5> <br> 
                                <h5> Precio Total: </h5> <br> 
                            </div>
                            <div class ="col-sm-6">
                                <h5> $ ${habitacion.getPrecio()} </h5>  <br>
                                <h5> $0 </h5>  <br>
                                <h5> $ ${habitacion.getPrecio()} </h5>  <br>
                            </div>
                            <a href="${pageContext.request.contextPath}/UsuarioControlador?accion=agregarHabitacion&idHabitacion=${habitacion.id_habitacion}" class="btn btn-primary">Reservar</a> 
                           
                        </div>
                        <br><br><br>
                        <div class="row text-center">
                        <h4><b>Todavia estas a tiempo !RESERVA YA¡</b></h4>
                        </div>
                    </div>

                </div>
            </div>
        </section>


    </body>
</html>
