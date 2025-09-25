package exceptions;

public class DadoInvalidoException extends Exception {
    public DadoInvalidoException(String s) {
        super(s);
    }

    public DadoInvalidoException() {
        super("O dado informado é invalido.");

    }
}
