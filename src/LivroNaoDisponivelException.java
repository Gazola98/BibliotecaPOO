public class LivroNaoDisponivelException extends RuntimeException {

    public LivroNaoDisponivelException(String mensagem) {
        super(mensagem);
    }
}