package controller;

import exceptions.*;
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

    public void adicionarIniciais() {
        try {
            clienteController.cadastrarCliente(new Cliente("Julio", "11", 32));
            clienteController.cadastrarCliente(new Cliente("Ana", "22", 20));
            contaController.abrirConta(new Cliente("Julio", "11", 32));
            contaController.abrirConta(new Cliente("Ana", "22", 20));

        } catch (ContaInvalidaException | DadoInvalidoException | ClienteInvalidoException e) {
            throw new RuntimeException(e);
        }

    }

    public void cadastrarCliente(String texto) {
        mensagemHeadLineMenu(texto);

        try {
            String nome = lerString("Informe o nome do cliente: ").toUpperCase();
            String cpf = lerString("Informe o CPF do cliente: ").strip();
            int idade = lerInteiro("Informe o idade do cliente: ");

            var cliente = new Cliente(nome, cpf, idade);
            clienteController.cadastrarCliente(cliente);

            System.out.println("Cliente Cadastrado com sucesso!");
        } catch (ClienteInvalidoException | DadoInvalidoException e) {
            System.out.println("Não foi possível cadastrar o cliente: " + e.getMessage());
        } catch (InputInvalidoException | NumberFormatException e) {
            System.out.println("O valor inserido é inválido: " + e.getMessage());
        }
    }

    public void listarClientes(String texto) {
        mensagemHeadLineMenu(texto);
        clienteController.listarClientes();
    }


    public void abrirConta(String texto) {
        mensagemHeadLineMenu(texto);

        try {
            String cpf = lerString("Informe o CPF do cliente: ");
            Cliente cliente = clienteController.getByCpf(cpf).get();

            contaController.abrirConta(cliente);

            System.out.println("Conta Aberta com sucesso!");
        } catch (ContaInvalidaException e) {
            System.out.println("Erro ao abrir a conta: " + e.getMessage());
        } catch (InputInvalidoException | NumberFormatException e) {
            System.out.println("O valor inserido é inválido: " + e.getMessage());
        }
    }

    public void listarContas(String texto) {
        mensagemHeadLineMenu(texto);
        contaController.listarContas();
    }

    public void depositar(String texto) {
        mensagemHeadLineMenu(texto);

        try {
            int numeroConta = lerInteiro("Informe o numero da conta a ser depositada: ");
            double valorDeposito = lerDouble("Informe o valor a ser depositado: ");
            contaController.depositar(numeroConta, valorDeposito);

            System.out.println("Deposito realizado com sucesso.");
        } catch (ContaInvalidaException e) {
            System.out.println("Erro ao depositar na conta: " + e.getMessage());
        } catch (InputInvalidoException e) {
            System.out.println("O valor inserido é inválido: " + e.getMessage());
        }
    }

    public void sacar(String texto) {
        mensagemHeadLineMenu(texto);

        try {
            int numeroConta = lerInteiro("Informe o numero da conta a ser sacado: ");
            double valorSaque = lerDouble("Informe o valor a ser sacado: ");

            contaController.sacar(numeroConta, valorSaque);

            System.out.println("Saque realizado com sucesso.");
        } catch (ContaInvalidaException e) {
            System.out.println("Erro ao sacar da conta: " + e.getMessage());
        } catch (InputInvalidoException e) {
            System.out.println("O valor inserido é inválido: " + e.getMessage());
        }
    }

    public void transferir(String texto) {
        mensagemHeadLineMenu(texto);

        try {
            int contaSaida = lerInteiro("Informe o numero da conta a transferir: ");
            int contaEntrada = lerInteiro("Informe o numero da conta a receber: ");
            double valor = lerDouble("Informe o valor a transferir: ");

            contaController.transferir(contaSaida, contaEntrada, valor);

            System.out.println("Transferencia realizada com sucesso.");
        } catch (ContaInvalidaException | TransferenciaInvalidaException e) {
            System.out.println("Erro ao transferir da conta: " + e.getMessage());
            ;
        } catch (InputInvalidoException e) {
            System.out.println("O valor inserido é inválido: " + e.getMessage());
        }
    }


    public String lerString(String texto) throws InputInvalidoException {
        System.out.println(texto);
        String inputUsuario = input.nextLine();

        if (inputUsuario == null || inputUsuario.isBlank()) {
            throw new InputInvalidoException ("Informe algum valor.");
        }

        return inputUsuario;
    }

    public int lerInteiro(String texto) throws InputInvalidoException {
        System.out.println(texto);
        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            throw new InputInvalidoException("O valor deve ser um número inteiro.");
        }
    }

    public double lerDouble(String texto) throws InputInvalidoException {
        System.out.println(texto);
        try {
            return Double.parseDouble(input.nextLine());
        } catch (NumberFormatException e) {
            throw new InputInvalidoException("O valor deve ser um número decimal.");
        }
    }


    public void mensagemHeadLineMenu(String texto) {
        System.out.printf("\n=== %s ===\n", texto);
    }

}
