package com.cotiviti.enterprise.cpd.dao;

import com.cotiviti.enterprise.cpd.model.Opportunity;
import com.mongodb.WriteResult;
import com.mongodb.client.result.UpdateResult;

import org.bson.BsonValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

/**
 * Created by 
 */
public class OpportunityRepositoryImpl implements OpportunityRepositoryCustom {

    @Autowired
    private MongoTemplate mongoTemplate;

    @Override
    public long updateDispositionNoteOpportunity(String id, String dispositionNote) {

        Query query = new Query();
                query.addCriteria(Criteria.where("id").is(id));

        Update update = new Update();
        update.set("dispositionNote", dispositionNote);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Opportunity.class, Opportunity.COLLECTION_NAME);
        return result.getMatchedCount();
    }

    @Override
    public long updateDispositionOpportunity(String id, String disposition) {
        Query query = new Query();
        query.addCriteria(Criteria.where("id").is(id));

        Update update = new Update();
        update.set("disposition", disposition);

        UpdateResult result = mongoTemplate.updateFirst(query, update, Opportunity.class, Opportunity.COLLECTION_NAME);

        return result.getMatchedCount();
    }
}
