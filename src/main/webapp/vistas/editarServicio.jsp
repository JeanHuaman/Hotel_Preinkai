
<%@page import="modelo.Servicio"%>
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
            <h1 class="text-center">Editar Servicio</h1>
        </header>
            <%           Servicio servicio = (Servicio) request.getAttribute("servicio");
            %>
            <div class="container">
              <form action="${pageContext.request.contextPath}/ServicioControlador?accion=UpdateService&id_servicio=<%= servicio.getId_servicio()%>" method="POST">          
                <div class="row">
                    <div class="col-sm-6">
                        <label class="form-label">Nombre</label>
                        <input class="form-control" type="text" name="nombre_servicio" value="<%= servicio.getNombreServicio()%>"/><br> 
                        
                        <label class="form-label">Horario Inicio</label>
                        <input class="form-control" type="text" name="horario_inicio" value="<%= servicio.getHorariInicio()%>"/><br>
                        
                        <label class="form-label">Horario Fin</label>
                        <input class="form-control" type="text" name="horario_fin" value="<%= servicio.getHorarioFinal()%>"/> <br>
                        
                        <label class="form-label" for="nombre">Ambiente</label>
                        <input class="form-control" type="text" name="ambiente" value="<%= servicio.getAmbiente()%>"/> <br>

                        <label class="form-label">Estado</label>
                        <select class="form-select" name="estado">           
                                <%
                                    if (servicio.getEstado().equals("Disponible")) {
                                %>
                                <option value="Disponible" selected>Disponible</option>
                                <option value="Ocupado">Ocupado</option>
                                <option value="Limpieza">En Limpieza</option>
                                <%
                                } else if (servicio.getEstado().equals("Ocupado")) {
                                %>
                                <option value="Disponible">Disponible</option>
                                <option value="Ocupado" selected>Ocupado</option>
                                <option value="Limpieza">En Limpieza</option>
                                <%
                                } else {
                                          
                                %>
                                <option value="Disponible">Disponible</option>
                                <option value="Ocupado">Ocupado</option>
                                <option value="Limpieza" selected>En Limpieza</option>
                                <%
                                    }
                                %>
                            </select><br>

                        <label class="form-label">Precio</label>
                        <input class="form-control" type="text" name="precio" value="<%= servicio.getPrecio()%>"/><br>
                                                
                        <label class="form-label">Personas Máximas</label>
                        <input class="form-control" type="number" name="personas_maximas" value="<%= servicio.getPersonasMaximas()%>"/> <br>
                        
                        <button type="submit" class="btn btn-primary">Guardar</button>
                        <br><br>
                    </div>
                    <div class="col-sm-6">
                        <img src="img/banner_edit_habitacion.png" alt="" style="width: 100%;"/><br><br>
                        <img src="img/banner_edit_habitacion2.png" alt="" style="width: 100%;"/>
                    </div>
                </div>
              </form>  
            </div>
                
        </div>    
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-pprn3073KE6tl6bjs2QrFaJGz5/SUsLqktiwsUTF55Jfv3qYSDhgCecCxMW52nD2" crossorigin="anonymous"></script>    
    </body>
</html>
