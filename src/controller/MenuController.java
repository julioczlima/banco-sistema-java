package controller;

import exceptions.ClienteNaoLocalizadoException;
import model.Cliente;
import model.Conta;

import java.util.Scanner;

public class MenuController {

    ClienteController clienteController = new ClienteController();
    ContaController contaController = new ContaController();

    Scanner input = new Scanner(System.in);

    public MenuController() {
    }

    private Cliente criarClientePeloInput() {
        mensagemHeadLineMenu("CRIAR CLIENTE");
        String nome = String.valueOf(usuarioInput("Informe o nome do cliente: "));
        String cpf = String.valueOf(usuarioInput("Informe o CPF do cliente: "));
        int idade = Integer.parseInt(usuarioInput("Informe o idade do cliente: "));

        return new Cliente(nome, cpf, idade);
    }

    public void criarCliente() {
        clienteController.cadastrarCliente(criarClientePeloInput());
    }

    public void listarClientes() {
        mensagemHeadLineMenu("LISTAR CLIENTES");
        clienteController.listarClientes();
    }

    public void criarConta() {
        mensagemHeadLineMenu("CRIAR CONTA");
        String cpf = String.valueOf(usuarioInput("Informe o CPF do cliente: "));
        Cliente cliente = clienteController.getByCpf(cpf);

        try {
            contaController.criarContas(new Conta(cliente));
        } catch (ClienteNaoLocalizadoException e) {
            System.out.println(e.getMessage());;
        }
    }

    public  void listarContas() {
        mensagemHeadLineMenu("LISTAR CONTAS");
        contaController.listarContas();
    }

    public String usuarioInput(String texto) {
        System.out.println(texto);
        return input.nextLine();
    }

    public void mensagemHeadLineMenu(String texto) {
        System.out.printf("\n=== %s ===\n", texto);
    }

}
