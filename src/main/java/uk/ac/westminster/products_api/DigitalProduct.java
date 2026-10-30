package uk.ac.westminster.products_api;

public class DigitalProduct extends Product {
    private String downloadURL;
    private double fileSizeMB;

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
}
