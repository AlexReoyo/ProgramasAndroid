package com.proyectopropio.jugadoresequipo;


public class Jugador
{
    private String nombre;
    private String apellido1;
    private String apellido2;
    private String dni;
    private String email;
    private String tlfno;
    private int dorsal;

    public Jugador (String nombre,String apellido1,String apellido2,String dni,String email,String tlfno,int dorsal){
        this.nombre=nombre;
        this.apellido1=apellido1;
        this.apellido2=apellido2;
        this.dni=dni;
        this.email=email;
        this.tlfno=tlfno;
        if (dorsal<0){
            this.dorsal=dorsal*-1;
        } else {
            this.dorsal=dorsal;
        }
    }
    //getters
    public String getNombre (){
        return nombre;
    }
    public String getApellido1 (){
        return apellido1;
    }
    public String getApellido2 (){
        return apellido2;
    }
    public String getDni (){
        return dni;
    }
    public String getEmail (){
        return email;
    }
    public String getTlfno (){
        return tlfno;
    }
    public int getDorsal (){
        return dorsal;
    }

    //setters
    public void setNombre (String nombre){
        this.nombre = nombre;
    }
    public void setApellido1 (String apellido1){
        this.apellido1 = apellido1;
    }
    public void setApellido2 (String apellido2){
        this.apellido2 = apellido2;
    }
    public void setDni (String dni){
        this.dni = dni;
    }
    public void setEmail (String email){
        this.email = email;
    }
    public void setTlfno (String tlfno){
        this.tlfno = tlfno;
    }
    public void setDorsal (int dorsal){
        if (dorsal<0){
            this.dorsal=dorsal*-1;
        } else {
            this.dorsal=dorsal;
        }
    }

    @Override
    public String toString(){
        String str = nombre+",";
        str+=apellido1+",";
        str+=apellido2+",";
        str+=dni+",";
        str+=email+",";
        str+=tlfno+",";
        str+=dorsal;
        return str;
    }
}
