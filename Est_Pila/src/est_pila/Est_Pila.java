package est_pila;
import javax.swing.JOptionPane;
//Pilas Dinamicas 
public class Est_Pila{ 
    public static void main(String[] args) {
        int opcion = 0,elemento=0;
        Pila pil=new Pila();
        try{
            do {    
                opcion=Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Empujar un elemento de la pila\n"
                                + "2. Sacar un elemento de la pila\n"
                                + "3. ¿La pila está vacia?\n"
                                + "4. ¿Qué elemento esta en la cima?\n"
                                + "5. Tamaño de la pila\n"
                                + "6. Vaciar pila\n"
                                + "7. Salir\n"
                                + "Que deseas hacer?","Menu de Opciones"));
                switch(opcion){
                    case 1:
                        elemento = Integer.parseInt(JOptionPane.showInputDialog(null,
                                "Ingresa el elemento a empujar en la pila","Apilando Datos",
                                JOptionPane.INFORMATION_MESSAGE));
                        pil.insertar(elemento);
                    break;
                    case 2:
                        if (!pil.estaVacia()) {
                            
                            JOptionPane.showMessageDialog(null, "El elemento obtenido es: " + pil.sacar(),
                                    "Obteniendo datos de la pila",JOptionPane.INFORMATION_MESSAGE);
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila esta vacia","Error",JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case 3:
                        if (pil.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "La pila está vacia",
                                    "Vacia",JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "La pila contiene datos",
                                    "Tiene datos",JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case 4:
                         if (!pil.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "El elemento que esta en la cima es: " + pil.tope(),
                                    "Cima",JOptionPane.INFORMATION_MESSAGE);   
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "La pila esta vacia",
                                    "Vacia",JOptionPane.INFORMATION_MESSAGE);
                        }  
                    break;
                    case 5:
                         JOptionPane.showMessageDialog(null, "El tamaño de la pila es "+pil.tamañoPila(),
                                    "Tamaño de la Pila",JOptionPane.INFORMATION_MESSAGE);   
                    break;
                    case 6:
                        if(!pil.estaVacia()){
                            pil.limpiarPila();
                            JOptionPane.showMessageDialog(null, "La pila se ha Vaciado ",
                                    "Vaciando pila",JOptionPane.INFORMATION_MESSAGE);  
                        }else{
                             JOptionPane.showMessageDialog(null, "La pila esta vacia, No hay nada que vaciar",
                                    "Vacia",JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case 7:
                       JOptionPane.showMessageDialog(null, "Saliendo","Programa Terminado",JOptionPane.INFORMATION_MESSAGE);
                    break;              
                }
            } while (opcion!=7);
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }}}
    

    

