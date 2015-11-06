package br.ufpa.easoftware.padroes.gestao.banco;

import br.ufpa.easoftware.padroes.gestao.banco.modelo.Agencia;
import br.ufpa.easoftware.padroes.gestao.banco.modelo.ContaBancaria;
import br.ufpa.easoftware.padroes.gestao.banco.modelo.Correntista;
import br.ufpa.easoftware.padroes.gestao.banco.modelo.state.Disponivel;

public class Terminal {

    public static void main(String[] args) {
        Agencia braz = new Agencia().nome("Braz de Aguia").numero("001");
        Correntista stelio = new Correntista().nome("Stélio Corrêa").cpf("659.002.512-68");
        ContaBancaria conta = new ContaBancaria()
                .numero("01")
                .daAgencia(braz)
                .doCorrentista(stelio)
                .comSaldo(250.0)
                .comLimite(500.0);

        try {
            System.out.println("==================================================");
            System.out.println("EXTRATO");
            System.out.println("==================================================");
            System.out.println("Correntista: " + conta.getCorrentista().getNome());
            System.out.println("CPF: " + conta.getCorrentista().getCpf());
            System.out.println("Saldo atual: R$ " + conta.getSaldo());
            System.out.println("Limite atual: R$ " + conta.getLimite());
            if (conta.getSituacao() instanceof Disponivel) {
                System.out.println("Situação: Disponível");
            } else {
                System.out.println("Situação: Devedora");
            }
            System.out.println("==================================================\n\n");
            System.out.println("Preparando para realizar saque de R$ 500,00\n\n");
            conta.sacar(500.0);
            System.out.println("==================================================");
            System.out.println("EXTRATO");
            System.out.println("==================================================");
            System.out.println("Correntista: " + conta.getCorrentista().getNome());
            System.out.println("CPF: " + conta.getCorrentista().getCpf());
            System.out.println("Saldo atual: R$ " + conta.getSaldo());
            System.out.println("Limite atual: R$ " + conta.getLimite());
            if (conta.getSituacao() instanceof Disponivel) {
                System.out.println("Situação: Disponível");
            } else {
                System.out.println("Situação: Devedora");
            }
            System.out.println("==================================================\n\n");
            System.out.println("Preparando para realizar deposito de R$ 1.500,00\n\n");
            conta.depositar(1500.0);
            System.out.println("==================================================");
            System.out.println("EXTRATO");
            System.out.println("==================================================");
            System.out.println("Correntista: " + conta.getCorrentista().getNome());
            System.out.println("CPF: " + conta.getCorrentista().getCpf());
            System.out.println("Saldo atual: R$ " + conta.getSaldo());
            System.out.println("Limite atual: R$ " + conta.getLimite());
            if (conta.getSituacao() instanceof Disponivel) {
                System.out.println("Situação: Disponível");
            } else {
                System.out.println("Situação: Devedora");
            }
            System.out.println("==================================================\n\n");
        } catch (RuntimeException e) {
            System.out.println("==================================================");
            System.out.println("OPERAÇÃO NÃO FOI REALIZADA");
            System.out.println("==================================================");
            System.out.println("Correntista: " + conta.getCorrentista().getNome());
            System.out.println("CPF: " + conta.getCorrentista().getCpf());
            System.out.println("Motivo: ");
            System.out.println(e.getMessage());
            System.out.println("==================================================");
        }
    }
}
