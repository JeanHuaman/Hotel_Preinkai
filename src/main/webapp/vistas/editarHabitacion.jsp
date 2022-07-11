
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="card">
        <header>
            <h1 class="text-center">Editar Habitación</h1>
        </header>
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
                            <div class="row row justify-content-between my-4">
                                <div class="col">
                                    <label class="form-label" for="nombre">Tipo de Habitacion</label>
                                        <select class="form-select" name="pisos">           
                                            <option value="habilitado">suit</option>
                                            <option value="desabilitado">estandar</option>
                                        </select>
                                </div>
                                <div class="col">
                                    <label class="form-label" for="nombre">Regimen</label>
                                        <select class="form-select" name="pisos">           
                                            <option value="habilitado">Con desayuno</option>
                                            <option value="desabilitado">Sin desayuno</option>
                                        </select>
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
                                    <label class="form-label" for="nombre">Personas Máximas</label>
                                <input class="form-control" type="text" name="personasMaximas"/>
                                </div>
                            </div>
                            <div class="row row justify-content-between my-4">
                                <div class="col-sm-12">
                                    <label class="form-label" for="nombre">Precio</label>
                                <input class="form-control" type="text" name="personasMaximas"/>
                                </div>
                            </div>
                            <div class="row row justify-content-between my-4">
                                <div class="col-sm-12">
                                    <label class="form-label" for="nombre">Descripción</label>
                                <input class="form-control" type="text" name="personasMaximas"/>
                                </div>
                            </div>
                            <div class="row justify-content-center px-2 my-4">
                                <button type="submit" class="btn btn-primary">Guardar</button>
                            </div>
                        </div>
                    </div> 
                </div>   
            </div>    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>    
    </body>
</html>
