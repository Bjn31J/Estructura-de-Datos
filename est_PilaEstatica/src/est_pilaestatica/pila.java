package est_pilaestatica;
public class pila {
    private int tope;
    private int max;
    private Object datos[];
    public pila(int maxNum){
        max=maxNum;
        tope=-1;
        datos=new Object[max];
    }
    //cuando no hay ningun elemento tope es igual a -1
    public boolean vacia(){
        return tope==-1;
    }
    public boolean llena(){
        return tope==max-1;
    }
    //insertar en pila push
    public boolean push(int a){
        if(!llena()){
            tope++;
            datos[tope]=a;
            return true;
        }
        return false;
    }
    //Elimina elemento que se encuentra en la pila
    public Object pop(){
        Object aux=null;
        if(!vacia()){
            aux=datos[tope];
            datos[tope]=null;
            tope--;
            return aux;
        }
        return aux;
    }
    
    public void imprimir(){
        for(int i=-1;i<tope;i++){
            System.out.println("Total ab+c*\n"+datos[tope]);
             tope--;  
        }
    }
}
