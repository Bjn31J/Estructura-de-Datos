package estacionamiento_piladinamica;
public class Pila {
    private NodoPila tope;
    int tamaño;
    //constructor
    public Pila(){
        tope=null;
        tamaño=0;
    }
    //Metodo para saber cuando la pila esta vacia
    public boolean estaVacia(){
        return tope==null;
    }
    //Metodo para insertar un elemento en la pila
    public void insertar(String elemento){
        NodoPila nuevo =new NodoPila(elemento);
        nuevo.anterior=tope;
        tope=nuevo;
        tamaño++;   
    }
    //Metodo para sacar un elemento en la pila
    public  String sacar(){
        String aux=tope.novehiculo;
        tope=tope.anterior;
        tamaño--;
        return aux;
    }
    //Metodo para saber quien esta en la cima de la pila
    public String tope(){
        return tope.novehiculo;
    }
    //Metodo para saber el tamaño de la pila
    public int tamañoPila(){
        return tamaño;
    }
    //Metodo para limpiar (Vaciar la pila)
    public void limpiarPila(){
        while(!estaVacia()){
            sacar();
        }
    }
    //Metodo para mostrar pila 
    public String mostrarPila(){
        NodoPila aux=tope;
        String cadena="Datos del estacioamamiento \n";
        while(aux!=null){
            cadena+="vehiculo: "+aux.getNovehiculo();
            aux.getAnterior();
        }
     return cadena;
    }
   }

