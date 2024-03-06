import java.util.Scanner;
public class Main {
    public static void main(String[] args)
    {
        Scanner scanner = new Scanner(System.in);

        // Pedir al usuario que elija qué tipo de operación desea realizar
        System.out.println("Seleccione la operación que desea realizar:");
        System.out.println("1. Suma");
        System.out.println("2. Resta");
        System.out.println("3. Multiplicación");
        System.out.println("4. División");
        int opcion = scanner.nextInt();

        // Pedir al usuario que ingrese los dos operandos
        System.out.println("Introduzca el primer operando (formato: numerador/denominador o solo número): ");
        String input1 = scanner.nextLine();

        System.out.println("Introduzca el segundo operando (formato: numerador/denominador o solo número): ");
        String input2 = scanner.nextLine();

        try {
            // Convertir las entradas a objetos Fraccion
            Fraccion operando1 = ParseFraccion(input1);
            Fraccion operando2 = ParseFraccion(input2);

            // Realizar la operación seleccionada y mostrar el resultado
            Fraccion resultado = null;
            switch (opcion) {
                case 1:
                    resultado = operando1.sumar(operando2);
                    break;
                case 2:
                    resultado = operando1.restar(operando2);
                    break;
                case 3:
                    resultado = operando1.multiplicar(operando2);
                    break;
                case 4:
                    resultado = operando1.dividir(operando2);
                    break;
                default:
                    throw new RuntimeException("Opción no válida");
            }

            System.out.println("Resultado: " + resultado);
        } catch (RuntimeException e) {
            // Mostrar mensaje de error si hay algún problema al convertir las entradas o realizar las operaciones
            System.err.println("Error: " + e.getMessage());
        }
    }


    }

class Fraccion {

    private int numerador;
    private int denominador;

    public Fraccion(int numerador, int denominador) {
        this.numerador = numerador;
        this.denominador = denominador;
        simplificar();
    }

    public Fraccion(int numero) {
        this(numero, 1);
    }

    public int getNumerador() {
        return numerador;
    }

    public void setNumerador(int numerador) {
        this.numerador = numerador;
    }

    public int getDenominador() {
        return denominador;
    }

    public void setDenominador(int denominador) {
        this.denominador = denominador;
        simplificar();
    }

    private void simplificar() {
        int mcd = maximoComunDivisor(numerador, denominador);
        numerador /= mcd;
        denominador /= mcd;
    }

    private int maximoComunDivisor(int a, int b) {
        if (b == 0) {
            return a;
        }
        return maximoComunDivisor(b, a % b);
    }

    public Fraccion sumar(Fraccion otraFraccion) {
        int nuevoNumerador = (this.numerador * otraFraccion.denominador)
                + (otraFraccion.numerador * this.denominador);
        int nuevoDenominador = this.denominador * otraFraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion sumar(int numero) {
        return sumar(new Fraccion(numero));
    }

    public Fraccion restar(Fraccion otraFraccion) {
        int nuevoNumerador = (this.numerador * otraFraccion.denominador)
                - (otraFraccion.numerador * this.denominador);
        int nuevoDenominador = this.denominador * otraFraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion restar(int numero) {
        return restar(new Fraccion(numero));
    }

    public Fraccion multiplicar(Fraccion otraFraccion) {
        int nuevoNumerador = this.numerador * otraFraccion.numerador;
        int nuevoDenominador = this.denominador * otraFraccion.denominador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion multiplicar(int numero) {
        return multiplicar(new Fraccion(numero));
    }

    public Fraccion dividir(Fraccion otraFraccion) {
        int nuevoNumerador = this.numerador * otraFraccion.denominador;
        int nuevoDenominador = this.denominador * otraFraccion.numerador;
        return new Fraccion(nuevoNumerador, nuevoDenominador);
    }

    public Fraccion dividir(int numero) {
        return dividir(new Fraccion(numero));
    }

    public ParseFraccion parseFraccion(String input) {
        try {
            if (input.contains("/")) {
                String[] partes = input.split("[/]");
                int numerador = Integer.parseInt(partes[0]);
                int denominador = Integer.parseInt(partes[1]);
                if (denominador == 0) {
                    throw new RuntimeException("El denominador no puede ser 0");
                }
                return new Fraccion(numerador, denominador);
            } else {
                int numero = Integer.parseInt(input);
                return new Fraccion(numero);
            }
        } catch (NumberFormatException e) {
            throw new RuntimeException("Entrada no válida: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return String.format("%d/%d", numerador, denominador);
    }
}