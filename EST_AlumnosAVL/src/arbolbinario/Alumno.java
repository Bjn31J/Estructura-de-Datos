package arbolbinario;

import java.util.Arrays;

public class Alumno implements Comparable {

    private String nombre;
    private int numControl;
    private int calificacion[];

    public Alumno(String nombre, int numControl, int[] calificacion) {
        this.nombre = nombre;
        this.numControl = numControl;
        this.calificacion = calificacion;
    }

    public Alumno(int numControl) {
        this.numControl = numControl;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getNumControl() {
        return numControl;
    }

    public void setNumControl(int numControl) {
        this.numControl = numControl;
    }

    public int[] getCalificacion() {
        return calificacion;
    }

    public void setCalificacion(int[] calificacion) {
        this.calificacion = calificacion;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(nombre);
        sb.append(",").append(numControl);
        sb.append(",").append(Arrays.toString(calificacion));
        sb.append("\n");
        return sb.toString();
    }

    @Override
    public int compareTo(Object o) {
        if (this.getNumControl() > ((Alumno) o).getNumControl()) {
            return 1;
        }else if (this.getNumControl() < ((Alumno) o).getNumControl()) {
            return -1;
        }else {
            return 0;
        }
    }

}
