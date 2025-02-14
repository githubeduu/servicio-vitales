package com.example.servicio_vitales.controller;

import com.example.servicio_vitales.services.KafkaProducerService;
import com.example.servicio_vitales.services.RabbitMQSender;
import com.example.servicio_vitales.services.VitalesService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vitales")
public class VitalesController {

    private final VitalesService signoVitalesService;
    
    private final KafkaProducerService kafkaProducerService;

    public VitalesController(VitalesService signoVitalesService, KafkaProducerService kafkaProducerService) {
        this.signoVitalesService = signoVitalesService;
        this.kafkaProducerService = kafkaProducerService;
    }

    @Scheduled(fixedRate = 1000) // Cada 5 segundos
    public void enviarResumenSenalesVitales() {

        kafkaProducerService.sendMessage();
    }

   //SE MANTIENE ESTE CODIGO, POR SI LO SOLICITAN EN EL EXAMEN
    // @Autowired
    // private RabbitMQSender rabbitMQSender;

    
   // @Scheduled(fixedRate = 1000) // Cada 5 segundos
    // public void enviarResumenSenalesVitales() {
    //     List<SignosVitales> signosVitales = signoVitalesService.getAllSignosVitales();

    //     rabbitMQSender.enviarInformeCron(signosVitales);
    // }

    
}