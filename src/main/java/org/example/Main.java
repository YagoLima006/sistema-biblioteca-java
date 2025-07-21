package org.example;

import model.entities.*;



import model.enums.MateriasLivros;
import model.services.BibliotecaServices;

import java.time.LocalDate;
import java.util.InputMismatchException;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        BibliotecaServices biblioteca = new BibliotecaServices();

        popularDadosIniciais(biblioteca);

        int opcao = -1;

        while (opcao != 0) {
            exibirMenu();
            try {
                System.out.print("Escolha uma opção: ");
                opcao = scanner.nextInt();
                scanner.nextLine();

                switch (opcao) {
                    case 1:
                        adicionarNovoLivro(biblioteca, scanner);
                        break;
                    case 2:
                        adicionarNovoUsuario(biblioteca, scanner);
                        break;
                    case 3:
                        biblioteca.listarTodosOsLivros();
                        break;
                    case 4:
                        emprestarUmLivro(biblioteca, scanner);
                        break;
                    case 5:
                        devolverUmLivro(biblioteca, scanner);
                        break;
                    case 6:
                        biblioteca.listarEmprestimosAtivos();
                        break;
                    case 7:
                        biblioteca.listarHistoricoDeEmprestimos();
                        break;
                    case 0:
                        System.out.println("Obrigado por utilizar a Biblioteca Digital. Até logo!");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Erro: Por favor, digite um número válido para a opção.");
                scanner.nextLine();
                opcao = -1;
            }
            pressioneEnterParaContinuar(scanner);
        }

        scanner.close();
    }

    private static void exibirMenu() {
        System.out.println("\n--- BEM-VINDO À BIBLIOTECA DIGITAL ---");
        System.out.println("1. Adicionar Novo Livro");
        System.out.println("2. Adicionar Novo Usuário");
        System.out.println("3. Listar Todos os Livros");
        System.out.println("4. Emprestar um Livro");
        System.out.println("5. Devolver um Livro");
        System.out.println("6. Listar Empréstimos Ativos");
        System.out.println("7. Listar Histórico de Empréstimos");
        System.out.println("0. Sair do Sistema");
        System.out.println("------------------------------------");
    }

    private static void adicionarNovoLivro(BibliotecaServices biblioteca, Scanner scanner) {
        System.out.println("--- Adicionar Novo Livro ---");
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Autor: ");
        String autor = scanner.nextLine();
        System.out.print("ISBN: ");
        String isbn = scanner.nextLine();
        System.out.print("Descrição: ");
        String descricao = scanner.nextLine();
        System.out.print("Número de Páginas: ");
        int paginas = scanner.nextInt();
        scanner.nextLine(); // Limpa o buffer
        System.out.print("Localização (Ex: Prateleira A-3): ");
        String localizacao = scanner.nextLine();

        Livro novoLivro = new LivroImpresso(titulo, autor, descricao, isbn, paginas, LocalDate.now(), localizacao);
        biblioteca.adicionarLivro(novoLivro);
    }

    private static void adicionarNovoUsuario(BibliotecaServices biblioteca, Scanner scanner) {
        System.out.println("--- Adicionar Novo Usuário ---");
        System.out.print("Nome: ");
        String nome = scanner.nextLine();
        System.out.print("Código (numérico): ");
        int codigo = scanner.nextInt();
        scanner.nextLine();


        Usuario novoUsuario = new Aluno(nome, codigo, MateriasLivros.tecnologia);
        biblioteca.adicionarUsuario(novoUsuario);
    }

    private static void emprestarUmLivro(BibliotecaServices biblioteca, Scanner scanner) {
        System.out.println("--- Realizar Empréstimo ---");
        System.out.print("Digite o título do livro a ser emprestado: ");
        String titulo = scanner.nextLine();
        System.out.print("Digite o código do usuário: ");
        int codigo = scanner.nextInt();
        scanner.nextLine();

        biblioteca.emprestarLivro(titulo, codigo);
    }

    private static void devolverUmLivro(BibliotecaServices biblioteca, Scanner scanner) {
        System.out.println("--- Realizar Devolução ---");
        System.out.print("Digite o título do livro a ser devolvido: ");
        String titulo = scanner.nextLine();

        biblioteca.devolverLivro(titulo);
    }

    private static void pressioneEnterParaContinuar(Scanner scanner) {
        System.out.println("\nPressione ENTER para continuar...");
        scanner.nextLine();
    }

    private static void popularDadosIniciais(BibliotecaServices biblioteca) {
        Livro l1 = new LivroImpresso("O Senhor dos Anéis", "J.R.R. Tolkien", "A saga de Frodo para destruir o anel.", "978-0618640157", 1216, LocalDate.of(1954, 7, 29), "Ficção A-1");
        Livro l2 = new LivroImpresso("Código Limpo", "Robert C. Martin", "Um guia para o desenvolvimento ágil de software.", "978-8576082675", 464, LocalDate.of(2008, 8, 1), "Tecnologia B-2");
        Livro l3 = new LivroImpresso("1984", "George Orwell", "Uma distopia sobre vigilância e totalitarismo.", "978-0451524935", 328, LocalDate.of(1949, 6, 8), "Ficção C-3");

        biblioteca.adicionarLivro(l1);
        biblioteca.adicionarLivro(l2);
        biblioteca.adicionarLivro(l3);

        Usuario u1 = new Aluno("João Silva", 101, MateriasLivros.humanas);
        Usuario u2 = new Professor("Maria Oliveira", 202, MateriasLivros.exatas);

        biblioteca.adicionarUsuario(u1);
        biblioteca.adicionarUsuario(u2);

        System.out.println("Dados iniciais carregados com sucesso!");
    }
}

