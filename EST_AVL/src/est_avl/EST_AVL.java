package est_avl;
public class EST_AVL {
    public static void main(String[] args) {
       ArbolAVL ar=new ArbolAVL();
       ar.insertar(new Nodo(80));
       ar.insertar(new Nodo(30));
       ar.insertar(new Nodo(90));
       ar.insertar(new Nodo(100));
       ar.insertar(new Nodo(20));
       ar.insertar(new Nodo(40));
       ar.insertar(new Nodo(85));
       ar.eliminar(30);
       
       
       ar.escribeArbol();
       
    }
    
}
