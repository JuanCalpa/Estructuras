/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.proyecto1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Scanner;
import mundo.Alumno;

/**
 *
 * @author jcalp
 */
public class Proyecto1 {

    public static void main(String[] args) throws IOException {
        
        /*
        lector para recibir los datos
        */
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        /*
        declaramos interruptor de tipo booleanpara activar o desactivar el menu
        */
        boolean interruptor = true;
        
        /*
        declaramos el scaner de la clase Scanner
        */
        Scanner scaner = new Scanner(System.in);
        
        /*
        declaramos ArrayList para guardar los alumnos registrados
        */
        ArrayList<Alumno> alumnosRegistrados = new ArrayList<Alumno>();
        
        leerArchivo(alumnosRegistrados); // llamamos al metodo que lee nuestro archivo txt en la carpeta .data
        
         /*
        ciclo do while para que el menu este activo hasta que el usuario lo desactive
        */
         do { 
             
            System.out.println("--------------------------");
            System.out.println("         Menu");
            System.out.println("--------------------------");
            System.out.println("1 = Insertar alumno");
            System.out.println("2 = Eliminar alumno");
            System.out.println("3 = Modificar alumno");
            System.out.println("4 = Consultar alumno");
            System.out.println("5 = Imprimir estudiantes segun su semestre en archivo");
            System.out.println("6 = Generar reporte de datos");
            System.out.println("7 = Finalizar");
            System.out.println("         ");
            
            /*
            Opcion que selecciona el usuario
            */
            int seleccion = scaner.nextInt();
            
            /*
            switch con todas las opciones que puede elegir el usuario
            */
            switch(seleccion){
                
                case 1: //si el usuario ingresa la tecla 1
                    
                    System.out.println("-----------------");
                    System.out.println("Insertar alumno ");
                    System.out.println("-----------------");
                    
                    agregarAlumno(alumnosRegistrados, new BufferedReader(new InputStreamReader(System.in)));
                    
                    break;
                    
                case 2: //si el usuario ingresa la tecla 2
                    
                    System.out.println("-----------------");
                    System.out.println("Eliminar alumno ");
                    System.out.println("-----------------");
                    
                    eliminarAlumno(alumnosRegistrados, new BufferedReader(new InputStreamReader(System.in)));
                    
                    break;
                    
                case 3: //si el usuario ingresa la tecla 3
                    
                    System.out.println("-----------------");
                    System.out.println("Modificar alumno ");
                    System.out.println("-----------------");
                    
                    modificarAlumno(alumnosRegistrados, new BufferedReader(new InputStreamReader(System.in)));
                    
                    break;
                    
                case 4: //si el usuario ingresa la tecla 4
                    
                    System.out.println("-----------------");
                    System.out.println("Consultar alumno ");
                    System.out.println("-----------------");
                    
                    //consultarAlumno(alumnosRegistrados, new BufferedReader(new InputStreamReader(System.in)));
                    mostrarAlumnos(alumnosRegistrados, new BufferedReader(new InputStreamReader(System.in)));
                    break;
                    
                case 5: //si el usuario ingresa la tecla 5
                    
                    System.out.println("-----------------");
                    System.out.println("Mira el archivo reporteAlumnos.txt");
                    System.out.println("-----------------");
                    
                    imprimirAlumnos(alumnosRegistrados, new BufferedReader(new InputStreamReader(System.in)));
                    
                    break;
                    
                case 6: //si el usuario ingresa la tecla 6
                    
                    System.out.println("-----------------");
                    System.out.println("Mira el archivo reporte.txt");
                    System.out.println("-----------------");
                    
                    reporte(alumnosRegistrados);
                    
                    break;
                    
                case 7: //si el usuario ingresa la tecla 7
                    
                    System.out.println("-----------------");
                    System.out.println("Programa ya no esta en ejecucion. Hasta la proxima ;)");
                    System.out.println("-----------------");
                    
                    
                    interruptor = false; //se cambia el estado de la variable a falso
                    break;
            }
         }while(interruptor); //la condicion es que el interruptor sea igual a "true"
         
        scaner.close(); //cerramos el Scanner que declaramos para que se guarde la informacion
    }
    
