package Splitwise;

import java.util.List;

import Splitwise.Expense_Strategy.SplitStrategy;

public class Expense {
    private final User paidBy;
    private final double amount;
    private final List<User> participants;
    private final SplitStrategy strategy;

    public Expense(User paidBy, double amount,
                   List<User> participants,
                   SplitStrategy strategy) {
        this.paidBy = paidBy;
        this.amount = amount;
        this.participants = participants;
        this.strategy = strategy;
    }

    public User getPaidBy() { return paidBy; }
    public double getAmount() { return amount; }
    public List<User> getParticipants() { return participants; }
    public SplitStrategy getStrategy() { return strategy; }
}

