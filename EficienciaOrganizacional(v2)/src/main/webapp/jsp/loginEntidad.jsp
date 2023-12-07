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
    <form action="../ServletEntidad" method="post">
        <div class="group">
            <input type="email" name="correo"><span class="highlight"></span><span class="bar"></span>
            <label>Correo</label>
        </div>
        <div class="group">
            <input type="password" name="pass"><span class="highlight"></span><span class="bar"></span>
            <label>Contraseña</label>
        </div>
        <button type="submit" class="button buttonBlue">Iniciar Sesion
            <input type="hidden" value="login" name="operacion"/>
            <div class="ripples buttonRipples"><span class="ripplesCircle"></span></div>
        </button>
    </form>

    <script>
        $(window, document, undefined).ready(function() {

            $('input').blur(function() {
                var $this = $(this);
                if ($this.val())
                    $this.addClass('used');
                else
                    $this.removeClass('used');
            });

            var $ripples = $('.ripples');

            $ripples.on('click.Ripples', function(e) {

                var $this = $(this);
                var $offset = $this.parent().offset();
                var $circle = $this.find('.ripplesCircle');

                var x = e.pageX - $offset.left;
                var y = e.pageY - $offset.top;

                $circle.css({
                    top: y + 'px',
                    left: x + 'px'
                });

                $this.addClass('is-active');

            });

            $ripples.on('animationend webkitAnimationEnd mozAnimationEnd oanimationend MSAnimationEnd', function(e) {
                $(this).removeClass('is-active');
            });

        });
    </script>
</body>
</html>
