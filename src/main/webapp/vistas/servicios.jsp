<%@taglib prefix="sql" uri="http://java.sun.com/jsp/jstl/sql"%>
<%-- 
    Document   : servicios
    Created on : 9 jul. 2022, 10:07:20
    Author     : JEAN
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>Reserva de Servicios</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/estilos/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1 class="text-center">Reserva de Servicios</h1>
        <div class="container mx-auto row my-2">
                <div class="col-12 col-sm-2">
                    <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary fs-3">Regresar</a>
                </div>
        </div>
        <div class="text-center">
            <span >Fecha de Reserva</span>
            <input placeholder="dd/mm/aa">
        </div>
        <main>
            <section class="row px-5">
                <div class="col-12 col-lg-8 ">
                    <div class="encabezado">
                        <p>Selecciona la hora de reservación</p>
                        <div>
                            <span>Turno</span>
                            <button class="btn btn-primary">Mañana</button>
                            <button class="btn btn-primary">Tarde</button>
                            <button class="btn btn-primary">Noche</button>
                        </div> 
                    </div>                    
                    <div class="desplazamiento py-3">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Servicio</th>
                                    <th>Personas</th>
                                    <th>Precio C/u</th>
                                    <th>Horario</th>
                                    <th>Subtotal</th>
                                    <th>Acción</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Cancha de Tennis</td>
                                    <td><input type="number"></td>
                                    <td>S/30.00</td>
                                    <td>
                                        <select>
                                            <option>8am - 9am</option>
                                            <option>9:30am - 10:30am</option>
                                            <option>11:00am - 12:00pm</option>
                                        </select>
                                    </td>
                                    <td>S/150.00</td>
                                    <td><a href="#">Reservar</a></td>
                                </tr>
                                <tr>
                                    <td>Restaurante Oceania</td>
                                    <td><input type="number"></td>
                                    <td>S/30.00</td>
                                    <td>
                                        <select>
                                            <option>8am - 9am</option>
                                            <option>9:30am - 10:30am</option>
                                            <option>11:00am - 12:00pm</option>
                                        </select>
                                    </td>
                                    <td>S/150.00</td>
                                    <td><a href="#">Reservar</a></td>
                                </tr>
                                <tr>
                                    <td>Sauna</td>
                                    <td><input type="number"></td>
                                    <td>S/30.00</td>
                                    <td>
                                        <select>
                                            <option>8am - 9am</option>
                                            <option>9:30am - 10:30am</option>
                                            <option>11:00am - 12:00pm</option>
                                        </select>
                                    </td>
                                    <td>S/150.00</td>
                                    <td><a href="#">Reservar</a></td>
                                </tr>
                            </tbody>
                        </table>
                    </div>
                </div>
                <div class="col-12 col-lg-4 px-0 pb-1">
                    <div class="encabezado">
                        <h2>Datos de la Reserva</h2>
                        <div>
                            <span>Fecha de la Reserva</span>
                            <span>11/06/22</span>
                        </div>
                    </div>                    
                    <div class="py-3">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Servicio</th>
                                    <th>Horario</th>
                                    <th>Subtotal</th>
                                </tr>
                            </thead>
                            <tbody>
                                <tr>
                                    <td>Cancha de Tennis</td>
                                    <td>8am - 9am</td>
                                    <td>S/150.00</td>
                                </tr>
                                <tr>
                                    <td>Restaurante de Oceania</td>
                                    <td>8am - 9am</td>
                                    <td>S/150.00</td>
                                </tr>
                            </tbody>
                        </table> 
                    </div>                    
                    <p class="d-flex justify-content-between">
                        <span>Total</span>
                        <span>S/150.00</span>
                    </p>
                    <div class="text-center">
                        <a href="#" class="btn btn-primary">Reservar</a>
                    </div>
                </div>
            </section>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
