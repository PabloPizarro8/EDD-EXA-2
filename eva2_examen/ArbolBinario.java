package eva2_examen;

public class ArbolBinario {
    
    private Nodo raiz;
    public Listadoble lista = new Listadoble();
    private String alog;
    
    public ArbolBinario() {
        this.raiz = null;
    }
    
    public void agregar(String valor) {
        Nodo nuevo = new Nodo(valor);
        
        if (raiz == null) {
            raiz = nuevo;
        } else {
            agregarRecu(raiz, nuevo);
        }
    }
    
    private void agregarRecu(Nodo actual, Nodo nuevo) {
        /*
        Usaremos el metodo compareTo() para poder comparar los strings
        Este metodo sirve para que, al comparar un string con otro (el cual es parametro
        de compareTo() ), este arrojara un valor dependiendo de su posicion respecto al segundo
        Si comparamos a con b
        "a".compareTo("b");
        nos arrojara un valor negativo
        -1
        
        Esto es por que el valor Unicode de "a" se diferencia con respecto a "b" en uno
        Valor unicode de "a" es: 097
        Valor unicode de "b" es: 098
        
        097 - 098 = -1
        
        Pero hay un problema con esto, y es lo siguiente:
        El valor de A mayuscula es: 065
        
        El valor Unicode de las letras mayusculas y munusculas son diferentes, con lo cual
        se tendra que aplicar un toLowerCase() a las cadenas a la hora de hacer una
        comparacion
         */
        // Ver si la cadena del nuevo nodo es menor al del actual
        // usamos toLowerCase para poder hacer una comparacion mas simple
        // Asi que si las cadenas solo se diferencian con mayusculas
        // el programa las tomara como iguales
        String nuevoString = nuevo.getDato().toLowerCase();
        String actualString = actual.getDato().toLowerCase();
        if ((nuevoString.compareTo(actualString)) < 0) {
            // Comprobar si el nodo izquierdo esta disponible
            if (actual.getIzquierda() == null) {
                actual.setIzquierda(nuevo); // Establecer el nodo nuevo como izquierdo del actual
                nuevo.setPadre(actual);// Establecer el nodo actual como padre del nodo nuevo
            } // Si esta ocupado
            else {
                agregarRecu(actual.getIzquierda(), nuevo); // Movernos al lado izquierdo del actual
            }
        } // Si la cadena del nuevo es mayor que el actual, entonces
        else if ((nuevoString.compareTo(actualString)) > 0) {
            // Revisamos si el nodo derecho esta libre
            if (actual.getDerecha() == null) {
                actual.setDerecha(nuevo); // Establecemos el lado derecho como el nuevo
                nuevo.setPadre(actual); // Establecemos el padre como actual
            } // Si no esta libre
            else {
                agregarRecu(actual.getDerecha(), nuevo); // Nos movemos al lado derecho del actual
            }
        } // En caso de que sean iguales, entonces
        else {
            System.out.println("El valor ya esta en el arbol.\n");
        }
    }
    
    public void setRaiz(Nodo parametro){
        this.raiz = parametro;
    }
    
    // Borrar nodo
    /*
    Si borramos un nodo, su hijo mayor pasa a ser el nodo padre
    Por defecto, el hijo mayor sera el nodo izquierdo
    A menos que no exista
    Entonces el nodo derecho sera el padre
     */
    public void borrarNodo(String buscar){
        Nodo nuevoNodo = new Nodo(buscar);
        
        if(raiz != null){
            buscarToBorrar(raiz, nuevoNodo);
        }else{
            System.out.println("No existe arbol\n");
        }
    }
    
    private void buscarToBorrar(Nodo actual, Nodo buscar){
        if ((buscar.getDato().compareTo(actual.getDato()) < 0) && (actual.getIzquierda() != null)) {
            buscarToBorrar(actual.getIzquierda(), buscar);
        }
        else if ((buscar.getDato().compareTo(actual.getDato()) > 0) && (actual.getDerecha() != null)) {
            buscarToBorrar(actual.getDerecha(), buscar);
        }
        else if (buscar.getDato().equals(actual.getDato())) {
            System.out.println("El valor que quieres borrar es: " + actual.getDato());
            
            // Si tiene un padre
            if (actual.getPadre() != null) {
                System.out.println("Cuyo padre es: " + actual.getPadre().getDato() + "\n");

                if(buscar.getDato().compareTo(actual.getPadre().getDato()) < 0){
                    revisarIzquierdo(actual);
                }
                else if (buscar.getDato().compareTo(actual.getPadre().getDato()) > 0) {
                    revisarDerecho(actual);
                }
            }
            // Si no tiene padre
            else{
                System.out.println("Es la raiz del arbol\n");
                
                revisarPadre(raiz);
            }
        }else{
            System.out.println("El valor no existe en el arbol\n");
        }
    }
    
    private void revisarPadre(Nodo nodo){
        if(nodo.getIzquierda() != null){
            nodo.getIzquierda().setPadre(null);
            raiz = nodo.getIzquierda();
            if(nodo.getDerecha() != null){
                acomodarNodos(nodo.getIzquierda(), nodo.getDerecha());
            }
        }
        else if(nodo.getDerecha() != null){
            nodo.getDerecha().setPadre(null);
            raiz = nodo.getDerecha();
        }
        else{
            setRaiz(null);
        }
    }
    
