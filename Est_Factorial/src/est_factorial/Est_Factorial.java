package est_factorial;
public class Est_Factorial {
    static int num;
     public static void main(String[] args) {
     num=1;
     System.out.println("Factorial de :"+ num +" es : "+factorial(num));
    }
     static public int factorial(int num)
	{
            if(num==0)//caso de salida
                return 1;
            else return num*factorial(num-1);
	}
}
