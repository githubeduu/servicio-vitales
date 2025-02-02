package com.example.servicio_vitales.controller;

import com.example.servicio_vitales.DTO.*;
import com.example.servicio_vitales.model.SignosVitales;
import com.example.servicio_vitales.services.RabbitMQSender;
import com.example.servicio_vitales.services.VitalesService;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vitales")
public class VitalesController {

    private final VitalesService signoVitalesService;

    public VitalesController(VitalesService signoVitalesService) {
        this.signoVitalesService = signoVitalesService;
    }


    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/informe")
    public String enviarInforme(@RequestBody VitalesDTO vitalesDTO) {
        rabbitMQSender.enviarInforme(vitalesDTO);
        return "Mensaje enviado a la cola!";
    }


    

    @Scheduled(fixedRate = 20000) // Cada 20 segundos
    public void enviarResumenSenalesVitales() {
        List<SignosVitales> signosVitales = signoVitalesService.getAllSignosVitales();

        rabbitMQSender.enviarInformeCron(signosVitales);
    }
}