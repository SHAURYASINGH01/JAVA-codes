import java.util.Scanner;

class Vehicle {
    //..... YOUR CODE STARTS HERE .....
    
    String registrationNumber;
    String ownerName;
    // Constructor to initialize registration number and owner name
    public Vehicle(String registrationNumber, String ownerName) {
        this.registrationNumber = registrationNumber;
        this.ownerName = ownerName;
    }
    // Method to display vehicle details
    public void displayDetails() {
        System.out.println("Registration Number: " + registrationNumber);
        System.out.println("Owner: " + ownerName);
    }
    
    //..... YOUR CODE ENDS HERE .....
}
class Car extends Vehicle {
    //..... YOUR CODE STARTS HERE .....
    
    int numberOfDoors;
    // Constructor to initialize Car attributes
    public Car(String registrationNumber, String ownerName, int numberOfDoors) {
        super(registrationNumber, ownerName);
        this.numberOfDoors = numberOfDoors;
    }
    // Overriding displayDetails method to include Car-specific details
    @Override
    public void displayDetails() {
        System.out.println("Vehicle: Car");
        super.displayDetails();
        System.out.println("Number of Doors: " + numberOfDoors);
    }
    
    //..... YOUR CODE ENDS HERE .....
}
class Motorcycle extends Vehicle {
    //..... YOUR CODE STARTS HERE .....
    
    String engineCapacity;
    // Constructor to initialize Motorcycle attributes
    public Motorcycle(String registrationNumber, String ownerName, String engineCapacity) {
        super(registrationNumber, ownerName);
        this.engineCapacity = engineCapacity;
    }
    // Overriding displayDetails method to include Motorcycle-specific details
    
    @Override
    public void displayDetails() {
        System.out.println("Vehicle: Motorcycle");
        super.displayDetails();
        System.out.println("Engine Capacity: " + engineCapacity);
    }
    
    //..... YOUR CODE ENDS HERE .....
}
class Truck extends Vehicle {
    //..... YOUR CODE STARTS HERE .....
    
    String cargoCapacity;
    // Constructor to initialize Truck attributes
    public Truck(String registrationNumber, String ownerName, String cargoCapacity) {
        super(registrationNumber, ownerName);
        this.cargoCapacity = cargoCapacity;
    }
    // Overriding displayDetails method to include Truck-specific details
    @Override
    public void displayDetails() {
        System.out.println("Vehicle: Truck");
        super.displayDetails();
        System.out.println("Cargo Capacity: " + cargoCapacity);
    }
    
    //..... YOUR CODE ENDS HERE .....
}
public class Main {
    public static void main(String[] args) {
        //..... YOUR CODE STARTS HERE .....
        
        Scanner scanner = new Scanner(System.in);
        // Input the number of operations
        int N = scanner.nextInt();
        scanner.nextLine();  // Consume the newline
        // Process each registration operation
        for (int i = 0; i < N; i++) {
            String operation = scanner.nextLine();
            String[] parts = operation.split(" ");
            // Extract the operation details
            String vehicleType = parts[1];
            String registrationNumber = parts[2];
            String ownerName = parts[3];
            String specificAttribute = parts[4];
            // Register the appropriate vehicle type
            switch (vehicleType.toLowerCase()) {
                case "car":
                    int numberOfDoors = Integer.parseInt(specificAttribute);
                    Car car = new Car(registrationNumber, ownerName, numberOfDoors);
                    car.displayDetails();
                    break;
                case "motorcycle":
                    Motorcycle motorcycle = new Motorcycle(registrationNumber, ownerName, specificAttribute);
                    motorcycle.displayDetails();
                    break;
                case "truck":
                    Truck truck = new Truck(registrationNumber, ownerName, specificAttribute);
                    truck.displayDetails();
                    break;
                default:
                    System.out.println("Unknown vehicle type!");
                    break;
            }
        }
        scanner.close();
        
        //..... YOUR CODE ENDS HERE .....
    }
}
