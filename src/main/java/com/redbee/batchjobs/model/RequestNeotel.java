package com.redbee.batchjobs.model;

import org.json.JSONObject;

import java.util.Map;

public class RequestNeotel {

    private Integer idTask; //idTask: si es 14 es produccion, si es 20 es test
    private String param1; //id de canal
    private String param2; //id de campania
    private String param3; //id de producto
    private String param4; //numero de telefono
    private String param5; //mail
    private String param6; //nombre
    private String param7; //apellido
    private String param8; //dni
    private String param9; //codigoPostal;precioFinal;descripcionProducto;marca;modelo;url;descripcionError
    private String param10; //id facebook
    private String param11; //id messenger
    private String param12; //horario llamada

    public RequestNeotel(Transaccion transaccion, Integer idTask) {
        Map<String, String> map = transaccion.requestNeotelDTO();

        this.idTask = idTask;
        this.param1 = "3";
        this.param2 = "20";
        this.param3 = map.get("idProducto");
        this.param4 = map.get("codArea") + map.get("nroCelular");
        this.param5 = map.get("email");
        this.param6 = map.get("nombre");
        this.param7 = map.get("apellido");
        this.param8 = map.get("nroDocumento");
        this.param9 = this.getParam9(transaccion);
        this.param10 = "";
        this.param11 = "";
        this.param12 = "0";
    }

    private String getParam9(Transaccion transaccion) {
        Map<String, String> map = transaccion.requestNeotelDTO();

        return map.get("codPostal") + ";" +                     //codigo postal
                ";" +                                           //precio final
                ";" +                                           //descripcion producto
                map.get("marca") + ";" +                        //marca
                map.get("modelo") + ";" +                       //modelo
                "ecommerce" + ";" +                             //url
                "leads neotel" +                                //descripcion error
                this.getDatos(transaccion);
    }

    private String getDatos(Transaccion transaccion) {
        Map<String, String> map = transaccion.requestNeotelDTO();

        JSONObject json = new JSONObject()
            .put("CodigoPostal", map.get("codPostal"))
            .put("Apellido", map.get("apellido"))
            .put("Nombre", map.get("nombre"))
            .put("DNI", map.get("nroDocumento"))
            .put("Email", map.get("email"))
            .put("FechaNacimiento", map.get("fechaNacimiento"))
            .put("Calle", map.get("calle"))
            .put("Nro", map.get("nroCalle"))
            .put("Piso", map.get("piso"))
            .put("Depto", map.get("depto"))
            .put("Marca", map.get("marca"))
            .put("Modelo", map.get("modelo"))
            .put("Año", map.get("anioMoto"))
            .put("Dominio", map.get("dominio"))
            .put("Motor", map.get("motor"))
            .put("Chasis", map.get("chasis"))
            .put("FechaInicioVigencia", map.get("fechaInicioVigencia"));

        return json.toString();
    }

    public Integer getIdTask() {
        return idTask;
    }

    public void setIdTask(Integer idTask) {
        this.idTask = idTask;
    }

    public String getParam1() {
        return param1;
    }

    public void setParam1(String param1) {
        this.param1 = param1;
    }

    public String getParam2() {
        return param2;
    }

    public void setParam2(String param2) {
        this.param2 = param2;
    }

    public String getParam3() {
        return param3;
    }

    public void setParam3(String param3) {
        this.param3 = param3;
    }

    public String getParam4() {
        return param4;
    }

    public void setParam4(String param4) {
        this.param4 = param4;
    }

    public String getParam5() {
        return param5;
    }

    public void setParam5(String param5) {
        this.param5 = param5;
    }

    public String getParam6() {
        return param6;
    }

    public void setParam6(String param6) {
        this.param6 = param6;
    }

    public String getParam7() {
        return param7;
    }

    public void setParam7(String param7) {
        this.param7 = param7;
    }

    public String getParam8() {
        return param8;
    }

    public void setParam8(String param8) {
        this.param8 = param8;
    }

    public String getParam9() {
        return param9;
    }

    public void setParam9(String param9) {
        this.param9 = param9;
    }

    public String getParam10() {
        return param10;
    }

    public void setParam10(String param10) {
        this.param10 = param10;
    }

    public String getParam11() {
        return param11;
    }

    public void setParam11(String param11) {
        this.param11 = param11;
    }

    public String getParam12() {
        return param12;
    }

    public void setParam12(String param12) {
        this.param12 = param12;
    }
}