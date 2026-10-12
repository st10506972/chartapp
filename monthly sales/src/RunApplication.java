


import java.util.Scanner;

// Interface
interface IBeverage {
    String getBeverageType();
    String getCity();
    int getTotalSales();
}

// Abstract class
abstract class Beverage implements IBeverage {

    // Variables to store the beverage type, city and total sales
    private final String beverageType;
    private final String city;
    private final int totalSales;

    // Constructor accepting beverage type, city and total sales
    public Beverage(String beverageType, String city, int totalSales) {
        this.beverageType = beverageType;
        this.city = city;
        this.totalSales = totalSales;
    }

    // Methods to get the beverage type, city and total sales
    @Override
    public String getBeverageType() {
        return beverageType;
    }

    @Override
    public String getCity() {
        return city;
    }

    @Override
    public int getTotalSales() {
        return totalSales;
    }

    // Must be implemented by subclasses
    public abstract void printReport();
}

// Subclass
class BeverageSales extends Beverage {

    // Constructor accepting beverage type, city and total sales
    public BeverageSales(String beverageType, String city, int totalSales) {
        super(beverageType, city, totalSales);
    }

    // Prints the beverage type, city and total sales for the city
   
    @Override
    public void printReport() {
        System.out.println();
        System.out.println("Total sales of " + getBeverageType()
                + " beverages in " + getCity() + ": " + getTotalSales());
    }
}

// Main class
public class RunApplication {

    public static void main(String[] args) {
        // Select beverage type
        try (Scanner input = new Scanner(System.in)) {
            // Select beverage type
            String[] beverages = {"COFFEE", "TEA", "BOBA TEA"};
            int choice = 0;
            
            while (choice < 1 || choice > beverages.length) {
                System.out.println("Select the beverage type");
                for (int i = 0; i < beverages.length; i++) {
                    System.out.println((i + 1) + ". " + beverages[i]);
                }
                System.out.print("Enter choice: ");
                
                if (input.hasNextInt()) {
                    choice = input.nextInt();
                } else {
                    input.next(); // discard invalid input
                }
                input.nextLine();
                
                if (choice < 1 || choice > beverages.length) {
                    System.out.println("Invalid choice. Please try again.\n");
                    choice = 0;
                }
            }
            String beverageType = beverages[choice - 1];
            
            // Enter city
            System.out.print("Enter the city: ");
            String city = input.nextLine().trim().toUpperCase();
            
            // Enter total sales
            int totalSales = -1;
            while (totalSales < 0) {
                System.out.print("Enter the total sales of " + beverageType
                        + " beverages in " + city + ": ");
                if (input.hasNextInt()) {
                    totalSales = input.nextInt();
                } else {
                    input.next();
                }
                if (totalSales < 0) {
                    System.out.println("Invalid amount. Please enter a positive whole number.");
                    totalSales = -1;
                }
            }
            
            // Instantiate BeverageSales and print the report
            BeverageSales report = new BeverageSales(beverageType, city, totalSales);
            report.printReport();
        }
    }
}
