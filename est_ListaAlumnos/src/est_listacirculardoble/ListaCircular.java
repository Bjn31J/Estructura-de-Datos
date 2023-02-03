package est_listacirculardoble;
import java.util.Scanner;
class ListaCircular {
    Scanner sc=new Scanner (System.in);
    Nodo p;
    int noElementos;
    public ListaCircular(){
       p=new Nodo("C",0,0.0,0.0,0.0);
       p.setAnterior(p);
       p.setSiguiente(p);
       noElementos=0; 
    }
    public void ingresa(Nodo nuevo,  Nodo posicion){
       if(posicion==null){
            posicion=p;
            nuevo.setSiguiente(posicion.getSiguiente());
            nuevo.setAnterior(posicion.getSiguiente().getAnterior());
            posicion.getSiguiente().setAnterior(nuevo);
            posicion.setSiguiente(nuevo);
            noElementos++;
       }else{
           nuevo.setSiguiente(posicion.getSiguiente());
            nuevo.setAnterior(posicion);
            posicion.getSiguiente().setAnterior(nuevo);
            posicion.setSiguiente(nuevo);
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
    public void modificar(int calMod,double newCal, Nodo Act){
        if(calMod==1){
        Act.setCali(newCal);   
        }else if(calMod==2){
            Act.setCali2(newCal);   
        }else if(calMod==3){
             Act.setCali3(newCal);   
        }
    }
    public void imprimirR(){
        imprimirR(p.getSiguiente());
    }
    private void imprimirR(Nodo actual){
           if(actual!=null){
               if(actual!=p){
                System.out.println(" Nombre: "+actual.getNombre()+" Numero de control: "+actual.getNoControl()+" Calificacion: "+actual.getCali()+" Calificacion2: "
                +actual.getCali2()+" Calificacion3: "+actual.getCali3());
               actual=actual.siguiente;
               imprimirR(actual);   
               }
           }
      }

    public int getNoElementos() {
        return noElementos;
    }

    public void setNoElementos(int noElementos) {
        this.noElementos = noElementos;
    }
    
}
