<%-- 
    Document   : agregarVideo
    Created on : 29/08/2023, 5:45:39 p. m.
    Author     : jcalp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Agregar video</title>
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
        
        
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <header>Sistema reproductor de videos</header>
        
        <div class="formulario"> 
            
            <form class="form" action="SvVideo" method="POST">
                
                <div class="agregar">
                    
                    <div class="inputs">
                        <label for="idvideo"></label>
                        <input type="type" name="Id video" placeholder="idvideo">
                    </div><br>

                    <div class="inputs">
                        <label for="titulo"></label>
                        <input type="type" name="titulo" placeholder="Titulo">
                    </div><br>

                    <div class="inputs">
                        <label for="autor"></label>
                        <input type="type" name="autor" placeholder="Autor">
                    </div><br>

                    <div class="inputs">
                        <label for="anio"></label>
                        <input type="type" name="anio" placeholder="Año">
                    </div><br>

                    <div class="inputs">
                        <label for="categoria"></label>
                        <input type="type" name="categoria" placeholder="Categoria">
                    </div><br>

                    <div class="inputs">
                        <label for="url"></label>
                        <textarea type="type" name="url" placeholder="Url"></textarea>
                    </div><br>

                    <div class="inputs">
                        <label for="letra"></label>
                        <textarea id="id" name="letra" rows="5" cols="10" placeholder="Letra"> </textarea>

                    </div><br>

                    <div class="botonAgregar">
                        <input type="submit" value="Agregar video">
                     </div>
                    
                </div>
                
                
            </form>
        
            <div class="regresar">
                <a href="index.jsp">Regresar al menu</a>
            </div>
            
        </div>
        
    </body>
</html>
