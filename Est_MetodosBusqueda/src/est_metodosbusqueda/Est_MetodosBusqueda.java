package est_metodosbusqueda;
import javax.swing.JOptionPane;
public class Est_MetodosBusqueda {
    public static void main(String[] args) {
        int n;
        n = Integer.parseInt(JOptionPane.showInputDialog("Teclea número de elementos"));

        int[] vec1;
        Busqueda bus = new Busqueda();
        vec1 = bus.LlenarVector(n);
        JOptionPane.showMessageDialog(null, "Arreglo 1" + bus.imprimirVector(vec1));
        
       /* bus.busquedaBinaria(vec1);
        bus.busquedaSecuencial(vec1);*/
        bus.busquedaSecuencialMe(vec1);  
    }
}
