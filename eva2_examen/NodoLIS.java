/*
v2
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eva2_examen;

/**
 *
 * @author PC
 */
public class NodoLIS {
    private String iDato; // Aqui guardaremos el dato
    private NodoLIS siguiente; // Aqui guardaremos los siguientes nodos
    private NodoLIS previo;
    
    // Constructores
    public NodoLIS(){ // Si no pasamos ningun parametro
        this.siguiente = null;
        this.previo = null;
    }
    public NodoLIS(String dato){ // si pasamos el dato
        this.iDato = dato;
        this.siguiente = null;
        this.previo = null;
    }

    //  SETTERS Y GETTERS
    
    // getter de dato
    public String getiDato() {
        return iDato;
    }

    // Setter de dato
    public void setiDato(String iDato) {
        this.iDato = iDato;
    }

    // Getter del nodo siguiente
    public NodoLIS getSiguiente() {
        return siguiente;
    }

    // Setter del nodo siguiente
    public void setSiguiente(NodoLIS siguiente) {
        this.siguiente = siguiente;
    }

    // Getter del nodo previo
    public NodoLIS getPrevio() {
        return previo;
    }

    // Setter del nodo previo
    public void setPrevio(NodoLIS previo) {
        this.previo = previo;
    }
    
}
