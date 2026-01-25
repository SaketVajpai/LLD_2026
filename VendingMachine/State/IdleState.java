package VendingMachine.State;

import VendingMachine.Coin;
import VendingMachine.VendingMachine;

public class IdleState implements State{

    public void insertCoin(VendingMachine vm, Coin coin){
        vm.addBalance(coin.getValue());
        vm.setState(new HasMoneyState());
    }
    public void selectProduct(VendingMachine vm, int productId){
        System.out.println("Cannot Select Product, Insert Coin First!!!");
    }
    public void dispense(VendingMachine vm){
        System.out.println("Cannot dispense Product, Insert Coin First!!!");
    }
}
