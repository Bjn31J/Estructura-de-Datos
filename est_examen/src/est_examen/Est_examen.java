package est_examen;
import java.util.Scanner;
public class Est_examen {
    String nombre, serie;
    Podadoras p = new Podadoras();
    ListaCircular lst = new ListaCircular();
    ListaCircular lst2 = new ListaCircular();
    public static void main(String[] args) {
        Est_examen E = new Est_examen();
        E.iniciador();
    }
    Scanner sc = new Scanner(System.in);
    private void iniciador() {

        int opc = 0;
        do {
            String Menu = "\tCompra-Venta de Podadoras\nIngrese la opcion que desea\n1.-Ingresar Cliente\n2.-Reporte 1\n3.-Reporte 2\n4.-Salir";
            System.out.println(Menu);
            opc = sc.nextInt();
            switch (opc) {
                case 1:
                    ingresarDatos();
                    break;
                case 2:
                    System.out.println("Registro de Clientes");
                    lst.imprimirR();
                    break;
                case 3:
                    System.out.println("Clientes que no encontraron el tipo de podadora que buscaron");
                    lst2.imprimirC();
                    break;
            }
        } while (opc != 4);
        System.exit(0);
    }
    private void ingresarDatos() {
        System.out.println("Ingrese el nombre del cliente");
        nombre = sc.next();
        System.out.println("Numero de serie de podadora \n1.-" + p.getSerie() + "\n2.-" + p.getSerie2() + "\n3.-" + p.getSerie3());
        serie = sc.next();
        boolean ok = false;
        if (ok = buscar(serie)) {
            float pre = 0;
            if (serie.equalsIgnoreCase(p.getSerie())) {
                pre = ((200 * 10) / 100) + 200;
                p.setPrecio(pre);
            } else if (serie.equalsIgnoreCase(p.getSerie2())) {
                pre = ((300 * 10) / 100) + 300;
                p.setPrecio(pre);
            } else if (serie.equalsIgnoreCase(p.getSerie3())) {
                pre = ((400 * 10) / 100) + 400;
                p.setPrecio(pre);
            }
            Nodo nuevo = new Nodo(nombre, serie, p.getPrecio());
            lst.ingresa(nuevo);
        } else {
            System.out.println("Numero de Serie no encontrado");
            Nodo nuevo = new Nodo(nombre);
            lst2.ingresa(nuevo);
        }
    }
    private boolean buscar(String serie) {
        if (serie.equalsIgnoreCase(p.getSerie())) {
            return true;
        } else if (serie.equalsIgnoreCase(p.getSerie2())) {
            return true;
        } else if (serie.equalsIgnoreCase(p.getSerie3())) {
            return true;
        }
        return false;
    }
}
