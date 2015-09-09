package vm;

import java.io.Serializable;

public class Food implements Serializable {

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNutritionInformation() {
		return nutritionInformation;
	}
	public void setNutritionInformation(String nutritionInformation) {
		this.nutritionInformation = nutritionInformation;
	}
	public Food(){}
	public Food(String name, String nutritionInformation)
	{
		this.name = name;
		this.nutritionInformation = nutritionInformation;
	}
	private String name;
	private String nutritionInformation;
	@Override
	public String toString() {
		return "Food [name=" + name + ", nutritionInformation="
				+ nutritionInformation + "]";
	}
}
