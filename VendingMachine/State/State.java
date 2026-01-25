package VendingMachine.State;

import VendingMachine.Coin;
import VendingMachine.VendingMachine;

public interface State {
    void insertCoin(VendingMachine vm, Coin coin);
    void selectProduct(VendingMachine vm, int productId);
    void dispense(VendingMachine vm);
}

