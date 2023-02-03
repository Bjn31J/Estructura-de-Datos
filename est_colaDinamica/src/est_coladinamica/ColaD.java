package est_coladinamica;
public class ColaD {
    private Nodo frente;
    private Nodo fin;
    private int tamaño;
    public ColaD() {
        frente = null;
        fin= null;
        tamaño = 0;
    }
     public boolean estaVacia() {
        return frente == null;
    }
     public int tamaño() {
        return tamaño;
    }
     public int inserta(int valor) {
        Nodo nuevo = new Nodo(valor, null);
        if(!estaVacia()){
            fin.setSiguiente(nuevo);
            fin=nuevo;
            tamaño++;            
        }else{
            fin = nuevo;
            frente = nuevo;
          
        }
        return nuevo.getDato();
    }
    public int suprimir() {
	int aux=0;
	if (!estaVacia()) {
	    aux = frente.getDato();
	    frente = frente.getSiguiente();
            tamaño--;
	    } else {
            
	    System.out.println("EstaVacia");
	    }
        return aux;
    }
   public void imprimir() {
       Nodo aux = frente;
       while (aux != null){
        System.out.print(aux.getDato()+"\n");
	aux = aux.getSiguiente();
       }		
}}


