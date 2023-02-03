package est_avl;
public class ArbolAVL {
    Nodo raiz;
    int altura;
    String [][] matriz=new String[100][100];
    ArbolAVL(){
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
        return balancea(nodo);
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
         if(nodo!=null)
             nodo=balancea(nodo);
        return nodo;  
    }
    private Nodo balancea(Nodo raiz) {
        Nodo a=raiz;
        Nodo b,c;
        calculaFe(a);
        if(a.getFe()<-1){
            b=a.izq;
            if(b.getFe()<0){
                b=a.izq=b.der;
                b.der=a;
                raiz=b;
                calculaFe(a);
                calculaFe(b);
            }
            else{
                c=b.der;
                b.der=c.izq;
                a.izq=c.der;
                c.izq=b;
                c.der=a;
                raiz=c;
                calculaFe(a);
                calculaFe(b);
                calculaFe(c);
            }
        }
        else if(a.getFe()>1){
            b=a.der;
            if(b.getFe()>0){
                a.der=b.izq;
                b.izq=a;
                calculaFe(a);
                calculaFe(b);
            }else{
                c=b.izq;
                b.izq=c.der;
                a.der=c.izq;
                c.izq=a;
                c.der=b;
                raiz=c;
                calculaFe(a);
                calculaFe(b);
                calculaFe(c);
            }
        }
        return raiz;  
    }
    private Nodo anterior(Nodo nodo) {
       if(nodo.der!=null)
           return anterior(nodo.der);
       return nodo;
    }
    private void calculaFe(Nodo raiz) {
        int hd=(raiz.der==null)? 0:raiz.der.getAltura();
        int hi=(raiz.izq==null)? 0:raiz.izq.getAltura();
        raiz.setAltura((hd>hi)?hd+1:hi+1);
        raiz.setFe(hd-hi);
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
public Nodo buscar(int valor){
    if(this.raiz==null)
        return null;
    else return buscar(this.raiz,valor);
}
public Nodo buscar(Nodo raiz,int valor){
    if(raiz==null)
        return null;
    else if (valor==raiz.num)
        return raiz;
    else if(valor<raiz.num)
        return buscar(raiz.izq,valor);
    else return buscar(raiz.der,valor);
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
