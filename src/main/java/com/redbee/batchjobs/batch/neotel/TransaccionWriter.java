package com.redbee.batchjobs.batch.neotel;

import com.redbee.batchjobs.model.Transaccion;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemWriter;

import java.util.List;

public class TransaccionWriter implements ItemWriter<Transaccion> {

    private static final Logger log = LoggerFactory.getLogger(TransaccionItemProcessor.class);

    @Override
    public void write(List<? extends Transaccion> items) throws Exception {
        log.info("write transaccion");
    }
}
