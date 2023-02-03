package est_coladinamica;
    public class Nodo {
    private int dato;
    private Nodo siguiente;
    public Nodo(int elemento, Nodo siguiente) {
        this.dato = elemento;
        this.siguiente = siguiente;
    }
    public int getDato() {
        return dato;
    }
    public void setDato(int elemento) {
        this.dato = elemento;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }   
}
    

