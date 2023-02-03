package est_listacirculardoble;
public class Nodo {
 private String nombre;
 private int noControl;
 private double cali,cali2,cali3;
 Nodo anterior;
 Nodo siguiente;
    Nodo(String pNombre,int pnoControl,double pCali,double pCali2, double pCali3){
        this.nombre=pNombre;
        this.noControl=pnoControl;
        this.cali=pCali;
        this.cali2= pCali2;
        this.cali3=pCali3;
        this.anterior=null;
        this.siguiente=null;
    }

    public double getCali2() {
        return cali2;
    }

    public void setCali2(double cali2) {
        this.cali2 = cali2;
    }

    public double getCali3() {
        return cali3;
    }

    public void setCali3(double cali3) {
        this.cali3 = cali3;
    }
    
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getNoControl() {
        return noControl;
    }
    public void setNoControl(int noControl) {
        this.noControl = noControl;
    }
    public double getCali() {
        return cali;
    }
    public void setCali(double calificacion) {
        this.cali = calificacion;
    }
    public Nodo getAnterior() {
        return anterior;
    }
    public void setAnterior(Nodo anterior) {
        this.anterior = anterior;
    }
    public Nodo getSiguiente() {
        return siguiente;
    }
    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
