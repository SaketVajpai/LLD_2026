package Splitwise.Expense_Strategy;

import Splitwise.User;
import java.util.*;

public interface SplitStrategy {
    public Map<User, Double> split(double amount, List<User> users);
}
