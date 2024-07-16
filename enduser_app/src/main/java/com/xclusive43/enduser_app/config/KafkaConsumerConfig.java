package com.xclusive43.enduser_app.config;

import com.xclusive43.enduser_app.constants.Constants;
import org.slf4j.Logger;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.KafkaListener;

@Configuration
public class KafkaConsumerConfig {



    @KafkaListener(topics = Constants.LOCATION_TOPIC_NAME, groupId = Constants.GROUP_ID)
    public void updatedLocation(String value) {
        System.out.println("Location: "+value);
    }
}
