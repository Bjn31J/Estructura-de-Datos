package est_listadoble;
import java.util.Scanner;
public class Est_ListaDoble {
    Scanner sc=new Scanner (System.in);
    ListaDoble club;
    private String nombre;
    private String sexo;
    private int edad;
    public static void main(String[] args) {
      Est_ListaDoble l=new Est_ListaDoble ();
      l.iniciador();
    }
    Est_ListaDoble(){
        club= new ListaDoble();
    }
    public void iniciador(){
        Nodo nuevo;
        Nodo pareja;
        this.pideNombre();
        while(!nombre.equals("S")){
            pideSexo();
            pideEdad();
            nuevo = new Nodo(nombre,sexo,edad);
            club.inserta(nuevo,buscaLugar(edad));
            muestra();
            if(sexo.equals("M")){
                pareja=buscaMujer(nuevo);
            }else{
                pareja=buscaHombre(nuevo);
            }
            if (pareja!=null){
                System.out.println(" Nombre: "+nuevo.getNombre()+" Sexo: "+nuevo.getSexo()+" Edad: "+nuevo.getEdad());
                System.out.println(" Su pareja es ");
                System.out.println(" Nombre: "+pareja.getNombre()+" Sexo: "+pareja.getSexo()+" Edad: "+pareja.getEdad());
                club.elimina(pareja);
                club.elimina(nuevo);
                muestra();
            } else {
            }
            pideNombre();   
        }
    }
    public void pideNombre(){
        System.out.println("Digite el nombre (S)alir");
        nombre =  sc.nextLine();
    }
    public void pideEdad(){
        System.out.println("Digite la edad ");
        edad=Integer.parseInt(sc.nextLine());
    }
    public void pideSexo(){
        System.out.println("Digite el sexo (F/M):");
        sexo=sc.nextLine();
    }
    public Nodo buscaLugar(int edad){
        boolean enc=false;
        Nodo anterior=null;
        Nodo actual=club.primer();
        while(actual!=null && !enc){
            if(actual.getEdad()> edad){
                enc=true;                
            }else{
                anterior=actual;
                actual=club.siguiente(actual);
            }
        }
        return anterior;
    }
    public Nodo buscaHombre(Nodo nuevo){
        boolean enc=false;
        Nodo actual=club.siguiente(nuevo);
        while((actual!=null) && (!enc)){
            if(actual.getSexo().equals("M")){
                enc=true;
            }else{
                actual=club.siguiente(actual);
            }
        }
        return actual;
    }
     public Nodo buscaMujer(Nodo nuevo){
        boolean enc=false;
        Nodo actual=club.siguiente(nuevo);
        while((actual!=null) && (!enc)){
            if(actual.getSexo().equals("F")){
                enc=true;
            }else{
                actual=club.siguiente(actual);
            }
        }
        return actual;
    }
    public void muestra(){
        Nodo actual=club.primer();
        while(actual!=null){
            System.out.println(" Nombre: "+actual.getNombre()+" Sexo: "+actual.getSexo()+" Edad: "+actual.getEdad());
            actual=club.siguiente(actual);
        }}
}
