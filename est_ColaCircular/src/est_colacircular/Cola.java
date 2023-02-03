package est_colacircular;
class Cola {
    private int frente,cFinal,digitosAgregados,tam;
    private int[] elementos;
    public Cola(int tam) {
        this.tam = tam;
        this.elementos= new int [this.tam];
        this.cFinal=0;
        this.frente=0;
        this.digitosAgregados=0;
    }
    private boolean estaVacia(){
       return digitosAgregados==0;
    }
    private boolean estaLlena(){
        return digitosAgregados==tam;
    }
    private int posicionNuevoElemento(){//Se calcula la posicion del elemento agregado
        int posicionNuevo;
        posicionNuevo=(frente+digitosAgregados)%tam;
        return posicionNuevo;
    }
    private void nuevaPosicionFrente(){
        frente=(frente+1)%tam;
    }
    public void agregarDatos(int dato){
        if(!estaLlena()){
            elementos[posicionNuevoElemento()]=dato;
            digitosAgregados++;
            if(cFinal<tam){
                cFinal++;
            }else{
                cFinal=0;
            }
        }else{
            System.out.println("Cola circular , LLENA");
        }
    }
    public int sacarElemento(){
        if (!estaVacia()){
            int datoSacado=elementos[frente];
            nuevaPosicionFrente();
            digitosAgregados--;
            return datoSacado;
        }else{
            System.out.println("NO hay Datos");
        }
        return Integer.MIN_VALUE;
    }
    public void imprimirDatos(){
        if(!estaVacia()){
            for(int i=frente;i<tam;i++){
                System.out.println(sacarElemento());
            }
            for(int i=0;i<cFinal+1 && estaVacia()==false;i++){
                System.out.println(sacarElemento());
            }}     
        }
   
    }
   
    
    
    
    

