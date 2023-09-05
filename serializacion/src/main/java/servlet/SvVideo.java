
package servlet;

import com.umariana.mundo.Video;
import java.io.*;
import java.util.ArrayList;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;


@WebServlet(name = "SvVideo", urlPatterns = {"/SvVideo"})
public class SvVideo extends HttpServlet {

    ArrayList<Video> misVideos = new ArrayList<>();

    @Override
    public void init() throws ServletException {
        super.init();

        ServletContext servletContext = getServletContext();

       
        leerArchivo(servletContext);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idVideo = request.getParameter("idvideo");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String anio = request.getParameter("anio");
        String categoria = request.getParameter("categoria");
        String url = request.getParameter("url");
        String letra = request.getParameter("letra");
        
        //System.out.println("idVideo: "+idVideo);
        //System.out.println("titulo: "+titulo);
        //System.out.println("autor: "+autor);
        //System.out.println("anio: "+anio);
        //System.out.println("categoria: "+categoria);
        //System.out.println("url: "+url);
        //System.out.println("letra: "+letra);
        try{
            
            int idVideoInt = Integer.parseInt(idVideo);
        
            Video miVideo = new Video(idVideoInt, titulo, autor, anio, categoria, url, letra);
            misVideos.add(miVideo);
            
        } catch (NumberFormatException e){
                        
            e.printStackTrace();
            System.out.println("Error al convertir a una variable int " + e.getMessage());
        }
        
        /*
          se guardan los datos del video en el archivo
        */
        escribirArchivo();
        
        //agregar el array 
        request.setAttribute("misVideos", misVideos);
        
        //redireccionar a la pagina web destino 
        request.getRequestDispatcher("listarVideos.jsp").forward(request, response);
        
    }

    private void escribirArchivo() {
        try {
            /*
            asignar la carpeta donde estar el archivo
            */
            String ruta = getServletContext().getRealPath("/data");

            /*
            crear carpeta como objeto de tipo file
            */
            File carpeta = new File(ruta);
            
            
            if (!carpeta.exists()) {
                /*
                este metodo crea la carpeta en caso de que no exista
                */
                carpeta.mkdirs();
            }

            /*
            
            */
            String rutaArchivo = carpeta + File.separator + "persistencia.ser";
            
            /*
            output stream es para la salida de datos y especificamos el archivo donde queremos escribir
            */
            FileOutputStream output = new FileOutputStream(rutaArchivo);
            
            ObjectOutputStream objectoutput = new ObjectOutputStream(output);
            /*
            escribimos en el array
            */
            objectoutput.writeObject(misVideos);
            objectoutput.close();
            
            System.out.println("Se guardaron los datos");
            
            
        } catch (IOException e) {
            
            /*
            el metodo printStackTrace lo usamos para especificar el error ocurrido
            */
            e.printStackTrace();
            
        }
    }

    
    /*
    metodo que va a leer los datos guardados de los videos para hacer persistencia
    */
    public void leerArchivo(ServletContext servletContext) {
        
        try {
            
            /*
            Especificamos el directorio del archivo 
            */
            String linea = servletContext.getRealPath("/data/persistencia.ser");

            /*
            creamos el objeto tipo file
            */
            File archivo = new File(linea);
            
            /*
            condicional para leer el archivo
            */
            if (archivo.exists()) {
                
                FileInputStream input = new FileInputStream(linea);
                ObjectInputStream objectinput = new ObjectInputStream(input);

                /*
                metodo readObjet para leer los videos que se guardaron
                */
                misVideos = (ArrayList<Video>) objectinput.readObject();
                objectinput.close();
                
            }
            /*
            catch para el input output y para cuando no se encuentre la clase
            */
        } catch (IOException | ClassNotFoundException e) {
            
            e.printStackTrace();
            //mensaje por si no se puede cargar la informacion
            System.out.println("Se ha producido un error " + e.getMessage());
        }
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }
}