import model.Aluno;
import model.Livro;
import model.Professor;
import model.Usuario;
import service.BibliotecaService;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        BibliotecaService bibliotecaService = new BibliotecaService();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Bem-vindo à Biblioteca! Escolha uma opção:");
            System.out.println("1. Cadastrar livro");
            System.out.println("2. Cadastrar usuário");
            System.out.println("3. Emprestar livro");
            System.out.println("4. Devolver livro");
            System.out.println("5. Consultar disponibilidade");
            System.out.println("6. Sair");

            int opcao = scanner.nextInt();
            scanner.nextLine(); // Consumir a nova linha

            switch (opcao) {
                case 1:
                    System.out.println("Digite o título do livro:");
                    String titulo = scanner.nextLine();
                    System.out.println("Digite o autor do livro:");
                    String autor = scanner.nextLine();
                    System.out.println("Digite o gênero do livro:");
                    String genero = scanner.nextLine();
                    System.out.println("Digite o ano de publicação:");
                    int anoPublicacao = scanner.nextInt();
                    Livro livro = new Livro(titulo, autor, genero, anoPublicacao);
                    bibliotecaService.cadastrarLivro(livro);
                    break;

                case 2:
                    System.out.println("Digite o nome do usuário:");
                    String nome = scanner.nextLine();
                    System.out.println("Digite o ID do usuário:");
                    String id = scanner.nextLine();
                    System.out.println("Digite o tipo de usuário (1 para Aluno, 2 para Professor):");
                    int tipoUsuario = scanner.nextInt();
                    Usuario usuario;
                    if (tipoUsuario == 1) {
                        usuario = new Aluno(nome, id);
                    } else {
                        usuario = new Professor(nome, id);
                    }
                    bibliotecaService.cadastrarUsuario(usuario);
                    break;

                case 3:
                    System.out.println("Digite o título do livro:");
                    titulo = scanner.nextLine();
                    System.out.println("Digite o ID do usuário:");
                    id = scanner.nextLine();
                    bibliotecaService.emprestarLivro(titulo, id);
                    break;

                case 4:
                    System.out.println("Digite o título do livro:");
                    titulo = scanner.nextLine();
                    System.out.println("Digite o ID do usuário:");
                    id = scanner.nextLine();
                    bibliotecaService.devolverLivro(titulo, id);
                    break;

                case 5:
                    System.out.println("Digite o título do livro:");
                    titulo = scanner.nextLine();
                    bibliotecaService.consultarDisponibilidade(titulo);
                    break;

                case 6:
                    System.out.println("Saindo...");
                    scanner.close();
                    return;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        }
    }
}
