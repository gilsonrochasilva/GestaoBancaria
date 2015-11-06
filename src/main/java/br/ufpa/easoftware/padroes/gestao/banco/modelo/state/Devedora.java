package br.ufpa.easoftware.padroes.gestao.banco.modelo.state;

import br.ufpa.easoftware.padroes.gestao.banco.modelo.ContaBancaria;

public class Devedora extends SituacaoState {

    @Override
    public Double sacar(ContaBancaria conta, Double quantia) {
        throw new RuntimeException("Correntista com saldo devedor.\nSaldo atual R$ "+conta.getSaldo());
    }

    @Override
    public Double aplicaJuros() {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
