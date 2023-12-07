<%--
  Created by IntelliJ IDEA.
  User: Edwin Mosquera
  Date: 17/09/2023
  Time: 6:33 p. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
  <head>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Página Eficiencia Organizacional</title>
    <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
    <link href="css/styles.css" rel="stylesheet"/>
  </head>
  <body>
    <header class="hero" style="min-height: 55vh;">
      <nav class="nav__hero">
        <div class="container nav__container">
          <div class="logo">
            <h2 class="logo__name"> Eficiencia Organizacional<span class="point">.</span></h2>
          </div>
          <div class="links">
            <a href="Servlet1?formulario=index" class="link">Inicio</a>
            <a href = "Servlet1?formulario=servicios" class="link">Servicios prestados</a>
            <!--a href="Servlet1?formulario=novedades" class="link">Novedades</a>
            <a href="Servlet1?formulario=contacto" class="link">Contacto</a>
            <a href="Servlet1?formulario=nosotros" class="link">Nosotros</a>
            <a href="Servlet1?formulario=ingresar" class="link link--active">Ingresar</a-->
          </div>
        </div>
      </nav>
      <section class="services">
        <div align="center">
          <c:if test="${not empty mensaje}" >
            <h2><p style="color: red;"><c:out value="${mensaje}" /></p></h2>
          </c:if>
          <form action="Servlet2" method="POST">
            <table border="1" cellpadding="5" style="padding: 2em;">
              <thead>
              <tr>
                <th>Tipo de Actividad</th>
                <th>Entidad</th>
              </tr>
              </thead>
              <tbody>
              <tr>
                <td>
                  <select name="area" size="2">
                    <option value="1" selected="">GD,SD y Transparencia</option>
                    <option value="2">SG-SST</option>
                    <option value="3">MIPG</option>
                  </select>
                </td>
                <td>
                  <select name="entidad" size="2">
                    <option value="1" selected="">Alcaldia de Betania</option>
                    <option value="2">EPMB</option>
                    <option value="3">Alcaldia de Hispania</option>
                    <option value="4">EPH</option>
                  </select>
                </td>
              </tr>
              <tr>
                <td COLSPAN="3">
                  Descripcion
                  <input type="text"
                         name="descripcion"
                         style="width: 250px; height: 100px;"/>
                </td>
              </tr>
              <tr>
                <td colspan="3">
                  <input type="hidden"
                         value="crearRegistro"
                         name="formulario"/>
                  <input type="submit"
                         value="Crear Registro"/>
                </td>
              </tr>
              </tbody>
            </table>
          </form>
        </div>
      </section>
    </header>
    <footer  class="footer">
      <div class="container--foot footer__caption">
        <section class="download">
          <div class="SloganSection">
            <img src="img/logo.png">

          </div>

          <div class="footer__copy">
            <h4 class="Slogan__text">trabajanos con sentido empresarial y social</h4>
            <p class="copyright">Eficiena Organizacional &COPY; 2022 Todos los derechos reservados</p>
            <a href="#" class="politica__privacidad politica__privacidad--margin">Política de privacidad</a>
            <a href="#" class="politica__privacidad">Términos y Condiciones</a>
          </div>

        </section>
        <section class="get-email">
          <h3 class="tittle-footer">¿Estás listo para trabajar con nosotros ?</h3>
          <form action="" class="newsletter newsletter--modifier">
            <input type="text" class="newsletter__input" placeholder="Ingresa tu email">
            <input type="submit" class="newsletter__submit" value="Comienza hoy">
          </form>
          <div class="socialmedia">
            <p class="socialmedia__legend">Siguenos en: </p>

            <i class='socialmedia__icon bx bxl-facebook-circle' ></i>
            <i class='socialmedia__icon bx bxl-linkedin-square' ></i>
            <i class='socialmedia__icon bx bxl-twitter' ></i>
            <a href="https://www.instagram.com/"><i class='socialmedia__icon bx bxl-instagram' ></i></a>
          </div>
        </section>
      </div>
    </footer>
  </body>
</html>
