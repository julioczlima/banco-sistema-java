package exceptions;

public class ContaInvalidaException extends Exception {
    public ContaInvalidaException(String mensagem) {
        super(mensagem);


    }

    public ContaInvalidaException() {
        super("Conta Invalida");

    }
}
