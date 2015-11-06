package br.ufpa.easoftware.padroes.gestao.banco.modelo;

public class Agencia {

    private String nome;
    private String numero;

    public Agencia() {
    }

    public String getNome() {
        return nome;
    }

    public Agencia nome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getNumero() {
        return numero;
    }

    public Agencia numero(String numero) {
        this.numero = numero;
        return this;
    }

    @Override
    public String toString() {
        return "Agencia{" + "nome=" + nome + ", numero=" + numero + '}';
    }
    
}
