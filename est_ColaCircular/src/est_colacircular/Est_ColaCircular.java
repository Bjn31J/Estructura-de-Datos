package est_colacircular;
public class Est_ColaCircular {
    public static void main(String[] args) {
      Cola col=new Cola(8);
      col.agregarDatos(0);
      col.agregarDatos(15);
      col.agregarDatos(60);
      col.agregarDatos(20);
      col.agregarDatos(90);
      col.agregarDatos(40);

      
      col.sacarElemento();
      col.sacarElemento();
      col.agregarDatos(15);      

      col.agregarDatos(300);
      col.imprimirDatos();
      
    }
    
}
