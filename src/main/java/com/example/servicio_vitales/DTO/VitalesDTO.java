package com.example.servicio_vitales.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;

public class VitalesDTO {

    @JsonProperty("usuario_id")
    private int usuario_id;

    @JsonProperty("frecuencia_cardiaca")
    private String frecuencia_cardiaca;

    @JsonProperty("presion_arterial")
    private String presion_arterial;

    @JsonProperty("temperatura_corporal")
    private String temperatura_corporal;

    public VitalesDTO() {}

    public VitalesDTO(int usuario_id, String frecuencia_cardiaca, String presion_arterial, String temperatura_corporal) {
        this.usuario_id = usuario_id;
        this.frecuencia_cardiaca = frecuencia_cardiaca;
        this.presion_arterial = presion_arterial;
        this.temperatura_corporal = temperatura_corporal;
    }

    public int getUsuarioId() {
        return usuario_id;
    }

    public void setUsuarioId(int usuario_id) {
        this.usuario_id = usuario_id;
    }

    public String getFrecuenciaCardiaca() {
        return frecuencia_cardiaca;
    }

    public void setFrecuenciaCardiaca(String frecuencia_cardiaca) {
        this.frecuencia_cardiaca = frecuencia_cardiaca;
    }

    public String getPresionArterial() {
        return presion_arterial;
    }

    public void setPresionArterial(String presion_arterial) {
        this.presion_arterial = presion_arterial;
    }

    public String getTemperaturaCorporal() {
        return temperatura_corporal;
    }

    public void setTemperaturaCorporal(String temperatura_corporal) {
        this.temperatura_corporal = temperatura_corporal;
    }
}
