package LibraryManagement;

import java.time.LocalDate;

public class Loan {
    private final BookCopy copy;
    private final Member member;
    private final LocalDate issueDate;

    public Loan(BookCopy copy, Member member) {
        this.copy = copy;
        this.member = member;
        this.issueDate = LocalDate.now();
    }

    public BookCopy getCopy() { return copy; }
    public Member getMember() { return member; }
    public LocalDate getIssueDate() { return issueDate; }
}

