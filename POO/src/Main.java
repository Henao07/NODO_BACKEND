import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Pedir información por teclado
        System.out.println("Ingrese el nombre:");
        String nombre = scanner.nextLine();

        System.out.println("Ingrese la edad:");
        int edad = scanner.nextInt();

        System.out.println("Ingrese el sexo (H o M):");
        char sexo = scanner.next().charAt(0);

        System.out.println("Ingrese el peso:");
        double peso = scanner.nextDouble();

        System.out.println("Ingrese la altura:");
        double altura = scanner.nextDouble();

        // Crear objetos de la clase Persona
        Persona persona1 = new Persona(nombre, edad, sexo, peso, altura);
        Persona persona2 = new Persona(nombre, edad, sexo);
        Persona persona3 = new Persona();

        // Mostrar información y resultados
        System.out.println("\nInformación de la persona 1:");
        System.out.println(persona1.toString());
        mostrarResultados(persona1);

        System.out.println("\nInformación de la persona 2:");
        System.out.println(persona2.toString());
        mostrarResultados(persona2);

        System.out.println("\nInformación de la persona 3:");
        System.out.println(persona3.toString());
        mostrarResultados(persona3);
    }

    private static void mostrarResultados(Persona persona) {
        int resultadoIMC = persona.calcularIMC();
        String mensajeIMC = "";

        switch (resultadoIMC) {
            case -1:
                mensajeIMC = "Por debajo del peso ideal.";
                break;
            case 0:
                mensajeIMC = "En peso ideal.";
                break;
            case 1:
                mensajeIMC = "Con sobrepeso.";
                break;
        }

        String mensajeEdad = persona.esMayorDeEdad() ? "Es mayor de edad." : "No es mayor de edad.";

        System.out.println("Resultado IMC: " + mensajeIMC);
        System.out.println(mensajeEdad);
    }
}