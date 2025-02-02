package com.example.servicio_vitales.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.servicio_vitales.model.SignosVitales;
import com.example.servicio_vitales.repository.SignosVitalesRepository;

@Service
public class VitalesService{
    
    @Autowired
    private SignosVitalesRepository signosVitalesRepository;

    public List<SignosVitales> getAllSignosVitales(){
        return signosVitalesRepository.findAll();
    }

}
