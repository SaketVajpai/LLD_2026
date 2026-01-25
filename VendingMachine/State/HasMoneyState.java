package VendingMachine.State;

import VendingMachine.Coin;
import VendingMachine.Product;
import VendingMachine.VendingMachine;
import VendingMachine.Exceptions.InsufficientBalanceException;

public class HasMoneyState implements State {

    @Override
    public void insertCoin(VendingMachine vm, Coin coin) {
        vm.addBalance(coin.getValue());
    }

    @Override
    public void selectProduct(VendingMachine vm, int productId) {

        Product product = vm.getSelectionStrategy()
                            .selectProduct(vm.getInventory(), productId);

        if (vm.getBalance() < product.getPrice()) {
            throw new InsufficientBalanceException("Not enough balance");
        }

        vm.setSelectedProduct(productId);
        vm.setState(new DispenseState());
        vm.dispense();
    }

    @Override
    public void dispense(VendingMachine vm) {
        System.out.println("Select product first");
    }
}
