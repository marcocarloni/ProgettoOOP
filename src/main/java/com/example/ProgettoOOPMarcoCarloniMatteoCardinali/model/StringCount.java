package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model;

/**
 * Classe modellante per il conteggio di stringhe 
 */
public class StringCount 
{

    private String field;
    private int count;

    /**
     * Costruttore della classe
     *
     * @param field Il campo associato al conteggio
     * @param count Il numero delle ripetizioni
     */
    public StringCount(String field,int count) 
    {
        this.field = field;
        this.count= count;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }
}
