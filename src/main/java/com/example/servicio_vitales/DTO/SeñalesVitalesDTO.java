package com.example.servicio_vitales.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class SeñalesVitalesDTO {

    @JsonProperty("idPaciente")
    private int idPaciente;

    @JsonProperty("heartRate")
    private int heartRate;
    
    @JsonProperty("temperature")
    private double temperature;
    
    @JsonProperty("oxygenSaturation")
    private int oxygenSaturation;

    public SeñalesVitalesDTO(int idPaciente, int heartRate, double temperature, int oxygenSaturation) {
        this.idPaciente = idPaciente;
        this.heartRate = heartRate;
        this.temperature = temperature;
        this.oxygenSaturation = oxygenSaturation;
    }

    
    public int getIdPaciente() { return idPaciente; }
    public void setIdPaciente(int idPaciente) { this.idPaciente = idPaciente; }

    public int getHeartRate() { return heartRate; }
    public void setHeartRate(int heartRate) { this.heartRate = heartRate; }

    public double getTemperature() { return temperature; }
    public void setTemperature(double temperature) { this.temperature = temperature; }

    public int getOxygenSaturation() { return oxygenSaturation; }
    public void setOxygenSaturation(int oxygenSaturation) { this.oxygenSaturation = oxygenSaturation; }

    public String toJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            return objectMapper.writeValueAsString(this);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
            return "{}";
        }
    }
}
