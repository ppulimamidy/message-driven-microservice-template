package com.cotiviti.enterprise.cpd.model;

import org.springframework.data.annotation.Id;

/**
 * Created 
 */
public class Opportunity {

    public static final String COLLECTION_NAME = "opportunity";

    @Id
    private String id;

    private String ruleDesc;
    private int subRuleKey;
    private int midRuleKey;
    private String disposition;
    private String dispositionNote;

    public Opportunity() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

  

    public String getRuleDesc() {
		return ruleDesc;
	}

	public void setRuleDesc(String ruleDesc) {
		this.ruleDesc = ruleDesc;
	}

	public int getSubRuleKey() {
		return subRuleKey;
	}

	public void setSubRuleKey(int subRuleKey) {
		this.subRuleKey = subRuleKey;
	}

	public int getMidRuleKey() {
		return midRuleKey;
	}

	public void setMidRuleKey(int midRuleKey) {
		this.midRuleKey = midRuleKey;
	}

	public String getDisposition() {
		return disposition;
	}

	public void setDisposition(String disposition) {
		this.disposition = disposition;
	}
	

	public String getDispositionNote() {
		return dispositionNote;
	}

	public void setDispositionNote(String dispositionNote) {
		this.dispositionNote = dispositionNote;
	}

	@Override
	public String toString() {
		return "Opportunity [id=" + id + ", ruleDesc=" + ruleDesc + ", subRuleKey=" + subRuleKey + ", midRuleKey="
				+ midRuleKey + ", disposition=" + disposition + "]";
	}
}
