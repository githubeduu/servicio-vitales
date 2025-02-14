package com.example.servicio_vitales.services;

import java.util.Random;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.kafka.core.KafkaTemplate;


import com.example.servicio_vitales.DTO.SeñalesVitalesDTO;

@Service
public class KafkaProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(KafkaProducerService.class);
    private static final String TOPIC = "senales_vitales";
    private final Random random = new Random();

    private final KafkaTemplate<String, String> kafkaTemplate;

    public KafkaProducerService(KafkaTemplate<String, String> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }

    public void sendMessage() {

        SeñalesVitalesDTO vitalSign = new SeñalesVitalesDTO(
                1,
                getRandomHeartRate(),
                getRandomTemperature(),
                getRandomOxygenSaturation()
        );

        String message = vitalSign.toJson();



        LOGGER.info("Enviando mensaje al tópico {}: {}", TOPIC, message);
        kafkaTemplate.send(TOPIC, message);
    }


    private int getRandomHeartRate() {
        return 60 + random.nextInt(41); // 60 - 100 bpm - Frecuencia Cardiaca
    }

    private double getRandomTemperature() {
        return 36.1 + random.nextDouble() * 1.1; // 36.1 - 37.2 °C - Temperatura Corporal
    }

    private int getRandomOxygenSaturation() {
        return 95 + random.nextInt(6); // 95 - 100% - Saturacioón de Oxígeno
    }
}
