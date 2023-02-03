package est_coladinamicasentinela;
public class Est_colaDinamicaCentinela {
    ColaDC cola1;
    public static void main(String[] args) {
        Est_colaDinamicaCentinela cd=new Est_colaDinamicaCentinela();
        cd.ejecuta();
      }
    Est_colaDinamicaCentinela(){
        cola1=new ColaDC();
    }
    public void ejecuta(){
        for (int i=1;i<=10;i++){
            cola1.inserta(new Nodo(i));
        }
        //this.imprimeIterativo();
        //this.imprimeRecursivo();
        this.imprimeInverso();
    }
    public void imprimeIterativo(){
        Nodo n;
        n=cola1.suprimir();
        while(n!=null){
            System.out.println(n.getDato());
            n=cola1.suprimir();
        }
    }
    public void imprimeRecursivo(){
        if(!cola1.vacia()){
            Nodo aux= cola1.suprimir();
            System.out.println(aux.getDato());
            imprimeRecursivo();
        }
    }
    public void imprimeInverso(){
        if(!cola1.vacia()){
            Nodo aux= cola1.suprimir();
            imprimeInverso();
            System.out.println(aux.getDato());
        }
    }
}
