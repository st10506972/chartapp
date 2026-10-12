
package monthly.sales;

public class buverages {

    public static void main(String[] args) {

        // single arrays for the names
        String[] cities = {"Cape Town", "Port Elizabeth", "Pretoria"};
        String[] beverages = {"Coffee", "Tea", "Boba Tea"};

        // two-dimensional array for the sales 
        int[][] sales = {
            {500, 300, 125},   // Cape Town
            {450, 250, 100},   // Port Elizabeth
            {480, 175, 120}    // Pretoria
        };

        // single array to store the total for each city
        int[] cityTotals = new int[3];

        int grandTotal = 0;

        System.out.println("=====================================");
        System.out.println("   NUMBER 1 COFFEE HUT BEVERAGE REPORT");
        System.out.println("=====================================");

        // go through each city
        for (int i = 0; i < 3; i++) {

            System.out.println();
            System.out.println("City: " + cities[i]);
            System.out.println("-------------------------------------");

            // go through each beverage for that city
            for (int j = 0; j < 3; j++) {
                System.out.println(beverages[j] + ": " + sales[i][j]);

                // add to the city total
                cityTotals[i] = cityTotals[i] + sales[i][j];
            }

            System.out.println("Total sales for " + cities[i] + ": " + cityTotals[i]);

            // add the city total to the grand total
            grandTotal = grandTotal + cityTotals[i];
        }

        System.out.println();
        System.out.println("=====================================");
        System.out.println("Total sales for all cities: " + grandTotal);
        System.out.println("=====================================");
    }
}

