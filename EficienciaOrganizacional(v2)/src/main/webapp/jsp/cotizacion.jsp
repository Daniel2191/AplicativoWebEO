<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Página Eficiencia Organizacional</title>
        <link rel="stylesheet" href="../css/styles.css">
        <link href='https://cdn.jsdelivr.net/npm/boxicons@2.0.5/css/boxicons.min.css' rel='stylesheet'>
    </head>
    <body>
        <header class="hero">
            <nav class="nav__hero">
                <div class="container nav__container">
                    <div class="logo">
                        <h2 class="logo__name"> Eficiencia Organizacional<span class="point">.</span></h2>
                    </div>
                    <div class="links">
                        <a href="Servlet1?formulario=index" class="link">Inicio</a>
                        <a href="Servlet1?formulario=cotizacion" class="link">Cotizacion</a>
                        <!--a href = "Servlet1?formulario=servicios" class="link">Servicios prestados</a>
                        <a href="Servlet1?formulario=novedades" class="link">Novedades</a>
                        <a href="Servlet1?formulario=contacto" class="link">Contacto</a>
                        <a href="Servlet1?formulario=nosotros" class="link">Nosotros</a>
                        <a href="Servlet1?formulario=ingresar" class="link link--active">Ingresar</a-->
                    </div>
                </div>
            </nav>
            <section class="services">
                <div align="center">
                    <c:if test="${not empty mensaje}" >
                        <section class="container hero__main">
                            <div class="hero__textos">
                                <h1 class="title"><p style="color: black; font-family: Comic Sans MS"><c:out value="${mensaje}" /></p></h1>
                            </div>
                            <img src="img/mockup.png" class="mockup">
                        </section>
                    </c:if>
                    <c:if test="${not empty mensaje1}" >
                        <h2><p style="color: red;"><c:out value="${mensaje1}" /></p></h2>
                    </c:if>
                    <c:if test="${empty mensaje}" >
                        <form action="Servlet4" method="POST">
                            <table border="1" cellpadding="5" style="padding: 2em;">
                                <thead>
                                <tr>
                                    <th>Nivel de riesgo</th>
                                    <th>Cantidad contratistas</th>
                                </tr>
                                </thead>
                                <tbody>
                                <tr>
                                    <td>
                                        <select name="nivel" size="2">
                                            <option value="1" selected="">Clacificacion de riesgo I, II ó III</option>
                                            <option value="2">Clacificacion de riesgo IV ó V</option>
                                        </select>
                                    </td>
                                    <td>
                                        <input type="text"
                                               name="cantidad"
                                               style="width: 250px; height: 20px;"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td>
                                        Correo Electronico
                                        <input type="text"
                                               name="correo"
                                               style="width: 120px; height: 20px;"/>
                                    </td>
                                    <td>
                                        Numero de telefono
                                        <input type="text"
                                               name="numero"
                                               style="width: 120px; height: 20px;"/>
                                    </td>
                                </tr>
                                <tr>
                                    <td colspan="3">
                                        <input type="hidden"
                                               value="EnviarCotizacion"
                                               name="formulario"/>
                                        <input type="submit"
                                               value="Enviar Cotizacion"/>
                                    </td>
                                </tr>
                                </tbody>
                            </table>
                        </form>
                    </c:if>
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
