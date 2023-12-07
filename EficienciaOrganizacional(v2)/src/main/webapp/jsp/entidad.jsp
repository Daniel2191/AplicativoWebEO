<%@ page import="static co.edu.poli.ppi.eficienciaorganizacional.DAO.Conexion.getConexion" %>
<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %><%--
  Created by IntelliJ IDEA.
  User: Edwin Mosquera
  Date: 30/11/2023
  Time: 3:51 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Entidad</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>
    <%
        try {
            String sql = "SELECT NIT, NOMBRE, DIRECCION, TELEFONO, ENT_CORREO FROM ENTIDADES";

            PreparedStatement ps = getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


    %>
    <div class="container">
        <h1>Lista de Entidad</h1>
        <hr>
        <table class="table table-bordered">
            <tr>
                <th class="text-center">NIT</th>
                <th class="text-center">NOMBRE</th>
                <th class="text-center">DIRECCIÓN</th>
                <th class="text-center">TELEFONO</th>
                <th class="text-center">CORREO</th>
            </tr>
            <%
                while (rs.next()) {


            %>
            <tr>
                <td class="text-center"><%= rs.getString("NIT")%></td>
                <td class="text-center"><%= rs.getString("NOMBRE")%></td>
                <td class="text-center"><%= rs.getString("DIRECCION")%></td>
                <td class="text-center"><%= rs.getString("TELEFONO")%></td>
                <td class="text-center"><%= rs.getString("ENT_CORREO")%></td>
                <td class="text-center">
                    <form method="post" action="../ServletEntidad">
                        <a class="btn btn-warning btn-sm" href="../jsp/editEntidad.jsp?id=<%= rs.getString("NIT")%>">Editar</a>
                        <input type="hidden" value="eliminar" name="operacion"/>
                        <input type="hidden" value="<%= rs.getString("NIT")%>" name="id"/>
                        <button class="btn btn-danger btn-sm" type="submit">Eliminar</button>
                    </form>
                </td>
            </tr>
            <%}%>
        </table>
    </div>
    <%

        }catch (Exception ex){
            System.out.println(ex);
        }
    %>

    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-C6RzsynM9kWDrMNeT87bh95OGNyZPhcTNXj1NW7RuBCsyN/o0jlpcV8Qyq46cDfL" crossorigin="anonymous"></script>
</body>
</html>
