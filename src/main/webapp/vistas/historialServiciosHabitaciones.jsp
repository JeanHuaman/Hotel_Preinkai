
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
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
        <div class="container">
            <div class="row justify-content-around">
                <div class="col-4">
                    <select class="form-select" name="servicioTip">           
                          <option value="servicios">Servicios</option>
                          <option value="habitaciones">Habitaciones</option>
                    </select>
                </div>
                <div class="col-4">
                    <input type="text" name="buscarProducto" />
                    <button class="bg-primary btn btn-primary" type="submit">Buscar</button>
                </div>
            </div>
            <br>
            <br>
            <div class="d-flex flex-wrap row justify-content-around">
                <div class="col-4">
                    <div class="card" style="width: 18rem;">
                        <svg class="bd-placeholder-img card-img-top" width="100%" height="180"
                             xmlns="http://www.w3.org/2000/svg" role="img" aria-label="Placeholder: Image cap"
                             preserveAspectRatio="xMidYMid slice" focusable="false"><title>Placeholder</title>
                             <rect width="100%" height="100%" fill="#868e96"></rect>
                             <text x="50%" y="50%" fill="#dee2e6" dy=".3em">Image cap</text></svg>
                            <div class="card-body">
                                <p class="card-text">Some quick example text to build on the card title and make up the bulk of the card's content.</p>
                            </div>
                    </div>
                </div>
                <div class="col-4">
                    <div class="footer-bottom text-center">
                        <br>
                        <br><!-- <br> -->
                        <br><!-- falta mejorar a Responsive igual q la part d img -->
                        <br>
                        <button class="bg-primary btn btn-primary" type="submit">Detalles</button>
                    </div>
                </div>
            </div>
        </div>
        
        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>    
    </body>
</html>
