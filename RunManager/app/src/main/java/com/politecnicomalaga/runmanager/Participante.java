package com.politecnicomalaga.runmanager;


public class Participante
{
    private String dni;
    private String nombre;
    private String apellidos;
    private String fechaNac;
    private String email;
    private String tfno;
    private int dorsal;

    public Participante(String dni,String nombre,String apellidos,String fechaNac,String email,String tfno,int dorsal){
        this.dni=dni;
        this.nombre=nombre;
        this.apellidos=apellidos;
        this.fechaNac=fechaNac;
        this.email=email;
        this.tfno=tfno;
        this.dorsal=dorsal;
    }

    //getters
    public String getDni(){
        return dni;
    }
    public String getNombre(){
        return nombre;
    }
    public String getApellidos(){
        return apellidos;
    }
    public String getFechaNac(){
        return fechaNac;
    }
    public String getEmail(){
        return email;
    }
    public String getTfno(){
        return tfno;
    }
    public int getDorsal(){
        return dorsal;
    }

    //Setters
    public void setDni( String dni){
        this.dni=dni;
    }
    public void setNombre( String nombre){
        this.nombre=nombre;
    }
    public void setApellidos( String apellidos){
        this.apellidos=apellidos;
    }
    public void setFechaNac( String fechaNac){
        this.fechaNac=fechaNac;
    }
    public void setEmail( String email){
        this.email=email;
    }
    public void setTfno( String tfno){
        this.tfno=tfno;
    }
    public void setDorsal(int dorsal){
        this.dorsal=dorsal;
    }

    //otros métodos
    @Override
    public String toString(){
        String res="";
        res+=dni+",";
        res+=nombre+",";
        res+=apellidos+",";
        res+=fechaNac+",";
        res+=email+",";
        res+=tfno+",";
        res+=dorsal;
        return res;
    }

}
