package VendingMachine;

public enum Coin {
    One(1),
    Two(2),
    Five(5),
    Ten(10),
    Twenty(20);
    private int value;
    Coin(int value){
        this.value = value;
    }
    public int getValue(){
        return this.value;
    }
}
