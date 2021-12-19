/*
EQUIPO: BananaBread
INTEGRANTES: 
    Paulina Arreguin
    Erick Lozano
    Pablo Pizarro
v2
Diseñar un programa que capture valores TIPO CADENA (STRING) desde el teclado por el usuario.
El usuario puede capturar cuantos datos quiera. Usted determine el mecanismo para que el 
usuario pueda dejar de capturar los datos
*/
package eva2_examen;

import java.util.Scanner;

public class EVA2_EXAMEN {
    static Scanner leer = new Scanner(System.in);
    static ArbolBinario arbol = new ArbolBinario();
    
    public static void main(String[] args) {
        runProgram();
    }
    
    // Metodo para iniciar el programa
    public static void runProgram(){
        // Un ciclo para poder elegir alguna de las opciones
        boolean arranque = true;
        while (arranque) {            
            System.out.println("Seleccione una opcion: "
                    + "\n1) Insertar datos"
                    + "\n2) Borrar nodo"
                    + "\n3) Ordenamientos"
                    + "\n4) Buscar nodo"
                    + "\n5) Limpiar lista"
                    + "\n6) Salir");
            String opcion = leer.next();
            
            switch (opcion.toLowerCase()) {
                case "1":
                    dataInsertion();
                    break;
                case "2":
                    borrarNodos();
                    break;
                case "3":
                    impresion();
                    break;
                case "4":
                    buscarNodo();
                    break;
                case "5":
                    arbol.setRaiz(null);
                default:
                    arranque=false;
                    break;
            }
        }
        System.out.println("Salio del programa...");
    }
    
    // Metodo para insertar datos
    public static void dataInsertion(){
        System.out.println("Si desea salir, escriba \"salir\"");
        // Un ciclo para poder insertar cuantos datos desee el usuario
        while (true) {
            System.out.print("Escriba algo para capturar: ");
            String algo = leer.next();
            algo = algo.toLowerCase();
            
            if(algo.toLowerCase().equals("salir")){
                break;
            }
            if(!algo.isEmpty()){
                arbol.agregar(algo);
            }
        }
        System.out.println("");
        imprimirCadenas();
    }

    private static void imprimirCadenas() {
        System.out.println("El arbol: ");
        arbol.printInOrder();
    }
    
    private static void borrarNodos(){
        System.out.println("Si desea cancelar, escriba \"cancel\""
                + "\nEscriba el texto que desee quitar del arbol:");
        String borrar = leer.next();
        borrar = borrar.toLowerCase();
        
        if(!borrar.equals("cancel")){
            arbol.borrarNodo(borrar);
        }
    }
    
    private static void impresion( ){
        System.out.println("Seleccione el numero de una opcion:\n"
                + "1) imprimir inOrder\n"
                + "2) imprimir postOrder\n"
                + "3) imprimir preOrder\n"
                + "4) importar a lista\n"
                + "5) imprimir lista\n");
        String opcion=leer.next();
        switch(opcion){
            case "1":
                arbol.printInOrder();
                break;
            case "2":
                arbol.printPostOrder();
                break;
            case "3":
                arbol.printPreOrder();
                break;
            case "4":
                arbol.printList();
                System.out.println("Importado");
                break;
            case "5":
                arbol.lista.printList();
                break;
        }
    }
    
    private static void buscarNodo(){
        System.out.println("Escriba el texto que desee buscar: ");
        String buscar = leer.next();
        buscar = buscar.toLowerCase();
        arbol.buscarNodo(buscar);
    }
}
