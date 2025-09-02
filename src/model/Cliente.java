package model;

public class Cliente {

    private String nome;
    private String cpf;
    private int idade;

    public Cliente(String nome, String cpf, int idade) {
        setNome(nome);
        setCpf(cpf);
        setIdade(idade);
    }

    public String getNome() {
        return nome;
    }

    private void setNome(String nome) {
        if (nome != null && !nome.isEmpty()) {
            this.nome = nome;
        }
    }

    public String getCpf() {
        return cpf;
    }

    private void setCpf(String cpf) {
        if (cpf != null && !cpf.isEmpty()) {
            this.cpf = cpf;
        }
    }

    public int getIdade() {
        return idade;
    }

    private void setIdade(int idade) {
        if (idade >= 0 && idade <= 150) {
            this.idade = idade;
        }
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", idade=" + idade +
                '}';
    }
}
