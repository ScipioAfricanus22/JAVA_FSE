import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        // Setup raw unsorted data
        Product[] products = {
            new Product("P104", "Wireless Mouse", "Electronics"),
            new Product("P101", "Mechanical Keyboard", "Electronics"),
            new Product("P105", "Gaming Chair", "Furniture"),
            new Product("P103", "Noise Cancelling Headphones", "Electronics"),
            new Product("P102", "4K Monitor", "Electronics")
        };

        String targetId = "String Target P103";
        String target = "P103";

        // --- Linear Search Demonstration ---
        System.out.println("--- Executing Linear Search ---");
        Product resultLinear = SearchAlgorithms.linearSearch(products, target);
        System.out.println("Result: " + (resultLinear != null ? resultLinear : "Not Found"));

        // --- Binary Search Demonstration ---
        System.out.println("\n--- Executing Binary Search ---");
        // CRITICAL STEP: Binary search requires data sorted by the search key
        Arrays.sort(products); 

        Product resultBinary = SearchAlgorithms.binarySearch(products, target);
        System.out.println("Result: " + (resultBinary != null ? resultBinary : "Not Found"));
    }
}