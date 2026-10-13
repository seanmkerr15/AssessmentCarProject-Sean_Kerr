//this is the start of your Car class 

package assessmentCarProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;

public class Car {

	private String car_ID;
	private String brand;
	private String model;
	private int year;
	private String fuel_Type;
	private String color;
	private double mileage;
	

	public Car(String car_ID, String brand, String model, int year, String fuel_type, String color, double mileage) {
		super();
		this.car_ID = car_ID;
		this.brand = brand;
		this.model = model;
		this.year = year;
		this.fuel_Type = fuel_type;
		this.color = color;
		this.mileage = mileage;
	}


	public String getCar_ID() {
		return car_ID;
	}


	public void setCar_ID(String car_ID) {
		car_ID = car_ID;
	}


	public String getBrand() {
		return brand;
	}


	public void setBrand(String brand) {
		brand = brand;
	}


	public String getModel() {
		return model;
	}


	public void setModel(String model) {
		model = model;
	}


	public int getYear() {
		return year;
	}


	public void setYear(int year) {
		year = year;
	}


	public String getFuel_type() {
		return fuel_Type;
	}


	public void setFuel_type(String fuel_type) {
		fuel_Type = fuel_type;
	}


	public String getColor() {
		return color;
	}


	public void setColor(String color) {
		color = color;
	}


	public double getMileage() {
		return mileage;
	}


	public void setMileage(double mileage) {
		mileage = mileage;
	}


	@Override
	public int hashCode() {
		return Objects.hash(brand, car_ID, color, fuel_Type, Double.valueOf(mileage), model, Integer.valueOf(year));
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Car other = (Car) obj;
		return Objects.equals(brand, other.brand) && Objects.equals(car_ID, other.car_ID)
				&& Objects.equals(color, other.color) && Objects.equals(fuel_Type, other.fuel_Type)
				&& Double.doubleToLongBits(mileage) == Double.doubleToLongBits(other.mileage)
				&& Objects.equals(model, other.model) && year == other.year;
	}


	@Override
	public String toString() {
		return "Car [car_ID=" + car_ID + ", brand=" + brand + ", model=" + model + ", year=" + year + ", fuel_Type="
				+ fuel_Type + ", color=" + color + ", mileage=" + mileage + "]";
	}



	
}//End main
