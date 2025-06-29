import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static Product linearSearch(Product[] products, String name) {
        for (Product product : products) {
            if (product.productName.equalsIgnoreCase(name)) {
                return product;
            }
        }
        return null;
    }

    public static Product binarySearch(Product[] products, String name) {
        int left = 0, right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;
            int compare = name.compareToIgnoreCase(products[mid].productName);

            if (compare == 0) return products[mid];
            else if (compare < 0) right = mid - 1;
            else left = mid + 1;
        }
        return null;
    }

    public static void main(String[] args) {
        Product[] productList = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Shirt", "Clothing"),
            new Product(103, "Book", "Stationery"),
            new Product(104, "Headphones", "Electronics"),
            new Product(105, "Shoes", "Footwear")
        };

        System.out.println("🔍 Linear Search Result:");
        Product foundLinear = linearSearch(productList, "Book");
        System.out.println(foundLinear != null ? foundLinear : "Product not found");

        Arrays.sort(productList, Comparator.comparing(p -> p.productName.toLowerCase()));

        System.out.println("\n🔍 Binary Search Result:");
        Product foundBinary = binarySearch(productList, "Book");
        System.out.println(foundBinary != null ? foundBinary : "Product not found");
    }
}

class Product {
    int productId;
    String productName;
    String category;

    public Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    @Override
    public String toString() {
        return productId + " - " + productName + " (" + category + ")";
    }
}
