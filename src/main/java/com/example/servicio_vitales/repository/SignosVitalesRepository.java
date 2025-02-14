package com.example.servicio_vitales.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.servicio_vitales.model.VitalSigns;


public interface SignosVitalesRepository extends JpaRepository<VitalSigns, Long> {

    @Query("SELECT v FROM VitalSigns v WHERE v.idPaciente = :idPaciente")
    List<VitalSigns> findByPaciente(@Param("idPaciente") Long idPaciente);
}
