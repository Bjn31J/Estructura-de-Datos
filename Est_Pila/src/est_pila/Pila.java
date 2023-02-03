package est_pila;
public class Pila {
    private NodoPila tope;
    int tamaño;
    //constructor
    public Pila(){
        tope=null;
        tamaño=0;
    }
    //Metodo para saber cuando la pila esta vacia
    public boolean estaVacia(){
        return tope==null;
    }
    //Metodo para insertar un elemento en la pila
    public void insertar(int elemento){
        NodoPila nuevo =new NodoPila(elemento);
        nuevo.siguiente=tope;
        tope=nuevo;
        tamaño++;   
    }
    //Metodo para sacar un elemento en la pila
    public int sacar(){
        int aux=tope.dato;
        tope=tope.siguiente;
        tamaño--;
        return aux;
    }
    //Metodo para saber quien esta en la cima de la pila
    public int tope(){
        return tope.dato;
    }
    //Metodo para saber el tamaño de la pila
    public int tamañoPila(){
        return tamaño;
    }
    //Metodo para limpiar (Vaciar la pila)
    public void limpiarPila(){
        while(!estaVacia()){
            sacar();
        }
    }
}
