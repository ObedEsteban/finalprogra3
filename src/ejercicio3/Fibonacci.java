package ejercicio3;

public class Fibonacci {

    public static void main(String[] args) {
        int n = 10;
        int a = 2, b = 3;

        if (n == 0) {
            System.out.println("Secuencia Fibonacci: ");
        } else if (n == 1) {
            System.out.println("Secuencia Fibonacci: " + a);
        } else {
            System.out.print("Secuencia Fibonacci: " + a + ", " + b);
            if (n > 2) {
                for (int i = 2; i < n; i++) {
                    int siguiente = a + b;
                    System.out.print(", " + siguiente);
                    a = b;
                    b = siguiente;
                }
            }
        }
    }
}

