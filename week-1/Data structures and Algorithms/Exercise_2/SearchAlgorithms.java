public class SearchAlgorithms {

    // 1. Linear Search Algorithm
    public static Product linearSearch(Product[] products, String targetId) {
        for (Product product : products) {
            if (product.getProductId().equals(targetId)) {
                return product; // Element found
            }
        }
        return null; // Element not found
    }

    // 2. Binary Search Algorithm (Requires a sorted array)
    public static Product binarySearch(Product[] products, String targetId) {
        int left = 0;
        int right = products.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2; // Prevents potential integer overflow
            int comparison = products[mid].getProductId().compareTo(targetId);

            if (comparison == 0) {
                return products[mid]; // Element found
            } else if (comparison < 0) {
                left = mid + 1; // Target is in the right half
            } else {
                right = mid - 1; // Target is in the left half
            }
        }
        return null; // Element not found
    }
}