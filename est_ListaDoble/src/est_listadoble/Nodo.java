package est_listadoble;
public class Nodo {
   private String nombre;
   private String sexo;
   private int edad;
   private Nodo anterior;
   private Nodo siguiente;
    Nodo(String pNombre,String pSexo,int pEdad){
        this.nombre=pNombre;
        this.sexo=pSexo;
        this.edad=pEdad;
        this.anterior=null;
        this.siguiente=null;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
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
