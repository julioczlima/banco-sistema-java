package controller;

import exceptions.*;
import model.Cliente;
import model.Conta;

import java.util.ArrayList;
import java.util.Optional;

public class ContaController {

    ArrayList<Conta> contas = new ArrayList<>();

    public void abrirConta(Cliente cliente) throws ContaInvalidaException {
        if (cliente == null) {
            throw new ContaInvalidaException();
        }

        contas.add(new Conta(cliente));
    }

    public void listarContas() {
        if (contas.isEmpty()) {
            System.out.println("Nenhum conta encontrado.");
        } else {
            contas.forEach(System.out::println);
        }
    }

    public void depositar(int numeroConta, double saldo) throws ContaInvalidaException {
        var conta = getByContaId(numeroConta);

        if (conta.isEmpty()) {
            throw new ContaInvalidaException("Numero da conta não encontrado.");
        }

        try {
            conta.get().depositar(saldo);
        } catch (DepositoInvalidoException e) {
            System.out.println("Não foi possível  depositar: " + e.getMessage());
        }

    }

    public void sacar(int numeroConta, double valor) throws ContaInvalidaException {
        Optional<Conta> conta = getByContaId(numeroConta);

        if (conta.isEmpty()) {
            throw new ContaInvalidaException("Numero da conta não encontrado.");
        }

        try {
            conta.get().sacar(valor);
        } catch (SaqueInvalidoException e) {
            System.out.println("Erro ao sacar da conta: " + e.getMessage());
        }

    }

    public void transferir(int numeroContaSaida, int numeroContaEntrada, double valor) throws ContaInvalidaException, TransferenciaInvalidaException {
        var contaSaida = getByContaId(numeroContaSaida);
        var contaEntrada = getByContaId(numeroContaEntrada);

        if (contaSaida.isEmpty() || contaEntrada.isEmpty()) {
            throw new ContaInvalidaException("Numero da conta não encontrado.");
        }


        contaSaida.get().transferir(contaEntrada.get(), valor);

    }


    public Optional<Conta> getByContaId(int numero) {
        return contas.stream()
                .filter(conta -> conta.getNumero() == numero)
                .findFirst();
    }

    public double verificarSaldo(Optional<Conta> conta) throws ContaInvalidaException {
        if (conta.isEmpty()) {
            throw new ContaInvalidaException("Conta inválida.");
        }

        return conta.get().getSaldo();
    }

}
