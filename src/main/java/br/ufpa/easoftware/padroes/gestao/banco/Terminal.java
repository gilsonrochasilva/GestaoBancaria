package br.ufpa.easoftware.padroes.gestao.banco;

import br.ufpa.easoftware.padroes.gestao.banco.modelo.Agencia;
import br.ufpa.easoftware.padroes.gestao.banco.modelo.ContaBancaria;
import br.ufpa.easoftware.padroes.gestao.banco.modelo.Correntista;
import br.ufpa.easoftware.padroes.gestao.banco.modelo.state.Disponivel;
import br.ufpa.easoftware.padroes.gestao.banco.quartz.ExecucaoTrintaDiasJob;
import org.quartz.*;
import org.quartz.impl.StdSchedulerFactory;

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
            imprimirExtrato(conta);

            System.out.println("==================================================");
            System.out.println("Preparando para realizar saque de R$ 500,00\n\n");
            conta.sacar(500.0);
            imprimirExtrato(conta);

            System.out.println("==================================================");
            System.out.println("Preparando para realizar saque de R$ 100,00\n\n");
            conta.depositar(100.0);
            imprimirExtrato(conta);

            System.out.println("==================================================");
            System.out.println("Quartz: simulação de dias passando (a cada dois segundos)...");

            JobDetail job = JobBuilder.newJob(ExecucaoTrintaDiasJob.class).withIdentity("ExecucaoTrintaDiasJob", "Banco").build();
            job.getJobDataMap().put("conta", conta);

            Trigger trigger = TriggerBuilder.newTrigger()
                    .withIdentity("PassouTrintaDias", "Banco").startNow()
                    .withSchedule(SimpleScheduleBuilder.simpleSchedule().withIntervalInSeconds(2).withRepeatCount(5))
                    .build();

            SchedulerFactory schedulerFactory = new StdSchedulerFactory();

            Scheduler scheduler = schedulerFactory.getScheduler();
            scheduler.scheduleJob(job, trigger);
            scheduler.start();
            //scheduler.shutdown(true);

        } catch (RuntimeException e) {
            System.out.println("==================================================");
            System.out.println("OPERAÇÃO NÃO FOI REALIZADA");
            imprimirExtrato(conta);
        } catch (SchedulerException e) {
            e.printStackTrace();
        }
    }

    public static void imprimirExtrato(ContaBancaria conta) {
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
    }
}
