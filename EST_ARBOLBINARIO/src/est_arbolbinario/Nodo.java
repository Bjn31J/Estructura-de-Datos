package est_arbolbinario;
public class Nodo {
    public Nodo izq;
    public int num;
    private int altura;
    private int fe;
    public Nodo der;
    Nodo(int num){
        this.num=num;
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

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
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
   public void escribe(){
       System.out.println(this.num);
   }

    
}
