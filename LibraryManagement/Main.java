package LibraryManagement;

public class Main {

    public static void main(String[] args) {

        LibraryService service = new LibraryService(new DefaultFineStrategy());

        Book book = new Book("ISBN1", "Clean Code", "Robert Martin");

        BookCopy copy1 = new BookCopy("C1", book);
        BookCopy copy2 = new BookCopy("C2", book);

        service.addBookCopy(copy1);
        service.addBookCopy(copy2);

        Member member = new Member("M1", "Alice");

        Loan loan = service.issueBook("ISBN1", member);

        System.out.println("Book issued to " + member);

        double fine = service.returnBook(loan.getCopy().getCopyId());

        System.out.println("Book returned. Fine: ₹" + fine);
    }
}
