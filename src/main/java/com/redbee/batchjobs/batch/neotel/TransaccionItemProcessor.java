package com.redbee.batchjobs.batch.neotel;

import com.redbee.batchjobs.model.Transaccion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;

public class TransaccionItemProcessor implements ItemProcessor<Transaccion, Transaccion> {

    private static final Logger log = LoggerFactory.getLogger(TransaccionItemProcessor.class);

    @Override
    public Transaccion process(final Transaccion transaccion) throws Exception {
        //chequea si tiene idPoliza o no y efectua el POST a neotel

        log.info("Procesando transaccion: " + transaccion.getId());

        return transaccion;
    }

}