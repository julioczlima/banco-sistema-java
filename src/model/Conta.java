package model;

public class Conta {
    private int numero;
    private double saldo;
    private Cliente titular;

    // TODO métodos depositar, transferir e sacar

    public Conta() {
    }

    public Conta(Cliente titular) {
        this.titular = titular;
        this.saldo = 0;
    }

    public Conta(Cliente titular, int numero) {
        super();
        this.titular = titular;
        this.numero = numero+1;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor) {
        this.saldo += valor;
    }

    public void sacar(double valor) {
        if (saldo >= valor
                && saldo > 0
                && saldo - valor >= 0) {
            this.saldo -= valor;
        }
    }

    @Override
    public String toString() {
        return "Conta{" +
                "numero=" + numero +
                ", saldo=" + saldo +
                ", titular=" + titular +
                '}';
    }
}
