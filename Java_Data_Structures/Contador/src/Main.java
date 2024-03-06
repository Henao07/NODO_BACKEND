public class Main {

    public static void main(String[] args) {
        Contador contador = new Contador();

        System.out.println("Valor inicial: " + contador.getValor());

        contador.incrementar();
        contador.incrementar();

        System.out.println("Valor después de dos incrementos: " + contador.getValor());

        contador.decrementar();

        System.out.println("Valor después de un decremento: " + contador.getValor());
    }
}

class Contador {

    private int valor;

    public Contador() {
        this.valor = 0;
    }

    public Contador(int valor) {
        this.valor = valor;
    }

    public Contador(Contador otroContador) {
        this.valor = otroContador.valor;
    }

    public void incrementar() {
        this.valor++;
    }

    public void decrementar() {
        this.valor--;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    @Override
    public String toString() {
        return "Contador{" +
                "valor=" + valor +
                '}';
    }
}
