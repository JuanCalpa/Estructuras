
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>

<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        
        <link rel="stylesheet" type="text/css" href="styles.css">
        
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
    </head>
    
    <body>
       <header>Sistema de reproductor de videos</header>
        <!-- formulario -->
        
         <div class="formulario"> 
             
            <form action="SvVideo" method="POST" >
                
                <div class="agregar">
                    
                    
                    <div class="inputs">
                        <label for="idVideo"> </label>
                        <input type="text" name="idVideo" placeholder="idvideo"><br>

                        <label for="titulo" > </label>
                        <input type="text" name="titulo" placeholder="Titulo"><br>

                        <label for="autor" > </label>
                        <input type="text" name="autor" placeholder="Autor"><br>

                        <label for="anio" > </label>
                        <input type="text" name="anio" placeholder="Año"><br>

                        <label for="categoria" >  </label>
                        <input type="text" name="categoria" placeholder="Categoria"><br>

                        <label for="url" ></label>
                        <input type="text" name="url" placeholder="Url"><br>

                        <label for="letra" ></label>
                        <textarea id="id" name="letra" rows="5" cols="10" placeholder="Letra"></textarea><br>

                        <div class="botonAgregar">
                            <input type="submit" value="Agregar video">
                         </div>

                        
            
                    </div>
                    
                </div>
                
                    <div class="regresar">
                            <a href="index.jsp">Regresar </a>
                        </div>
         </div>
 
    </body>
</html>
