public class Main {
    public static void main(String[] args)
    {
        Libro libro1 = new Libro("Harry Potter", "9780545582889", "Rowling, J. K.", false);

        System.out.println(libro1.toString()); // Imprime: Harry Potter, 9780545582889, Rowling, J. K., Disponible

        libro1.prestar();

        System.out.println(libro1.toString()); // Imprime: Harry Potter, 9780545582889, Rowling, J. K., Prestado

        libro1.devolver();

        System.out.println(libro1.toString()); // Imprime: Harry Potter, 9780545582889, Rowling, J. K., Disponible
    }
}
class Libro {

    private String titulo;
    private String isbn;
    private String autor;
    private boolean prestado;

    public Libro() {
        this("", "", "", false);
    }

    public Libro(String titulo, String isbn, String autor, boolean prestado) {
        this.titulo = titulo;
        this.isbn = isbn;
        this.autor = autor;
        this.prestado = prestado;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getAutor() {
        return autor;
    }

    public void setAutor(String autor) {
        this.autor = autor;
    }

    public boolean isPrestado() {
        return prestado;
    }

    public void setPrestado(boolean prestado) {
        this.prestado = prestado;
    }

    public boolean prestar() {
        if (prestado) {
            return false;
        }
        prestado = true;
        return true;
    }

    public boolean devolver() {
        if (!prestado) {
            return false;
        }
        prestado = false;
        return true;
    }

    @Override
    public String toString() {
        return String.format("%s, %s, %s, %s", titulo, isbn, autor, prestado ? "Prestado" : "Disponible");
    }
}
