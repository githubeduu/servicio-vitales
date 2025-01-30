package com.example.servicio_vitales.controller;

import com.example.servicio_vitales.DTO.*;
import com.example.servicio_vitales.services.RabbitMQSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/mensaje")
public class MensajeController {

    @Autowired
    private RabbitMQSender rabbitMQSender;

    @PostMapping("/encuesta")
    public String enviarMensaje(@RequestBody MensajeDTO mensajeDTO) {
        rabbitMQSender.enviarMensaje(mensajeDTO);
        return "Mensaje enviado a la cola!";
    }
}