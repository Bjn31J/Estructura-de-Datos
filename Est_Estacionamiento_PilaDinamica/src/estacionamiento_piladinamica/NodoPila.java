package estacionamiento_piladinamica;
public class NodoPila {
    String novehiculo;
    int tiempo;
    NodoPila anterior;
    public NodoPila(String d ){
        novehiculo=d;
        anterior = null;
    }  

    public String getNovehiculo() {
        return novehiculo;
    }

    public void setNovehiculo(String novehiculo) {
        this.novehiculo = novehiculo;
    }

    public int getTiempo() {
        return tiempo;
    }

    public void setTiempo(int tiempo) {
        this.tiempo = tiempo;
    }

    public NodoPila getAnterior() {
        return anterior;
    }

    public void setAnterior(NodoPila anterior) {
        this.anterior = anterior;
    }

    
}
