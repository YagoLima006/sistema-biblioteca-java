package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class LivroImpresso extends Livro
{
    private String localizacao;


    public LivroImpresso(String titulo, String autor, String descricao, String isbn, Integer numeroDePaginas, LocalDate date, String localizacao) {
        super(titulo, autor, descricao, isbn, numeroDePaginas, true, date, null);
        this.localizacao = localizacao;
    }

    public String getLocalizacao() {
        return localizacao;
    }

    public void setLocalizacao(String localizacao) {
        this.localizacao = localizacao;
    }

    @Override
    public void exibirDetalhesLivro() {
        System.out.println("--- Livro Impresso ---");
        System.out.println("Título: " + getTitulo());
        System.out.println("Autor: " + getAutor());
        System.out.println("Páginas: " + getNumeroDePaginas());
        System.out.println("Localização: " + getLocalizacao());
        System.out.println("Disponível: " + (getDisponivel() ? "Sim" : "Não"));
    }
}
