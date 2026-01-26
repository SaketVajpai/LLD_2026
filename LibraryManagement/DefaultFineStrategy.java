package LibraryManagement;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class DefaultFineStrategy implements FineStrategy {

    private static final int ALLOWED_DAYS = 7;

    @Override
    public double calculateFine(LocalDate issueDate) {
        long days = ChronoUnit.DAYS.between(issueDate, LocalDate.now());

        if (days <= ALLOWED_DAYS) return 0;

        return (days - ALLOWED_DAYS) * 5; // ₹5 per extra day
    }
}

