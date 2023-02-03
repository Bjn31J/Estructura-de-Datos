package est_arbolbinario;
public class EST_ARBOLBINARIO {
    public static void main(String[] args) {
        binario b=new binario();
        b.insertar(new Nodo (90));
        b.insertar(new Nodo(70));
        b.insertar(new Nodo(50));
        b.escribeArbol();
        b.enOrden(new Nodo (0));
    }
    
}
