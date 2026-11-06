package uk.ac.westminster.products_api;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.ArrayList;
import java.util.Optional;

@Service
public class ProductService {

    private List<Product> products = new ArrayList<>();
    private Long nextID = 1L;

    public ProductService() {
        products.add(new DigitalProduct(nextID++, "How to OOPs (E-Book)", 29.99, "/downloads/oops.pdf", 6.3) {});
        products.add(new PhysicalProduct(nextID++, "Basmati Rice", 1800, 10, "40x10"));
    }

    public List<Product> getAllProducts(){
        return products;
    }

    public Product addProduct(Product product) {
        product.setId(nextID++);
        products.add(product);
        return product;
    }

    public Optional<Product> getProductById(Long id) {
        return products.stream()
                .filter(p -> p.getId().equals(id))
                .findFirst();
    }

    public void deleteProduct(Long id){
        products.removeIf(p -> p.getId().equals(id));
    }

    public List<Product> findByName(String name) {
        return products.stream()
                .filter(p -> p.getName().contains(name))
                .toList();
    }

    public List<String> getAllSummaries() {
        ArrayList<String> temp = new ArrayList<>();
        for (Product p : products) {
            temp.add(p.getSummary());
        }
        return temp;
    }
}
