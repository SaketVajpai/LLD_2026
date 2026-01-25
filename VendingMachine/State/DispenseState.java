package VendingMachine.State;

import VendingMachine.Coin;
import VendingMachine.Product;
import VendingMachine.VendingMachine;
import java.util.Map;

public class DispenseState implements State {

    @Override
    public void insertCoin(VendingMachine vm, Coin coin) {
        System.out.println("Wait, dispensing...");
    }

    @Override
    public void selectProduct(VendingMachine vm, int productId) {
        System.out.println("Wait...");
    }

    @Override
    public void dispense(VendingMachine vm) {

        int productId = vm.getSelectedProductId();
        Product product = vm.getInventory().getProduct(productId);

        vm.getInventory().reduce(productId);

        int changeAmount = vm.getBalance() - product.getPrice();

        Map<Coin, Integer> change =
                vm.getChangeStrategy().returnChange(changeAmount, vm.getCoinInventory());

        System.out.println("Dispensed: " + product.getName());
        System.out.println("Change returned: " + change);

        vm.resetBalance();
        vm.setState(new IdleState());
    }
}
