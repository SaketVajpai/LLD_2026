package VendingMachine;
import java.util.HashMap;
import java.util.Map;

public class Inventory {

    private final Map<Integer, Integer> stock = new HashMap<>();
    private final Map<Integer, Product> products = new HashMap<>();

    public synchronized void addProduct(Product p, int quantity) {
        products.put(p.getId(), p);
        stock.put(p.getId(), quantity);
    }

    public synchronized boolean isAvailable(int productId) {
        return stock.getOrDefault(productId, 0) > 0;
    }

    public synchronized void reduce(int productId) {
        stock.put(productId, stock.get(productId) - 1);
    }

    public synchronized Product getProduct(int productId) {
        return products.get(productId);
    }
}
