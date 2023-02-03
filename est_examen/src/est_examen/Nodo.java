package est_examen;
public class Nodo {
 private String nombre,serie;
 private float precio;
 Nodo anterior;
 Nodo siguiente;
    Nodo(String Nombre,String serie,float precio){
        this.nombre=Nombre;
        this.serie=serie;
        this.precio=precio;
        this.anterior=null;
        this.siguiente=null;
    }
    public Nodo(String nombre) {
        this.nombre = nombre;
        this.anterior=null;
        this.siguiente=null;
    }
        public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getSerie() {
        return serie;
    }
    public void setSerie(String serie) {
        this.serie = serie;
    }
    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
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
