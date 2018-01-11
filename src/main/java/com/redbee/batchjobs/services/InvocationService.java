package com.redbee.batchjobs.services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.nio.charset.Charset;
import java.util.Map;

@Service
public class InvocationService {

    private static final Logger logger = LoggerFactory.getLogger(InvocationService.class);

    /**
     * @param URL_WS: url a la que se quiere realizar el llamado
     * @param httpMethod: GET/POST/PUT/PUSH/etc
     * @param headersMap: se le envia en el header parametros como Authorization donde va el token y Content-Type json, etc
     * @param params: parametros para un post, etc depende del tipo de Content-Type que se le haya puesto en el header
     * */
    public String invocarWS(String URL_WS, HttpMethod httpMethod, Map<String, String> headersMap, String params){

        return invocarWebService(URL_WS, httpMethod, headersMap, params);
    }

    private String invocarWebService(String URL_WS, HttpMethod httpMethod, Map<String, String> headersMap ,String parametros){

        Class type = String.class;
        System.setProperty("sun.net.http.allowRestrictedHeaders", "true");

        HttpHeaders headers = getHeadersList(headersMap);
        HttpEntity<String> request = new HttpEntity<String>(parametros, headers);

        logger.warn("request: " + request);

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> responseEntity = null;

        try {
            restTemplate.getMessageConverters().add(0, new StringHttpMessageConverter(Charset.forName("UTF-8")));
            responseEntity = restTemplate.exchange(URL_WS, httpMethod,  request, type);
            String respuesta = responseEntity.getBody();

            logger.warn("respuesta: " + respuesta);
            return respuesta;
        }

        catch(HttpClientErrorException httpClientErrorException){
            logger.error(httpClientErrorException.getMessage());
            return httpClientErrorException.getResponseBodyAsString();
        }
        catch(Exception e){
            logger.error(e.getMessage());
            return e.getMessage();
        }
    }

    private HttpHeaders getHeadersList(Map<String, String> mapa){

        HttpHeaders headers = new HttpHeaders();

        mapa.forEach((item, value) -> {
            headers.add(item, value);
        });

        return headers;
    }


}
