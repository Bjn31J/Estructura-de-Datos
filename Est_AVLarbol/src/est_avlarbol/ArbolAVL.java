package est_avlarbol;
public class ArbolAVL {
    Nodo raiz;
     public Nodo obtenerRaiz(){
       return raiz;
   }
    public void insertar(int dato){
        raiz=insertarAVL(raiz,dato);
    }
    private Nodo insertarAVL(Nodo nodoActual,int dato){
        if(nodoActual==null){
            return(new Nodo(dato));
        }
        if( dato < nodoActual.dato){
            nodoActual.izq = insertarAVL(nodoActual.izq,dato);
        }else if(dato> nodoActual.dato){
            nodoActual.der=insertarAVL(nodoActual.der,dato);
        }else{
            return nodoActual;
        }
        //actualizar altura
        nodoActual.altura=1+max(getAltura(nodoActual.izq),getAltura(nodoActual.der));
        int fe = ObtenerFE(nodoActual);
        //Rotacion simple derecha;
        if(fe > 1 && dato < nodoActual.izq.dato){
            
            return rotacionDer(nodoActual);
        }
        //Rotacion simple izquierda
        if(fe < -1 && dato>nodoActual.der.dato){
            return rotacionIzq(nodoActual);
        }
        //Rotacion doble izquierda derecha
          if(fe > 1 && dato > nodoActual.izq.dato){
              nodoActual.izq=rotacionIzq(nodoActual.izq);
            return rotacionDer(nodoActual);
        }
        //Rotacion doble derecha izquierda
        if(fe < -1 && dato > nodoActual.der.dato){
              nodoActual.der=rotacionIzq(nodoActual.der);
            return rotacionIzq(nodoActual);
        }
        return nodoActual;    
    }
//Devuelve el mayor entre dos numeros    
private int max(int x,int y){
    return(x>y)? x:y;
}
//obtiene el peso de un arbol (altura)
private int getAltura(Nodo nodoActual){
    if(nodoActual==null){
        return 0;
    }
    return nodoActual.altura;
}
private int ObtenerFE(Nodo nodoActual){
    if(nodoActual==null){
        return 0;
    }
    return getAltura(nodoActual.izq)-getAltura(nodoActual.der);
}
private Nodo rotacionDer(Nodo nodoActual){
    Nodo nuevaRaiz=nodoActual.izq;
    Nodo aux = nuevaRaiz.der;
    nuevaRaiz.der=nodoActual;
    nodoActual.izq=aux;
    nodoActual.altura=max(getAltura(nodoActual.izq),getAltura(nodoActual.der))+1;
    nuevaRaiz.altura=max(getAltura(nuevaRaiz.izq),getAltura(nuevaRaiz.der))+1;
    return nuevaRaiz;
}
private Nodo rotacionIzq(Nodo nodoActual){
    Nodo nuevaRaiz=nodoActual.der;
    Nodo aux = nuevaRaiz.izq;
    nuevaRaiz.izq=nodoActual;
    nodoActual.der=aux;
    nodoActual.altura=max(getAltura(nodoActual.izq),getAltura(nodoActual.der))+1;
    nuevaRaiz.altura=max(getAltura(nuevaRaiz.izq),getAltura(nuevaRaiz.der))+1;
    return nuevaRaiz;
}
public void eliminar(int dato){
    raiz=eliminarAVL(raiz,dato);
}
private Nodo eliminarAVL(Nodo nodoActual,int dato){
  if(nodoActual==null)
      return nodoActual;
  if(dato<nodoActual.dato){
      nodoActual.izq=eliminarAVL(nodoActual.izq,dato);
  }else if(dato>nodoActual.dato){
      nodoActual.der=eliminarAVL(nodoActual.der,dato);
  }else{
      //Nodo hijo unico o es hoja
      if((nodoActual.izq==null)||(nodoActual.der==null)){
          Nodo aux=null;
          if(aux==nodoActual.izq){
              aux=nodoActual.der;
          }else{
              aux=nodoActual.izq;
          }
          //no tiene hijos
          if(aux==null){
              nodoActual=null;
          }else{
              //un hijo
              nodoActual=aux;
          }
      }else{
          //Nodo con dos hijos
          Nodo aux= getNodoValorMax(nodoActual.izq);
          nodoActual.dato=aux.dato;
          nodoActual.izq=eliminarAVL(nodoActual.izq,aux.dato);
      }
}
  //un nodo
  if(nodoActual==null)
      return nodoActual;
  nodoActual.altura=max(getAltura(nodoActual.izq),getAltura(nodoActual.der))+1;
  int fe = ObtenerFE(nodoActual);
  if(fe > 1 && ObtenerFE(nodoActual.izq)>=0 ){
      return rotacionDer(nodoActual);
  }
   if(fe < -1 && ObtenerFE(nodoActual.der)<=0 ){
      return rotacionIzq(nodoActual);
  }
   if(fe > 1 && ObtenerFE(nodoActual.izq)<0){
       nodoActual.izq=rotacionIzq(nodoActual.izq);
       return rotacionDer(nodoActual);
   }
   if(fe < -1 && ObtenerFE(nodoActual.der)>0){
       nodoActual.der=rotacionDer(nodoActual.der);
       return rotacionIzq(nodoActual);
   }
   return nodoActual; 
}
private Nodo getNodoValorMax(Nodo aux){
    Nodo actual=aux;
    while(actual.der!=null){
        actual=actual.der;
    }
    return actual;
}
public void mostrarAVL(){
    System.out.println("ArbolAVL");
    mostrar(raiz,0);
    
}
private void mostrar(Nodo aux,int d){
    if(aux.der!=null){
        mostrar(aux.der,d+1);
    }
    for(int i=0;i<d;i++){
        System.out.println("  ");
    }
    System.out.println("(" +aux.dato+ ")");
    if(aux.izq!=null){
        mostrar(aux.izq,d+1);
    }
}
public void inOrden(Nodo raiz){
        if(raiz!=null){
            inOrden(raiz.izq);
            System.out.print(raiz.dato+", ");
            inOrden(raiz.der);  
        }
   }
    public void preOrden(Nodo raiz){
        if(raiz!=null){
            System.out.print(raiz.dato+", ");
            preOrden(raiz.izq);
            preOrden(raiz.der);  
        }
   }
    public void postOrden(Nodo raiz){
        if(raiz!=null){
            postOrden(raiz.izq);
            postOrden(raiz.der); 
            System.out.print(raiz.dato+", ");
        }
   }
}
