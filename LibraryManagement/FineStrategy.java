package LibraryManagement;

import java.time.LocalDate;

public interface FineStrategy {
    double calculateFine(LocalDate issueDate);
}
