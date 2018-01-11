package com.redbee.batchjobs.batch.neotel;

import com.redbee.batchjobs.model.RequestNeotel;
import com.redbee.batchjobs.model.Transaccion;
import com.redbee.batchjobs.services.InvocationService;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpMethod;

import java.util.HashMap;

public class TransaccionItemProcessor implements ItemProcessor<Transaccion, Transaccion> {

    private static final Logger log = LoggerFactory.getLogger(TransaccionItemProcessor.class);

    @Autowired
    private InvocationService invocationService;

    @Value("${urlWSNeotel}")
    String urlWSNeotel;

    @Value("${idTaskNeotel}")
    Integer idTaskNeotel;

    @Override
    public Transaccion process(final Transaccion transaccion) throws Exception {
        //chequea si tiene idPoliza o no y efectua el POST a neotel
        log.info("Procesando transaccion: " + transaccion.getId());

        if (transaccion.getIdPoliza() == null) {
            HashMap<String, String> header = new HashMap<>();
            header.put("Content-Type", "application/json");
            String body = this.getBody(transaccion);

            invocationService.invocarWS(urlWSNeotel, HttpMethod.POST, header, body);
        }

        return transaccion;
    }

    private String getBody(Transaccion transaccion) {
        RequestNeotel requestNeotel = new RequestNeotel(transaccion, idTaskNeotel);
        JSONObject json = new JSONObject(requestNeotel);
        return json.toString();
    }

}