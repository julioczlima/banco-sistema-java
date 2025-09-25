package model;

import exceptions.DadoInvalidoException;

public class Cliente {

    private String nome;
    private String cpf;
    private int idade;

    public String getNome() {
        return nome;
    }

    public Cliente(String nome, String cpf, int idade) throws DadoInvalidoException {
            setNome(nome);
            setCpf(cpf);
            setIdade(idade);

        }

    private void setNome(String nome) throws DadoInvalidoException {
        if (nome == null || nome.isEmpty()) {
            throw new DadoInvalidoException("Nome inválido.");
        }

        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) throws DadoInvalidoException {

        if (cpf == null || cpf.isEmpty()) {
            throw new DadoInvalidoException("CPF inválido - Nulo.");
        }

        try {
            Integer cpfEmNumeros = Integer.parseInt(cpf);
        } catch (NumberFormatException e) {
            throw new DadoInvalidoException("CPF Inválido - Informar somente números.");
        }


        this.cpf = cpf;
    }

    public int getIdade() {
        return idade;
    }

    private void setIdade(int idade) throws DadoInvalidoException {
        if (idade < 0 || idade >= 150) {
            throw new DadoInvalidoException("Idade inválida.");
        }
        this.idade = idade;
    }

    @Override
    public String toString() {
        return String.format("Cliente: %s | CPF: %s | Idade: %d", nome, cpf, idade);
    }
}
