package com.cotiviti.enterprise.cpd.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.cotiviti.enterprise.cpd.model.Opportunity;

import java.util.List;
import java.util.Optional;

/**
 * 
 * */
public interface OpportunityRepository extends MongoRepository<Opportunity, String>, OpportunityRepositoryCustom {

    public List<Opportunity> findAll();

    public Optional<Opportunity> findById(String id);
}
