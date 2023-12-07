<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="static co.edu.poli.ppi.eficienciaorganizacional.DAO.Conexion.getConexion" %>
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
    int id = Integer.parseInt(request.getParameter("id"));
    try {
        String sql = "SELECT * FROM EMPLEADOS WHERE DOCUMENTO="+id;

        PreparedStatement ps = getConexion().prepareStatement(sql);
        ResultSet rs = ps.executeQuery();

        while (rs.next()) {

%>
    <form action="../ServletEmpleado" method="post">
        <div class="group">
            <input type="number" name="documento" value="<%= rs.getInt("DOCUMENTO")%>" ><span class="highlight"></span><span class="bar"></span>
            <label>Documento</label>
        </div>
        <div class="group">
            <input type="text" name="nombre" value="<%= rs.getString("NOMBRE")%>"><span class="highlight"></span><span class="bar"></span>
            <label>Nombre</label>
        </div>
        <div class="group">
            <input type="text" name="p_apellido" value="<%= rs.getString("P_APELLIDO")%>"><span class="highlight"></span><span class="bar"></span>
            <label>Primer Apellido</label>
        </div>
        <div class="group">
            <input type="text" name="s_apellido" value="<%= rs.getString("S_APELLIDO")%>"><span class="highlight"></span><span class="bar"></span>
            <label>Segundo Apellido</label>
        </div>
        <div class="group">
            <input type="number" name="telefono" value="<%= rs.getString("TELEFONO")%>"><span class="highlight"></span><span class="bar"></span>
            <label>Telefono</label>
        </div>
        <div class="group">
            <input type="email" name="correo" value="<%= rs.getString("CORREO_PER")%>"><span class="highlight"></span><span class="bar"></span>
            <label>Correo Personal</label>
        </div>
        <div class="group">
            <input type="text" name="cargo" value="<%= rs.getInt("CARGO_CODIGO")%>"><span class="highlight"></span><span class="bar"></span>
            <label>Cargo</label>
        </div>
        <div class="group">
            <input type="text" name="rol" value="<%= rs.getInt("ROL_CODIGO")%>"><span class="highlight"></span><span class="bar"></span>
            <label>Rol</label>
        </div>

        <input type="hidden" value="editar" name="operacion"/>
        <input type="hidden" value="<%= rs.getString("CONTRASEÑA")%>" name="pass"/>
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
