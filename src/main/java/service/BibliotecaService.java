package service;

import model.Livro;
import model.Usuario;
import model.Emprestimo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BibliotecaService {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public BibliotecaService() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void cadastrarLivro(Livro livro) {
        livros.add(livro);
    }

    public void cadastrarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void emprestarLivro(String titulo, String idUsuario) {
        Livro livro = buscarLivro(titulo);
        Usuario usuario = buscarUsuario(idUsuario);

        if (livro != null && usuario != null && livro.isDisponivel()) {
            livro.setDisponivel(false);
            Emprestimo emprestimo = new Emprestimo(livro, usuario, new Date(), null);
            emprestimos.add(emprestimo);
            System.out.println("Livro emprestado com sucesso!");
        } else {
            System.out.println("Empréstimo não pode ser realizado.");
        }
    }

    public void devolverLivro(String titulo, String idUsuario) {
        for (Emprestimo emprestimo : emprestimos) {
            if (emprestimo.getLivro().getTitulo().equals(titulo) && emprestimo.getUsuario().getId().equals(idUsuario) && emprestimo.getDataDevolucao() == null) {
                emprestimo.getLivro().setDisponivel(true);
                emprestimo = new Emprestimo(emprestimo.getLivro(), emprestimo.getUsuario(), emprestimo.getDataEmprestimo(), new Date());
                System.out.println("Livro devolvido com sucesso!");
                return;
            }
        }
        System.out.println("Devolução não pode ser realizada.");
    }

    public void consultarDisponibilidade(String titulo) {
        Livro livro = buscarLivro(titulo);
        if (livro != null) {
            if (livro.isDisponivel()) {
                System.out.println("O livro está disponível.");
            } else {
                System.out.println("O livro não está disponível.");
            }
        } else {
            System.out.println("Livro não encontrado.");
        }
    }

    private Livro buscarLivro(String titulo) {
        for (Livro livro : livros) {
            if (livro.getTitulo().equals(titulo)) {
                return livro;
            }
        }
        return null;
    }

    private Usuario buscarUsuario(String id) {
        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }
        return null;
    }
}
