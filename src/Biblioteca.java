import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

public class Biblioteca {
    private List<Livro> livros;
    private List<Usuario> usuarios;
    private List<Emprestimo> emprestimos;

    public Biblioteca() {
        this.livros = new ArrayList<>();
        this.usuarios = new ArrayList<>();
        this.emprestimos = new ArrayList<>();
    }

    public void adicionarLivro(Livro livro) {
        livros.add(livro);
    }

    public void adicionarUsuario(Usuario usuario) {
        usuarios.add(usuario);
    }

    public void adicionarEmprestimo(Emprestimo emprestimo) {
        emprestimos.add(emprestimo);
    }

    public Livro buscarLivro(int id) {
        for (Livro livro : livros) {
            if(livro.getId() == id) {
                return livro;
            }
        }
            return null;
    }

    public List<Livro> getLivros() {
        return livros;
    }

    public Usuario buscarUsuario(int id) {
        for (Usuario usuario : usuarios) {
            if(usuario.getId() == id) {
                return usuario;
            }
        }
        return null;
    }

    public void listarLivrosDisponiveis() {
        for (Livro livro : livros) {
            if(livro.isDisponivel()) {
                System.out.println(livro);
            }
        }
    }

    public Emprestimo buscarEmprestimo(int idLivro) {
        for (Emprestimo emprestimo : emprestimos) {
            if(emprestimo.getLivro().getId() == idLivro) {
                return emprestimo;
            }
        }
        return null;
    }

    public void emprestarLivro(int idLivro, int idUsuario) {
        Livro livro = buscarLivro(idLivro);
        if(livro == null) {
            System.out.println("Não existe nenhum livro com o id informado");
            return;
        }
        Usuario usuario = buscarUsuario(idUsuario);
        if(usuario == null) {
            System.out.println("Não existe nenhum usuário com o id informado");
            return;
        }
        if(!livro.isDisponivel()) {
            System.out.println("O livro não esta disponível para empréstimo");
            return;
        }

        LocalDate diaEmprestimo = LocalDate.now();
        LocalDate devolucao = diaEmprestimo.plusDays(7);

        Emprestimo emprestimo = new Emprestimo(livro, usuario, diaEmprestimo, devolucao);

        livro.emprestar();
        emprestimos.add(emprestimo);
    }

    public void devolverLivro(int idLivro) {
        Emprestimo emprestimo = buscarEmprestimo(idLivro);

        if(emprestimo == null) {
            System.out.println("Não existe nenhum empréstimo para esse livro!");
            return;
        }
        Livro livro = emprestimo.getLivro();

        livro.devolver();
        emprestimos.remove(emprestimo);
    }

    public List<Usuario> getUsuarios() {
        return usuarios;
    }

    public List<Emprestimo> getEmprestimos() {
        return emprestimos;
    }
}
