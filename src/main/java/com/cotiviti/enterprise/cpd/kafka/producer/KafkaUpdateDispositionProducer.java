package com.cotiviti.enterprise.cpd.kafka.producer;

import com.cotiviti.enterprise.cpd.dao.OpportunityRepository;
import com.cotiviti.enterprise.cpd.model.Opportunity;

import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.Message;
import org.springframework.messaging.support.GenericMessage;
import org.springframework.stereotype.Component;

/**
 * Created 
 */
@Component
public class KafkaUpdateDispositionProducer implements UpdateDispositionProducer {

    @Autowired
    private OpportunityRepository repository;

    private static final Logger LOG = LoggerFactory.getLogger(Sender.class);

    @Autowired
    private KafkaTemplate<String, String> kafkaTemplate;

    @Value("${app.cpd.topic.disposition}")
    private String topic;


    @Override
    public void updateDataDispositionAndPublishToKafka(String id, String dispositionNote) {

        Optional<Opportunity> opportunity = repository.findById(id);
        
        //send to kafka topic dispositionUpdate
      
        LOG.info("sending message='{}' to topic='{}'", dispositionNote, topic);
        kafkaTemplate.send(topic, dispositionNote);
      
        repository.updateDispositionNoteOpportunity(id, dispositionNote);
    }
}
