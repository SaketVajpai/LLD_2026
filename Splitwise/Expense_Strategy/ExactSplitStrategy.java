package Splitwise.Expense_Strategy;

import java.util.List;
import java.util.Map;

import Splitwise.User;
import Splitwise.Exception.InvalidSplitException;

public class ExactSplitStrategy implements SplitStrategy {

    private final Map<User, Double> exactSplits;

    public ExactSplitStrategy(Map<User, Double> exactSplits) {
        this.exactSplits = exactSplits;
    }

    @Override
    public Map<User, Double> split(double amount, List<User> users) {
        double total = exactSplits.values()
                                  .stream()
                                  .mapToDouble(d -> d)
                                  .sum();

        if (total != amount) {
            throw new InvalidSplitException("Exact split mismatch");
        }

        return exactSplits;
    }
}

