package model;

import exceptions.SaqueInvalidoException;

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

    public void sacar(double valor) throws SaqueInvalidoException {

        if (this.saldo == 0) {
            throw new SaqueInvalidoException("A conta deve possuir algum valor para conseguir sacar.");
        } else if (valor < 0) {
            throw new SaqueInvalidoException("O valor a ser sacado deve ser superior a zero.");
        } else if (this.saldo < valor) {
            throw new SaqueInvalidoException("O valor a ser sacado não pode ultrapassar o valor do saldo.");
        } else if (this.saldo - valor < 0) {
            throw new SaqueInvalidoException("O valor do saque não pode deixar o saldo negativo.");
        } else {
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
