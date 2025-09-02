package controller;

import model.Conta;

import java.util.ArrayList;

public class ContaController {

    ArrayList<Conta> contas = new ArrayList<>();

    // TODO criar método para criarContas
    public void criarContas(Conta conta) {
        contas.add(conta);
        System.out.println("Conta Criada com sucesso!");
    }

    // TODO criar método para listarContas
    public void listarContas() {
        contas.forEach(System.out::println);
    }

    // TODO métodos depositar, transferir e sacar



}
