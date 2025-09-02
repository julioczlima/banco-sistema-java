package model;

public class Conta {
    private int numero = 0;
    private double saldo;
    private Cliente titular;

    // TODO métodos depositar, transferir e sacar

    public Conta() {
    }

    public Conta(Cliente titular) {
        this.numero = setNumero();
        this.saldo = 0;
        this.titular = titular;
    }

    private int setNumero() {
        return numero++;
    }

    private void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    private void setTitular(Cliente titular) {
        this.titular = titular;
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
