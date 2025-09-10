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
        if (cliente == null
                || cliente.getNome() == null
                || cliente.getCpf() == null) {
            throw new ClienteInvalidoException("Cliente inválido.");
        }

        if (getByCpf(cliente.getCpf()) != null) {
            throw new ClienteInvalidoException("CPF já cadastrado.");
        }

        clientes.add(cliente);
    }

    public void listarClientes() {
        if (clientes.isEmpty()) {
            System.out.println("Nenhum cliente encontrado!");
        } else {
            clientes.forEach(System.out::println);
        }
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
