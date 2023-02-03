package est_listaalumnosavl;
public class Nodo {
    public Nodo izq;
    public int numN;
    public String nombre;
    private int altura;
    private int fe;
    public Nodo der;
    int nCont;
    Nodo(int numN, String nombre){
        this.numN=numN;
        this.nombre=nombre;
        this.altura=1;
        this.fe=0;
        this.izq=null;
        this.der=null;
    }
    public Nodo getIzq() {
        return izq;
    }

    public void setIzq(Nodo izq) {
        this.izq = izq;
    }

    public int getNumN() {
        return numN;
    }

    public void setNumN(int numN) {
        this.numN = numN;
    }

    public int getAltura() {
        return altura;
    }

    public void setAltura(int altura) {
        this.altura = altura;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int fe) {
        this.fe = fe;
    }

    public Nodo getDer() {
        return der;
    }

    public void setDer(Nodo der) {
        this.der = der;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    

    void escribe() {
        System.out.println(this.numN);
    }

   

    
}
