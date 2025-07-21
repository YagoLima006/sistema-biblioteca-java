package model.entities;

import java.time.LocalDate;

public class Ebook extends Livro
{
    private String localizacao;
    private Double tamanhoArquivo;
    private String formatoArquivo;


    public Ebook(String titulo, String autor, String descricao, String isbn, Integer numeroDePaginas, LocalDate date, String formatoArquivo, Double tamanhoArquivo, String localizacao)
    {
        super(titulo, autor, descricao, isbn, numeroDePaginas, true, date, null);
        this.formatoArquivo = formatoArquivo;
        this.tamanhoArquivo = tamanhoArquivo;
        this.localizacao = localizacao;
    }

    public String getLocalizacao()
    {
        return localizacao;
    }

    public void setLocalizacao(String localizacao)
    {
        this.localizacao = localizacao;
    }

    public Double getTamanhoArquivo()
    {
        return tamanhoArquivo;
    }

    public void setTamanhoArquivo(Double tamanhoArquivo)
    {
        this.tamanhoArquivo = tamanhoArquivo;
    }

    public String getFormatoArquivo()
    {
        return formatoArquivo;
    }

    public void setFormatoArquivo(String formatoArquivo)
    {
        this.formatoArquivo = formatoArquivo;
    }

    @Override
    public void exibirDetalhesLivro()
    {
        System.out.println("---Ebook---");
        System.out.println("Título do livro: " +getTitulo());
        System.out.println("Autor: " +getAutor());
        System.out.println("Número de páginas: " +getNumeroDePaginas());
        System.out.println("Formato do arquivo: " +getFormatoArquivo());
        System.out.println("Tamanho do arquivo: " +getTamanhoArquivo()+ "MB");
        System.out.println("Localização do livro: " +getLocalizacao());
        System.out.println(" Descrição do livro: " +getDescricao());
        System.out.println("Data que o livro foi pego: " +getDate());
        System.out.println("Disponível: " + (getDisponivel() ? "Sim" : "Não"));
    }
}
