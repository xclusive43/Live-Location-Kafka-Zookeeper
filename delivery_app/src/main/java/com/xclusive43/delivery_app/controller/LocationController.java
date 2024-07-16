package com.xclusive43.delivery_app.controller;


import com.xclusive43.delivery_app.service.KafkaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.Random;

@RestController
@RequestMapping("/location")
public class LocationController {
    @Autowired
    private KafkaService kafkaService;

    @PostMapping("update")
    public ResponseEntity<?> updateLocation() {
        for (int i = 0; i <= 200000; i++) {
            this.kafkaService.updateLocation("(" + Math.round(Math.random() * 100) + " , " + Math.round(Math.random() * 99) + ")");
        }
        return new ResponseEntity<>(Map.of("message", "Location Updated"), HttpStatus.OK);

    }
}
