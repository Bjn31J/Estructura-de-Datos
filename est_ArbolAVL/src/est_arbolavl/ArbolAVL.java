package est_arbolavl;
public class ArbolAVL {
   private Nodo raiz;
   public ArbolAVL(){
       raiz=null;
   }
   public Nodo obtenerRaiz(){
       return raiz;
   }
   public int obtenerFE(Nodo aux){
       if(aux==null){
           return -1;
       }else{
           return aux.fe;
       }
   }
   public Nodo rotacionIzquierda(Nodo x){
       Nodo aux= x.hijoizq;
       x.hijoizq=aux.hijoder;
       aux.hijoder=x;
       x.fe=Math.max(obtenerFE(x.hijoizq),obtenerFE(x.hijoder))+1;
       aux.fe=Math.max(obtenerFE(aux.hijoizq),obtenerFE(aux.hijoder))+1;
       return aux;
   }
   public Nodo rotacionDerecha(Nodo x){
       Nodo aux= x.hijoder;
       x.hijoder=aux.hijoizq;
       aux.hijoizq=x;
       x.fe=Math.max(obtenerFE(x.hijoizq),obtenerFE(x.hijoder))+1;
       aux.fe=Math.max(obtenerFE(aux.hijoizq),obtenerFE(aux.hijoder))+1;
       return aux;
   }
   public Nodo rotacionDobleIzq(Nodo x){
       Nodo aux;
       x.hijoizq=rotacionDerecha(x.hijoizq);
       aux=rotacionIzquierda(x);
       return aux; 
   }
    public Nodo rotacionDobleDer(Nodo x){
       Nodo aux;
       x.hijoder=rotacionIzquierda(x.hijoder);
       aux=rotacionDerecha(x);
       return aux; 
   }
    public Nodo insertarAVL(Nodo nuevo,Nodo subAr){
        Nodo nuevoPadre=subAr;
        if(nuevo.dato<subAr.dato){
            if(subAr.hijoizq==null){
                subAr.hijoizq=nuevo;
            }else{
                subAr.hijoizq=insertarAVL(nuevo,subAr.hijoizq);
                if((obtenerFE(subAr.hijoizq) - obtenerFE(subAr.hijoder)==2)){
                   if(nuevo.dato<subAr.hijoizq.dato){
                       nuevoPadre=rotacionIzquierda(subAr);
                   }else{
                       nuevoPadre=rotacionDobleIzq(subAr);    
                   } 
                }
            }
        }else if(nuevo.dato>subAr.dato){
            if(subAr.hijoder==null){
                subAr.hijoder=nuevo;
            }else{
                subAr.hijoder= insertarAVL(nuevo,subAr.hijoder);
                if((obtenerFE(subAr.hijoder)-obtenerFE(subAr.hijoizq)==2)){
                    if(nuevo.dato>subAr.hijoder.dato){
                        nuevoPadre= rotacionDerecha(subAr);
                    }else{
                        nuevoPadre= rotacionDobleDer(subAr);
                    }
                }
            }
        }else{
            System.out.println("Ya existe el nodo");
        }
        if((subAr.hijoizq==null) && (subAr.hijoder!=null)){
            subAr.fe=subAr.hijoder.fe+1;
        }else if((subAr.hijoder==null) && subAr.hijoizq!=null){
           subAr.fe=subAr.hijoizq.fe+1; 
        }else{
            subAr.fe=Math.max(obtenerFE(subAr.hijoizq),obtenerFE(subAr.hijoder))+1;
        }
        return nuevoPadre;
    }
    public void insertar(int d){
        Nodo nuevo = new Nodo(d);
        if(raiz==null){
            raiz=nuevo;
        }else{
            raiz=insertarAVL(nuevo,raiz);
        }
    }
     public void inOrden(Nodo raiz){
        if(raiz!=null){
            inOrden(raiz.hijoizq);
            System.out.print(raiz.dato+", ");
            inOrden(raiz.hijoder);  
        }
   }
    public void preOrden(Nodo raiz){
        if(raiz!=null){
            System.out.print(raiz.dato+", ");
            preOrden(raiz.hijoizq);
            preOrden(raiz.hijoder);  
        }
   }
    public void postOrden(Nodo raiz){
        if(raiz!=null){
            postOrden(raiz.hijoizq);
            postOrden(raiz.hijoder); 
            System.out.print(raiz.dato+", ");
        }
   }
 
    
}
