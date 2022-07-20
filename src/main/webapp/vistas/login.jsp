
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Hotel PREINKAI login</title>
        <link href="https://fonts.googleapis.com/css2?family=Roboto:ital,wght@0,100;0,300;0,400;0,500;0,700;0,900;1,100;1,300;1,400;1,500;1,700;1,900&display=swap" rel="stylesheet">

        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.2.0-beta1/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-0evHe/X+R7YkIZDRvuzKMRqM+OrBnVFBL6DOitfPri4tjfHxaWutUpFmBp4vmVor" crossorigin="anonymous">
        <link rel="stylesheet" href="estilos/Estilologin.css">
    </head>
    <body>
        <main>

            <div class="contenedor__todo">
                <div class="caja__trasera">
                    <div class="caja__trasera-login">
                        <h3>¿Ya tienes una cuenta?</h3>
                        <p>Inicia sesión para entrar en la página</p>
                        <button id="btn__iniciar-sesion">Iniciar Sesión</button>
                    </div>
                    <div class="caja__trasera-register">
                        <h3>¿Aún no tienes una cuenta?</h3>
                        <p>Regístrate para que puedas iniciar sesión</p>
                        <button id="btn__registrarse">Regístrarse</button>
                    </div>
                </div>


                <div class="contenedor__login-register">

                    <form action="${pageContext.request.contextPath}/UsuarioControlador?accion=Login" class="formulario__login" method="POST">
                        <h2>Iniciar Sesión</h2>
                        <input type="email" name="correo" placeholder="Correo Electronico" required="true">
                        <input type="password" name="password" placeholder="Contraseña" required="true">
                        <button type="submit" class="button btn btn-primary">Ingresar</button>
                    </form>
                    <%
                        String isLogeado = (String) request.getAttribute("errorLogin");
                        if (isLogeado != null) {
                            if (isLogeado.toString().equals("error")) {
                    %> 
                    <div class="alert alert-success d-flex align-items-center" role="alert">
                        <svg class="bi flex-shrink-0 me-2" width="24" height="24" role="img" aria-label="Success:"><use xlink:href="#check-circle-fill"/></svg>
                        <div>
                            Email o contraseña inválidos.
                        </div>
                    </div>
                    <%
                            }
                        }
                    %>

                    <form action="${pageContext.request.contextPath}/UsuarioControlador?accion=AddUser" class="formulario__register" method="POST">
                        <h2>Regístrarse</h2>
                        <select class="form-select" name="id_membresia" required="true">           
                            <option value="1">Bronce</option>
                            <option value="2">Plata</option>
                            <option value="3">Oro</option>
                            <option value="4">Diamante</option>
                        </select>
                        <input type="text" placeholder="DNI" name="dni" required="true">
                        <input type="text" placeholder="Nombres y Apellidos" name="nombre" required="true">
                        <input type="text" placeholder="Celular" name="celular" required="true">
                        <input type="text" placeholder="Direccion" name="direccion" required="true">
                        <input type="email" placeholder="Email" name="email" required="true">
                        <input type="password" placeholder="Contraseña" name="password" required="true">
                        <input type="text" placeholder="Rol" value="Usuario" name="rol" hidden="true">
                        <input type="submit" class="btn btn-primary" value="Registrarse"/>
                    </form>
                </div>
            </div>

        </main>
        <script src="js/script.js"></script>

    </body>
</html>
