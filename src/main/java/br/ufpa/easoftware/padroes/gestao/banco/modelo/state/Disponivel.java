package br.ufpa.easoftware.padroes.gestao.banco.modelo.state;

import br.ufpa.easoftware.padroes.gestao.banco.modelo.ContaBancaria;


public class Disponivel extends SituacaoState {

    @Override
    public Double sacar(ContaBancaria conta, Double quantia) throws RuntimeException{
        Double saldoAtual = 0.0;
        if (conta.getSaldo() + conta.getLimite() <= 0)
            throw new RuntimeException("Você não possui saldo/limite para saque.");
        
        saldoAtual = conta.getSaldo() - quantia;
        
        return saldoAtual;
    }

    @Override
    public Double aplicaJuros() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
