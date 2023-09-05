
<%@page import="java.io.IOException"%>
<%@page import="java.io.ObjectInputStream"%>
<%@page import="java.io.FileInputStream"%>
<%@page import="java.io.File"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.umariana.mundo.Video"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link href="https://fonts.googleapis.com/css2?family=Rubik:wght@300&display=swap" rel="stylesheet">
        
        
        <title>JSP Page</title>
        
        <link rel="stylesheet" type="text/css" href="styles.css">
    </head>
    <body>
        <header>Listar videos</header>
        

            <%
            
            /*
              crear array de los videos  
             */
            ArrayList<Video> misVideos = null;
            
            /*
            especificamos 
            */
            String linea = application.getRealPath("/data/persistencia.ser");
            
            /*
            creamos un objeto tipo file y le asignamos el String que creamos antes
            */
            File archivo = new File(linea);
            
            /*
            condicional que comienza si existe el archivo especificado
            */
            if (archivo.exists()) {
            
                /*
                con input stream accedemos al archivo que creamos
                */
                FileInputStream input = new FileInputStream(linea);
                
                /*
                con output stream enviamos informacion al archivo
                */
                ObjectInputStream objectinput = new ObjectInputStream(input);
                
                /*
                leemos el array de videos
                */
                misVideos  = (ArrayList<Video>) objectinput.readObject();
                objectinput.close();
                
                System.out.println("Datos de videos cargados exitosamente desde: " + linea);
            }
            
            /*
            condicional que funciona si hay datos en el array
            */
             if (misVideos != null) {
             
                System.out.println("Videos cargados");
                
                /*
                ciclo for para mostrar los datos de nuestros videos
                */
                for (Video v : misVideos) {
                    out.print("IdVideo:" + v.getIdVideo() + "<br>");
                    out.print("Titulo:" + v.getTitulo() + "<br>");
                    out.print("Autor;" + v.getAutor() + "<br>");
                    out.print("Anio:" + v.getAnio() + "<br>");
                    out.print("Categoria:" + v.getCategoria() + "<br>");
                    out.print("Url" + v.getUrl() + "<br>");
                    out.print("Letra:" + v.getLetra() + "<br>");
                 
                }
                /*
                
                */
            } else {
                out.print("No has ingresado videos");
            }
            
            %>
 
        
    </body>
</html>
