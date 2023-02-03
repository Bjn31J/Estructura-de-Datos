package est_examen;
import java.util.Scanner;
class ListaCircular {
    Scanner sc=new Scanner (System.in);
    Nodo p,inicio=null,ultimo=null;
    int noElementos;
    public ListaCircular(){
       p=new Nodo("","",0);
       p.setAnterior(p);
       p.setSiguiente(p);
       noElementos=0; 
    }
    public void ingresa(Nodo nuevo){
       if(inicio==null){
       inicio=nuevo;
       ultimo=nuevo;  
        noElementos++;
       }else{
           nuevo.setAnterior(ultimo);
           ultimo.setSiguiente(nuevo);
           ultimo=nuevo;
           noElementos++;
       }
    }
     public void elimina(Nodo posicion){
         if((posicion==p)||(posicion==null)){
             System.out.println("No se puede eliminar");
         }else{
             posicion.getAnterior().setSiguiente(posicion.getSiguiente());
             posicion.getSiguiente().setAnterior(posicion.getAnterior());
             posicion.setAnterior(null);
             posicion.setSiguiente(null);
             noElementos--;
         }
    }
    boolean vacia(){
    return (p.getSiguiente()==p);
    }
    public Nodo primer(){
        return (vacia()? null:p.getSiguiente());
    }
     public Nodo ultimo(){
        return (vacia() ? null:p.getAnterior());
    }
    public Nodo siguiente(Nodo posicion){
        Nodo x=null;
        if(posicion!=null)
            if(posicion.getSiguiente()!=p)
                x=posicion.getAnterior();
        return x;
    }
    public Nodo anterior(Nodo posicion){
        Nodo x=null;
        if(posicion!=null)
            if(posicion.getAnterior()!=p)
                x=posicion.getAnterior();
        return x;
    }
    public void imprimirR(){
        Nodo aux=ultimo;
        while(aux!=null){
            System.out.println("Nombre : "+aux.getNombre()+" serie : "+aux.getSerie()+" precio "+aux.getPrecio());
            aux=aux.getAnterior();
        }
    }
    public void imprimirC(){
        Nodo aux=ultimo;
        while(aux!=null){
            System.out.println("Nombre : "+aux.getNombre());
            aux=aux.getAnterior();
        }
    }
    public int getNoElementos() {
        return noElementos;
    }
    public void setNoElementos(int noElementos) {
        this.noElementos = noElementos;
    }
}
