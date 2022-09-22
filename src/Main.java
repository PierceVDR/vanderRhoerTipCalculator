import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        DecimalFormat formatter = new DecimalFormat("#.##");

        // Welcome message:
        System.out.println("\nWelcome to my tip calculator!");

        System.out.println("-----------------------------------------------");
        // Getting info:

        System.out.print("Enter the number of people in your group: ");
        int people = scan.nextInt();
        scan.nextLine();

        System.out.print("Enter the tip percentage (100 = 100%): ");
        double tipP = scan.nextDouble(); // Tip percentage
        scan.nextLine();

        double totalNoTip = 0; // Sum variable
        while (true) { // Gets costs and calculates sum until -1 entered
            System.out.print("Enter a cost, or -1 to indicate all costs have been entered: $");
            double cost = scan.nextDouble();
            scan.nextLine();

            if (cost==-1) {break;}

            totalNoTip+=cost;
        }

        scan.close();

        System.out.println("-----------------------------------------------");
        // Calculating & printing:

        double tipTotal = totalNoTip*tipP/100; // Both variables are doubles, don't need to worry about flooring
        double totalWithTip = totalNoTip+tipTotal;

        System.out.println("Total Bill Before Tip: $" + formatter.format(totalNoTip));
        System.out.println("Tip Percentage: " + tipP + "%");
        System.out.println("Total Tip: $" + formatter.format(tipTotal));
        System.out.println("Total Bill With Tip: $" + formatter.format(totalWithTip) + "\n"); // Line break included here

        System.out.println("Bill Before Tip, Per Person: " + formatter.format(totalNoTip/people));
        System.out.println("Tip Percentage, Per Person: " + Math.round(tipP/people*100)/100.0 + "%"); // Not required
        System.out.println("Tip, Per Person: $" + formatter.format(tipTotal/people));
        System.out.println("Bill With Tip, Per Person: $" + formatter.format(totalWithTip/people));
    }
}