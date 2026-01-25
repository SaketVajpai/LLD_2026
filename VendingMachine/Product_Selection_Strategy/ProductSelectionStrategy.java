package VendingMachine.Product_Selection_Strategy;

import VendingMachine.Inventory;
import VendingMachine.Product;

public interface ProductSelectionStrategy {
    Product selectProduct(Inventory inventory, int requestedProductId);
}

