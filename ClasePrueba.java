/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package grupo3.grupo_03.treemap;

import java.util.ArrayList;

/**
 *
 * @author mbravop
 */
public class ClasePrueba {
    String nombre;
    float tamano;
    ArrayList<ClasePrueba> hijos;

    public void setHijos(ArrayList<ClasePrueba> hijos) {
        this.hijos = hijos;
    }

    public ArrayList<ClasePrueba> getHijos() {
        return hijos;
    }

    public ClasePrueba(String nombre, float tamano) {
        this.nombre = nombre;
        this.tamano = tamano;
    }

    public String getNombre() {
        return nombre;
    }

    public float getTamano() {
        return tamano;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setTamano(float tamano) {
        this.tamano = tamano;
    }
    
    public boolean tieneHijos(){
        return hijos!=null;
    }
 
}
