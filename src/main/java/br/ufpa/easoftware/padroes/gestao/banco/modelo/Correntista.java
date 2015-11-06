package br.ufpa.easoftware.padroes.gestao.banco.modelo;

public class Correntista {

    private String nome;
    private String cpf;

    public Correntista() {
    }

    public String getNome() {
        return nome;
    }

    public Correntista nome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getCpf() {
        return cpf;
    }

    public Correntista cpf(String cpf) {
        this.cpf = cpf;
        return this;
    }

    @Override
    public String toString() {
        return "Correntista{" + "nome=" + nome + ", cpf=" + cpf + '}';
    }
    
}
