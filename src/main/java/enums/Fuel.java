package enums;

public enum Fuel {
   GAS("Gas"),
   DIESEL("Diesel"),
   HYBRID("Hybrid"),
   ELECTRIC("Electric");

   private final String fuel;

    Fuel(String fuel) {
        this.fuel = fuel;
    }

    public String getFuel() {
        return fuel;
    }
}
