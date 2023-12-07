<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
    <head>
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Página Eficiencia Organizacional</title>
        <link rel="stylesheet" href="css/styles.css">
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
                        <a href = "Servlet1?formulario=servicios" class="link">Servicios</a>
                        <a href="Servlet1?formulario=novedades" class="link">Novedades</a>
                        <a href="Servlet1?formulario=contacto" class="link">Contacto</a>
                        <a href="Servlet1?formulario=nosotros" class="link">Nosotros</a>
                        <a href="Servlet1?formulario=ingresar" class="link link--active">Ingresar</a>
                    </div>
                </div>
            </nav>
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