    /*
    creamos el metodo para agregar alumnos
    */
    private static void agregarAlumno(ArrayList<Alumno> alumnosRegistrados, BufferedReader br) throws IOException{
        
        //con esta variable se permite el ingreso al ciclo while para registrar datos del usuario
        boolean interruptor = true;
        //esta variable nos ayuda a identificar si una cedula ya esta en uso para que no se repita
        boolean cedulaOcupada = false;

        // ciclo que mientras el interruptor este activo permitira recibir datos
        while(interruptor = true){
            
            // variable que pide el numero de cedula
            System.out.println("Cedula: ");
            String cedula = br.readLine();

            //ciclo y para recorrer las cedulas y condicional
            //para comparar si ya se registro una cedula con ese numero 
            for (Alumno alumno : alumnosRegistrados){
                if(cedula.equals(alumno.getCedula())){
                cedulaOcupada = true;
                }
            }
            
            //condicional que permite continunar con el registro si la cedula no esta repetida en el array
            if(cedulaOcupada!= true){
                /*
                estas variables son las que van a recibir los datos del alumno mediante el scaner
                */
                System.out.println("Nombre: ");
                String nombre = br.readLine();

                System.out.println("Apellido: ");
                String apellido = br.readLine();

                System.out.println("Semestre: ");
                String semestre = br.readLine();

                System.out.println("Correo: ");
                String correo = br.readLine();

                System.out.println("Celular: ");
                String celular = br.readLine();

                /*
                Creamos un objeto de la clase Alumno para almacnear su informacion
                */
                Alumno nAlumno = new Alumno(cedula, nombre, apellido, semestre, correo, celular);

                /*
                con el metodo "add" que pertenece a los array agregamos toda la informacion
                */
                alumnosRegistrados.add(nAlumno);
   
            }else{
                System.out.println("Ya hay un alumno registrado con esta cedula");
            }
            //cambiamos el estado del interruptor para que si se completo el registro no vuelva a entrar en el while
            interruptor = false; break;
        }
    }
    
     /*
    creamos el metodo para eliminar alumno
    */
    public static void eliminarAlumno(ArrayList<Alumno> alumnosRegistrados, BufferedReader br) throws IOException{
        
        /*
        pedimos la cedula para encontrar al estudiante en el array
        */
        System.out.println("Digita la cedula del alumno: ");
        String cedulaAlumnoEliminar = br.readLine();
        
        /*
        variable tipo boolean que se activa en caso de encontrar al estudiante
        */
        boolean usuarioEncontrado = false;
        
        /*
        ciclo que busca la cedula entre los alumnos registrados 
        */
        for(Alumno nAlumno : alumnosRegistrados){
            
            /*
            condicional que compara si existe una cedula identica a la ingresada
            */
            if(nAlumno.getCedula().equals(cedulaAlumnoEliminar)){
                
                /*
                    hacemos uso del metodo remove para eliminar los datos del array
                    */
                    alumnosRegistrados.remove(nAlumno);
                    System.out.println("Este alumno fue eliminado.");
                    
                    /*
                    se cambia el estado de la variable a "true" para identificar que se encontro el alumno
                    y que no lanze el anuncio en caso de ser false
                    */
                    usuarioEncontrado = true; break;
            }
        }
        
        /*
        condicional que identifica si la variable es "false", si es false enviara 
        este mensaje diciendo que no hay ningun estudiante que coincida
        */
        if(usuarioEncontrado == false) 
            System.out.println("Ningun estudiante ha sido registrado con esta cedula");
    }
    
