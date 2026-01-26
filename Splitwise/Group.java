package Splitwise;

import java.util.List;

public class Group {
    private final String id;
    private final List<User> members;

    public Group(String id, List<User> members) {
        this.id = id;
        this.members = members;
    }

    public List<User> getMembers() {
        return members;
    }

    public boolean contains(User user) {
        return members.contains(user);
    }
}

