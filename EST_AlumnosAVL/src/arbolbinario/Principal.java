package arbolbinario;

import java.util.Scanner;

public class Principal {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        Arbol<Alumno> arbol = new Arbol();
        int opc = 0;
        do {
            System.out.println("1. Insertar alumno");
            System.out.println("2. Actualizar Calificaciones");
            System.out.println("3. Eliminar alumnos");
            System.out.println("4. Mostrar los datos");
            System.out.println("5. Mostrar los datos de un alumno");
            System.out.println("6. Salir");
            opc = Integer.parseInt(input.nextLine());

            switch (opc) {
                case 1:
                    System.out.println("Ingresa el nombre del alumno");
                    String nombre = input.nextLine();
                    System.out.println("Ingresa el numero de control");
                    int num = Integer.parseInt(input.nextLine());
                    int calificaciones[] = {1, 2, 3};
                    System.out.println("=======Calificaciones========");
                    for (int i = 0; i < calificaciones.length; i++) {
                        System.out.println("Ingresa la calificacion");
                        calificaciones[i] = Integer.parseInt(input.nextLine());
                    }

                    arbol.insertar(new Alumno(nombre, num, calificaciones));
                    break;
                case 2:
                    System.out.println("Ingresa el numero de control");
                    num = Integer.parseInt(input.nextLine());
                    Nodo alumno = arbol.buscar(new Alumno(num));
                    if (arbol.buscar(new Alumno(num)) != null) {
                        System.out.println("Alumno encontrado");
                        Alumno a = (Alumno) alumno.getElemento();
                        int calificaciones2[] = {1, 2, 3};
                        System.out.println("=======Calificaciones========");
                        for (int i = 0; i < calificaciones2.length; i++) {
                            System.out.println("Ingresa la calificacion");
                            calificaciones2[i] = Integer.parseInt(input.nextLine());
                        }
                        a.setCalificacion(calificaciones2);
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    break;
                case 3:
                    System.out.println("Ingresa el numero de control");
                    num = Integer.parseInt(input.nextLine());
                    if (arbol.buscar(new Alumno(num)) != null) {
                        arbol.removeNodo(new Alumno(num));
                        System.out.println("Alumno eliminado");
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    break;
                case 4:
                    arbol.inorden();
                    break;
                case 5:
                    System.out.println("Ingresa el numero de control");
                    num = Integer.parseInt(input.nextLine());
                    if (arbol.buscar(new Alumno(num)) != null) {
                        System.out.println(arbol.buscar(new Alumno(num)).getElemento());
                    } else {
                        System.out.println("Alumno no encontrado");
                    }
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion incorrecta,intente de nuevo");
            }
            System.out.println();
        } while (opc != 6);
    }
}
