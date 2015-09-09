package vm;

import java.io.Serializable;

public class Dispenser implements Serializable{

	private Food food;
	private double price;
	private int number;
	private int max;
	public Dispenser(int number, double price, Food food)
	{
		this.food = food;
		this.number = number;
		this.max = number;
		this.price = price;
	}
	public Food getFood() {
		return food;
	}
	public void setFood(Food food) {
		this.food = food;
	}
	@Override
	public String toString() {
		return "Dispenser [food=" + food + ", price=" + price + ", number="
				+ number + "]";
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
}
