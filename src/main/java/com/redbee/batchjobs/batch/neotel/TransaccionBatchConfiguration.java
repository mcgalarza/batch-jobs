package com.redbee.batchjobs.batch.neotel;

import com.redbee.batchjobs.batch.JobCompletionNotificationListener;
import com.redbee.batchjobs.model.Transaccion;
import com.redbee.batchjobs.repository.TransaccionRepository;
import com.redbee.batchjobs.util.FechaUtil;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.data.RepositoryItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.Sort;

import java.util.*;

@Configuration
@EnableBatchProcessing
public class TransaccionBatchConfiguration {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private TransaccionRepository transaccionRepository;

    @Bean
    public RepositoryItemReader<Transaccion> reader() {
//        Date fechaActual = new Date();
//        Date fechaDesde = FechaUtil.restarHora(fechaActual);
//        Date fechaHasta = FechaUtil.restarMediaHora(fechaActual);

        Date fechaActual = new Date();
        Date fechaDesde = FechaUtil.restarHora(fechaActual);
        Date fechaHasta = fechaActual;

        Map sorts = new HashMap<>();
        sorts.put("id", Sort.Direction.ASC);

        List parametros = new ArrayList();
//        parametros.add(fechaDesde);
//        parametros.add(fechaHasta);

        RepositoryItemReader<Transaccion> transaccionItemReader = new RepositoryItemReader();
        transaccionItemReader.setRepository(transaccionRepository);
        transaccionItemReader.setMethodName("findAll");
        transaccionItemReader.setArguments(parametros);
        transaccionItemReader.setSort(sorts);

        return transaccionItemReader;
    }

    @Bean
    public TransaccionItemProcessor processor() {
        return new TransaccionItemProcessor();
    }

    @Bean
    public ItemWriter<Transaccion> writer() {
        return new TransaccionWriter();
    }

    @Bean
    public Job leadsNeotelJob(JobCompletionNotificationListener listener) {
        return jobBuilderFactory.get("leadsNeotelJob")
                .incrementer(new RunIdIncrementer())
                .listener(listener)
                .flow(leadsNeotelStep1())
                .end()
                .build();
    }

    @Bean
    public Step leadsNeotelStep1() {
        return stepBuilderFactory.get("leadsNeotelStep1")
                .<Transaccion, Transaccion> chunk(2)
                .reader(reader())
                .processor(processor())
                .writer(writer())
                .build();
    }

}
