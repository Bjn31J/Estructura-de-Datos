package est_arboles;
public class Arbol {
    NodoArbol raiz;
    public Arbol(){
        raiz=null;
    }
    public boolean estaVacio(){
        return(raiz==null);
    }
    public void insertaNodo(int dato){
        NodoArbol nodo = new NodoArbol(dato);
        if(estaVacio()){
            raiz=nodo;
        }else{
            NodoArbol aux=raiz;
            NodoArbol padre;
            while(true){
                padre=aux;
                if(dato<raiz.getDato()){
                    aux=aux.getHijoizquierdo();
                    if(aux==null){
                        padre.setHijoizquierdo(nodo);
                        return;
                    }
                    }else{
                    if(dato>raiz.getDato()){
                    aux=aux.getHijoderecho();
                    if(aux==null){
                        padre.setHijoderecho(nodo);
                        return;
                }
                }else{
                        System.out.println("El dato ya existe"+dato);
                        return;
                    }}}} 
   }
    public void inOrden(NodoArbol raiz){
        if(raiz!=null){
            inOrden(raiz.getHijoizquierdo());
            System.out.print(raiz.getDato()+", ");
            inOrden(raiz.getHijoderecho());  
        }
   }
    public void preOrden(NodoArbol raiz){
        if(raiz!=null){
            System.out.print(raiz.getDato()+", ");
            preOrden(raiz.getHijoizquierdo());
            preOrden(raiz.getHijoderecho());  
        }
   }
    public void postOrden(NodoArbol raiz){
        if(raiz!=null){
            postOrden(raiz.getHijoizquierdo());
            postOrden(raiz.getHijoderecho()); 
            System.out.print(raiz.getDato()+", ");
        }
   }
    public boolean eliminar(int d){
       NodoArbol aux=raiz;
       NodoArbol padre=raiz;
       boolean esHijoIzq=true;
            while(aux.dato!=d){
                padre=aux;
                if(d<aux.dato){
                    esHijoIzq=true;
                    aux=aux.hijoizquierdo;
                }else{
                    esHijoIzq=false;
                    aux=aux.hijoderecho;
                }
                if(aux==null){
                    return false;
                }
            }
            if(aux.hijoizquierdo==null && aux.hijoderecho==null){
                if(aux==raiz){
                    raiz=null;
                }else if(esHijoIzq){
                    padre.hijoizquierdo=null;
                }else{
                    padre.hijoderecho=null;
                } 
            }else if(aux.hijoderecho==null){
                 if(aux==raiz){
                    raiz=aux.hijoizquierdo;
                }else if(esHijoIzq){
                    padre.hijoizquierdo=aux.hijoizquierdo;
                }else{
                    padre.hijoderecho=aux.hijoizquierdo;
                }  
            }else if(aux.hijoizquierdo==null){
                if(aux==raiz){
                    raiz=aux.hijoderecho;
                }else if(esHijoIzq){
                    padre.hijoizquierdo=aux.hijoderecho;
                }else{
                    padre.hijoderecho=aux.hijoizquierdo;
                }    
            }else{
                NodoArbol modi=obtenerNodoM(aux);
                if(aux==raiz){
                    raiz=modi;
                }else if(esHijoIzq){
                    padre.hijoizquierdo=modi;
                }else{
                    padre.hijoderecho=modi;
                }
                modi.hijoizquierdo=aux.hijoizquierdo;
            }
        return true;
    }
    public NodoArbol obtenerNodoM(NodoArbol nodoReemp){
        NodoArbol reemplazoPadre=nodoReemp;
        NodoArbol reemplazo=nodoReemp;
        NodoArbol aux=nodoReemp.hijoderecho;
        while(aux!=null){
            reemplazoPadre=reemplazo;
            reemplazo=aux;
            aux=aux.hijoizquierdo;
        }
        if(reemplazo!=nodoReemp.hijoderecho){
            reemplazoPadre.hijoizquierdo=reemplazo.hijoderecho;
            reemplazo.hijoderecho=nodoReemp.hijoderecho;
        }
        System.out.println("El nodo Reemplazo es " + reemplazo);
        return reemplazo;
    }
}    

