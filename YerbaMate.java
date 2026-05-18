public class YerbaMate extends Tea {

    // Constants
    public static final int DEFAULT_NUM_PASSES = 0;

    // Instance variable
    private int numPasses;

    // Full constructor
    public YerbaMate(
            String name,
            int ounces,
            double price,
            int brewTemp,
            int numPasses) {

        super(name, ounces, price, brewTemp);

        if (!setNumPasses(numPasses)) {

            System.out.println(
                    "ERROR: Invalid data for YerbaMate.");

            System.exit(0);
        }
    }

    // Constructor with default numPasses
    public YerbaMate(
            String name,
            int ounces,
            double price,
            int brewTemp) {

        this(
                name,
                ounces,
                price,
                brewTemp,
                DEFAULT_NUM_PASSES);
    }

    // Default constructor
    public YerbaMate() {

        super();
        this.numPasses = DEFAULT_NUM_PASSES;
    }

    // Copy constructor
    public YerbaMate(YerbaMate original) {

        super(original);

        if (original != null) {

            this.numPasses = original.numPasses;

        } else {

            System.out.println(
                    "ERROR: Null object passed.");

            System.exit(0);
        }
    }

    // Private setter
    private boolean setNumPasses(int numPasses) {

        if (numPasses >= 0) {

            this.numPasses = numPasses;
            return true;
        }

        return false;
    }

    // Getter
    public int getNumPasses() {

        return this.numPasses;
    }

    // Pass the mate
    public void passMate() {

        this.numPasses++;

        System.out.println(
                "Passed the mate. Current passes: "
                + this.numPasses);
    }

    // Refill beverage
    public void refill(int ounces) {

        if (ounces > 0) {

            setOunces(
                    getOunces() + ounces);
        }
    }

    @Override
    public boolean equals(Object other) {

        if (other == null
                || !(other instanceof YerbaMate)) {

            return false;
        }

        YerbaMate otherMate =
                (YerbaMate) other;

        return super.equals(otherMate)
                && this.numPasses
                == otherMate.numPasses;
    }

    @Override
    public String toString() {

        return String.format(
                "Yerba Mate: %s, %d ounces, "
                + "brewed @ %d°C, $%.2f, "
                + "%d passes so far",
                getName(),
                getOunces(),
                getBrewTemp(),
                getPrice(),
                this.numPasses);
    }
}