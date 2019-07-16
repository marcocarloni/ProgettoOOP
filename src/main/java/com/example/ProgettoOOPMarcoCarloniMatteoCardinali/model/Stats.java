package com.example.ProgettoOOPMarcoCarloniMatteoCardinali.model;

/**
 * Classe modellante per le statistiche
 */
public class Stats 
{

    private String field;
    private double avg;
    private double devStd;
    private double max;
    private double min;
    private double sum;
    private int count;
    
	
	public String getField() {
		return field;
	}

	public void setField(String field) {
		this.field = field;
	}

	public double getAvg() {
		return avg;
	}

	public void setAvg(double avg) {
		this.avg = avg;
	}

	public double getDevStd() {
		return devStd;
	}

	public void setDevStd(double devStd) {
		this.devStd = devStd;
	}

	public double getMax() {
		return max;
	}

	public void setMax(double max) {
		this.max = max;
	}

	public double getMin() {
		return min;
	}

	public void setMin(double min) {
		this.min = min;
	}

	public double getSum() {
		return sum;
	}

	public void setSum(double sum) {
		this.sum = sum;
	}

	public int getCount() {
		return count;
	}

	public void setCount(int count) {
		this.count = count;
	}

    

}