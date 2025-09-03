package controller;

import exceptions.ContaInvalidaException;
import model.Cliente;
import model.Conta;

import java.util.ArrayList;

public class ContaController {

    ArrayList<Conta> contas = new ArrayList<>();

    public void abrirContas(Cliente cliente) throws ContaInvalidaException {
        if (cliente == null) {
            throw new ContaInvalidaException("Cliente invalido.");
        }

        contas.add(new Conta(cliente, contas.size()));
        System.out.println("Conta Criada com sucesso!");
    }

    public void listarContas() {
        contas.forEach(System.out::println);
    }

    // TODO metodo depositar
    public void depositar(int numeroConta, double saldo) throws ContaInvalidaException {
        var conta = getByContaId(numeroConta);

        if (conta == null) {
            throw new ContaInvalidaException("Numero da conta não encontrado.");
        } else {
            conta.depositar(saldo);
        }

    }

    // TODO metodo sacar
    public void sacar(int numeroConta, double saldo) {
        contas.get(numeroConta).sacar(saldo);
    }

    // TODO metodo transferir


    public Conta getByContaId(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

}
