package LibraryManagement;

public class BookCopy {
    private final String copyId;
    private final Book book;
    private boolean available = true;

    public BookCopy(String copyId, Book book) {
        this.copyId = copyId;
        this.book = book;
    }

    public boolean isAvailable() { return available; }

    public void issue() { available = false; }

    public void returned() { available = true; }

    public Book getBook() { return book; }

    public String getCopyId() { return copyId; }
}
