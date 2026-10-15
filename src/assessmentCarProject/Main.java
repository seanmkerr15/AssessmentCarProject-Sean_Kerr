package assessmentCarProject;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

	//insertion sort algorithm
	static void sort(ArrayList<Car> list) {
		for (int i = 1; i < list.size(); i++) {
			Car key = list.get(i);
			int j = i - 1;
		
		while( j >= 0 && list.get(j).getBrand().compareToIgnoreCase(key.getBrand()) > 0) {
			list.set(j+1, list.get(j));
			j = j - 1;
		}
		list.set(j + 1, key);
	}
		
	}
	
	//binary search
	 public static int binarySearch(ArrayList<Car> list, String targetBrand) {
		int low = 0;
		int hi = list.size() - 1;
		
		while (low <= hi) {
			int mid = (low + hi)/2;
			String midBrand = list.get(mid).getBrand();
			int compare = midBrand.compareToIgnoreCase(targetBrand);
			
			if (compare == 0) {
				return (mid); //found
			}
			else if (compare < 0) {
				low = mid + 1; // target is after mid
			}
			else {
				hi = mid - 1;
			}
			
		}
		return -1; //not found
	}
	
	public static void main(String[] args) throws IOException {
		
		Scanner scnr = new Scanner(System.in);
		int input = 0;

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
		ArrayList<Car> working = new ArrayList<>(cars.subList(0, 5000));
		//Boolean to check if it is sorted
		boolean sorted = false;
		do {
			System.out.println("\nPlease input respective number");
			System.out.println("1. Sort cars by Brand");
			System.out.println("2. Search for cars by Brand");
			System.out.println("3. Exit");
			input = scnr.nextInt();
			
			
			switch (input) {
			
			case 1: 
				//sets sorted = true and sorts
				sorted = true;
				sort(working);
				//prints out first 10
				for (int i = 0; i < 10; i++) {
				    System.out.println(working.get(i));
				}
				break;
				
			case 2:
				if (!sorted) {
					System.out.println("\nPlease sort before searching");
					break;
				}
				if (sorted) {
				scnr.nextLine();
				System.out.println("Please input Brand: ");
				String brand = scnr.nextLine();
				int index = binarySearch(working, brand);
				if (index == -1) {
					System.out.println("No cars found for brand: " + brand);
					break;
				}
				System.out.println("search " + working.get(index));
				int right = index;

				// expand left: check the NEXT position before stepping onto it
				while (index - 1 >= 0 && working.get(index - 1).getBrand().equalsIgnoreCase(brand)) {
				    index--;
				}

				// expand right: check the NEXT position before stepping onto it
				while (right + 1 < working.size() && working.get(right + 1).getBrand().equalsIgnoreCase(brand)) {
				    right++;
				}

				// print the whole matched block
				for (int i = index; i <= right; i++) {
				    System.out.println(working.get(i));
				}
				break;
				}
			case 3:
				System.out.println("Exiting Program.");
				break;
			default:
				System.out.println("Invalid choice, try again.");
			}
			
		} 
		while(input !=3);
	}//Main
	
	

}//End main
