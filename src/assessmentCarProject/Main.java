package assessmentCarProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main {

	//insertion sort algorithm
	//FIXMEEEEEEEE!!!!
	static void sort(ArrayList<Car> list) {
		for (int i = 1; i < list.size(); i++) {
			Car key = list.get(i);
			int j = i - 1;
		
		
		while( j >= 0 && list.get(j).getBrand().compareTo(key.getBrand()) > 0) {
			list.set(j+1, list.get(j));
			j = j - 1;
		}
		list.set(j + 1, key);
	}
	}
	
	public static void main(String[] args) throws IOException {
		//Read file and separates columns by rows.
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
			
			Car c = new Car(car_ID, brand, model, year, fuelType, color, mileage);
			cars.add(c);
		}
		car.close();
		//Where all the fields and stored.
		ArrayList<Car> working = new ArrayList<>(cars.subList(0, 2000));
		
		//FIXMEEEE!!!!!!!
		sort(working);
		for(Car num : working) {
			System.out.println(working);
		}
	}//Main
	
	

}//End main
