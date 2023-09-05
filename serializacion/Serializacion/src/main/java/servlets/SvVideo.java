
package servlets;

import com.umariana.mundo.Video;
import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Isabella
 */
@WebServlet(name = "SvVideo", urlPatterns = {"/SvVideo"})
public class SvVideo extends HttpServlet {

    ArrayList <Video> misVideos= new ArrayList<>();
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
     
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       //aqui estan los datos por get de agregarVideo
        
       
       
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idVideo = request.getParameter("idVideo");
        String titulo = request.getParameter("titulo");
        String autor = request.getParameter("autor");
        String anio = request.getParameter("anio");
        String categoria = request.getParameter("categoria");
        String letra = request.getParameter("letra");
        String url = request.getParameter("url");
        
        
       /* System.out.println("idVideo: " + idVideo);
        System.out.println("Titulo: " + titulo);
        System.out.println("Autor: " + autor);
        System.out.println("Anio: " + anio);
        System.out.println("Categoria: " + categoria);
        System.out.println("Letra: " + letra);
        System.out.println("Url: " + url); */
       
       
   
   
       //Ingresar los datos al objeto
       Video miVideo =new Video (Integer.parseInt(idVideo), titulo, autor, anio, categoria, letra, url);
       misVideos.add(miVideo);
       
       //agregar arrayList al objeto de solicitud como atributo
       request.setAttribute("misVideos",  misVideos);
       
       //redireccionar a la pagina web destino
       request.getRequestDispatcher("listarVideos.jsp").forward(request, response);
       
       for (Video v: misVideos){
        System.out.println("idVideo: " + v.getIdVideo());
        System.out.println("Titulo: " + v.getTitulo());
        System.out.println("Autor: " + v.getAutor());
        System.out.println("Anio: " + v.getAnio());
        System.out.println("Categoria: " + v.getCategoria());
        System.out.println("Letra: " + v.getLetra());
        System.out.println("Url: " + v.getUrl());
        System.out.println("==================");
       }
       
       
    }

    /**
     *
     * @return
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

  
}
