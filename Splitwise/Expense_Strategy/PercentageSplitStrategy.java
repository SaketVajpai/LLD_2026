package Splitwise.Expense_Strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Splitwise.User;
import Splitwise.Exception.InvalidSplitException;

public class PercentageSplitStrategy implements SplitStrategy {

    private final Map<User, Double> percentages;

    public PercentageSplitStrategy(Map<User, Double> percentages) {
        this.percentages = percentages;
    }

    @Override
    public Map<User, Double> split(double amount, List<User> users) {

        double totalPercent = percentages.values()
                                         .stream()
                                         .mapToDouble(d -> d)
                                         .sum();

        if (totalPercent != 100.0) {
            throw new InvalidSplitException("Percentages must sum to 100");
        }

        Map<User, Double> result = new HashMap<>();

        for (User u : percentages.keySet()) {
            result.put(u, amount * percentages.get(u) / 100);
        }

        return result;
    }
}
