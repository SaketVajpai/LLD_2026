package Splitwise;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SplitwiseService {

    private final BalanceSheet balanceSheet = new BalanceSheet();
    private final List<Expense> expenseHistory = new ArrayList<>();

    public void addExpense(Expense expense, Group group) {

        for (User u : expense.getParticipants()) {
            if (!group.contains(u)) {
                throw new RuntimeException("User not part of group");
            }
        }

        Map<User, Double> splits =
                expense.getStrategy()
                       .split(expense.getAmount(), expense.getParticipants());

        User paidBy = expense.getPaidBy();

        for (User u : splits.keySet()) {
            if (!u.equals(paidBy)) {
                balanceSheet.addBalance(u, paidBy, splits.get(u));
            }
        }

        expenseHistory.add(expense);
    }

    public void settle(User from, User to, double amount) {
        balanceSheet.settle(from, to, amount);
    }

    public void showBalance(User user) {
        balanceSheet.showBalance(user);
    }

    public void showAllBalances() {
        balanceSheet.showBalances();
    }
}
