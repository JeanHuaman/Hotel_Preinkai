<%-- 
    Document   : pago
    Created on : 9 jul. 2022, 12:14:12
    Author     : JEAN
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1, maximum-scale=1">
        <title>Pagar</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.8.2/css/all.css" integrity="sha384-oS3vJWv+0UjzBfQzYUhtDYW+Pj2yciDJxpsK1OYPAYjqT085Qq/1cq5FLXAZQ7Ay" crossorigin="anonymous">
        <link href="${pageContext.request.contextPath}/estilos/style.css" rel="stylesheet" type="text/css" />
    </head>
    <body>
        <h1 class="text-center">Tus Datos</h1>
        <p class="ps-2">Indica los datos tal y como aparecen en el documento de identidad</p>
        <main>
            <section class="row px-5 justify-content-around">
                <div class="col-12 col-md-5 ">
                    <form method="POST" action="${pageContext.request.contextPath}/UsuarioControlador?accion=pagar&tipo=habitacion">
                        <div class="mb-3 dimension">
                            <label for="exampleFormControlInput1" class="form-label">Tipo de Pago</label>
                            <select class="form-select" aria-label="Default select example" name="tipoPago">
                                <option value="1">Efectivo</option>
                                <option value="2">Tarjeta</option>
                            </select>
                        </div>
                        <div class="mb-3 dimension">
                            <label for="exampleFormControlInput1" class="form-label">Tipo de Tarjeta</label>
                            <select class="form-select" aria-label="Default select example" name="tipoTarjeta">
                                <option value="1">Visa</option>
                                <option value="2">Mastercard</option>
                            </select>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Número de tarjeta</label>
                            <input type="text" class="form-control" id="exampleFormControlInput1">
                        </div>
                        <div class="row justify-content-between">
                            <div class="mb-3 col-12 col-md-5">
                                <label for="exampleFormControlInput1" class="form-label">Caducidad</label>
                                <input type="text" class="form-control" id="exampleFormControlInput1">
                            </div>
                            <div class="mb-3 col-12 col-md-5">
                                <label for="exampleFormControlInput1" class="form-label">CVV</label>
                                <input type="text" class="form-control" id="exampleFormControlInput1">
                            </div>
                        </div>
                        <div class="mb-3">
                            <label for="exampleFormControlInput1" class="form-label">Titular de la tarjeta</label>
                            <input type="text" class="form-control" id="exampleFormControlInput1">
                        </div>
                        <div class="mb-3 ">
                            <button class="btn btn-primary w-100" type="submit">Reservar y pagar</button>
                        </div>
                    </form>
                </div>
                <div class="col-12 col-lg-4 px-0 pb-1">
                    <div class="encabezado">
                        <p>Tarifa no se admite modificación ni cancelación</p>
                    </div>                    
                    <div class="py-3">
                        <table class="table">
                            <thead>
                                <tr>
                                    <th>Habitación</th>
                                    <th class="text-end">Subtotal</th>
                                </tr>
                            </thead>
                            <tbody>
                                <c:forEach var="habitacion" items="${carritoHabitacion}">
                                <tr>
                                    <td>${habitacion.getDescripcion()}</td>
                                    <td class="text-end">S/ ${habitacion.getPrecio()}</td>
                                </tr>
                                </c:forEach>
                            </tbody>
                        </table> 
                    </div>                    
                    <p class="d-flex justify-content-between">
                        <span>Total</span>
                        <span>S/ ${totalHabitacion}</span>
                    </p>
                </div>
            </section>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
