package controller;

import exceptions.ContaInvalidaException;
import exceptions.SaqueInvalidoException;
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

    public void depositar(int numeroConta, double saldo) throws ContaInvalidaException {
        var conta = getByContaId(numeroConta);

        if (conta == null) {
            throw new ContaInvalidaException("Numero da conta não encontrado.");
        } else {
            conta.depositar(saldo);
        }

    }

    public void sacar(int numeroConta, double valor) throws ContaInvalidaException {
        var conta =  getByContaId(numeroConta);

        if (conta == null) {
            throw new ContaInvalidaException("Numero da conta não encontrado.");
        } else {
            try {
                conta.sacar(valor);
            } catch (SaqueInvalidoException e) {
                System.out.println("Erro ao sacar da conta: " + e.getMessage());
            }
        }
    }

    public void transferir(int numeroContaSaida, int numeroContaEntrada, double valor) throws ContaInvalidaException {
        var contaSaida =  getByContaId(numeroContaSaida);
        var contaEntrada =  getByContaId(numeroContaEntrada);

        if (contaSaida == null || contaEntrada == null) {
            throw new ContaInvalidaException("Numero da conta não encontrado.");
        } else {
            try {
                contaSaida.sacar(valor);
                contaEntrada.depositar(valor);
            } catch (SaqueInvalidoException e) {
                System.out.println("Erro ao transferir da conta: " + e.getMessage());
            }
        }

    }


    public Conta getByContaId(int numero) {
        for (Conta conta : contas) {
            if (conta.getNumero() == numero) {
                return conta;
            }
        }
        return null;
    }

}
