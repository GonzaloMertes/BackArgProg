
package com.portfolio.ap.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class hys {
   @Id
   @GeneratedValue(strategy = GenerationType.IDENTITY)
   private int id;
   private String nombre;
   private int porcentaje;
   private String img;

    public hys() {
    }

    public hys(String nombre, int porcentaje, String img) {
        this.nombre = nombre;
        this.porcentaje = porcentaje;
        this.img = img;
    }

    public hys(String nombre, int porcentaje) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
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

    public int getPorcentaje() {
        return porcentaje;
    }

    public void setPorcentaje(int porcentaje) {
        this.porcentaje = porcentaje;
    }
   
   
}
