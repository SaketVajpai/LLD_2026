package Splitwise;
import java.util.*;

import Splitwise.Expense_Strategy.EqualSplitStrategy;
import Splitwise.Expense_Strategy.ExactSplitStrategy;
import Splitwise.Expense_Strategy.PercentageSplitStrategy;

public class Main {

    public static void main(String[] args) {

        // -------- Users --------
        User A = new User("1", "A");
        User B = new User("2", "B");
        User C = new User("3", "C");

        // -------- Group --------
        Group group = new Group("G1", Arrays.asList(A, B, C));

        // -------- Service --------
        SplitwiseService service = new SplitwiseService();

        // -------- 1. Equal Split Expense --------
        Expense equalExpense = new Expense(
                A,
                900,
                Arrays.asList(A, B, C),
                new EqualSplitStrategy()
        );

        service.addExpense(equalExpense, group);

        System.out.println("After Equal Split:");
        service.showAllBalances();

        // -------- 2. Exact Split Expense --------
        Map<User, Double> exactSplits = new HashMap<>();
        exactSplits.put(A, 300.0);
        exactSplits.put(B, 200.0);
        exactSplits.put(C, 100.0);

        Expense exactExpense = new Expense(
                B,
                600,
                Arrays.asList(A, B, C),
                new ExactSplitStrategy(exactSplits)
        );

        service.addExpense(exactExpense, group);

        System.out.println("\nAfter Exact Split:");
        service.showAllBalances();

        // -------- 3. Percentage Split Expense --------
        Map<User, Double> percentages = new HashMap<>();
        percentages.put(A, 50.0);
        percentages.put(B, 30.0);
        percentages.put(C, 20.0);

        Expense percentExpense = new Expense(
                C,
                1000,
                Arrays.asList(A, B, C),
                new PercentageSplitStrategy(percentages)
        );

        service.addExpense(percentExpense, group);

        System.out.println("\nAfter Percentage Split:");
        service.showAllBalances();

        // -------- Settlement --------
        System.out.println("\n---- Settlement: B pays A ₹200 ----");
        service.settle(B, A, 200);

        // -------- Show individual balance --------
        service.showBalance(B);

        System.out.println("\nFinal Balances:");
        service.showAllBalances();
    }
}
