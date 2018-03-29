package com.cotiviti.enterprise.cpd.kafka.producer;

/**
 * Created 
 */
public interface UpdateDispositionProducer {

    void updateDataDispositionAndPublishToKafka(String id, String disposition);
}
