package model.entities;


import java.time.LocalDate;
import java.util.Objects;

public abstract class Livro
{
    protected String titulo;
    protected String autor;
    protected String descricao;
    protected String isbn;
    protected Integer numeroDePaginas;
    protected Boolean disponivel;
    protected LocalDate date;
    protected Usuario emprestadoPara;

    public Livro(String titulo, String autor, String descricao, String isbn, Integer numeroDePaginas, Boolean disponivel, LocalDate date, Usuario emprestadoPara) {
        this.titulo = titulo;
        this.autor = autor;
        this.descricao = descricao;
        this.isbn = isbn;
        this.numeroDePaginas = numeroDePaginas;
        this.disponivel = disponivel;
        this.date = date;
        this.emprestadoPara = emprestadoPara;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public void setNumeroDePaginas(Integer numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
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

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getNumeroDePaginas() {
        return numeroDePaginas;
    }

    public void setNumeroDePaginas(int numeroDePaginas) {
        this.numeroDePaginas = numeroDePaginas;
    }

    public boolean isDisponivel()
    {
        return disponivel;
    }

    public abstract void exibirDetalhesLivro();

    public void emprestar(Usuario usuario)
    {
        this.disponivel = false;
        this.emprestadoPara = usuario;
    }

    public void devolver()
    {
        this.disponivel = true;
        this.emprestadoPara = null;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Livro livro = (Livro) o;

        return Objects.equals(isbn, livro.isbn);
    }

    @Override
    public int hashCode() {
        return Objects.hash(isbn);
    }


}
