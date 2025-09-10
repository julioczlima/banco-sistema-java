package controller;

import exceptions.ClienteInvalidoException;
import exceptions.ContaInvalidaException;
import exceptions.DadoInvalidoException;
import exceptions.InputInvalidoException;
import model.Cliente;
import model.Conta;

import java.util.Optional;
import java.util.Scanner;

public class MenuController {

    ClienteController clienteController = new ClienteController();
    ContaController contaController = new ContaController();

    Scanner input = new Scanner(System.in);

    public MenuController() {
    }

    public void cadastrarCliente(String texto) {
        mensagemHeadLineMenu(texto);

        try {
            String nome = String.valueOf(usuarioInput("Informe o nome do cliente: ").toUpperCase());
            String cpf = String.valueOf(usuarioInput("Informe o CPF do cliente: ").strip());
            int idade = Integer.parseInt(usuarioInput("Informe o idade do cliente: ").strip());

            var cliente = new Cliente(nome, cpf, idade);
            clienteController.cadastrarCliente(cliente);
        } catch (ClienteInvalidoException | DadoInvalidoException e) {
            System.out.println("Não foi possível cadastrar o cliente: " + e.getMessage());
        } catch (InputInvalidoException | NumberFormatException e) {
            System.out.println("O valor inserido é inválido: " + e.getMessage());
        }

        System.out.println("Cliente Cadastrado com sucesso!");
    }

    public void listarClientes(String texto) {
        mensagemHeadLineMenu(texto);
        clienteController.listarClientes();
    }


    public void abrirConta(String texto) {
        mensagemHeadLineMenu(texto);

        try {
            String cpf = String.valueOf(usuarioInput("Informe o CPF do cliente: "));
            Cliente cliente = clienteController.getByCpf(cpf);

            contaController.abrirConta(cliente);
        } catch (ContaInvalidaException e) {
            System.out.println("Erro ao abrir a conta: " + e.getMessage());
        } catch (InputInvalidoException | NumberFormatException e) {
            System.out.println("O valor inserido é inválido: " + e.getMessage());
        }

        System.out.println("Conta Aberta com sucesso!");

    }

    public void listarContas(String texto) {
        mensagemHeadLineMenu(texto);
        contaController.listarContas();
    }

    public void depositar(String texto) {
        mensagemHeadLineMenu(texto);

        try {
            int numeroConta = Integer.parseInt(usuarioInput("Informe o numero da conta a ser depositada: "));
            double valorDeposito = Double.parseDouble(usuarioInput("Informe o valor a ser depositado: "));
            contaController.depositar(numeroConta, valorDeposito);

        } catch (ContaInvalidaException e) {
            System.out.println("Erro ao depositar na conta: " + e.getMessage());
        } catch (InputInvalidoException e) {
            System.out.println("O valor inserido é inválido: " + e.getMessage());
        }

        System.out.println("Deposito realizado com sucesso.");
    }

    public void sacar(String texto) {
        mensagemHeadLineMenu(texto);

        try {
            int numeroConta = Integer.parseInt(usuarioInput("Informe o numero da conta a ser sacado: "));
            double valorSaque = Double.parseDouble(usuarioInput("Informe o valor a ser sacado: "));

            contaController.sacar(numeroConta, valorSaque);
        } catch (ContaInvalidaException e) {
            System.out.println("Erro ao sacar da conta: " + e.getMessage());
        } catch (InputInvalidoException e) {
            System.out.println("O valor inserido é inválido: " + e.getMessage());
        }

        System.out.println("Saque realizado com sucesso.");
    }

    public void transferir(String texto) {
        mensagemHeadLineMenu(texto);

        try {
            int contaSaida = Integer.parseInt(usuarioInput("Informe o numero da conta a transferir: "));
            int contaEntrada = Integer.parseInt(usuarioInput("Informe o valor da conta a receber: "));
            double valor = Double.parseDouble(usuarioInput("Informe o valor a transferir: "));

            contaController.transferir(contaSaida, contaEntrada, valor);
        } catch (ContaInvalidaException e) {
            System.out.println("Erro ao transferir da conta: " + e.getMessage());
            ;
        } catch (InputInvalidoException e) {
            System.out.println("O valor inserido é inválido: " + e.getMessage());
        }

        System.out.println("Transferencia realizada com sucesso.");
    }


    public String usuarioInput(String texto) throws InputInvalidoException {
        System.out.println(texto);
        return input.nextLine();
    }

    public void mensagemHeadLineMenu(String texto) {
        System.out.printf("\n=== %s ===\n", texto);
    }

}