     /*
    creamos el metodo para modificar alumno
    */
    public static void modificarAlumno(ArrayList<Alumno> alumnosRegistrados, BufferedReader br) throws IOException{
        
        /*
        pedimos la cedula para buscarla en el array
        */
        System.out.println("Digite la cedula del alumno: ");
        String modificarCedula = br.readLine();
        
        /*
        interruptor de tipo boolean que se iguala a "true" cuando se encuentra el alumno
        */
        boolean alumnoEncontrado = false;
        
        /*
        ciclo para buscar una cedula que coincida a la ingresada por consola
        */
        for(Alumno nAlumno : alumnosRegistrados){
            /*
            condicional que verifica si la cedula es identica a la guardada
            */
            if( modificarCedula.equals(nAlumno.getCedula())){
                
                /*
                mensaje de bienvenida para el usuario buscado
                */
                System.out.println("Hola!" + nAlumno.getNombre() + " " + nAlumno.getApellido());
                
                /*
                variables que reciben los nuevos datos
                metodo trim que permite dejar campos vacios
                */
                System.out.println("Nuevo nombre:");
                String nombre = br.readLine();
                
                System.out.println("Nuevo apellido: ");
                String apellido = br.readLine();
                
                System.out.println("Nuevo semestre: ");
                String semestre = br.readLine();
                
                System.out.println("Nuevo correo: ");
                String correo = br.readLine();
                
                System.out.println("Nuevo celular: ");
                String celular = br.readLine();
                
                /*
                guardamos la nueva informacion en el array
                */
                nAlumno.setNombre(nombre); nAlumno.setApellido(apellido); 
                nAlumno.setSemestre(semestre); nAlumno.setCorreo(correo);
                nAlumno.setCelular(celular);
        
                /*
                con el metodo "add" se guarda en el array
                */
                alumnosRegistrados.add(nAlumno);
                System.out.println("Se han guardado los datos");
                
                /*
                como si existe un alumno que coincidio con la cedula la variable toma el valor de "true"
                */
                alumnoEncontrado = true; break; 
            }
            
            /*
            condicional para que salte un mensaje si no se encuentra un alumno con la cedula registrada
            */
            if(alumnoEncontrado == false)
                System.out.println("No hay un alumno registrado con esta cedula");
        }
    }

     /*
    creamos el metodo para mostrar los alumnos registrados
    */    
    public static void mostrarAlumnos(ArrayList<Alumno> alumnosRegistrados, BufferedReader br){
        
        //usamos la funcion .isEmpty para comprobar si el array esta vacio
        if(alumnosRegistrados.isEmpty())
            System.out.println("No hay alumnos registrados.");
        
        //ciclo for para recorrer el array y obtener la posicion del estudiante 
        for (int i = 0; i < alumnosRegistrados.size(); i++){
            
            //usamos la funcion .get para obtener la informacion 
            Alumno mostrarAlumno = alumnosRegistrados.get(i);
            
            //guardamos la informacion en variables
            String cedula = mostrarAlumno.getCedula();
            String nombre = mostrarAlumno.getNombre();
            String apellido = mostrarAlumno.getApellido();
            String semestre = mostrarAlumno.getSemestre();
            String correo = mostrarAlumno.getCorreo();
            String celular = mostrarAlumno.getCelular();
            
            //imprimimos en consola la informacion de los estudiantes
            System.out.println( cedula + " * " + nombre + " * " + apellido + " * " + semestre + " * " + correo + " * " + celular + " * ");
        }
        
    }
 
    /*
    creamos el metodo para imprimir el reporte de los alumnos guardados
    */
    public static void imprimirAlumnos(ArrayList<Alumno> alumnosRegistrados, BufferedReader br) throws FileNotFoundException, IOException{
        
        //creamos el archivo donde se va a generar el reporte
        File archivo = new File("./data/reporteAlumnos.txt");
        // creamos la pluma que va a escribir en nuestro archivo txt
        PrintWriter pluma = new PrintWriter(archivo);
        
        System.out.println("De que semestre deseas ver los estudiantes?");
        
        //creamos la variable semstre para saber de que semestre se va a generar el reporte
        String semestre = br.readLine();
        
        pluma.println("===========Reporte de estudiantes del semestre " + semestre + "======" );
        pluma.println("====cedula/nombre/apellido/celular/correo/semestre====");
        pluma.println("======================================================");

        // ciclo for each para recorrer el array de alumnos
        for(Alumno nAlumno : alumnosRegistrados){
            
            //condicional para que se muestren solo los estudiantes del semestre especificado
            if(nAlumno.getSemestre().equals(semestre)){
                /*
                se muestra en consola los datos del alumno buscado
                */
                pluma.print(nAlumno.getCedula());
                pluma.print("|"+nAlumno.getNombre());
                pluma.print("|"+nAlumno.getApellido());
                pluma.print("|"+nAlumno.getCelular());
                pluma.print("|"+nAlumno.getCorreo());
                pluma.print("|"+nAlumno.getSemestre());
                pluma.println("");
            }
        }
        //cerramos la pluma para que se escriban los datos
        pluma.close();
        
        //este condicional detecta si hay datos escritos en el archivo txt y muestra un mensaje de exito
        if(archivo.length() != 0)
            System.out.println("El reporte fue generado.");
        
        //si no hay datos escritos se muestra la alerta de que no hay alumnos en el semestre especificado
        if (archivo.length() == 0) 
            System.out.println("Aun no hay alumnos que se hayan registrado.");
        
    }
    
