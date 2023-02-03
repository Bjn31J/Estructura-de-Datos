package est_arboles;
import javax.swing.JOptionPane;
public class Est_Arboles {
    public static void main(String[] args) {
       Arbol ar=new Arbol();
       int opc=0;
       int dato;
       do{
         opc=Integer.parseInt(JOptionPane.showInputDialog(null,
                  "1.-Agrega un nodo\n"
                 +"2.-Recorrido inOrden\n"+
                  "3.-Recorrido preOrden\n"+
                  "4.-Recorrido postOrden\n"+
                  "5.-Eliminar un nodo del arbol\n"+
                  "6.-Salir",JOptionPane.QUESTION_MESSAGE));
         switch(opc){
             case 1 :
                 dato=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el valor del nodo",
                         "Agrega nodo ",JOptionPane.QUESTION_MESSAGE));
                 ar.insertaNodo(dato);
                 break;
             case 2:
                 if(!ar.estaVacio()){
                     System.out.println("recorrido inorden: ");
                     ar.inOrden(ar.raiz); 
                 }else{
                     JOptionPane.showMessageDialog(null, "El esta vacio","fin",JOptionPane.INFORMATION_MESSAGE);
                 }
                 break;
             case 3:
                 if(!ar.estaVacio()){
                     System.out.println("\nrecorrido preOrden: ");
                     ar.preOrden(ar.raiz); 
                 }else{
                     JOptionPane.showMessageDialog(null, "El esta vacio","fin",JOptionPane.INFORMATION_MESSAGE);
                 }
                 break;
             case 4:
                 if(!ar.estaVacio()){
                     System.out.println("\nrecorrido postOrden: ");
                     ar.postOrden(ar.raiz); 
                 }else{
                     JOptionPane.showMessageDialog(null, "El esta vacio","fin",JOptionPane.INFORMATION_MESSAGE);
                 }
                 break;
             case 5:
                 if(!ar.estaVacio()){
                     System.out.println("\nEliminar un nodo del arbol");
                     dato=Integer.parseInt(JOptionPane.showInputDialog(null,"Ingresa el valor del nodo a eliminar",
                         "Eliminando nodo",JOptionPane.QUESTION_MESSAGE));
                     if(ar.eliminar(dato)==false){
                         JOptionPane.showMessageDialog(null,"El nodo no se encuentra en el arbol","Nodo no encontrado"
                         ,JOptionPane.INFORMATION_MESSAGE);
                     }else{
                         JOptionPane.showMessageDialog(null,"El nodo ha sido eliminado","Nodo eliminado"
                         ,JOptionPane.INFORMATION_MESSAGE);
                     }
                 }else{
                     JOptionPane.showMessageDialog(null, "El esta vacio","fin",JOptionPane.INFORMATION_MESSAGE);
                 }
                 break;
                 
             case 6:
                 JOptionPane.showConfirmDialog(null, "Aplicacion finalizada","fin",JOptionPane.INFORMATION_MESSAGE);
                 break;
             default:
                 JOptionPane.showMessageDialog(null, "Opcion incorrecta ","preste atencion a las opciones",JOptionPane.INFORMATION_MESSAGE);
         }     
       }while(opc !=6);
    }
}
