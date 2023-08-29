/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mundo;

/**
 *
 * @author jcalp
 */
public class Alumno {
    
    /*
    variables para los datos personales del Alumno
    */
    private String Cedula;
    private String Nombre;
    private String Apellido;
    private String Semestre;
    private String Correo;
    private String Celular;
    
    /*
    metodo constructor de la clase alumno
    */
    public Alumno(String Cedula, String Nombre, String Apellido, String Semestre, String Correo, String Celular) {
        this.Cedula = Cedula;
        this.Nombre = Nombre;
        this.Apellido = Apellido;
        this.Semestre = Semestre;
        this.Correo = Correo;
        this.Celular = Celular;
    }
    
    public Alumno(){}
    
    
    /*
    metodos getter y setter
    */

    public String getCedula() {
        return Cedula;
    }

    public void setCedula(String Cedula) {
        this.Cedula = Cedula;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    public String getApellido() {
        return Apellido;
    }

    public void setApellido(String Apellido) {
        this.Apellido = Apellido;
    }

    public String getSemestre() {
        return Semestre;
    }

        public void setSemestre(String Semestre) {
        this.Semestre = Semestre;
    }

    public String getCorreo() {
        return Correo;
    }

    public void setCorreo(String Correo) {
        this.Correo = Correo;
    }

    public String getCelular() {
        return Celular;
    }

    public void setCelular(String Celular) {
        this.Celular = Celular;
    }
}
