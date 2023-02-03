package est_balanceopiladinamica;
import java.util.Scanner;
public class PilaDinamica {
    private NodoPila tope;
    int tamaño;
    //constructor
    public PilaDinamica() {
         tope=null;
          tamaño=0;
    }
    //Metodo para saber cuando la pila esta vacia
    public boolean estaVacia(){
        return tope==null;
    }
    //Metodo para insertar un elemento en la pila
    public void push(int elemento){
        NodoPila nuevo =new NodoPila(elemento);
        nuevo.siguiente=tope;
        tope=nuevo;
        tamaño++;   
    }
    //Metodo para sacar un elemento en la pila
    public char pop(){
        char aux=(char) tope.dato;
        tope=tope.siguiente;
        tamaño--;
        return aux;
    }
    //Metodo para saber quien esta en la cima de la pila
    public int tope(){
        return tope.dato;
    }
    //Metodo para saber el tamaño de la pila
    public int tamañoPila(){
        return tamaño;
    }
    //Metodo para limpiar (Vaciar la pila)
    public void limpiarPila(){
        while(!estaVacia()){
            pop();
        }
    }
    public void Balanceo(){
   Scanner sc=new Scanner(System.in);
   String entrada=sc.next();
   int tam=entrada.length();
   for (int i = 0; i < tam; i++) {
	  if (entrada.charAt(i) == '(') push(')');
	  else if (entrada.charAt(i) == '{') push('}');
	  else if (entrada.charAt(i) == '[') push(']');
	  else if (entrada.charAt(i) == ')') verifica(')');
	  else if (entrada.charAt(i) == '}') verifica('}');
	  else if (entrada.charAt(i) == ']') verifica(']');
      }
      if (estaVacia())
	  System.out.println("Parentesis balanceados");
      else 
	  System.out.println("Parentesis NO balanceados");	 
 }    
    
    public void verifica (char c) {
      if (estaVacia()) {
	  System.out.println("Parentesis NO balanceados"); 
	  System.exit(0); 
      } else {
	  Character s = (Character)pop();  
	  if (c != s) {
	      System.out.println("Parentesis NO balanceados"); 
	      System.exit(0); 
	  }
      }
  }    
}
