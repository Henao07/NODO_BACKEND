import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Integer> numeros = new ArrayList<>();
        int numero;
        int suma = 0;
        int contador = 0;

        // Leer números hasta que se introduzca -99
        do {
            System.out.print("Introduzca un número (o -99 para terminar): ");
            numero = scanner.nextInt();
            if (numero != -99) {
                numeros.add(numero);
                suma += numero;
                contador++;
            }
        } while (numero != -99);

        // Calcular la media
        double media = (double) suma / contador;

        // Mostrar resultados
        System.out.println("Número de valores leídos: " + contador);
        System.out.println("Suma: " + suma);
        System.out.println("Media: " + media);

        // Mostrar los valores leídos y cuántos son mayores que la media
        int mayoresQueMedia = 0;
        for (int i = 0; i < numeros.size(); i++) {
            System.out.println(numeros.get(i));
            if (numeros.get(i) > media) {
                mayoresQueMedia++;
            }
        }
        System.out.println("Valores mayores que la media: " + mayoresQueMedia);
    }
}
