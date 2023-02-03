package est_listaalumnosavl;

import java.util.Scanner;

public class Est_ListaAlumnosAVL {
    Scanner sc=new Scanner (System.in);
    ArbolAVL arbol;
    Nodo pos;
    int numN;
    String nombre;
    int opcion;
    int num;
    private double cali,cali2,cali3;
     Est_ListaAlumnosAVL(){
        arbol= new ArbolAVL();
    }
    public static void main(String[] args) {
       Est_ListaAlumnosAVL l=new Est_ListaAlumnosAVL();
       l.iniciador();
       
    }
    public void iniciador(){
       Scanner sc=new Scanner (System.in);
       int opc=0;
       do{
           System.out.println("Digite su opcion");
           System.out.println("1.-Ingresa un alumno");//
           System.out.println("2.-Actualizar calificaciones ");//(pidiendo el numero de control del alumno y el numero de la cali)
           System.out.println("3.-Eliminar alumnos AVL.");
           System.out.println("4.-Mostrar los datos de un alumnos");//Pidiendo el Numero de control)
           System.out.println("5.-Mostrar el contenido de la lista.");
           System.out.println("6.-Salir");
           opc=sc.nextInt();
         
           switch(opc){
               case 1:
                   System.out.println("Ingresa un alumno ");
                   inserta();
                   break;
               case 2:
                   
                   
                   
                   break;
               case 3:
                           
                   break;
               case 4:
                  
                   break;
               case 5:
                   System.out.println("Mostrar el contenido de la lista");
                   arbol.escribeArbol();
                   break;
               case 6:
                   System.out.println("Salir");
                   break;
                
           } 
       }while(opc!=6);
    }
    
     public void pideNombre(){
        System.out.println("Digite el nombre:  (S)alir");
        nombre =  sc.next();
    }
    public void pideNoControl(){
        System.out.println("Digite el numero de control; ");
        numN=sc.nextInt();
    }
    public void pideCalificacion(){
        System.out.println("Digite su calificacion: ");
        cali=sc.nextDouble();
        System.out.println("Digite su calificacion2: ");
        cali2=sc.nextDouble();
        System.out.println("Digite su calificacion3: ");
        cali3=sc.nextDouble();
    }
    public void inserta(){
        pideNoControl();
        pideNombre();
        arbol.insertar(pos,new Nodo(numN,nombre));
    }
    public void elimina(){
        pideNoControl();
        pos=arbol.buscar(numN);
        if((pos!=null) && (pos.nCont == numN))
            arbol.eliminar(pos);
        else System.out.println("");
    }
    public void actualiza(){
        System.out.println("actuliza");
        pideNoControl();
    }
    
    
}
