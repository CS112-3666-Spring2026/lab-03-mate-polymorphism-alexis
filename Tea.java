public class Tea extends CaffeinatedBeverage {

    public static final int DEFAULT_BREW_TEMP = 90;

    private int brewTemp;

    
     //Full constructor.
    public Tea(
            String name,
            int ounces,
            double price,
            int brewTemp) {

        super(name, ounces, price);

        if (!this.setBrewTemp(brewTemp)) {

            System.out.println(
                    "ERROR: Bad data given to "
                    + "full Tea constructor.");

            System.exit(0);
        }
    }

    
    //Default constructor.
     
    public Tea() {

        super();
        this.setBrewTemp(DEFAULT_BREW_TEMP);
    }

    
    //Copy constructor.
     
    public Tea(Tea original) {

        super(original);

        if (original != null) {

            this.brewTemp = original.brewTemp;

        } else {

            System.out.println(
                    "ERROR: Null data given to "
                    + "copy Tea constructor.");

            System.exit(0);
        }
    }

    // SETTERS / MUTATORS

    public boolean setBrewTemp(int brewTemp) {

        if (brewTemp >= 0) {

            this.brewTemp = brewTemp;
            return true;
        }

        return false;
    }

    public boolean setAll(
            String name,
            int ounces,
            double price,
            int brewTemp) {

        return super.setAll(name, ounces, price)
                && this.setBrewTemp(brewTemp);
    }

    // GETTERS / ACCESSORS

    public int getBrewTemp() {
        return this.brewTemp;
    }

    @Override
    public boolean equals(Object other) {

        if (other == null
                || !(other instanceof Tea)) {

            return false;
        }

        Tea otherTea = (Tea) other;

        return super.equals(otherTea)
                && this.brewTemp
                == otherTea.brewTemp;
    }

    @Override
    public String toString() {

        return String.format(
                "Tea: %s, %d ounces, "
                + "brewed @ %d°C, $%.2f",
                this.getName(),
                this.getOunces(),
                this.brewTemp,
                this.getPrice());
    }
}
