

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
                            <option value="efectivo">Habitaciones</option>
                            <option value="tarjeta">Servicios</option>
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
                                        <th>Tipo de Habitacion</th>
                                        <th >disponibilidad</th>
                                        <th>Personas Permitidas</th>
                                        <th >Piso</th>
                                        <th >Precio</th>
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
                                        <td class="row">
                                            <div class="col-4">
                                                <a class="btn btn-success" href="${pageContext.request.contextPath}/vistas/editarHabitacion.jsp">Editar</a>
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
               <h2 class="text-center">Agregar Habitación</h2>
               <div class="card-body">
                    <div class="container-fluid">
                        <div class="row justify-content-between my-4">
                            <div class="col-sm-3">
                                <label class="form-label" for="nombre">Disponibilidad</label>
                                <select class="form-select" name="pisos">           
                                    <option value="habilitado">Habilitado</option>
                                    <option value="desabilitado">Desabilitado</option>
                                </select>
                            </div>
                            <div class="col-sm-3">
                                <label class="form-label" for="nombre">Personas Máximas</label>
                                <input class="form-control" type="text" name="personasMaximas"/>
                            </div>
                            <div class="col-sm-3">
                                <label class="form-label" for="imagen">Imagen</label>
                                    <select class="form-select" name="imagen">
                                        <option value="img/biciGras.jpg">Montañera</option>
                                        <option value="img/biciNaranja.jpg">Bmx</option>
                                        <option value="img/biciNegroRojo.jpg">Bicicleta Plegable</option>
                                        <option value="img/biciRojo.jpg">Triatlón</option>
                                        <option value="img/biciVerdeAzul.jpg">paseo</option>
                                    </select>
                            </div>
                            <div class="col-sm-3">
                                <label class="form-label" for="nombre">Regimen</label>
                                <select class="form-select" name="pisos">           
                                    <option value="habilitado">Con desayuno</option>
                                    <option value="desabilitado">Sin desayuno</option>
                                </select>
                            </div>
                            
                            <div class="row">
                                <div class="col">
                                    <label class="form-label" for="nombre">Tipo de Habitacion</label>
                                        <select class="form-select" name="pisos">           
                                            <option value="habilitado">suit</option>
                                            <option value="desabilitado">estandar</option>
                                        </select>
                                </div>
                                <div class="col">
                                    <label class="form-label" for="nombre">Precio</label>
                                    <input class="form-control" type="text" name="personasMaximas"/>
                                </div>
                                <div class="col">
                                    <label class="form-label" for="nombre">Piso</label>
                                    <input class="form-control" type="text" name="personasMaximas"/>
                                </div>
                                <div class="col">
                                    <label class="form-label" for="nombre">Categoría</label>
                                        <select class="form-select" name="pisos">           
                                            <option value="habilitado">4 estrellas</option>
                                            <option value="desabilitado">2 estrellas</option>
                                        </select>
                                </div>
                            </div>
                            <div class="row justify-content-between my-4">
                                <div class="col-sm-12">
                                   <textarea class="col-12" name="descripcion" placeholder="Escribe una descripción"></textarea> 
                                </div>
                            </div>
                            <div class="row">
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
