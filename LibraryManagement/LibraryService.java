package LibraryManagement;

import java.util.*;

public class LibraryService {

    private final Catalog catalog = new Catalog();
    private final Map<String, Loan> activeLoans = new HashMap<>();
    private final FineStrategy fineStrategy;

    public LibraryService(FineStrategy fineStrategy) {
        this.fineStrategy = fineStrategy;
    }

    public void addBookCopy(BookCopy copy) {
        catalog.addBookCopy(copy);
    }

    public Loan issueBook(String isbn, Member member) {

        for (BookCopy copy : catalog.searchByIsbn(isbn)) {
            if (copy.isAvailable()) {
                copy.issue();
                Loan loan = new Loan(copy, member);
                activeLoans.put(copy.getCopyId(), loan);
                return loan;
            }
        }

        throw new RuntimeException("No copies available");
    }

    public double returnBook(String copyId) {
        Loan loan = activeLoans.get(copyId);

        if (loan == null) throw new RuntimeException("Invalid copy id");

        loan.getCopy().returned();
        activeLoans.remove(copyId);

        return fineStrategy.calculateFine(loan.getIssueDate());
    }
}