    /*
    creamos el metodo para imprimir el reporte de los alumnos guardados
    */    
    public static void reporte(ArrayList<Alumno> alumnosRegistrados) throws FileNotFoundException{
        
        // se crea el archivo txt 
        File archivo = new File("./data/reporte.txt");
        
        // creamos nuestra pluma y especificamos el archivo donde va a escribir
        try(PrintWriter pluma = new PrintWriter(archivo);){
            
            //ciclo for each para recorrer el array
            for(Alumno nAlumno : alumnosRegistrados){
                
                //creamos una variable tipo String a la que le asignaremos todos los datos
                //ademas de la "," para separar estos datos
                String alumno = (nAlumno.getCedula()+
                ","+nAlumno.getNombre()+
                ","+nAlumno.getApellido()+
                ","+nAlumno.getCelular()+
                ","+nAlumno.getCorreo()+
                ","+nAlumno.getSemestre());
                
                //con la funcion println la pluma escribira nuestra cadena de texto anteriormente creada
                pluma.println(alumno);
            }
            
                pluma.close(); //cerramos la pluma para asegurarnos de que se escriban todos los datos
                
                //este catch se usa para el FileNotFoundException en caso de que no se encuentre el archivo o
                //la ruta especificada
            }catch(FileNotFoundException e){
                System.out.println("no se encontro el archivo");
        }
    }

    /*
    creamos el metodo para imprimir el reporte de los alumnos guardados
    */        
    public static void leerArchivo (ArrayList<Alumno> alumnosRegistrados ) throws FileNotFoundException, IOException {
        
        File archivo = new File("./data/reporte.txt"); // Carga el archivo
        
        try(FileReader fr = new FileReader (archivo); // Lee archivo
        BufferedReader lector = new BufferedReader (fr);) { //Abrir un buffer para poder leer en el archivo
        
        //creamos variable donde guardaremos los datos del alumnos
        String linea;
        
        // while que funcionara mientras la linea de texto no este vacia
        while ((linea = lector.readLine()) !=null ){

            //metodo split que cuando encuentra una coma guarda un dato
            String[] datos = linea.split(",");
            //tambien usamos la funcion .trim para eliminar los espacios en blanco 
            // en las variables guardamos los datos segun la posicion del array
            String cedula = datos[0].trim();
            String nombre = datos[1].trim();
            String apellido = datos[2].trim();
            String celular = datos[3].trim();
            String correo = datos[4].trim();
            String semestre = datos[5].trim();

            //creamos un nuevo objeto de tipo alumno y le asignamos los datos leidos en su constructor
            Alumno cargarAlumno = new Alumno(cedula, nombre, apellido, celular, correo, semestre);
            //usamos la funcion .add para agregar en el array los datos de nuestro objeto cargarAlumno
            alumnosRegistrados.add(cargarAlumno);
            }
        //catch para la excepcion en caso de no encontrar el archivo
        }catch (FileNotFoundException e) {
            System.out.println("El archivo no ha sido encontrado");
        // cach para el input output exception
        }catch (IOException e) {
            System.out.println("No se pudo leer el archivo");
        }
    }

}
