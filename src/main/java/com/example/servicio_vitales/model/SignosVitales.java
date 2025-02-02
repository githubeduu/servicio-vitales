package com.example.servicio_vitales.model;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "vital_signs")
public class SignosVitales {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vital_signs;

    @Column(name = "IDPACIENTE", nullable = false)
    private int id_paciente;

    @Column(name = "HEARTRATE", nullable = false)
    private Double heartrate;

    @Column(name = "FECHA", nullable = false)
    private Date fecha;

    // Getters y setters
    public Long getId() {
        return id_vital_signs;
    }

    public void setId(Long id_vital_signs) {
        this.id_vital_signs = id_vital_signs;
    }

    public int getIdPaciente() {
        return id_paciente;
    }

    public void setIdPaciente(int id_paciente) {
        this.id_paciente = id_paciente;
    }

    public Double getHeartrate() {
        return heartrate;
    }

    public void setHeart(Double heartrate) {
        this.heartrate = heartrate;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
