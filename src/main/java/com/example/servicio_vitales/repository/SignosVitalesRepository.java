package com.example.servicio_vitales.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.servicio_vitales.model.SignosVitales;


public interface SignosVitalesRepository extends JpaRepository<SignosVitales, Long> {

}

