<%--
  Created by IntelliJ IDEA.
  User: Edwin Mosquera
  Date: 29/11/2023
  Time: 9:18 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
    <link href='https://fonts.googleapis.com/css?family=Open+Sans:400,300,700' rel='stylesheet' type='text/css'>
    <link href="../css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>

    <hgroup>
        <h1>Eficiena Organizacional</h1>
        <h3>Iniciar Sesion</h3>
    </hgroup>
    <form action="../ServletEmpleado" method="post">
        <div class="group">
            <input type="email"><span class="highlight"></span><span class="bar"></span>
            <label>Correo</label>
        </div>
        <div class="group">
            <input type="password"><span class="highlight"></span><span class="bar"></span>
            <label>Contraseña</label>
        </div>
        <button type="submit" class="button buttonBlue">Iniciar Sesion
            <input type="hidden" value="login" name="operacion"/>
            <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
        </button>

    </form>

    <script src="../js/login.js" type="text/javascript"></script>
</body>
</html>
