package controller;

import exceptions.ClienteInvalidoException;
import exceptions.ClienteNaoLocalizadoException;
import model.Cliente;

import java.util.ArrayList;
import java.util.Optional;

public class ClienteController {

    ArrayList<Cliente> clientes = new ArrayList<>();

    public ClienteController() {
    }

    public void cadastrarCliente(Cliente cliente) throws ClienteInvalidoException {
        if (cliente == null) {
            throw new ClienteInvalidoException("Cliente inválido.");
        } else {
            clientes.add(cliente);
        }

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
        for (Cliente cliente : clientes) {
            if (cliente.getCpf().equals(cpf)) {
                return cliente;
            }
        }
        return null;
    }

}
