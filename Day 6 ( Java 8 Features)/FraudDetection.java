import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Transaction {
    String transactionId;
    String policyNumber;
    double amount;
    LocalDate transactionDate;
    boolean isFraudulent;

    public Transaction(String transactionId, String policyNumber, double amount, LocalDate transactionDate, boolean isFraudulent) {
        this.transactionId = transactionId;
        this.policyNumber = policyNumber;
        this.amount = amount;
        this.transactionDate = transactionDate;
        this.isFraudulent = isFraudulent;
    }
}

class FraudStats {
    String policyNumber;
    long fraudCount;
    double totalFraudAmount;

    public FraudStats(String policyNumber, long fraudCount, double totalFraudAmount) {
        this.policyNumber = policyNumber;
        this.fraudCount = fraudCount;
        this.totalFraudAmount = totalFraudAmount;
    }

    @Override
    public String toString() {
        return "Policy: " + policyNumber + ", Fraud Count: " + fraudCount +
               ", Total Amount: $" + String.format("%.2f", totalFraudAmount);
    }
}

public class FraudDetection {
    public static void main(String[] args) {
        List<Transaction> transactions = Arrays.asList(
            new Transaction("T001", "P001", 12000, LocalDate.of(2024, 1, 15), true),
            new Transaction("T002", "P001", 15000, LocalDate.of(2024, 2, 10), true),
            new Transaction("T003", "P002", 9000, LocalDate.of(2024, 3, 5), true),
            new Transaction("T004", "P003", 30000, LocalDate.of(2024, 4, 20), true),
            new Transaction("T005", "P001", 11000, LocalDate.of(2024, 4, 25), true),
            new Transaction("T006", "P003", 10000, LocalDate.of(2024, 5, 1), false),
            new Transaction("T007", "P001", 18000, LocalDate.of(2024, 5, 2), true),
            new Transaction("T008", "P001", 22000, LocalDate.of(2024, 5, 3), true)
        );

        // 1. Filter: isFraudulent and amount > $10,000
        List<Transaction> fraudulent = transactions.stream()
            .filter(t -> t.isFraudulent && t.amount > 10000)
            .collect(Collectors.toList());

        // 2. Group by policyNumber
        Map<String, List<Transaction>> grouped = fraudulent.stream()
            .collect(Collectors.groupingBy(t -> t.policyNumber));

        // 3. Aggregate: count and sum per policy
        List<FraudStats> stats = grouped.entrySet().stream()
            .map(entry -> {
                String policy = entry.getKey();
                long count = entry.getValue().size();
                double sum = entry.getValue().stream().mapToDouble(t -> t.amount).sum();
                return new FraudStats(policy, count, sum);
            })
            .collect(Collectors.toList());

        // 4. Alert: if fraudCount > 5 or totalAmount > 50000
        System.out.println("Fraud Alerts:");
        stats.stream()
            .filter(s -> s.fraudCount > 5 || s.totalFraudAmount > 50000)
            .forEach(System.out::println);
    }
}
