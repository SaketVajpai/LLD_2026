package VendingMachine.Product_Selection_Strategy;

import VendingMachine.Inventory;
import VendingMachine.Product;
import VendingMachine.Exceptions.OutOfStockException;

public class DefaultSelectionStrategy implements ProductSelectionStrategy {

    @Override
    public Product selectProduct(Inventory inventory, int requestedProductId) {
        if (!inventory.isAvailable(requestedProductId)) {
            throw new OutOfStockException("Product out of stock");
        }
        return inventory.getProduct(requestedProductId);
    }
}

