package Splitwise.Expense_Strategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import Splitwise.User;

public class EqualSplitStrategy implements SplitStrategy {

    public Map<User, Double> split(double amount, List<User> users) {
        Map<User, Double> result = new HashMap<>();
        double share = amount / users.size();

        for (User u : users) {
            result.put(u, share);
        }
        return result;
    }

}
