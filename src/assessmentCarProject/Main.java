package assessmentCarProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	public static void main(String[] args) throws IOException {
		ArrayList<Car> cars = new ArrayList<>();
		BufferedReader car = new BufferedReader(new FileReader("Car_Data.csv"));
		String line = car.readLine();
		while((line = car.readLine()) != null) {
			String[] fields = line.split(",");
			String car_ID = fields[0];
			String brand = fields[1];
			String model = fields[2];
			int year = Integer.parseInt(fields[3]);
			String fuelType = fields[4];
			String color = fields[5];
			double mileage = Double.parseDouble(fields[6]);
		}
		car.close();
	}
	

}//End main
