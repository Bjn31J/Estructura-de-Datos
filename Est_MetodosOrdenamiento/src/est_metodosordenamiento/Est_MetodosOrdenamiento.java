package est_metodosordenamiento;
import javax.swing.JOptionPane;
public class Est_MetodosOrdenamiento {
    public static void main(String[] args) {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog("Teclea número de elementos"));

        int[] vec1;
        MetodosOrdenamiento mo = new MetodosOrdenamiento();
        vec1 = mo.LlenarVector(n);
        //JOptionPane.showMessageDialog(null, "Arreglo 1" + mo.imprimirVector(vec1));

        /*mo.ordenarSeleccionDirecta(vec1);
        JOptionPane.showMessageDialog(null, "Seleccion Directa: " + mo.imprimirVector(vec1));
*/
        mo.ordenarBurbujaMejorado(vec1);
        JOptionPane.showMessageDialog(null, "Burbuja Mejorado: " + mo.imprimirVector(vec1));

        /*mo.MetodoInsercionSimple(vec1);
        JOptionPane.showMessageDialog(null, "Insercion Simple: " + mo.imprimirVector(vec1));

        mo.OrdenamientoPorConteo(vec1);
        JOptionPane.showMessageDialog(null, "Ordenamiento por conteo : " + mo.imprimirVector(vec1));*/
    }
}
