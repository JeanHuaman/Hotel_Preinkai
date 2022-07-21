
<%@page import="modelo.TipoHabitacion"%>
<%@page import="dao.TipoHabitacionDAO"%>
<%@page import="modelo.Habitacion"%>
<%@page import="modelo.Piso"%>
<%@page import="java.util.List"%>
<%@page import="dao.PisoDAO"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<%
    List<TipoHabitacion> tipohabitaciones = new TipoHabitacionDAO().getListaTipoHabitacion();
    List<Piso> pisos = new PisoDAO().getListaPiso();

%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <title>JSP Page</title>
    </head>
    <body>
        <div class="card">
            <header class="mt-3">
                <h1 class="text-center">Editar Habitación</h1>
                <br>
            </header>
            <%           Habitacion habitacion = (Habitacion) request.getAttribute("habitacion");
            %>

            <div class="container">
                <form action="${pageContext.request.contextPath}/HabitacionControlador?accion=UpdateRoom&id_habitacion=<%= habitacion.getId_habitacion()%>" method="POST">    
                    <div class="row">
                        <div class="col-sm-6">
                            <label class="form-label">Tipo de Habitacion</label>
                            <select class="form-select" name="id_tipohabitacion">
                                <%
                                    for (TipoHabitacion tipohabitacion : tipohabitaciones) {
                                        if (tipohabitacion.getIdTipoHabitacion() == habitacion.getId_tipohabitacion()) {
                                %>
                                <option value="<%= tipohabitacion.getIdTipoHabitacion()%>" selected><%= tipohabitacion.getNombreH()%> </option>
                                <%
                                } else {
                                %>
                                <option value="<%= tipohabitacion.getIdTipoHabitacion()%>"><%= tipohabitacion.getNombreH()%> </option>
                                <%
                                        }
                                    }
                                %> 
                            </select>
                            <br>
                            <label class="form-label">Piso</label>
                            <select class="form-select" name="id_piso"> 
                                <%
                                    for (Piso piso : pisos) {
                                        if (piso.getIdPiso() == habitacion.getId_piso()) {
                                %>
                                <option value="<%= piso.getIdPiso()%>" selected><%= piso.getIdPiso()%> </option>
                                <%
                                } else {
                                %>
                                <option value="<%= piso.getIdPiso()%>"><%= piso.getIdPiso()%> </option>
                                <%
                                        }
                                    }
                                %> 
                            </select>
                            <br>
                            <label class="form-label">Precio</label>
                            <input class="form-control" type="text" name="precio" value="<%= habitacion.getPrecio()%>"/>
                            <br>
                            <label class="form-label">Descripción</label>
                            <input class="form-control" type="text" name="descripcion" value="<%= habitacion.getDescripcion()%>"/>
                            <br>
                            <label class="form-label">Personas Máximas</label>
                            <input class="form-control" type="text" name="personas_maximas" value="<%= habitacion.getPersonas_maximas()%>"/>
                            <br>
                            <label class="form-label" for="disponibilidad">Disponibilidad</label>
                            <select class="form-select" name="disponibilidad">           
                                <%
                                    if (habitacion.getDisponibilidad().equals("Disponible")) {
                                %>
                                <option value="Disponible" selected>Disponible</option>
                                <option value="Ocupado">Ocupado</option>
                                <option value="Limpieza">En Limpieza</option>
                                <%
                                } else if (habitacion.getDisponibilidad().equals("Ocupado")) {
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
                            </select>
                            <br>
                            <label class="form-label">Estrellas</label>
                            <select class="form-select" name="estrellas">           
                                <%
                                    if (habitacion.getEstrellas() == 1) {
                                %>
                                <option value="1" selected>1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <%
                                } else if (habitacion.getEstrellas() == 2) {
                                %>
                                <option value="1">1</option>
                                <option value="2" selected>2</option>
                                <option value="3">3</option>
                                <option value="4">4</option>
                                <%
                                } else if (habitacion.getEstrellas() == 3) {
                                %> 
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3" selected>3</option>
                                <option value="4">4</option>
                                <%
                                } else {
                                %>
                                <option value="1">1</option>
                                <option value="2">2</option>
                                <option value="3">3</option>
                                <option value="4" selected>4</option>
                                <%
                                    }
                                %>
                            </select>
                            <br>
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
