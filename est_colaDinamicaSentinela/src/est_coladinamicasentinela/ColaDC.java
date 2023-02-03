package est_coladinamicasentinela;
public class ColaDC {
   Nodo fin,frente;
   int tam=0;
    public ColaDC() {
        this.fin = new Nodo(0);
        this.frente = fin;
        tam=0;
    }
    public void inserta(Nodo nuevo) {
        fin.setSiguiente(nuevo);
        fin=nuevo;
        tam++; 
    }
    public boolean vacia(){
        return (frente==fin);
    }
     public Nodo suprimir() {
	Nodo aux=null;
        if (!vacia()){
            aux = frente.getSiguiente();
            frente.setSiguiente(aux.getSiguiente()); 
            tam--;
            if(frente.getSiguiente()==null){
                fin = frente;
            }
        }
        return aux;
    }
   
}

