
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Crud de Habitaciones y Servicios</title>
    </head>
    <body>
        <header class="bg-success bg-gradient py-2">
            <div class="container mx-auto row">
                <div class="col-12 col-sm-2">
                    <img src="${pageContext.request.contextPath}/img/Logo.png" alt="logo" class="logo">
                </div>
                <h1 class=" col-12 col-sm-8 inline text-center">PREINKAI</h1>
            </div>
        </header>

        <div class="container-fluid">
            <br>
            <div class="row justify-content-start">
                <div class="col-3">
                  <h3 align="left">Mantenimiento </h3>
                </div>
                <div class="col-2">
                    <select class="form-select" name="servicioTip">           
                            <option value="efectivo">servicios</option>
                            <option value="tarjeta">Habitaciones</option>
                    </select>
                </div>
            </div>
            <div class="row justify-content-between my-4">
                <div class="col-2">
                  <select class="form-select" name="pisos">           
                    <option value="efectivo">Piso1</option>
                    <option value="tarjeta">Piso2</option>
                  </select>
                </div>
                <div class="col-8 d-flex flex-column">
                  <input type="text" name="buscarServiciosHabitaciones" />
                </div>
                <div class="col-2">
                  <button class="bg-primary btn btn-primary" type="submit">Buscar</button>
                </div>
            </div>
            <div class="container">
                            <table class="table">
                                <thead>
                                    <tr >
                                        <th >Codigo</th>
                                        <th>Nombre</th>
                                        <th >Horario Inicio</th>
                                        <th>Horario Fin</th>
                                        <th >Local</th>
                                        <th >Precio</th>
                                        <th >Personas Permitidas</th>
                                        <th >Acción</th>
                                    </tr>
                                </thead>
                                <tbody>                                    
                                    <tr>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td></td>
                                        <td class="row">
                                            <div class="col-4">
                                                <a class="btn btn-success" href="${pageContext.request.contextPath}/vistas/editarServicio.jsp">Editar</a>
                                            </div>
                                            <div class="col-4">
                                                <a class="btn btn-danger" href="">Eliminar</a>
                                            </div>
                                        </td>
                                    </tr>
                                </tbody>
                            </table>
            </div>
            <div class="card">
               <h2 class="text-center">Agregar Servicio</h2>
               <div class="card-body">
                    <div class="container-fluid">
                        <div class="row justify-content-between my-4">
                            <div class="col-sm-4">
                                <label class="form-label" for="nombre">Horario Inicio</label>
                                <input class="form-control" type="text" name="personasMaximas"/>
                            </div>
                            <div class="col-sm-4">
                                <label class="form-label" for="nombre">Horario Fin</label>
                                <input class="form-control" type="text" name="personasMaximas"/>
                            </div>
                            <div class="col-sm-4">
                                <label class="form-label" for="nombre">Ambiente</label>
                                <select class="form-select" name="pisos">           
                                    <option value="habilitado">Relax</option>
                                    <option value="desabilitado">Con Niños :)</option>
                                </select>
                            </div>
                            
                            <div class="row justify-content-between my-4 ">
                                <div class="col">
                                    <label class="form-label" for="nombre">Nombre</label>
                                        <input class="form-control" type="text" name="nombre"/>
                                </div>
                                <div class="col">
                                    <label class="form-label" for="nombre">Precio</label>
                                    <input class="form-control" type="text" name="precio"/>
                                </div>
                                <div class="col">
                                    <label class="form-label" for="nombre">Personas Máximas</label>
                                    <input class="form-control" type="text" name="personasMaximas"/>
                                </div>
                            </div>
                            <div class="row justify-content-between my-4">
                                <div class="col-sm-12">
                                    <input class="btn btn-primary col-12 mx-auto" type="submit" value="Agregar"/>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>   
            </div>          
        </div>        
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>        
    </body>
</html>
