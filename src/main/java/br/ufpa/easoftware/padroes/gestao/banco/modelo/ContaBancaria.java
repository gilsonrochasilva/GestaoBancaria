package br.ufpa.easoftware.padroes.gestao.banco.modelo;

import br.ufpa.easoftware.padroes.gestao.banco.modelo.state.Disponivel;
import br.ufpa.easoftware.padroes.gestao.banco.modelo.state.SituacaoState;

public class ContaBancaria {

    private String numero;
    private Agencia agencia;
    private Correntista correntista;
    private Double saldo = 0.0;
    private Double limite = 1000.0;
    private SituacaoState situacao = new Disponivel();

    public ContaBancaria() {
    }

    public void sacar(Double quantia) {
        saldo = situacao.sacar(this, quantia);
        situacao.atualizaSiuacao(this);
    }
    
    public void depositar(Double quantia) {
        saldo = situacao.depositar(this, quantia);
        situacao.atualizaSiuacao(this);
    }

    public String getNumero() {
        return numero;
    }

    public ContaBancaria numero(String numero) {
        this.numero = numero;
        return this;
    }

    public Double getSaldo() {
        return saldo;
    }

    public ContaBancaria comSaldo(Double saldo) {
        this.saldo = saldo;
        return this;
    }

    public Double getLimite() {
        return limite;
    }

    public ContaBancaria comLimite(Double limite) {
        this.limite = limite;
        return this;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public ContaBancaria daAgencia(Agencia agencia) {
        this.agencia = agencia;
        return this;
    }

    public Correntista getCorrentista() {
        return correntista;
    }

    public ContaBancaria doCorrentista(Correntista correntista) {
        this.correntista = correntista;
        return this;
    }

    public SituacaoState getSituacao() {
        return situacao;
    }

    public ContaBancaria comSituacao(SituacaoState situacao) {
        this.situacao = situacao;
        return this;
    }

}
