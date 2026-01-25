package VendingMachine.Change_Return_Strategy;
import java.util.Map;

import VendingMachine.Coin;

public interface ChangeReturnStrategy {
    Map<Coin, Integer> returnChange(int changeAmount, Map<Coin, Integer> coinInventory);
}
