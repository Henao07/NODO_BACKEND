public class Persona {
    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;

    // Constante para el sexo por defecto
    private static final char SEXO_POR_DEFECTO = 'H';

    // Constantes para el resultado de calcularIMC()
    private static final int BAJO_PESO_IDEAL = -1;
    private static final int PESO_IDEAL = 0;
    private static final int SOBREPESO = 1;

    // Constructor por defecto
    public Persona() {
        this("", 0, SEXO_POR_DEFECTO, 0, 0);
    }

    // Constructor con nombre, edad y sexo
    public Persona(String nombre, int edad, char sexo) {
        this(nombre, edad, sexo, 0, 0);
    }

    // Constructor con todos los atributos
    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = comprobarSexo(sexo);
        this.peso = peso;
        this.altura = altura;
        this.DNI = generaDNI();
    }

    // Métodos públicos

    public int calcularIMC() {
        double imc = peso / (altura * altura);

        if (imc < 20) {
            return BAJO_PESO_IDEAL;
        } else if (imc >= 20 && imc <= 25) {
            return PESO_IDEAL;
        } else {
            return SOBREPESO;
        }
    }

    public boolean esMayorDeEdad() {
        return edad >= 18;
    }

    public String toString() {
        return "Nombre: " + nombre +
                "\nEdad: " + edad +
                "\nDNI: " + DNI +
                "\nSexo: " + sexo +
                "\nPeso: " + peso +
                "\nAltura: " + altura;
    }

    // Métodos privados

    private char comprobarSexo(char sexo) {
        return (sexo == 'H' || sexo == 'M') ? sexo : SEXO_POR_DEFECTO;
    }

    private String generaDNI() {
        // Generar un número aleatorio de 8 cifras
        long numeroAleatorio = (long) (Math.random() * 90000000L) + 10000000L;

        // Calcular la letra correspondiente al número
        char letra = "TRWAGMYFPDXBNJZSQVHLCKE".charAt((int) (numeroAleatorio % 23));

        // Devolver el DNI completo
        return Long.toString(numeroAleatorio) + letra;
    }

    // Métodos set

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public void setSexo(char sexo) {
        this.sexo = comprobarSexo(sexo);
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }
}

