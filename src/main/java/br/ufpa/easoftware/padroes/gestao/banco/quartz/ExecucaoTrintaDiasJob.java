package br.ufpa.easoftware.padroes.gestao.banco.quartz;

import br.ufpa.easoftware.padroes.gestao.banco.Terminal;
import br.ufpa.easoftware.padroes.gestao.banco.modelo.ContaBancaria;
import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import java.util.Calendar;

/**
 *
 * Created by gilson on 09/11/15.
 */
public class ExecucaoTrintaDiasJob implements Job {

    public ExecucaoTrintaDiasJob() {
    }

    @Override
    public void execute(JobExecutionContext jobExecutionContext) throws JobExecutionException {
        System.out.println("==================================================");
        System.out.println("Passaram 30 dias, aplicando juros...");

        Calendar trintaDiasDepois = Calendar.getInstance();
        trintaDiasDepois.add(Calendar.MONTH, 31);

        final ContaBancaria conta = (ContaBancaria) jobExecutionContext.getMergedJobDataMap().get("conta");
        conta.getSituacao().aplicaJuros(conta, trintaDiasDepois.getTime());
        Terminal.imprimirExtrato(conta);
    }
}
