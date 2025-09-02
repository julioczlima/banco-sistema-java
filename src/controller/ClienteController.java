package controller;

import exceptions.ClienteNaoLocalizadoException;
import model.Cliente;

import java.util.ArrayList;
import java.util.Optional;

public class ClienteController {

    ArrayList<Cliente> clientes = new ArrayList<>();

    public ClienteController() {
    }

    public void cadastrarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado!");
        }

        clientes.forEach(cliente -> {
            System.out.printf("Cliente: %s | CPF: %s | Idade: %s%n",
                    cliente.getNome(), cliente.getCpf(), cliente.getIdade());
        });
    }

    public Cliente getByCpf(String cpf) {
        try {
            for (Cliente cliente : clientes) {
                if (cliente.getCpf().equals(cpf)) {
                    return cliente;
                }
            }
        } catch (ClienteNaoLocalizadoException e) {
            throw new ClienteNaoLocalizadoException("Não foi possível localizar o cliente pelo CPF.");
        }
        return null;
    }

}
