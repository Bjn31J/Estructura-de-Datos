package est_arbolavl;
public class Est_ArbolAVL {
    public static void main(String[] args) {
     ArbolAVL avl=new ArbolAVL();
     avl.insertar(10);
     avl.insertar(5);
     avl.insertar(13);
     avl.insertar(1);
     avl.insertar(6);
     avl.insertar(17);
     avl.insertar(16);
     avl.insertar(22);
     avl.preOrden(avl.obtenerRaiz());
        System.out.println("");
     avl.inOrden(avl.obtenerRaiz());
        System.out.println("");
     avl.postOrden(avl.obtenerRaiz());
    }
}
