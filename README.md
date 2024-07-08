
Sistema de Biblioteca em Java:

Este projeto é um sistema básico de biblioteca desenvolvido em Java. Ele permite o cadastro de livros e usuários (alunos e professores), além de gerenciar empréstimos e devoluções de livros, bem como consultar a disponibilidade dos livros. O sistema foi projetado utilizando conceitos de Programação Orientada a Objetos (POO).

Funcionalidades:

Cadastro de Livros:
Permite cadastrar novos livros na biblioteca, informando título, autor, gênero e ano de publicação.

Cadastro de Usuários:
Permite cadastrar novos usuários da biblioteca, que podem ser alunos ou professores.

Empréstimo de Livros:
Permite realizar o empréstimo de livros para usuários cadastrados, verificando a disponibilidade dos livros.

Devolução de Livros:
Permite a devolução de livros emprestados, atualizando a disponibilidade dos mesmos.

Consulta de Disponibilidade:
Permite consultar se um determinado livro está disponível na biblioteca.

Estrutura do Projeto:
O projeto está organizado nas seguintes classes e pacotes:

model/: Contém as classes que representam os dados do sistema.

Livro: Representa um livro na biblioteca.
Usuario: Classe abstrata que representa um usuário da biblioteca.
Aluno: Representa um aluno, estendendo a classe Usuario.
Professor: Representa um professor, estendendo a classe Usuario.
Emprestimo: Representa um empréstimo de um livro para um usuário.
service/: Contém a classe que gerencia as operações da biblioteca.

BibliotecaService: Gerencia a lógica de negócio da biblioteca.
