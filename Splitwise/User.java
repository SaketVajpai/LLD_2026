package Splitwise;

public class User {
    private final String id;
    private final String name;

    public User(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }

    @Override
    public String toString() {
        return name;
    }
}
