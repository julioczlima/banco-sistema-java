package controller;

import exceptions.ClienteInvalidoException;
import exceptions.ContaInvalidaException;
import model.Cliente;

import java.util.Scanner;

public class MenuController {

    ClienteController clienteController = new ClienteController();
    ContaController contaController = new ContaController();

    Scanner input = new Scanner(System.in);

    public MenuController() {
    }

    public void criarCliente(String texto) {
        mensagemHeadLineMenu(texto);

        String nome = String.valueOf(usuarioInput("Informe o nome do cliente: "));
        String cpf = String.valueOf(usuarioInput("Informe o CPF do cliente: "));
        int idade = Integer.parseInt(usuarioInput("Informe o idade do cliente: "));
        var cliente = new Cliente(nome, cpf, idade);

        try {
            clienteController.cadastrarCliente(cliente);
        } catch (ClienteInvalidoException e) {
            System.out.println("Não foi possível cadastrar o cliente: " + e.getMessage());
        }
    }

    public void listarClientes(String texto) {
        mensagemHeadLineMenu(texto);
        clienteController.listarClientes();
    }


    public void abrirConta(String texto) {
        mensagemHeadLineMenu(texto);
        String cpf = String.valueOf(usuarioInput("Informe o CPF do cliente: "));
        Cliente cliente = clienteController.getByCpf(cpf);

        try {
            contaController.abrirContas(cliente);
        } catch (ContaInvalidaException e) {
            System.out.println("Erro ao abrir a conta: " + e.getMessage());
        }
    }

    public void listarContas(String texto) {
        mensagemHeadLineMenu(texto);
        contaController.listarContas();
    }

    // TODO metodo depositar
    public void depositar(String texto) {
        mensagemHeadLineMenu(texto);
        int numeroConta = Integer.parseInt(usuarioInput("Informe o numero da conta a ser depositada: "));
        double valorDeposito = Double.parseDouble(usuarioInput("Informe o valor a ser depositado: "));

        try {
            contaController.depositar(numeroConta, valorDeposito);
        } catch (ContaInvalidaException e) {
            System.out.println("Erro ao depositar na conta: " + e.getMessage());
        }

    }

    // TODO metodo sacar


    // TODO metodo transferir

    public String usuarioInput(String texto) {
        System.out.println(texto);
        return input.nextLine();
    }

    public void mensagemHeadLineMenu(String texto) {
        System.out.printf("\n=== %s ===\n", texto);
    }

}
