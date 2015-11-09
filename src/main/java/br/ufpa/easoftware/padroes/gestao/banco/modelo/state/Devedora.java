package br.ufpa.easoftware.padroes.gestao.banco.modelo.state;

import br.ufpa.easoftware.padroes.gestao.banco.modelo.ContaBancaria;
import org.joda.time.DateTime;
import org.joda.time.Days;

import java.util.Date;

public class Devedora extends SituacaoState {

    private Date dataQueFicouDevedor;

    public Devedora() {
        this.dataQueFicouDevedor = new Date();
    }

    @Override
    public Double sacar(ContaBancaria conta, Double quantia) {
        throw new RuntimeException("Correntista com saldo devedor.\nSaldo atual R$ "+conta.getSaldo());
    }

    @Override
    public void aplicaJuros(ContaBancaria conta, Date hoje) {
        int dias = Days.daysBetween(new DateTime(dataQueFicouDevedor), new DateTime(hoje)).getDays();

        if(dias >= 30) {
            //Como o cálculo de juros não foi especificado. Será descontando sempre -10
            conta.comSaldo(conta.getSaldo() - 10);
            this.atualizaSiuacao(conta);
        }
    }
}