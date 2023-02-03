package est_metodosordenamiento;

public class MetodosOrdenamiento {
    public int[] LlenarVector(int n) 
    {
        int[] vector = new int[n];    
        
        for (int i = 0; i < vector.length; i++)
        {
            int numA = (int)(Math.random()*((1000000+1)+1))+1;
            /*while(revisar(vector,numA,i)){
                numA = (int)(Math.random()*((1000000+1)+1))+1;
            }*/
            vector[i] = numA;
          
        }
        return vector;
    }
    public String imprimirVector(int[] vector) 
    {
        String res = "Elementos\n";      
        for (int i = 0; i < vector.length; i++) {
            res = res + vector[i] + "\n";
        }
        System.out.print(res);
        return res;     
    }
    public void ordenarBurbujaMejorado(int[] vec) {
        int aux = 0, i = 0;
        boolean cambio = false;
        while (i < vec.length - 1 && cambio == false) {
            cambio = true;
            for (int j = 0; j < vec.length - i - 1; j++) {
                if (vec[j] > vec[j + 1]) {
                    aux = vec[j];
                    vec[j] = vec[j + 1];
                    vec[j + 1] = aux;
                    cambio = false;
                }
            }
            i = i + 1;
        }
    }
    public void ordenarSeleccionDirecta(int[] vec) {
        int menor, posicion, temporal;
        int tam = vec.length;
        for (int i = 0; i < tam - 1; i++) {
            menor = vec[i];
            posicion = i;
            for (int j = i + 1; j < tam; j++) {
                if (vec[j] < menor) {
                    menor = vec[j];
                    posicion = j;
                }
            }
            if (posicion != i) {
                temporal = vec[i];
                vec[i] = vec[posicion];
                vec[posicion] = temporal;
            }
        }
    }
    public void MetodoInsercionSimple(int[] vec) {
        for (int i = 1; i < vec.length; i++) {
            int temp = vec[i];
            int po = i;
            while (po > 0 && vec[po - 1] > temp) {//Cambiar los valores a la derecha
                vec[po] = vec[po - 1];
                po--;
            }
            vec[po] = temp;
        }
    }
    public void OrdenamientoPorConteo(int[] vec) {
        int tam = vec.length;
        if (tam == 0) {
            return;
        }
        int max = vec[0], min = vec[0];
        for (int i = 1; i < tam; i++) {
            if (vec[i] > max) {
                max = vec[i];
            }
            if (vec[i] < min) {
                min = vec[i];
            }
        }
        int rango = max - min + 1;
        int[] cont = new int[rango];
        for (int i = 0; i < tam; i++) {
            cont[vec[i] - min]++;
        }
        for (int i = 1; i < rango; i++) {
            cont[i] += cont[i - 1];
        }
        int j = 0;
        for (int i = 0; i < rango; i++) {
            while (j < cont[i]) {
                vec[j++] = i + min;
            }
        }
    } 

    private boolean revisar(int[] vector, int numA,int cont) {
        for(int i=0;i<cont;i++){
            if(vector[i]==numA){
             return true;
            }
        }
        return false;
    }
}
