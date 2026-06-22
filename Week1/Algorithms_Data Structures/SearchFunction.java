class Product {
    int productId;
    String productName;
    String category;

    Product(int productId, String productName, String category) {
        this.productId = productId;
        this.productName = productName;
        this.category = category;
    }

    void display() {
        System.out.println(productId + " " + productName + " " + category);
    }
}

public class SearchFunction {

    public static Product linearSearch(Product products[], String target) {
        for (int i = 0; i < products.length; i++) {
            if (products[i].productName.equalsIgnoreCase(target)) {
                return products[i];
            }
        }
        return null;
    }

    public static Product binarySearch(Product products[], String target) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            int compare = products[mid].productName.compareToIgnoreCase(target);

            if (compare == 0) {
                return products[mid];
            } else if (compare < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return null;
    }

    public static void main(String args[]) {
        Product products[] = {
            new Product(101, "Laptop", "Electronics"),
            new Product(102, "Phone", "Electronics"),
            new Product(103, "Shoes", "Fashion"),
            new Product(104, "Watch", "Accessories")
        };

        Product result1 = linearSearch(products, "Shoes");
        if (result1 != null)
            result1.display();

        Product result2 = binarySearch(products, "Shoes");
        if (result2 != null)
            result2.display();
    }
}