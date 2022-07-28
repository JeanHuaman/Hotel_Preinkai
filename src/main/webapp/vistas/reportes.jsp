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
                        <a class="btn btn-primary" href="">Reportes</a>
                    </div>
                    <div class="px-2">
                        <a class="btn btn-primary" href="">Alexander Minaya Rosas de la Vega</a>
                    </div>
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
                    <div class="col-sm-6">        

                        <div class="card_item">

                            <div class="card-body">
                                <h4 class="card-title">Habitaciones con mayor numero de vistas</h4>

                            </div></div>
                        <h5>Cantidad:</h5><br>
                        <h5>Intervalos:</h5><br>
                        <h5>Ganancias Generadas:</h5><br>
                        <a href="../UsuarioControlador?accion=GenerarReporteExcel" class="btn btn-primary">Generar Reporte</a>
                    </div>
                    <div class="col-sm-6">          

                        <div class="card_item">

                            <div class="card-body">
                                <h4 class="card-title">Habitaciones con mayor numero de vistas</h4>

                            </div></div>
                        <h5>Cantidad:</h5><br>
                        <h5>Intervalos:</h5><br>
                        <h5>Ganancias Generadas:</h5><br>
                        <button class="btn btn-primary">Download</button>
                    </div>
                </div> 
                <br>


                <div class="col-sm-6">        

                    <div class="card_item">

                        <div class="card-body">
                            <h4 class="card-title">Eventos mas usados</h4>

                        </div></div>
                    <h5>Cantidad:</h5><br>
                    <h5>Intervalos:</h5><br>
                    <h5>Ganancias Generadas:</h5><br>
                    <button class="btn btn-primary">Download</button>

                </div>
                <div class="col-sm-6">          

                        <div class="card_item">

                            <div class="card-body">
                                <h4 class="card-title">Habitaciones con mayor numero de vistas</h4>

                            </div></div>
                        <h5>Cantidad:</h5><br>
                        <h5>Intervalos:</h5><br>
                        <h5>Ganancias Generadas:</h5><br>
                        <button class="btn btn-primary">Download</button>
                    </div>
                

            </section>
    </body>
</html>
