package model;

import exceptions.DepositoInvalidoException;
import exceptions.SaqueInvalidoException;
import exceptions.TransferenciaInvalidaException;

public class Conta {
    private int numero;
    private double saldo;
    private Cliente titular;
    private static int contador = 1;


    public Conta() {
    }

    public Conta(Cliente titular) {
        super();
        this.titular = titular;
        this.numero = contador++;
    }

    public int getNumero() {
        return numero;
    }

    public Cliente getTitular() {
        return titular;
    }

    public void depositar(double valor) throws DepositoInvalidoException {
        if  (valor <= 0) {
            throw new DepositoInvalidoException("Valor inváido.");
        }
        this.saldo += valor;
    }

    public void sacar(double valor) throws SaqueInvalidoException {

        if (this.saldo == 0) {
            throw new SaqueInvalidoException("O saldo da conta está zerado.");
        }
        if (valor <= 0) {
            throw new SaqueInvalidoException("Valor de saque inválido.");
        }
        if (this.saldo < valor || this.saldo - valor < 0) {
            throw new SaqueInvalidoException("Saldo Insuficiente.");
        }

        this.saldo -= valor;
    }

    public void transferir (Conta destino, double valor) throws TransferenciaInvalidaException {
        // TODO fazer método
        if (this.saldo == 0) {
            throw new TransferenciaInvalidaException("O saldo da conta está zerado.");
        }
        if (valor <= 0) {
            throw new TransferenciaInvalidaException("Valor de transferência inválido.");
        }
        if (this.saldo < valor || this.saldo - valor < 0) {
            throw new TransferenciaInvalidaException("Saldo Insuficiente.");
        }

        this.saldo -= valor;
        destino.saldo += valor;
    }

    public double getSaldo() {
        return saldo;
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
