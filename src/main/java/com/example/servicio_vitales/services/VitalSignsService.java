package com.example.servicio_vitales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicio_vitales.model.VitalSigns;
import com.example.servicio_vitales.repository.SignosVitalesRepository;

@Service
public class VitalSignsService {

    @Autowired
    private SignosVitalesRepository signosVitalesRepository;
    
    public List<VitalSigns> getVitalSignsById(Long idPaciente) {
        return signosVitalesRepository.findByPaciente(idPaciente);
    }
}