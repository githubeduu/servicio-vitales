package com.example.servicio_vitales.DTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;

public class SeñalesVitalesDTO {

    @JsonProperty("idPaciente")
    private int idPaciente;

    @JsonProperty("heartRate")
    private int heartRate;
    
    @JsonProperty("bodyTemperature")
    private double bodyTemperature;
    
    @JsonProperty("bloodPressure")
    private int bloodPressure;

    public SeñalesVitalesDTO(int idPaciente, int heartRate, double bodyTemperature, int bloodPressure) {
        this.idPaciente = idPaciente;
        this.heartRate = heartRate;
        this.bodyTemperature = bodyTemperature;
        this.bloodPressure = bloodPressure;
    }

    
    public int getIdPaciente() { return idPaciente; }
    public void setIdPaciente(int idPaciente) { this.idPaciente = idPaciente; }

    public int getHeartRate() { return heartRate; }
    public void setHeartRate(int heartRate) { this.heartRate = heartRate; }

    public double getBodyTemperature() { return bodyTemperature; }
    public void setBodyTemperature(double bodyTemperature) { this.bodyTemperature = bodyTemperature; }

    public int getBloodPressure() { return bloodPressure; }
    public void setBloodPressure(int bloodPressure) { this.bloodPressure = bloodPressure; }

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
