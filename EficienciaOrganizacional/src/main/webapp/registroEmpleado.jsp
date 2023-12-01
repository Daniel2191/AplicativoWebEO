<%--
  Created by IntelliJ IDEA.
  User: Edwin Mosquera
  Date: 30/11/2023
  Time: 3:21 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registro Empleado</title>
    <link href="css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>

    <hgroup>
        <h1>Eficiena Organizacional</h1>
        <h3>Registro Empleado</h3>
    </hgroup>
    <form action="ServletEmpleado" method="post">
        <div class="group">
            <input type="number" name="documento"><span class="highlight"></span><span class="bar"></span>
            <label>Documento</label>
        </div>
        <div class="group">
            <input type="text" name="nombre"><span class="highlight"></span><span class="bar"></span>
            <label>Nombre</label>
        </div>
        <div class="group">
            <input type="text" name="p_apellido"><span class="highlight"></span><span class="bar"></span>
            <label>Primer Apellido</label>
        </div>
        <div class="group">
            <input type="text" name="s_apellido"><span class="highlight"></span><span class="bar"></span>
            <label>Segundo Apellido</label>
        </div>
        <div class="group">
            <input type="number" name="telefono"><span class="highlight"></span><span class="bar"></span>
            <label>Telefono</label>
        </div>
        <div class="group">
            <input type="email" name="correo"><span class="highlight"></span><span class="bar"></span>
            <label>Correo Personal</label>
        </div>
        <div class="group">
            <input type="text" name="cargo"><span class="highlight"></span><span class="bar"></span>
            <label>Cargo</label>
        </div>
        <div class="group">
            <input type="text" name="rol"><span class="highlight"></span><span class="bar"></span>
            <label>Rol</label>
        </div>
        <div class="group">
            <input type="password" name="pass"><span class="highlight"></span><span class="bar"></span>
            <label>Contraseña</label>
        </div>
        <input type="hidden" value="crear" name="operacion"/>
        <button type="submit" class="button buttonBlue">Iniciar Sesion
            <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
        </button>
    </form>

    <script src="js/login.js" type="text/javascript"></script>
</body>
</html>
