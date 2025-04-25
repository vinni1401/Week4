import java.util.*;
import java.util.stream.Collectors;

class Sale {
    String productId;
    int quantity;
    double price;

    public Sale(String productId, int quantity, double price) {
        this.productId = productId;
        this.quantity = quantity;
        this.price = price;
    }
}

class ProductSales {
    String productId;
    double totalRevenue;

    public ProductSales(String productId, double totalRevenue) {
        this.productId = productId;
        this.totalRevenue = totalRevenue;
    }

    @Override
    public String toString() {
        return "ProductID: " + productId + ", Revenue: $" + totalRevenue;
    }
}

public class ProductSalesAnalysis {
    public static void main(String[] args) {
        List<Sale> sales = Arrays.asList(
            new Sale("P101", 5, 100.0),
            new Sale("P102", 15, 200.0),
            new Sale("P103", 25, 150.0),
            new Sale("P104", 12, 300.0),
            new Sale("P105", 8, 180.0),
            new Sale("P106", 30, 250.0),
            new Sale("P107", 50, 50.0)
        );

        // 1. Filter: quantity > 10
        List<Sale> filtered = sales.stream()
            .filter(s -> s.quantity > 10)
            .collect(Collectors.toList());

        // 2. Transform to ProductSales (total revenue)
        List<ProductSales> transformed = filtered.stream()
            .map(s -> new ProductSales(s.productId, s.quantity * s.price))
            .collect(Collectors.toList());

        // 3. Sort by revenue descending
        List<ProductSales> sorted = transformed.stream()
            .sorted(Comparator.comparingDouble(p -> -p.totalRevenue))
            .collect(Collectors.toList());

        // 4. Top 5 products by revenue
        List<ProductSales> top5 = sorted.stream()
            .limit(5)
            .collect(Collectors.toList());

        // Display
        System.out.println("Top 5 Products by Revenue:");
        top5.forEach(System.out::println);
    }
}
