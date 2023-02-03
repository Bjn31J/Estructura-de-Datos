package est_coladinamica;
public class Est_colaDinamica {
    public static void main(String[] args) {
        ColaD col=new ColaD();
        col.inserta(30);
        col.inserta(40);
        col.imprimir();
        col.suprimir();
        System.out.println("Eliminando 30");
        col.imprimir();
    }
}
