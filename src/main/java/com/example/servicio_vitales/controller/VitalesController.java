package com.example.servicio_vitales.controller;

import com.example.servicio_vitales.model.VitalSigns;
import com.example.servicio_vitales.services.KafkaProducerService;
import com.example.servicio_vitales.services.VitalSignsService;

import java.util.List;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/vitales")
public class VitalesController {

    private final VitalSignsService vitalSignsService;
    
    private final KafkaProducerService kafkaProducerService;

    public VitalesController(KafkaProducerService kafkaProducerService,
    VitalSignsService vitalSignsService) {
        this.kafkaProducerService = kafkaProducerService;
        this.vitalSignsService = vitalSignsService;
    }

    @Scheduled(fixedRate = 1000) // Cada 5 segundos
    public void enviarResumenSenalesVitales() {

        kafkaProducerService.sendMessage();
    }

    @GetMapping("/paciente/{idPaciente}")
    public List<VitalSigns> getVitalSigns(@PathVariable Long idPaciente) {
        return vitalSignsService.getVitalSignsById(idPaciente);
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