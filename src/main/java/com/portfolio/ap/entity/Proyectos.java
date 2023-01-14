package com.portfolio.ap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

@Entity
public class Proyectos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    
    @NotBlank
    private String nombre;
    
    @NotBlank
    private String descripcion;
    
    @NotBlank
    private String fecha;
    
    @NotBlank
    private String link;
    
    //contructor

    public Proyectos() {
    }

    public Proyectos(String nombre, String descripcion, String fecha, String link) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.link = link;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getLink() {
        return link;
    }
    
       public void setLink(String link) {
        this.link = link;
    }
}