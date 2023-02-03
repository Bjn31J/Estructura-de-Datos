package est_quicksort;
import java.util.Scanner;
import javax.swing.JOptionPane;
public class quicksort {
    Scanner sc = new Scanner(System.in);
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
    public int particion(int vec[], int izq, int der) {
        int pivote = vec[izq];
        while (true) {
            while (vec[izq] < pivote) {
                izq++;
            }
            while (vec[der] > pivote) {
                der--;
            }
            if (izq >= der) {
                return der;
            } else {
                int temp = vec[izq];
                vec[izq] = vec[der];
                vec[der] = temp;
                if (vec[der] == pivote) {
                    izq++;
                } else {
                    der--;
                }
                for (int i = 0; i < vec.length; i++) {
                    System.out.print(" " + vec[i]);
                }
                System.out.println(" ");
                System.out.println(" izquierda " + izq + " derecha " + der);
                System.out.println(" teclea un numero: ");
                String x = sc.nextLine();
            }
        }
    }
    public void quicksort(int vec[], int izq, int der) {
        if (izq < der) {
            int indicepar = particion(vec, izq, der);
            quicksort(vec, izq, indicepar);
            quicksort(vec, indicepar + 1, der);
        }
    }
}
