package est_avlarbol;
public class Est_AVLarbol {
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
           avl.mostrarAVL();
           avl.preOrden(avl.obtenerRaiz());
           System.out.println("");
           avl.inOrden(avl.obtenerRaiz());
           System.out.println("");
           avl.postOrden(avl.obtenerRaiz()); 
           avl.eliminar(6);
           avl.eliminar(22);
           avl.mostrarAVL();
           avl.preOrden(avl.obtenerRaiz());
           System.out.println("");
           avl.inOrden(avl.obtenerRaiz());
           System.out.println("");
           avl.postOrden(avl.obtenerRaiz()); 
       }
}
