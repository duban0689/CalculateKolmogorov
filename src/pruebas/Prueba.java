/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pruebas;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author dgonzalez
 */
public class Prueba {
    private int id;
    private List<Float> numeros=new ArrayList<Float>();
    private Float media;
    private Float frecuenciaChi;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public List<Float> getNumeros() {
        return numeros;
    }

    public void setNumeros(List<Float> numeros) {
        this.numeros = numeros;
    }

    public Float getMedia() {
        return media;
    }

    public void setMedia(Float media) {
        this.media = media;
    }

    public Float getFrecuenciaChi() {
        return frecuenciaChi;
    }

    public void setFrecuenciaChi(Float frecuenciaChi) {
        this.frecuenciaChi = frecuenciaChi;
    } 
    
}
