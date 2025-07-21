package model.entities;

import java.time.LocalDate;


public class Emprestimo
{
    private final Livro livro;
    private final Usuario usuario;
    private final LocalDate dataEmprestimo;
    private final LocalDate dataDevolucaoPrevista;
    private boolean ativo;

    public Emprestimo(Livro livro, Usuario usuario, int diasParaDevolucao) {
        this.livro = livro;
        this.usuario = usuario;
        this.dataEmprestimo = LocalDate.now();
        this.dataDevolucaoPrevista = this.dataEmprestimo.plusDays(diasParaDevolucao);
        this.ativo = true;
    }

    // --- Getters para acessar os dados do empréstimo ---
    public Livro getLivro() {
        return livro;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public LocalDate getDataEmprestimo() {
        return dataEmprestimo;
    }

    public LocalDate getDataDevolucaoPrevista() {
        return dataDevolucaoPrevista;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void encerrarEmprestimo() {
        this.ativo = false;
        // Também devemos atualizar o estado do livro associado
        this.livro.devolver();
    }

    public void exibirDetalhesEmprestimo() {
        System.out.println("--- Detalhes do Empréstimo ---");
        System.out.println("Livro: " + this.livro.getTitulo() + " (Autor: " + this.livro.getAutor() + ")");
        System.out.println("Usuário: " + this.usuario.getName() + " (Código: " + this.usuario.getCodigo() + ")");
        System.out.println("Data do Empréstimo: " + this.dataEmprestimo);
        System.out.println("Data de Devolução Prevista: " + this.dataDevolucaoPrevista);
        System.out.println("Status: " + (this.ativo ? "Em andamento" : "Finalizado"));
        System.out.println("------------------------------");
    }
}