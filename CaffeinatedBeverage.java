//This is the class that shows a caffeinated beverage
//@author Alexis zamudio
public class CaffeinatedBeverage {

    // Constants
    public static final String DEFAULT_NAME = "Caffeine Fix";
    public static final int DEFAULT_OUNCES = 16;
    public static final double DEFAULT_PRICE = 0.99;

    // Instance variables
    private String name;
    private int ounces;
    private double price;

    
     //Full constructor.
     
    public CaffeinatedBeverage(
            String name,
            int ounces,
            double price) {

        if (!this.setAll(name, ounces, price)) {

            System.out.println(
                    "ERROR: Bad data given to full "
                    + "CaffeinatedBeverage constructor.");

            System.exit(0);
        }
    }

    //Default constructor.
    
    public CaffeinatedBeverage() {
        this(DEFAULT_NAME, DEFAULT_OUNCES, DEFAULT_PRICE);
    }

    /**
     * Copy constructor.
     */
    public CaffeinatedBeverage(
            CaffeinatedBeverage original) {

        if (original != null) {

            this.setAll(
                    original.name,
                    original.ounces,
                    original.price);

        } else {

            System.out.println(
                    "ERROR: Null data given to copy "
                    + "CaffeinatedBeverage constructor.");

            System.exit(0);
        }
    }

    // SETTERS / MUTATORS

    public boolean setName(String name) {

        if (name != null && name.length() > 0) {
            this.name = name;
            return true;
        }

        return false;
    }

    public boolean setOunces(int ounces) {

        if (ounces >= 0) {
            this.ounces = ounces;
            return true;
        }

        return false;
    }

    public boolean setPrice(double price) {

        if (price >= 0) {
            this.price = price;
            return true;
        }

        return false;
    }

    public boolean setAll(
            String name,
            int ounces,
            double price) {

        return this.setName(name)
                && this.setOunces(ounces)
                && this.setPrice(price);
    }

    // GETTERS / ACCESSORS

    public String getName() {
        return this.name;
    }

    public int getOunces() {
        return this.ounces;
    }

    public double getPrice() {
        return this.price;
    }

    //Simulates taking a sip from the beverage.
    
    public boolean sip(int ounces) {

        if (ounces < 0) {
            return this.ounces > 0;
        }

        if (this.ounces >= ounces) {
            this.ounces -= ounces;
        } else {
            this.ounces = 0;
        }

        return this.ounces > 0;
    }

    @Override
    public boolean equals(Object o) {

        if (o == null || this.getClass() != o.getClass()) {
            return false;
        }

        CaffeinatedBeverage that =
                (CaffeinatedBeverage) o;

        return this.ounces == that.ounces
                && Double.compare(this.price,
                                  that.price) == 0
                && this.name.equals(that.name);
    }

    @Override
    public String toString() {

        return String.format(
                "CaffeinatedBeverage: name = %s, "
                + "%d fl. oz., $%.2f",
                this.name,
                this.ounces,
                this.price);
    }
}