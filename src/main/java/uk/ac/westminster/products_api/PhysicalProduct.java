package uk.ac.westminster.products_api;

// A Physical product IS-A product because it directly inherits 3 fields : id, name and price from parent class Product

public class PhysicalProduct extends Product implements Discountable{
    private double weightKG;
    private String dimensions;
    private double discountedPrice;

    public PhysicalProduct() {}

    public PhysicalProduct(Long id, String name, double price, double weightKG, String dimensions){
        super(id, name, price);
        this.weightKG = weightKG;
        this.dimensions= dimensions;
    }

    public double getWeightKG() {
        return weightKG;
    }

    public String getDimensions() {
        return dimensions;
    }

    @Override
    public String getSummary() { return getName() + " | " + getPrice() + " | " + weightKG + "kg | " + dimensions;}

    @Override
    public void applyDiscount(double rate) {
        double capped = Math.min(rate, 0.20);
        this.discountedPrice = getPrice() * (1-capped);

    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
