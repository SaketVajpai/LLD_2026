package LibraryManagement;

import java.util.*;

public class Catalog {

    private final Map<String, List<BookCopy>> bookMap = new HashMap<>();

    public void addBookCopy(BookCopy copy) {
        bookMap.putIfAbsent(copy.getBook().getIsbn(), new ArrayList<>());
        bookMap.get(copy.getBook().getIsbn()).add(copy);
    }

    public List<BookCopy> searchByIsbn(String isbn) {
        return bookMap.getOrDefault(isbn, new ArrayList<>());
    }
}

