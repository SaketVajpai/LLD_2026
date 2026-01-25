package VendingMachine;

public class Product {
    private final int id;
    private final String name;
    private final int price;

    public Product(int id, String name, int price) {
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public int getPrice() { return price; }
    public int getId() { return id; }
    public String getName() { return name; }
}

