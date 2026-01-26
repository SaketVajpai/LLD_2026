package Splitwise;

import java.util.HashMap;
import java.util.Map;


public class BalanceSheet {

    // A owes B -> amount
    private final Map<User, Map<User, Double>> sheet = new HashMap<>();

    public void addBalance(User from, User to, double amount) {
        sheet.putIfAbsent(from, new HashMap<>());
        Map<User, Double> owes = sheet.get(from);

        owes.put(to, owes.getOrDefault(to, 0.0) + amount);
    }

    public void showBalance(User user) {
        Map<User, Double> owes = sheet.get(user);
    
        if (owes == null || owes.isEmpty()) {
            System.out.println(user + " has no dues");
            return;
        }
    
        for (Map.Entry<User, Double> entry : owes.entrySet()) {
            System.out.println(user + " owes " + entry.getKey() + " : ₹" + entry.getValue());
        }
    }    

    public void settle(User from, User to, double amount) {
        Map<User, Double> owes = sheet.get(from);

        if (owes == null || owes.getOrDefault(to, 0.0) < amount) {
            throw new RuntimeException("Invalid settlement");
        }

        owes.put(to, owes.get(to) - amount);

        if (owes.get(to) == 0.0) {
            owes.remove(to);
        }
    }

    public void showBalances() {
        for (User from : sheet.keySet()) {
            for (Map.Entry<User, Double> entry : sheet.get(from).entrySet()) {
                System.out.println(from + " owes " + entry.getKey() + " : ₹" + entry.getValue());
            }
        }
    }
}

