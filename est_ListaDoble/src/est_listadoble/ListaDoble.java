package est_listadoble;
class ListaDoble {
    Nodo p;
    int noElementos;
    public ListaDoble() {
       p=new Nodo("C","C",0);
       p.setAnterior(p);
       p.setSiguiente(p);
       noElementos=0; 
    }
    public void inserta(Nodo nuevo,  Nodo posicion){
        if(posicion==null){
            posicion=p;
            nuevo.setSiguiente(posicion.getSiguiente());
            nuevo.setAnterior(posicion.getSiguiente().getAnterior());
            posicion.getSiguiente().setAnterior(nuevo);
            posicion.setSiguiente(nuevo);
            noElementos++;
        } 
    }
     public void elimina(Nodo posicion){
         if((posicion==p)||(posicion==null)){
             System.out.println("No se puede eliminar");
         }else{
             /*Nodo ant= posicion.getAnterior();
             ant.setSiguiente(posicion.getSiguiente());
             Nodo sig= posicion.getSiguiente();
             sig.setAnterior(posicion.getAnterior());*/
             //Equivalente 
           posicion.getSiguiente().setAnterior(posicion.getAnterior());
           posicion.getAnterior().setSiguiente(posicion.getSiguiente());
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
}      


    
    