    private void revisarIzquierdo(Nodo nodo) {
        if(nodo.getIzquierda() != null){
            nodo.getPadre().setIzquierda(nodo.getIzquierda());
            nodo.getIzquierda().setPadre(nodo.getPadre());
            
            if(nodo.getDerecha() != null){
                acomodarNodos(nodo.getIzquierda(), nodo.getDerecha());
            }
        }
        else if(nodo.getDerecha() != null){
            nodo.getPadre().setIzquierda(nodo.getDerecha());
            nodo.getDerecha().setPadre(nodo.getPadre());
        }
        else{
            nodo.getPadre().setIzquierda(null);
        }
    }
    
    private void revisarDerecho(Nodo nodo){
        if(nodo.getIzquierda() != null){
            nodo.getPadre().setDerecha(nodo.getIzquierda());
            nodo.getIzquierda().setPadre(nodo.getPadre());
            
            if(nodo.getDerecha() != null){
                acomodarNodos(nodo.getIzquierda(), nodo.getDerecha());
            }
        }
        else if(nodo.getDerecha() != null){
            nodo.getPadre().setDerecha(nodo.getDerecha());
            nodo.getDerecha().setPadre(nodo.getPadre());
        }
        else{
            nodo.getPadre().setDerecha(null);
        }
    }
    
    private void acomodarNodos(Nodo izq, Nodo der){
        if(izq.getDerecha() == null){
            izq.setDerecha(der);
            der.setPadre(izq);
        }
        else{
            acomodarNodos(izq.getDerecha(), der);
        }
    }
    
    // Buscar nodo
    /*
    Este metodo fue para buscar una manera de buscar nodos para poder borrarlos
    */
    public void buscarNodo(String dato) {
        Nodo buscar = new Nodo(dato);
        
        // Si la raiz existe
        if (raiz != null) {
            buscarNodoRecu(buscar, raiz); // Nos vamos al buscarNodoRecu
        }
        // Si no existe
        else {
            System.out.println("No existe arbol\n");
        }
    }
    
    // Forma recursiva de buscarNodo
    private void buscarNodoRecu(Nodo buscar, Nodo actual) {
        String buscarString = buscar.getDato().toLowerCase(); // guardamos el dato de buscar en un string
        String arbolString = actual.getDato().toLowerCase(); // Guardamos el dato del actual en un string
        /*
        Guardamos los strings en variables a parte para no complicar la comparacion
        Debido a que tambien se busca mantenerlo en minusculas
        */
        
        // Si el nodo buscar es menor que el nodo actual, entonces nos vamos a la izquierda
        // Tambien tiene que existir la izquierda
        if ((buscarString.compareTo(arbolString) < 0) && (actual.getIzquierda() != null)) {
            buscarNodoRecu(buscar, actual.getIzquierda());
        }
        // Si el nodo buscar es mayor que el nodo actual, entonces nos movemos a la derecha
        // Tambien tiene que existir la derecha
        else if ((buscarString.compareTo(arbolString) > 0) && (actual.getDerecha() != null)) {
            buscarNodoRecu(buscar, actual.getDerecha());
        }
        // Si el nodo buscar es igual al nodo actual, entonces ya lo encontramos
        else if (buscarString.equals(arbolString)) {
            System.out.println("El valor que buscas es: " + actual.getDato());
            
            // Si tiene un padre
            if (actual.getPadre() != null) {
                System.out.println("Cuyo padre es: " + actual.getPadre().getDato() + "\n");
            }
            // Si no tiene padre
            else{
                System.out.println("Es la raiz del arbol\n");
            }
        }
        // Si no existe el valor en el nodo
        else {
            System.out.println("El valor que estas buscando no se encuentra en el arbol\n");
        }
    }

// - - - IMPRIMIR NODOS DEL ARBOL - - - 
    // Se tendra que preguntar al profe por estos ordenamientos, por que aparentemente 
    // estan mal
    // inOrder
    public void printInOrder() {
        inOrder(raiz);
        System.out.println("\n");
    }
    
    private void inOrder(Nodo actual) {
        if (actual != null) {
            inOrder(actual.getIzquierda());
            System.out.print("[" + actual.getDato() + "]");
            inOrder(actual.getDerecha());
        }
    }

    // preOrder
    public void printPreOrder() {
        preOrder(raiz);
        System.out.println("\n");
    }
    
    private void preOrder(Nodo actual) {
        if (actual != null) {
            System.out.print("[" + actual.getDato() + "]");
            preOrder(actual.getIzquierda());
            preOrder(actual.getDerecha());
        }
        // No hay nada? Pos no hago nada, como la ves?
    }

    // postOrder
    public void printPostOrder() {
        postOrder(raiz);
        System.out.println("\n");
    }
    
    private void postOrder(Nodo actual) {
        if (actual != null) {
            
            postOrder(actual.getIzquierda());
            
            postOrder(actual.getDerecha());
            System.out.print("[" + actual.getDato() + "]");
            
        }
    }
    
    public void printList() {
        inList(raiz);
        lista.printList();
        System.out.println("\n");
    }
    
    private void inList(Nodo actual) {
        if (actual != null) {
            inList(actual.getIzquierda());
            lista.agregar(actual.getDato());
            inList(actual.getDerecha());
        }
    }
}
