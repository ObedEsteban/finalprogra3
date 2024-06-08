package ejercicio3;


import java.util.Scanner;

public class Fibonacci2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Ingrese el primer número de la secuencia Fibonacci: ");
        int a = scanner.nextInt();
        System.out.print("Ingrese el segundo número de la secuencia Fibonacci: ");
        int b = scanner.nextInt();
        System.out.print("Ingrese la cantidad de números Fibonacci a generar: ");
        int n = scanner.nextInt();

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

        scanner.close();
    }
}
