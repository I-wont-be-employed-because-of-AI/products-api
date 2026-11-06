package uk.ac.westminster.products_api;

public class DigitalProduct extends Product implements Discountable {
    private String downloadURL;
    private double fileSizeMB;
    private double discountedPrice;

    public DigitalProduct() {}

    public DigitalProduct(Long id, String name, double price, String downloadURL, double fileSizeMB) {
        super(id, name, price);
        this.downloadURL = downloadURL;
        this.fileSizeMB = fileSizeMB;
    }

    public String getDownloadURL() {
        return downloadURL;
    }

    public double getFileSizeMB() {
        return fileSizeMB;
    }

    @Override
    public String getSummary() {return "name = " + getName() + " | price = $" + getPrice() + " | URL : " + downloadURL + " | size = " + fileSizeMB + " MB";}

    @Override
    public void applyDiscount(double rate) {
        this.discountedPrice = getPrice()*(1-rate);
    }

    @Override
    public double getDiscountedPrice() {
        return discountedPrice;
    }
}
