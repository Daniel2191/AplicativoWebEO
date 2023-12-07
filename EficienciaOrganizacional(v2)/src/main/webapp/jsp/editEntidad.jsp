<%@ page import="static co.edu.poli.ppi.eficienciaorganizacional.DAO.Conexion.getConexion" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Edwin Mosquera
  Date: 1/12/2023
  Time: 1:14 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Actualizar</title>
    <link href="../css/login.css" rel="stylesheet" type="text/css"/>
</head>
<body>
    <%
        String id = request.getParameter("id");
        try {
            String sql = "SELECT * FROM ENTIDADES WHERE NIT=?";

            PreparedStatement ps = getConexion().prepareStatement(sql);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();

            while (rs.next()) {

    %>
    <form action="../ServletEntidad" method="post">
        <div class="group">
            <input type="text" name="nit" value="<%= rs.getString("NIT")%>" ><span class="highlight"></span><span class="bar"></span>
            <label>NIT</label>
        </div>
        <div class="group">
            <input type="text" name="nombre" value="<%= rs.getString("NOMBRE")%>"><span class="highlight"></span><span class="bar"></span>
            <label>Nombre</label>
        </div>
        <div class="group">
            <input type="text" name="direccion" value="<%= rs.getString("DIRECCION")%>"><span class="highlight"></span><span class="bar"></span>
            <label>Direccion</label>
        </div>
        <div class="group">
            <input type="text" name="telefono" value="<%= rs.getString("TELEFONO")%>"><span class="highlight"></span><span class="bar"></span>
            <label>Telefono</label>
        </div>
        <div class="group">
            <input type="text" name="correo" value="<%= rs.getString("ENT_CORREO")%>"><span class="highlight"></span><span class="bar"></span>
            <label>Correo</label>
        </div>
        <input type="hidden" value="editar" name="operacion"/>
        <button type="submit" class="button buttonBlue">Actualizar
            <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
        </button>
    </form>
    <%
            }
        }catch (Exception ex){
            System.out.println(ex);
        }
    %>
</body>
</html>
