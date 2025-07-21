package model.services;

import model.entities.Emprestimo;
import model.entities.Livro;
import model.entities.Usuario;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BibliotecaServices
{
    private  List<Usuario> usuarios;
    private List<Livro> livros;
    private List<Emprestimo> emprestimos;

    public BibliotecaServices() {
        this.usuarios = new ArrayList<>();
        this.livros = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }


    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public void adicionarUsuario(Usuario usuario)
    {
        if(usuario == null)
        {
            System.out.println("Usuário nao pode nulo. ");
            return;
        }
        if(usuarios.contains(usuario))
        {
            System.out.println("Erro: usuário com codigo ja existente: " +usuario.getCodigo());
            return;

        }
        usuarios.add(usuario);
        System.out.println("Usuário adicionado com sucesso: " + usuario.getName());

    }

    public boolean adicionarLivro(Livro livro)
    {
        if(livro == null)
        {
            System.out.println("Livro não pode ser nulo.");
            return  false;
        }
        if(livros.contains(livro))
        {
            System.out.println("Erro: livro ja adicionado. " +livro.getTitulo());
            return false;

        }
        livros.add(livro);
        livro.exibirDetalhesLivro();
        return true;
    }

    public boolean removerLivro(Livro livro)
    {
        if(livro == null)
        {
            System.out.println("Livro não pode ser nulo.");
            return false;
        }
        if(livros.remove(livro))
        {
            System.out.println("Livro removido com sucesso: " +livro.getTitulo());
            return true;
        }
        System.out.println("Livro não encontrado no estoque.");
        return false;
    }

    public Optional<Usuario> buscarUsuarioPorCodigo(int codigo)
    {
        for (Usuario usuario : this.usuarios)
        {
            if (usuario.getCodigo() == codigo)
            {
                return Optional.of(usuario);
            }
        }
        return Optional.empty();
    }

    public Optional<Livro> buscarLivroPorTitulo(String titulo)
    {
        for (Livro livro : livros)
        {
            if (livro.getTitulo().equalsIgnoreCase(titulo))
            {
                return Optional.of(livro);
            }
        }
        return Optional.empty();
    }

    public void listarTodosOsLivros()
    {
        if(livros.isEmpty())
        {
            System.out.println("A biblioteca não possui livros no momento. ");
        }
        else
        {
            System.out.println("----Lista de livros na biblioteca----");
            for (Livro livro : livros)
            {
                livro.exibirDetalhesLivro();
                System.out.println("----------------------");
            }
        }
    }

    public int totalDeLivros()
    {
        return livros.size();
    }

    public void emprestarLivro(String tituloLivro, int codigoUsuario)
    {
        Optional<Usuario> usuarioOpt = buscarUsuarioPorCodigo(codigoUsuario); // Você precisará criar este método
        Optional<Livro> livroOpt = buscarLivroPorTitulo(tituloLivro);

        if (usuarioOpt.isEmpty())
        {
            System.out.println("Erro: Usuário com código " + codigoUsuario + " não encontrado.");
            return;
        }

        if (livroOpt.isEmpty())
        {
            System.out.println("Erro: Livro com título '" + tituloLivro + "' não encontrado.");
            return;
        }

        Livro livro = livroOpt.get();
        Usuario usuario = usuarioOpt.get();

        if (!livro.isDisponivel())
        {
            System.out.println("Erro: O livro '" + livro.getTitulo() + "' não está disponível para empréstimo.");
            return;
        }

        int diasParaDevolver = 14;
        Emprestimo novoEmprestimo = new Emprestimo(livro, usuario, diasParaDevolver );

        this.emprestimos.add(novoEmprestimo);

        livro.emprestar(usuario);

        System.out.println("Empréstimo realizado com sucesso!");
        System.out.println(novoEmprestimo);
    }

    public Optional<Emprestimo> buscarEmprestimoAtivoPorTitulo(String tituloLivro)
    {
        return this.emprestimos.stream()
                .filter(emprestimo ->
                        emprestimo.isAtivo() && emprestimo.getLivro().getTitulo().equalsIgnoreCase(tituloLivro))
                .findFirst();
    }

    public void devolverLivro(String tituloLivro)
    {
        Optional<Emprestimo> emprestimoOpt = buscarEmprestimoAtivoPorTitulo(tituloLivro);
        if(emprestimoOpt.isPresent())
        {
            Emprestimo emprestimoparaFinalizar = emprestimoOpt.get();

            emprestimoparaFinalizar.encerrarEmprestimo();
            System.out.println("O livro '" + tituloLivro + "' foi devolvido com sucesso!");
        }
        else
        {
            System.out.println("Erro: Não foi encontrado um empréstimo ativo para o livro '" + tituloLivro + "'.");
            System.out.println("Verifique se o título está correto ou se o livro já foi devolvido.");
        }
    }

    public void listarEmprestimosAtivos()
    {
        System.out.println("-----Emprestimos ativos-----");

        List<Emprestimo> ativos = this.emprestimos.stream().filter(Emprestimo::isAtivo).toList();

        if(ativos.isEmpty())
        {
            System.out.println("Nenhum livro encontrado. ");
        }
        else
        {
            for(Emprestimo emprestimo : ativos)
            {
                emprestimo.exibirDetalhesEmprestimo();
            }
        }
    }

    public void listarHistoricoDeEmprestimos()
    {
        System.out.println("----Historico completo de emprestimos----");

        if(this.emprestimos.isEmpty())
        {
            System.out.println("Nenhum empréstimo foi realizado ainda. ");
        }
        else
        {
            for(Emprestimo emprestimo : this.emprestimos)
            {
                emprestimo.exibirDetalhesEmprestimo();
            }
        }
    }

}
