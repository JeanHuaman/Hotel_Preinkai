<%@page import="dao.ServicioDAO"%>
<%@page import="modelo.Servicio"%>
<%@page import="java.util.List"%>
<%@page import="controlador.ServicioControlador"%>

<%
    List<String> nombreServicios = ServicioControlador.listarServicios();

%>
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
        <header>            
            <nav class="p-3 d-md-flex text-center align-items-md-center bg-light">
                <div class="col-12 col-sm-3">
                    <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-primary fs-5">Regresar</a>
                </div>
                <h1 class="text-center col-12 col-sm-8">Reserva de Servicios</h1>
            </nav>
            <div class="my-2 container mx-auto">
                <form class="row justify-content-center align-items-center me-0 justify-content-sm-around fs-5" action="${pageContext.request.contextPath}/ServicioControlador?accion=filtrarServicio" method="POST">
                    <div class="px-0 col-8 d-flex justify-content-center gap-2 col-sm-4">
                        <label>Fecha de Reserva </label>
                        <input class="boton" name="fecha" type="date" value="${fechaServicio}" required>
                    </div>
                    <div class="px-0 py-3 col-8 d-flex justify-content-center gap-2 col-sm-4">
                        <label>Servicios </label>
                        <select name ="nombreServicio" class="boton" required>
                            <%                                for (String nombreServicio : nombreServicios) {
                            %>
                            <option value="<%= nombreServicio%>"><%= nombreServicio%></option>
                            <%
                                }
                            %>
                        </select>
                    </div>
                    <button class="col-8 col-sm-1 btn btn-primary fs-4" type="submit">Buscar</button>
                </form>
            </div>
        </header>
        <main>
            <section class="row px-5 me-0">
                <div class="col-12 col-lg-8 ">
                    <div class="encabezado">
                        <p>Selecciona la hora de reservación </p>
                        <div class="row fs-5">
                            <span class="col-12 col-sm-3">Servicio :
                                <span>${nombreServicioActual}</span>
                            </span>
                        </div> 
                    </div>                    
                    <div class="desplazamiento py-3">
                        <section class="grid">
                            <div>Servicio</div>
                            <div>Personas</div>
                            <div>Precio C/u</div>
                            <div>Horario</div>
                            <div>Accion</div>
                            <div class="grid_total">
                                <%
                                    List<Servicio> servicios = (List<Servicio>) request.getAttribute("servicios");
                                    int contador = 0;
                                    if (servicios == null) {
                                        servicios = ServicioControlador.listarServicioDefecto(request, response);
                                    }
                                    if (servicios != null) {
                                        int i;
                                        for (i = 0; i < servicios.size(); i++) {
                                %>
                                <form class="grid" action="${pageContext.request.contextPath}/UsuarioControlador?accion=agregarServicio" method="POST">

                                    <div><%= servicios.get(i).getAmbiente()%></div>
                                    <div><input required name="personas" min="0" required="true" value="0" type="number" style="width: 80px;"></div>
                                    <div><%= servicios.get(i).getPrecio()%></div>
                                    <div>                                        
                                        <select name="idServicio">
                                            <%
                                                String ambiente = servicios.get(i).getAmbiente();
                                                for (int j = i; j < servicios.size(); j++) {
                                                    if (servicios.get(j).getAmbiente().equalsIgnoreCase(ambiente)) {
                                            %>   
                                            <option  value="<%= servicios.get(j).getId_servicio()%>"><%= servicios.get(j).getHorariInicio()%> - <%= servicios.get(j).getHorarioFinal()%></option>
                                            <%
                                                        contador = j;
                                                    }
                                                }

                                            %>
                                        </select>
                                    </div>
                                    <div><input class="btn btn-primary" type="submit" value="Reservar"></div>        
                                </form>
                                <%
                                            i = contador;
                                        }
                                    }

                                %>  

                            </div>
                        </section>
                    </div>
                </div>
                <div class="col-12 col-lg-4 px-0 pb-1">
                    <div class="encabezado">
                        <h2>Datos de la Reserva</h2>
                        <div>
                            <span>Fecha de la Reserva</span>
                            <span>${fechaServicio}</span>
                        </div>
                    </div>                    
                    <div class="py-3">
                        <section class="gridServicio">
                            <div>Servicio</div>
                            <div>Horario</div>
                            <div class="text-end">Subtotal</div>
                            <section class="gridServicio grid_detalleServicio">
                                <%                                    List<Servicio> listaServicios = (List<Servicio>) session.getAttribute("carritoServicios");

                                    if (listaServicios != null) {
                                        for (Servicio servicio : listaServicios) {
                                %>
                                <div><%= servicio.getNombreServicio()%></div>
                                <div><%= servicio.getHorariInicio()%> <%= servicio.getHorarioFinal()%></div>
                                <div class="text-end"><%= servicio.getPrecio() * servicio.getPersonasMaximas()%></div>
                                <% }
                                    }%>
                                <div class="grid_detalleServicio">
                                    <p class="d-flex justify-content-between">
                                        <span>Total</span>
                                        <span>${totalServicio}</span>
                                    </p>
                                    <div class="text-center">
                                        <a class="btn btn-primary" data-bs-toggle="modal" data-bs-target="#exampleModal">Reservar</a>
                                    </div>
                                    <div class="modal fade" id="exampleModal" tabindex="-1" aria-labelledby="exampleModalLabel" aria-hidden="true">
                                        <div class="modal-dialog">
                                            <div class="modal-content">
                                                <div class="modal-header">
                                                    <h5 class="modal-title" id="exampleModalLabel">Pagar Servicios</h5>
                                                    <button type="button" class="btn-close" data-bs-dismiss="modal" aria-label="Close"></button>
                                                </div>
                                                <div class="col-12 modal-body">
                                                    <form method="POST" action="${pageContext.request.contextPath}/UsuarioControlador?accion=pagar&tipo=servicio">
                                                        <div class="mb-3 dimension">
                                                            <label for="exampleFormControlInput1" class="form-label">Tipo de Pago</label>
                                                            <select class="form-select" aria-label="Default select example" name="tipoPago">
                                                                <option value="Efectivo">Efectivo</option>
                                                                <option value="Tarjeta">Tarjeta</option>
                                                            </select>
                                                        </div>
                                                        <div class="mb-3 dimension">
                                                            <label for="exampleFormControlInput1" class="form-label">Tipo de Tarjeta</label>
                                                            <select class="form-select" aria-label="Default select example" name="tipoTarjeta">
                                                                <option value="Visa">Visa</option>
                                                                <option value="Mastercard">Mastercard</option>
                                                            </select>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="exampleFormControlInput1" class="form-label">Número de tarjeta</label>
                                                            <input type="text" class="form-control" id="exampleFormControlInput1">
                                                        </div>
                                                        <div class="row justify-content-between">
                                                            <div class="mb-3 col-12">
                                                                <label for="exampleFormControlInput1" class="form-label">Caducidad</label>
                                                                <input type="text" class="form-control" id="exampleFormControlInput1">
                                                            </div>
                                                            <div class="mb-3 col-12">
                                                                <label for="exampleFormControlInput1" class="form-label">CVV</label>
                                                                <input type="text" class="form-control" id="exampleFormControlInput1">
                                                            </div>
                                                        </div>
                                                        <div class="mb-3">
                                                            <label for="exampleFormControlInput1" class="form-label">Titular de la tarjeta</label>
                                                            <input type="text" class="form-control" id="exampleFormControlInput1" value="${usuario.getNombre()}">
                                                        </div>
                                                        <div class="mb-3 modal-footer">
                                                            <button type="submit" class="btn btn-primary w-100" data-bs-dismiss="modal">Reservar y pagar</button>
                                                        </div>
                                                    </form>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                </div>
                            </section>
                        </section> 
                    </div>                    

                </div>
            </section>
        </main>
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    </body>
</html>
