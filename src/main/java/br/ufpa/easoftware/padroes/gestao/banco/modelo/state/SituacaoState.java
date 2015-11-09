package br.ufpa.easoftware.padroes.gestao.banco.modelo.state;

import br.ufpa.easoftware.padroes.gestao.banco.modelo.ContaBancaria;

import java.util.Date;

public abstract class SituacaoState {

    public Double depositar(ContaBancaria conta, Double quantia) {
        return conta.getSaldo() + quantia;
    }

    public void atualizaSiuacao(ContaBancaria conta) {
        if (conta.getSaldo() >= 0)  conta.comSituacao(new Disponivel());
        else conta.comSituacao(new Devedora());
    }

    public abstract Double sacar(ContaBancaria conta, Double quantia);

    public abstract void aplicaJuros(ContaBancaria conta, Date hoje);

}
