import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        CaffeinatedBeverage[] inventory =
                new CaffeinatedBeverage[10];

        Scanner keyboard = new Scanner(System.in);

        int choice;
        int ounces = 0;
        int brewTemp = 0;
        int count = 0;

        String name;
        double price = 0.0;

        do {

            System.out.println();
            System.out.println("1) Enter new Tea");
            System.out.println("2) Enter new Yerba Mate");
            System.out.println("3) Exit");
            System.out.print(">> ");

            choice = keyboard.nextInt();
            keyboard.nextLine();

            if (choice >= 1 && choice <= 2) {

                System.out.print("Enter name: ");
                name = keyboard.nextLine();

                System.out.print("Enter ounces: ");
                ounces = keyboard.nextInt();

                System.out.print("Enter price: $");
                price = keyboard.nextDouble();

                System.out.print(
                        "Enter brew temperature (Celsius): ");
                brewTemp = keyboard.nextInt();

                keyboard.nextLine();

                if (choice == 1) {

                    inventory[count] =
                            new Tea(
                                    name,
                                    ounces,
                                    price,
                                    brewTemp);

                } else {

                    inventory[count] =
                            new YerbaMate(
                                    name,
                                    ounces,
                                    price,
                                    brewTemp);
                }

                count++;
            }

        } while (choice != 3);

        // Print inventory
        System.out.println("\n--- Inventory ---");

        for (int i = 0; i < count; i++) {

            System.out.println(inventory[i]);
        }

        // Highest priced Yerba Mate
        YerbaMate highest =
                findHighestPricedYerbaMate(inventory);

        if (highest != null) {

            System.out.println(
                    "\nHighest priced Yerba Mate:");
            System.out.println(highest);
        }

        // Average price
        double average =
                findAveragePrice(inventory);

        System.out.printf(
                "\nAverage beverage price: $%.2f\n",
                average);

        keyboard.close();
    }

    // Finds average price of all beverages
    public static double findAveragePrice(
            CaffeinatedBeverage[] inventory) {

        double total = 0;
        int count = 0;

        for (int i = 0; i < inventory.length; i++) {

            if (inventory[i] != null) {

                total += inventory[i].getPrice();
                count++;
            }
        }

        if (count == 0) {
            return 0;
        }

        return total / count;
    }

    // Finds highest priced Yerba Mate
    public static YerbaMate findHighestPricedYerbaMate(
            CaffeinatedBeverage[] inventory) {

        YerbaMate highest = null;

        for (int i = 0; i < inventory.length; i++) {

            if (inventory[i] instanceof YerbaMate) {

                YerbaMate current =
                        (YerbaMate) inventory[i];

                if (highest == null
                        || current.getPrice()
                        > highest.getPrice()) {

                    highest = current;
                }
            }
        }

        return highest;
    }
}