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
        products.add(new DigitalProduct(nextID++, "Cynerpunk2067 (E-Book)", 29.99, "/downloads/cyberpunk2067.pdf",6.3));
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
}
