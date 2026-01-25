package VendingMachine.Change_Return_Strategy;

import java.util.HashMap;
import java.util.Map;

import VendingMachine.Coin;

public class GreedyChangeStrategy implements ChangeReturnStrategy {

    @Override
    public Map<Coin, Integer> returnChange(int amount, Map<Coin, Integer> coins) {
        Map<Coin, Integer> change = new HashMap<>();

        for (Coin coin : Coin.values()) {
            while (amount >= coin.getValue() && coins.getOrDefault(coin, 0) > 0) {
                amount -= coin.getValue();
                coins.put(coin, coins.get(coin) - 1);
                change.put(coin, change.getOrDefault(coin, 0) + 1);
            }
        }

        if (amount != 0) {
            throw new RuntimeException("Cannot return exact change");
        }

        return change;
    }
}

