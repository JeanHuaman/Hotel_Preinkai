
<%@page contentType="text/html" pageEncoding="UTF-8"%>
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
        <header class="py-3">
            <nav class="container d-md-flex justify-content-md-between align-items-md-center">
                <div class="text-center">
                    <img src="${pageContext.request.contextPath}/img/Logo.png" alt="logo">
                </div>
                <div class="d-flex justify-content-around">
                    <div class="px-2">
                        <a class="btn btn-primary" href="">Ver Reservación</a>
                    </div>
                    <div class="px-2">
                        <a class="btn btn-primary" href="">Jean Franco Huaman</a>
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
                    <button type="button" class="option">Reportes</button>
                </div>                                  
            </section>
            <section class="col-12 col-md-9 py-3">
                <div class="row justify-content-between text-center">
                    <div class="card_item">
                        <img src="${pageContext.request.contextPath}/img/Logo.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Usuarios</h5>
                            <p class="card-text">33</p>
                        </div>
                    </div>
                    <div class="card_item">
                        <img src="${pageContext.request.contextPath}/img/Logo.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Usuarios</h5>
                            <p class="card-text">33</p>
                        </div>
                    </div>
                    <div class="card_item">
                        <img src="${pageContext.request.contextPath}/img/Logo.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Usuarios</h5>
                            <p class="card-text">33</p>
                        </div>
                    </div>
                    <div class="card_item">
                        <img src="${pageContext.request.contextPath}/img/Logo.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Usuarios</h5>
                            <p class="card-text">33</p>
                        </div>
                    </div>
                    <div class="card_item">
                        <img src="${pageContext.request.contextPath}/img/Logo.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Usuarios</h5>
                            <p class="card-text">33</p>
                        </div>
                    </div>
                    <div class="card_item">
                        <img src="${pageContext.request.contextPath}/img/Logo.png" class="card-img-top" alt="...">
                        <div class="card-body">
                            <h5 class="card-title">Usuarios</h5>
                            <p class="card-text">33</p>
                        </div>
                    </div>
                </div>
            </section>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
