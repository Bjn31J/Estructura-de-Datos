package estacionamiento_piladinamica;
import javax.swing.JOptionPane;
public class Estacionamiento_PilaDinamica {
    public static void main(String[] args) {
        int opcion = 0;
        String elemento;
        Pila pil=new Pila();
        try{
            do {    
                opcion=Integer.parseInt(JOptionPane.showInputDialog(null,
                        "1. Ingresar un vehiculo\n"
                                + "2. Sacar un vehiculo\n"
                                + "3. ¿El estacionamiento esta vacio?\n"
                                + "4. ¿Qué vehiculo esta en la cima?\n"
                                + "5. Tamaño del estacionamiento\n"
                                + "6. Vaciar estacionamiento\n"
                                + "7. Mostrar vehiculos\n"
                                + "8. Salir\n"
                                + "Que deseas hacer?","Menu de Opciones"));
                switch(opcion){
                    case 1:
                        elemento =JOptionPane.showInputDialog(null,
                                "Ingresa vehiculo en la pila","Apilando vehiculos",
                                JOptionPane.INFORMATION_MESSAGE);
                        pil.insertar(elemento);
                    break;
                    case 2:
                        if (!pil.estaVacia()) {
                            
                            JOptionPane.showMessageDialog(null, "El vehiculo obtenido es: " + pil.sacar(),
                                    "Obteniendo datos del estacionamiento",JOptionPane.INFORMATION_MESSAGE);
                            
                        } else {
                            JOptionPane.showMessageDialog(null, "El  estacionamiento esta vacio","Error",JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case 3:
                        if (pil.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "El estacionamiento vacio",
                                    "Vacio",JOptionPane.INFORMATION_MESSAGE);
                        } else {
                            JOptionPane.showMessageDialog(null, "El estacionamiento contiene vehiculos",
                                    "Tiene vehiculos",JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case 4:
                         if (!pil.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "El vehiculo que esta en la cima es: " + pil.tope(),
                                    "Cima",JOptionPane.INFORMATION_MESSAGE);   
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Estacionamiento vacio",
                                    "Vacia",JOptionPane.INFORMATION_MESSAGE);
                        }  
                    break;
                    case 5:
                         JOptionPane.showMessageDialog(null, "El tamaño del estacionamiento es "+pil.tamañoPila(),
                                    "Tamaño de la Pila",JOptionPane.INFORMATION_MESSAGE);   
                    break;
                    case 6:
                        if(!pil.estaVacia()){
                            pil.limpiarPila();
                            JOptionPane.showMessageDialog(null, "El estacionamiento esta  vacio ",
                                    "Vaciando pila",JOptionPane.INFORMATION_MESSAGE);  
                        }else{
                             JOptionPane.showMessageDialog(null, "El estacionamiento vacio, No hay nada que vaciar",
                                    "Vacia",JOptionPane.INFORMATION_MESSAGE);
                        }
                    break;
                    case 7:
                         if (!pil.estaVacia()) {
                            JOptionPane.showMessageDialog(null, "Los vehiculos son: " + pil.mostrarPila(),
                                    "Vehiculos",JOptionPane.INFORMATION_MESSAGE); 
                            
                        } else {
                            
                            JOptionPane.showMessageDialog(null, "Estacionamiento vacio",
                                    "Vacia",JOptionPane.INFORMATION_MESSAGE);
                        }  
                       
                    break; 
                    case 8:
                        JOptionPane.showMessageDialog(null, "Saliendo","Programa Terminado",JOptionPane.INFORMATION_MESSAGE);
                        break;
                }
            } while (opcion!=8);
        }catch(Exception e){
            System.out.println("Error"+e.getMessage());
        }}}
    
    

