package est_pilaestatica;

import java.util.Scanner;

public class Est_PilaEstatica {
    public static void main(String[] args) {
        pila pil= new pila(3);
        int a,b,c;
        Scanner sc=new Scanner(System.in);
        System.out.println("Ingresa el valor de a:");
        a=sc.nextInt();
        pil.push(a);
        System.out.println("Ingresa el valor de b:");
        b=sc.nextInt();
        pil.push(b);
        int sum;
        Object eliminar;
        sum=a+b;
        eliminar = pil.pop();//sacar
        System.out.println("eliminado B: "+eliminar);
        eliminar= pil.pop();
        System.out.println("eliminado A: "+eliminar);
        pil.push(sum);
        System.out.println("Ingresa el valor de c:");
        c=sc.nextInt();
        pil.push(c);//meter
        eliminar=pil.pop();
        System.out.println("Elimina c: "+eliminar);
        eliminar=pil.pop();
        System.out.println("Elimina suma: "+eliminar);
        pil.push(sum*c);
        pil.imprimir();
    }
}
