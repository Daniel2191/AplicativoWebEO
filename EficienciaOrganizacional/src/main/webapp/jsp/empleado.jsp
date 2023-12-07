<%@ page import="java.sql.PreparedStatement" %>
<%@ page import="java.sql.ResultSet" %>
<%@ page import="static co.edu.poli.ppi.eficienciaorganizacional.DAO.Conexion.getConexion" %><%--
  Created by IntelliJ IDEA.
  User: Edwin Mosquera
  Date: 30/11/2023
  Time: 3:52 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Empleado</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-T3c6CoIi6uLrA9TneNEoa7RxnatzjcDSCmG1MXxSR1GAsXEV/Dwwykc2MPK8M2HN" crossorigin="anonymous">

</head>
<body>

    <%
        try {
            String sql = "SELECT E.DOCUMENTO, E.NOMBRE, E.P_APELLIDO, E.S_APELLIDO, E.TELEFONO, E.CORREO_PER, C.NOMBRE_C, R.NOMBRE_R " +
                    "FROM EMPLEADOS E INNER JOIN CARGOS C ON E.CARGO_CODIGO=C.CODIGO INNER JOIN ROLES R ON E.ROL_CODIGO=R.CODIGO";

            PreparedStatement ps = getConexion().prepareStatement(sql);
            ResultSet rs = ps.executeQuery();


    %>
    <div class="container">
        <h1>Lista de empleados</h1>
        <hr>
        <table class="table table-bordered">
            <tr>
                <th class="text-center">Documento</th>
                <th class="text-center">Nombre</th>
                <th class="text-center">Primer Apellido</th>
                <th class="text-center">Segundo Apellido</th>
                <th class="text-center">Telefono</th>
                <th class="text-center">Correo</th>
                <th class="text-center">Cargo</th>
                <th class="text-center">Rol</th>
            </tr>
            <%
                while (rs.next()) {


            %>
            <tr>
                <td class="text-center"><%= rs.getInt("DOCUMENTO")%></td>
                <td class="text-center"><%= rs.getString("NOMBRE")%></td>
                <td class="text-center"><%= rs.getString("P_APELLIDO")%></td>
                <td class="text-center"><%= rs.getString("S_APELLIDO")%></td>
                <td class="text-center"><%= rs.getString("TELEFONO")%></td>
                <td class="text-center"><%= rs.getString("CORREO_PER")%></td>
                <td class="text-center"><%= rs.getString("NOMBRE_C")%></td>
                <td class="text-center"><%= rs.getString("NOMBRE_R")%></td>
                <td class="text-center">
                    <form method="post" action="../ServletEmpleado">
                        <a class="btn btn-warning btn-sm" href="../jsp/editEmpleado.jsp?id=<%= rs.getInt("DOCUMENTO")%>">Editar</a>
                        <input type="hidden" value="eliminar" name="operacion"/>
                        <input type="hidden" value="<%= rs.getInt("DOCUMENTO")%>" name="id"/>
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
