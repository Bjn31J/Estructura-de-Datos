package est_arbolbinario;
public class binario {
     Nodo raiz;
    int altura;
    String [][] matriz=new String[100][100];
    binario(){
        raiz=null;
        altura=0;
    }
    public boolean vacio(){
        return (raiz==null);
    }
    public void insertar(Nodo nuevo){
        this.raiz=this.insertar(this.raiz,nuevo);
    }
    private Nodo insertar(Nodo nodo,Nodo nuevo){
        if(nodo==null)
            nodo=nuevo;
        else if(nuevo.num>nodo.num)
            nodo.der=this.insertar(nodo.der, nuevo);
        else if(nuevo.num<nodo.num)
            nodo.izq=this.insertar(nodo.izq, nuevo);
        else System.out.println("numero duplicado");
        return nodo;
    }
    public  void eliminar(int numero){
        raiz=eliminar(raiz,numero);
    }
     private Nodo eliminar(Nodo nodo, int numero) {
         Nodo anterior;
         if(nodo==null)
             System.out.println("ese elemento no esta en el arbol");
         else{
             if(numero<nodo.num)
                 nodo.izq=eliminar(nodo.izq,numero);
             else if (numero>nodo.num)
                nodo.der=eliminar(nodo.der,numero);
             else if((nodo.izq==null)&(nodo.der==null))
                    nodo=null;
             else if(nodo.izq==null)
                    nodo=nodo.der;
             else if(nodo.der==null)
                 nodo=nodo.izq;
             else{
                 anterior=this.anterior(nodo.izq);
                 nodo.num=anterior.num;
                 nodo.izq=eliminar(nodo.izq,anterior.num);
             }
                    
         }
        return nodo;  
    }
     private Nodo anterior(Nodo nodo) {
       if(nodo.der!=null)
           return anterior(nodo.der);
       return nodo;
    }
    public void enOrden(Nodo aux){
    if(aux!=null){
        enOrden(aux.izq);
        aux.escribe();
        enOrden(aux.der);
    }
}
public void preOrden(Nodo raiz){
        if(raiz!=null){
            raiz.escribe();
            preOrden(raiz.izq);
            preOrden(raiz.der);  
        }
}
public void posOrden(Nodo aux){
    if(aux!=null){
        posOrden(aux.izq);
        posOrden(aux.der);
        aux.escribe();
    }
}
public int altura(Nodo aux){
    if(aux!=null){
        if(altura(aux.izq)>altura(aux.der))
            return altura(aux.izq)+1;
        else return altura(aux.der)+1;
    }
    else return 0;
}
public void escribeArbol(){
    int nivel=0;
    int pos=80;
    String linea;
    for(int i=0;i<altura(raiz);i++)
        for(int j=0;j<100;j++)
            matriz[i][j]=" ";
    llenaenOrden(this.raiz,nivel,pos/2,pos/4);
    for(int i=0;i<altura(raiz);i++){
        linea="";
        for(int j=0;j<100;j++)
            linea =linea+matriz[i][j];
        System.out.println(linea);
    }    
}
    private void llenaenOrden(Nodo aux,int nivel,int pos,int inc) {
        if(aux !=null){
            llenaenOrden(aux.izq,nivel+1,pos-(inc),inc/2);
            matriz[nivel][pos]=String.valueOf(aux.num+" "+aux.getFe());
            llenaenOrden(aux.der,nivel+1,pos+(inc),inc/2);
        }
    }  
}
