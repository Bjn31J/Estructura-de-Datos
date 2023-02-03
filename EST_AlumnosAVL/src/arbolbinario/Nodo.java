package arbolbinario;

public class Nodo<T extends Comparable> {
    private Nodo izq;
    private Nodo der;
    private int factorEquilibrio;
    private T elemento;

    public Nodo(T elemento) {
        this(elemento,null,null);
    }

    public Nodo(T elemento,Nodo izq, Nodo der) {
        this.izq = izq;
        this.der = der;
        this.elemento = elemento;
        factorEquilibrio=0;
    }

    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public int getFactorEquilibrio() {
        return factorEquilibrio;
    }

    public void setFactorEquilibrio(int factorEquilibrio) {
        this.factorEquilibrio = factorEquilibrio;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    @Override
    public String toString() {
        return  elemento.toString();
    }
    
}
