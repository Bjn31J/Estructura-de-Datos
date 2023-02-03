package est_arbolavl;
public class Nodo {
    int dato,fe;//fe factor de equilibrio
    Nodo hijoizq,hijoder;
    public Nodo(int d){
        this.dato=d;
        this.fe=0;
        this.hijoizq=null;
        this.hijoder=null; 
    }  
}
