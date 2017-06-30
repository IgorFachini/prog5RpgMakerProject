package frojing.rpgmaker.entity;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

public class Attribute implements Bean {

	public Attribute(long id){
		super();
		this.id = id;
	}
	
	public Attribute(String name, int minimumValue, int maxValue, int priceMultiplier) {
		super();
		this.name = name;
		this.minimumValue = minimumValue;
		this.maxValue = maxValue;
		this.priceMultiplier = priceMultiplier;
		setCurrentValue(this.minimumValue);
	}

	@Id
	@GeneratedValue
	private long id;

	@NotNull
	private String name;
	
	private int currentValue;
	
	private int minimumValue;
	
	private int maxValue;
	
	private int priceMultiplier;
	
	private int specialMultiplier;
	
	private String specialization;

	@Override
	public long getId() {
		return id;
	}

	@Override
	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getCurrentValue() {
		return currentValue;
	}

	public void setCurrentValue(int currentValue) {
		this.currentValue = currentValue;
		this.specialMultiplier = this.currentValue + 1;
	}

	public int getMinimumValue() {
		return minimumValue;
	}

	public void setMinimumValue(int minimumValue) {
		this.minimumValue = minimumValue;
	}

	public int getMaxValue() {
		return maxValue;
	}

	public void setMaxValue(int maxValue) {
		this.maxValue = maxValue;
	}

	public int getPriceMultiplier() {
		return priceMultiplier;
	}

	public void setPriceMultiplier(int priceMultiplier) {
		this.priceMultiplier = priceMultiplier;
	}

	public int getSpecialMultiplier() {
		return specialMultiplier;
	}

	public String getSpecialization() {
		return specialization;
	}

	public void setSpecialization(String specialization) {
		this.specialization = specialization;
	}

}
