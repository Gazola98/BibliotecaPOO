import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Biblioteca novaBiblioteca = new Biblioteca();

        Livro livro1 = new Livro(1, "O pequeno príncipe", "934-232-1212-4");
        novaBiblioteca.adicionarLivro(livro1);

        boolean sairMenu = true;

        while (sairMenu) {
            System.out.println("=== BIBLIOTECA ===");
            System.out.println("1 - Cadastrar livro");
            System.out.println("2 - Cadastrar usuário");
            System.out.println("3 - Listar livros disponíveis");
            System.out.println("4 - Emprestar livro");
            System.out.println("5 - Devolver livro");
            System.out.println("6 - Listar Empréstimos");
            System.out.println("7 - Sair");

            System.out.print("Escolha uma opção: ");
            int opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o ID o livro: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o título: ");
                    String titulo = scanner.nextLine();

                    System.out.print("Digite o ISBN: ");
                    String isbn = scanner.nextLine();

                    Livro livro = new Livro(id, titulo, isbn);
                    novaBiblioteca.adicionarLivro(livro);
                    System.out.println("Livro adicionado com sucesso!");
                    break;
                case 2:
                    System.out.print("Digite o ID do usuário: ");
                    int idUsuario = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Digite o nome: ");
                    String nomeUsuario = scanner.nextLine();

                    System.out.print("Digite o email: ");
                    String email = scanner.nextLine();

                    Usuario usuario = new Usuario(idUsuario, nomeUsuario, email);
                    novaBiblioteca.adicionarUsuario(usuario);
                    System.out.println("Usuário adicionado com sucesso!");
                    break;
                case 3:
                    novaBiblioteca.listarLivrosDisponiveis();
                    break;
                case 4:
                    System.out.print("Digite o ID do livro: ");
                    int idLivro = scanner.nextInt();

                    System.out.print("Digite o ID do usuário: ");
                    int idUser = scanner.nextInt();

                    try {
                        novaBiblioteca.emprestarLivro(idLivro, idUser);
                    } catch (LivroNaoEncontradoException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 5:
                    System.out.print("Digite o ID do livro: ");
                    int iddevolucao = scanner.nextInt();

                    novaBiblioteca.devolverLivro(iddevolucao);
                    break;
                case 6:
                    for (Emprestimo emprestimo : novaBiblioteca.getEmprestimos()) {
                        System.out.println(emprestimo);
                    }
                    break;
                case 7:
                    System.out.println("Saindo do programa!");
                    sairMenu = false;
                    break;
            }
        }
    }
}