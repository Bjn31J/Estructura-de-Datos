package est_metodosbusqueda;
import javax.swing.JOptionPane;
public class Busqueda {
    public int[] LlenarVector(int n) {
        int[] vector = new int[n];
        for (int i = 0; i < vector.length; i++) {
            vector[i] = Integer.parseInt(JOptionPane.showInputDialog("Teclea valor [" + (i + 1) + "]"));
        }
        return vector;
    }
    public String imprimirVector(int[] vector) {
        String res = "Elementos\n";
        for (int i = 0; i < vector.length; i++) {
            res = res + vector[i] + "\n";
        }
        System.out.print(res);
        return res;
    }
    public void busquedaBinaria(int[] vec) {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a buscar: "));
        int cont = 0;
        while (cont < vec.length - 1 && vec[cont] != buscar) {
            cont++;
        }
        if (vec[cont] == buscar) {
            JOptionPane.showMessageDialog(null,"EL numero: " + buscar + " Si existe");
        } else {
            JOptionPane.showMessageDialog(null,"EL numero: " + buscar + " No existe");
        }
    }
    public void busquedaSecuencial(int[] vec) {
        int buscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a buscar: "));
        int tam = vec.length;
        int i = 0;
        boolean cambio = false;
        while (i < tam && cambio == false) {
            if (buscar == vec[i]) {
                cambio = true;
            }
            i++;
        }
        if (cambio == true) {
            JOptionPane.showMessageDialog(null,"EL numero: " + buscar + " Si existe");
        } else {
           JOptionPane.showMessageDialog(null,"EL numero: " + buscar + " No existe");
        }
    }
    public void busquedaSecuencialMe(int[] vec) {
        int tam = vec.length;
        int j = 0;
        boolean cambio = false;
        //ordenamiento insercion simple 
        for (int i = 1; i < vec.length; i++) {
            int temp = vec[i];
            int po = i;
            while (po > 0 && vec[po - 1] > temp) {//Cambiar los valores a la derecha
                vec[po] = vec[po - 1];
                po--;
            }
            vec[po] = temp;
        }
        imprimirVector(vec);
        int buscar = Integer.parseInt(JOptionPane.showInputDialog("Digite el numero a buscar: "));
        while (j < tam && cambio == false) {
            if (buscar == vec[j]) {
                cambio = true;
            }
            j++;
        }
        if (cambio == true) {
            JOptionPane.showMessageDialog(null, "EL numero: " + buscar + " Si existe");
        } else {
            JOptionPane.showMessageDialog(null, "EL numero: " + buscar + " No existe");
        }
    }
}
