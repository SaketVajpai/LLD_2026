package VendingMachine;

import VendingMachine.Change_Return_Strategy.ChangeReturnStrategy;
import VendingMachine.Change_Return_Strategy.GreedyChangeStrategy;
import VendingMachine.Product_Selection_Strategy.DefaultSelectionStrategy;
import VendingMachine.Product_Selection_Strategy.ProductSelectionStrategy;

public class Main {
    public static void main(String[] args) {

        Inventory inventory = new Inventory();
        inventory.addProduct(new Product(1, "Coke", 10), 5);
        inventory.addProduct(new Product(2, "Pepsi", 15), 10);


        ChangeReturnStrategy changeReturnStrategy = new GreedyChangeStrategy();
        ProductSelectionStrategy productSelectionStrategy = new DefaultSelectionStrategy();

        // BEGIN: Fix VendingMachine constructor
        VendingMachine vm = new VendingMachine(inventory, productSelectionStrategy, changeReturnStrategy); // Updated to use constructor with Inventory parameter
        // END: Fix VendingMachine constructor

        vm.insertCoin(Coin.Five);
        vm.insertCoin(Coin.Five);
        vm.insertCoin(Coin.Ten);
        vm.insertCoin(Coin.Twenty);
        vm.selectProduct(1);
    }
}

