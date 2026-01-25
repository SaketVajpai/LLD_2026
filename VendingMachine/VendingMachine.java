package VendingMachine;
import java.util.HashMap;
import java.util.Map;

import VendingMachine.Change_Return_Strategy.ChangeReturnStrategy;
import VendingMachine.Product_Selection_Strategy.ProductSelectionStrategy;
import VendingMachine.State.IdleState;
import VendingMachine.State.State;

public class VendingMachine {

    private State state;
    private int balance;

    private final Inventory inventory;
    private final ProductSelectionStrategy selectionStrategy;
    private final ChangeReturnStrategy changeStrategy;

    private final Map<Coin, Integer> coinInventory = new HashMap<>();

    private int selectedProductId;

    public VendingMachine(Inventory inventory,
                          ProductSelectionStrategy selectionStrategy,
                          ChangeReturnStrategy changeStrategy) {

        this.inventory = inventory;
        this.selectionStrategy = selectionStrategy;
        this.changeStrategy = changeStrategy;
        this.state = new IdleState();

        for (Coin c : Coin.values()) {
            coinInventory.put(c, 10); // initial coins
        }
    }

    public synchronized void addBalance(int amount) {
        balance += amount;
    }

    public synchronized int getBalance() {
        return balance;
    }

    public synchronized void resetBalance() {
        balance = 0;
    }

    public Inventory getInventory() {
        return inventory;
    }

    public ProductSelectionStrategy getSelectionStrategy() {
        return selectionStrategy;
    }

    public ChangeReturnStrategy getChangeStrategy() {
        return changeStrategy;
    }

    public Map<Coin, Integer> getCoinInventory() {
        return coinInventory;
    }

    public void setSelectedProduct(int id) {
        this.selectedProductId = id;
    }

    public int getSelectedProductId() {
        return selectedProductId;
    }

    public synchronized void insertCoin(Coin coin) {
        coinInventory.put(coin, coinInventory.get(coin) + 1);
        state.insertCoin(this, coin);
    }

    public synchronized void selectProduct(int id) {
        state.selectProduct(this, id);
    }

    public synchronized void dispense() {
        state.dispense(this);
    }

    public void setState(State state) {
        this.state = state;
    }
}
