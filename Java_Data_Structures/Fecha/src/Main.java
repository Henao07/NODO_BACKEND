import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Fecha fecha = null;

        while (true) {
            // Pedir la fecha inicial
            System.out.println("Introduzca la fecha inicial (dd/mm/aaaa) o C para salir: ");
            String fechaStr = scanner.nextLine();

            if (fechaStr.equalsIgnoreCase("C")) {
                break;
            }

            try {
                // Validar la fecha inicial
                fecha = new Fecha(fechaStr);

                // Mostrar la fecha inicial
                System.out.println("Fecha inicial: " + fecha);

                // Sumar un día a la fecha
                fecha.sumarDia();

                // Mostrar la fecha después de sumar un día
                System.out.println("Fecha después de sumar un día: " + fecha);

                // Mostrar la fecha actual
                System.out.println("Fecha actual: " + fecha);
            } catch (RuntimeException e) {
                System.out.println("Fecha no válida: " + e.getMessage());
            }
        }

        System.out.println("Saliendo del programa...");
    }
}

class Fecha {

    private GregorianCalendar fecha;

    public Fecha(String fechaStr) {
        String[] partes = fechaStr.split("/");

        if (partes.length != 3) {
            throw new RuntimeException("Formato de fecha no válido");
        }

        int dia = Integer.parseInt(partes[0]);
        int mes = Integer.parseInt(partes[1]);
        int año = Integer.parseInt(partes[2]);

        if (!esFechaValida(dia, mes, año)) {
            throw new RuntimeException("Fecha no válida");
        }

        this.fecha = new GregorianCalendar(año, mes - 1, dia);
    }

    public boolean esFechaValida(int dia, int mes, int año) {
        return dia >= 1 && dia <= diasDelMes(mes, año) && mes >= 1 && mes <= 12 && año >= 1;
    }

    public int diasDelMes() {
        return diasDelMes(this.fecha.get(Calendar.MONTH) + 1, this.fecha.get(Calendar.YEAR));
    }

    private int diasDelMes(int mes, int año) {
        switch (mes) {
            case 1:
            case 3:
            case 5:
            case 7:
            case 8:
            case 10:
            case 12:
                return 31;
            case 4:
            case 6:
            case 9:
            case 11:
                return 30;
            case 2:
                if (esBisiesto(año)) {
                    return 29;
                } else {
                    return 28;
                }
            default:
                return 0;
        }
    }

    private boolean esBisiesto(int año) {
        return (año % 4 == 0) && ((año % 100 != 0) || (año % 400 == 0));
    }

    public void sumarDia() {
        this.fecha.add(Calendar.DAY_OF_MONTH, 1);
    }

    public int getDia() {
        return this.fecha.get(Calendar.DAY_OF_MONTH);
    }

    public void setDia(int dia) {
        if (esFechaValida(dia, this.fecha.get(Calendar.MONTH) + 1, this.fecha.get(Calendar.YEAR))) {
            this.fecha.set(Calendar.DAY_OF_MONTH, dia);
        } else {
            throw new RuntimeException("Fecha no válida");
        }
    }

    public int getMes() {
        return this.fecha.get(Calendar.MONTH) + 1;
    }

    public void setMes(int mes) {
        if (esFechaValida(this.fecha.get(Calendar.DAY_OF_MONTH), mes, this.fecha.get(Calendar.YEAR))) {
            this.fecha.set(Calendar.MONTH, mes - 1);
        } else {
            throw new RuntimeException("Fecha no válida");
        }
    }

    public int getAño() {
        return this.fecha.get(Calendar.YEAR);
    }

    public void setAño(int año) {
        if (esFechaValida(this.fecha.get(Calendar.DAY_OF_MONTH), this.fecha.get(Calendar.MONTH) + 1, año)) {
            this.fecha.set(Calendar.YEAR, año);
        } else {
            throw new RuntimeException("Fecha no válida");
        }
    }

    @Override
    public String toString() {
        return String.format("%02d/%02d/%04d", this.fecha.get(Calendar.DAY_OF_MONTH), this.fecha.get(Calendar.MONTH) + 1, this.fecha.get(Calendar.YEAR));
    }
}

