package est_listacirculardoble;
import java.util.Scanner;
public class Est_ListaCircularDoble {
    Scanner sc=new Scanner (System.in);
    ListaCircular alumnos;
    private String nombre;
    private int noControl;
    private double cali,cali2,cali3;
     Est_ListaCircularDoble(){
        alumnos= new ListaCircular();
    }
    public static void main(String[] args) {
       Est_ListaCircularDoble l=new Est_ListaCircularDoble();
       l.iniciador();
    }
    public void iniciador(){
       Scanner sc=new Scanner (System.in);
       int opc=0;
       do{
           System.out.println("Digite su opcion");
           System.out.println("1.-Ingresa un alumno");//
           System.out.println("2.-Actualizar calificaciones ");//(pidiendo el numero de control del alumno y el numero de la cali)
           System.out.println("3.-Eliminar alumnos de la lista.");
           System.out.println("4.-Mostrar los datos de un alumnos");//Pidiendo el Numero de control)
           System.out.println("5.-Mostrar el contenido de la lista.");
           System.out.println("6.-Muestra lista de alumnos recursivo");
           System.out.println("7.-Salir");
           opc=sc.nextInt();
           Nodo nuevo;
           int bus;
           switch(opc){
               case 1:
                   System.out.println("Ingresa un alumno ");
                   this.pideNombre();
                   while(!nombre.equals("S")){
                   pideNoControl();
                   pideCalificacion();
                   nuevo = new Nodo(nombre,noControl,cali,cali2,cali3);
                   alumnos.ingresa(nuevo, buscaLugar(noControl));
                   System.out.println( alumnos.getNoElementos());
                   pideNombre();
                   }
                   break;
               case 2:
                   bus=0;
                   System.out.println("Actualizar calificaciones ");
                   System.out.println("Digite su numero de control");
                   bus=sc.nextInt();
                   Nodo Act=buscaNocrl(bus);
                   if(Act!=null){
                       System.out.println("que calificacion desea actualizar? 1, 2, 3");
                      int calMod=sc.nextInt();
                       System.out.println("actualizar calificacion :");
                      double cal=sc.nextDouble();
                      alumnos.modificar(calMod,cal, Act);
                      buscaNocrl(bus);
                   }
                   break;
               case 3:
                   Nodo alumno;
                   System.out.println("Eliminar alumno");
                   System.out.println("Digite su numero de control a eliminar");
                   bus=sc.nextInt();
                   alumno=buscaNocrl(bus);
                   alumnos.elimina(alumno);               
                   break;
               case 4:
                   System.out.println("Mostrar los datos de un alumno");
                   System.out.println("Digite su numero de control a buscar");
                   bus=sc.nextInt();
                   buscaNocrl(bus);
                   break;
               case 5:
                   System.out.println("Mostrar el contenido de la lista");
                   muestra();
                   break;
               case 6:
                   System.out.println("Muestra lista de alumnos recursivo");
                   alumnos.imprimirR();
                   break;
               case 7:
                   System.out.println("Salir");
                   break;
                
           } 
       }while(opc!=7);
    }
     public void pideNombre(){
        System.out.println("Digite el nombre:  (S)alir");
        nombre =  sc.next();
    }
    public void pideNoControl(){
        System.out.println("Digite el numero de control; ");
        noControl=sc.nextInt();
    }
    public void pideCalificacion(){
        System.out.println("Digite su calificacion: ");
        cali=sc.nextDouble();
        System.out.println("Digite su calificacion2: ");
        cali2=sc.nextDouble();
        System.out.println("Digite su calificacion3: ");
        cali3=sc.nextDouble();
        
    }
     public Nodo buscaLugar(int noCtrl){
        boolean enc=false;
        Nodo anterior=null;
        Nodo actual=alumnos.primer();
        while(actual!=null && !enc){
            if(actual.getNoControl()>noCtrl){
                enc=true;
            }else{
                anterior=actual;
                actual=alumnos.siguiente(actual);
            }
        }
        return anterior;
    }
      public void muestra(){
        Nodo actual=alumnos.primer();
        while(actual!=alumnos.p){
            System.out.println(" Nombre: "+actual.getNombre()+" Numero de control: "+actual.getNoControl()+" Calificacion: "+actual.getCali()+" Calificacion2: "
            +actual.getCali2()+" Calificacion3: "+actual.getCali3());
            actual=actual.siguiente;
        }
      }
      public Nodo buscaNocrl(int noCtrl){
        boolean enc=false;
        Nodo actual=alumnos.primer();
        while(actual!=null && !enc){
            if(actual.getNoControl()==noCtrl){
            enc=true;
            System.out.println(" Alumno encontrado ");
            System.out.println(" Nombre: "+actual.getNombre()+" Numero de control: "+actual.getNoControl()+" Calificacion: "+actual.getCali()+" Calificacion2: "
            +actual.getCali2()+" Calificacion3: "+actual.getCali3());
            return actual;
            }else{
                actual=actual.siguiente;
            }
        }
        if(enc!=true){
            actual=null;
            System.out.println("No se a encontrado");    
        }
        return actual;
    }
    
}

