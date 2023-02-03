package est_quicksort;
import javax.swing.JOptionPane;
public class Est_quicksort {
    public static void main(String[] args) {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog("Teclea número de elementos"));

        int[] vec1;
        
        quicksort q = new quicksort();
        vec1 = q.LlenarVector(n);
        JOptionPane.showMessageDialog(null, "Arreglo 1" + q.imprimirVector(vec1));
        
        q.quicksort(vec1, 0, n-1);
        q.imprimirVector(vec1);
    }
}
