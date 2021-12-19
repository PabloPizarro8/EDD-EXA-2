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
    public class Listadoble {

        private NodoLIS inicio, finnal;
        private int tamano; // Contador de nodos

        public Listadoble() {
            inicio = null; // LISTA VACIA
            finnal = null; // Posicion final de la lista
            tamano = 0; // Tamano comenzara en cero
        }

        public void agregar(String valor) {
            NodoLIS nuevoNodo = new NodoLIS(valor);

            // Hay nodos en la lista?
            if (inicio == null) {
                inicio = nuevoNodo; // Pasamos el nuevoNodo al inicio
                finnal = nuevoNodo; // Y al final
            } else { // Lista con nodos
                // Agregamos el nodo al final de la lista
                finnal.setSiguiente(nuevoNodo); // Establecemos el nodoNuevo como siguiente al nodo actual
                nuevoNodo.setPrevio(finnal); // Establecemos el actual como previo al nodoNuevo
                finnal = nuevoNodo; // El nodoNuevo ahora es el final
            }
            // Incrementamos
            tamano++;
        }

        // Imprimir la lista entera
        public void printList() {
            NodoLIS temp = inicio; // Guardamos la lista en temp

            System.out.print("[");
            // Pasamos por cada nodo  1 en 1
            while (temp != null) { // Mientras temp no sea nulo
                System.out.print(temp.getiDato());
                if(temp.getSiguiente() != null)
                    System.out.print(" - "); // imprimimos
                temp = temp.getSiguiente(); // guardamos los nodos siguientes de temp en temp
            }
            System.out.println("]"); // Pa que se vea bomnito
        }

        // Limpiamos la lista completa
        public void limpiar() {
            inicio = null; // Igualamos el inicio a nulo, eliminando la lista casi completa
            finnal = null; // Igualamos el ultimo nodo a nulo, terminando de limpiar la lista
            tamano = 0; // Reducimos el contador a 0
        }

        // Getter del tamaño de la lista XDXDXD
        public int tamanoLista() {
            return tamano; // Devolvemos el tamaño
        }

        // Saber si es una lista vacia
        public boolean isEmpty() {
            if (inicio == null) // si esta vacia
            {
                return true; // devolvemos verdadero
            } else {
                return false; // devolvemos falso si no
            }
        }

        // Saber un nodo especifico
        public String getPosicion(int iPos) throws Exception { // Lanzara una excepcion
            if (isEmpty()) { // en caso de ser una lista vacia
                throw new Exception("No hay valores almacenados en la lista!!");
            } else { // Si no
                if ((iPos < 0) || (iPos >= tamanoLista())) { // Revisara si la posicion dada
                    // esta dentro de la lista
                    throw new Exception("Posicion fuera de rango");
                }
            }
            NodoLIS temp = inicio; // Guardamos la lista en temp

            // Vamos desde 0 hasta -1 de la posicion dada
            for (int i = 0; i < (iPos); i++) {
                temp = temp.getSiguiente();  // Vamos pasando cada siguiente de temp en temp
            }
            return temp.getiDato(); // Devolvemos el valor
        }

        // Insertar un nodo
        /*
    Explicacion, este metodo funciona de la sig manera:
    Insertara un nodo en la posicion dada -1, desplazando el nodo en esa posicion y los siguientes
    hacia adelante
         */
        public void insertarEn(int iPos, String valor) {
            NodoLIS nuevo = new NodoLIS(valor);

            if (iPos == 0) { // Si es en la primera posicion
                nuevo.setSiguiente(inicio); // establecemos inicio como siguiente del nodoNuevo
                inicio.setPrevio(nuevo); // establecemos nuevoNodo como previo de inicio
                inicio = nuevo; // igualamos inicio al nuevo nodo
            } else { // Cualquier otra posicion
                NodoLIS temp = inicio; // guardamos la lista en temp

                // Pasamos por cada nodo hasta llegar al deseado
                for (int i = 0; i < iPos; i++) {
                    temp = temp.getSiguiente(); // Lo guardamos en temp 
                }
                nuevo.setSiguiente(temp); // Establecemos temp como siguiente de nuevo
                nuevo.setPrevio(temp.getPrevio()); // establecemos el anterior a temp como el anterior a nuevo
                temp.getPrevio().setSiguiente(nuevo); // establecemos el nuevo como el siguiente del anterior a temp
                temp.setPrevio(nuevo); // establecemos el nuevo como previo de temp
            }
            tamano++; // Incrementamos contador
        }

        // Borrar un nodo
        public void borrarEn(int iPos) {
            if (tamanoLista() == 1) { // si solo hay un nodo, entonces solo limpiamos
                limpiar();
            } else { // mas de un nodo
                if (iPos == 0) { // Si es el primer nodo
                    inicio = inicio.getSiguiente(); // Pasamos el segundo nodo a ser el primero
                    inicio.setPrevio(null); // El nodo previo lo mandamos a null
                } else { // Si no es el primer nodo
                    NodoLIS temp = inicio; // Guardamos la lista en temp

                    // Pasamos por cada nodo hasta llegar a la posicion dada
                    for (int i = 0; i < iPos; i++) {
                        temp = temp.getSiguiente();  // Vamos guardando el nodo en temp
                    }

                    temp.getPrevio().setSiguiente(temp.getSiguiente()); // Establecemos el siguiente del
                    // Nodo temp como el siguiente del nodo anterior a temp

                    // En caso de que sig de temp no sea nullo
                    if (temp.getSiguiente() != null) {
                        temp.getSiguiente().setPrevio(temp.getPrevio());// igualamos el nodo previo 
                        // del siguiente de temp como el nodo anterior a temp
                    }

                    // Si la posicion era la ultima
                    if (iPos == tamanoLista() - 1) {
                        finnal = temp.getPrevio(); // Indicamos que finnal ahora es el anterior a temp
                    }
                }
            }
            // Decrementamos el conteo
            tamano--;
        }

        // Imprimir la lista en reversa
        public void printReversList() {
            NodoLIS temp = finnal; // Guardamos el nodo final en temp

            while (temp != null) { // Mientras temp no sea null
                System.out.print(temp.getiDato() + " - "); // Imprimimos
                temp = temp.getPrevio(); // Guardamos en temp cada nodo previo
            }
            System.out.println(""); // Evitar que se vea feo XD
        }
    }
