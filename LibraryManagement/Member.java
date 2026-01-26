package LibraryManagement;

public class Member {
    private final String id;
    private final String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }

    @Override
    public String toString() {
        return name;
    }
}

