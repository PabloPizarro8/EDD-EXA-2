// v2
package eva2_examen;

public class Nodo {
    private String dato;
    private Nodo padre;
    private Nodo derecha;
    private Nodo izquierda;
    
    // Constructores
    public Nodo(){
        this.derecha = null;
        this.izquierda = null;
        this.padre = null;
    }
    
    public Nodo(String dato){
        this.dato = dato;
        this.derecha = null;
        this.izquierda = null;
        this.padre = null;
    }

    //  SETTERS Y GETTERS
    
    // getter de dato
    public String getDato() {
        return dato;
    }

    // Setter de dato
    public void setDato(String dato) {
        this.dato = dato;
    }

    // Getter del nodo Derecha
    public Nodo getDerecha() {
        return derecha;
    }

    // Setter del nodo Derecha
    public void setDerecha(Nodo derecha) {
        this.derecha = derecha;
    }

    // Getter del nodo Izquierda
    public Nodo getIzquierda() {
        return izquierda;
    }

    // Setter del nodo Iquierda
    public void setIzquierda(Nodo izquierda) {
        this.izquierda = izquierda;
    }

    // Getter del nodo padre
    public Nodo getPadre() {
        return padre;
    }

    // Setter del nodo padre
    public void setPadre(Nodo padre) {
        this.padre = padre;
    }
    
    
}
