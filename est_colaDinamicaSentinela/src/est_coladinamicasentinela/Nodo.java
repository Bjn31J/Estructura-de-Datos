package est_coladinamicasentinela;
    public class Nodo {
    private int dato;
    public Nodo siguiente;
    public Nodo(int elemento) {
        this.dato = elemento;
        this.siguiente = null;
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
    

