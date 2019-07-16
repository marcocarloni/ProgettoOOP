package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model;

/**
 * Classe modellante per i metadata
 */
public class MetaData 
{
	private String alias;
    private String sourceField;
    private String type;

    public String getSourceField() {
        return sourceField;
    }

    public String getAlias() {
		return alias;
	}

	public void setAlias(String alias) {
		this.alias = alias;
	}

	public void setSourceField(String sourceField) {
        this.sourceField = sourceField;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

}
