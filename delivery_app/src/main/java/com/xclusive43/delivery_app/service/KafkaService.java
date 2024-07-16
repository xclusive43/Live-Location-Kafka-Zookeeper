package com.xclusive43.delivery_app.service;

import com.xclusive43.delivery_app.config.Constants;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    private Logger logger = LoggerFactory.getLogger(KafkaService.class);

    public boolean updateLocation(String location) {
//        BULK messaging
        this.kafkaTemplate.send(Constants.LOCATION_TOPIC_NAME, location);
        System.out.println("---------------------------");

        return true;
    }
}
