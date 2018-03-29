package com.cotiviti.enterprise.cpd.dao;

/**
 * Created by 
 */
public interface OpportunityRepositoryCustom {

    public long updateDispositionNoteOpportunity(String id, String dispositionNote);

    public long updateDispositionOpportunity(String id, String disposition);
}
