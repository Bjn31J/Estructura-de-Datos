package est_examen;
class Podadoras {
    String Serie,Serie2,Serie3;
    float precio=0;

    public float getPrecio() {
        return precio;
    }
    public void setPrecio(float precio) {
        this.precio = precio;
    }
    public Podadoras() {
        this.Serie="1A";
        this.Serie2 = "2A";
        this.Serie3 = "3A";
    }
    public String getSerie2() {
        return Serie2;
    }
    public void setSerie2(String Serie2) {
        this.Serie2 = Serie2;
    }
    public String getSerie3() {
        return Serie3;
    }
    public void setSerie3(String Serie3) {
        this.Serie3 = Serie3;
    }
    public String getSerie() {
        return Serie;
    }
    public void setSerie(String Serie) {
        this.Serie = Serie;
    }
}
