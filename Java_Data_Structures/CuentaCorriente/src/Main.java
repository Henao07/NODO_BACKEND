public class Main {

    public static void main(String[] args) {
        CuentaCorriente cuentaCorriente1 = new CuentaCorriente(12345, 1000.0);
        CuentaCorriente cuentaCorriente2 = new CuentaCorriente(54321, 500.0);

        System.out.println("Saldo inicial cuenta 1: " + cuentaCorriente1.getSaldo());
        System.out.println("Saldo inicial cuenta 2: " + cuentaCorriente2.getSaldo());

        cuentaCorriente1.transferir(cuentaCorriente2, 300.0);

        System.out.println("Saldo después de la transferencia:");
        System.out.println("Cuenta 1: " + cuentaCorriente1.getSaldo());
        System.out.println("Cuenta 2: " + cuentaCorriente2.getSaldo());
    }
}

class CuentaCorriente {

    private int numero;
    private double saldo;

    public CuentaCorriente() {
        this.numero = 0;
        this.saldo = 0.0;
    }

    public CuentaCorriente(int numero, double saldo) {
        this.numero = numero;
        this.saldo = saldo;
    }

    public void ingresar(double cantidad) {
        this.saldo += cantidad;
    }

    public void egresar(double cantidad) {
        if (cantidad <= this.saldo) {
            this.saldo -= cantidad;
        } else {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    public void reintegrar(double cantidad) {
        this.saldo += cantidad;
    }

    public void transferir(CuentaCorriente cuentaDestino, double cantidad) {
        if (cantidad <= this.saldo) {
            this.saldo -= cantidad;
            cuentaDestino.ingresar(cantidad);
        } else {
            throw new RuntimeException("Saldo insuficiente");
        }
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    @Override
    public String toString() {
        return "CuentaCorriente{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                '}';
    }
}
