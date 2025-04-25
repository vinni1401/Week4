import java.util.*;
import java.util.stream.Collectors;

class Claim {
    String claimId;
    String policyNumber;
    double claimAmount;
    String claimDate;
    String status;

    public Claim(String claimId, String policyNumber, double claimAmount, String claimDate, String status) {
        this.claimId = claimId;
        this.policyNumber = policyNumber;
        this.claimAmount = claimAmount;
        this.claimDate = claimDate;
        this.status = status;
    }
}

class ClaimStats {
    double totalAmount;
    double averageAmount;

    public ClaimStats(double totalAmount, double averageAmount) {
        this.totalAmount = totalAmount;
        this.averageAmount = averageAmount;
    }

    @Override
    public String toString() {
        return "Total: $" + totalAmount + ", Average: $" + averageAmount;
    }
}

public class ClaimsAnalysis {
    public static void main(String[] args) {
        List<Claim> claims = Arrays.asList(
            new Claim("C001", "P1001", 6000, "2024-01-01", "Approved"),
            new Claim("C002", "P1002", 7000, "2024-01-05", "Pending"),
            new Claim("C003", "P1001", 12000, "2024-01-10", "Approved"),
            new Claim("C004", "P1003", 3000, "2024-01-12", "Approved"),
            new Claim("C005", "P1002", 9000, "2024-01-15", "Approved"),
            new Claim("C006", "P1004", 15000, "2024-01-20", "Approved"),
            new Claim("C007", "P1004", 11000, "2024-01-22", "Approved")
        );

        // 1. Filter: Approved status and amount > $5000
        List<Claim> filtered = claims.stream()
            .filter(c -> c.status.equalsIgnoreCase("Approved") && c.claimAmount > 5000)
            .collect(Collectors.toList());

        // 2. Group by policyNumber
        Map<String, List<Claim>> grouped = filtered.stream()
            .collect(Collectors.groupingBy(c -> c.policyNumber));

        // 3. Aggregate: total and average per policy
        Map<String, ClaimStats> statsByPolicy = new HashMap<>();
        for (Map.Entry<String, List<Claim>> entry : grouped.entrySet()) {
            String policy = entry.getKey();
            List<Claim> claimList = entry.getValue();
            double total = claimList.stream().mapToDouble(c -> c.claimAmount).sum();
            double average = total / claimList.size();
            statsByPolicy.put(policy, new ClaimStats(total, average));
        }

        // 4. Top 3 policies with highest total claim amounts
        List<Map.Entry<String, ClaimStats>> topPolicies = statsByPolicy.entrySet().stream()
            .sorted((e1, e2) -> Double.compare(e2.getValue().totalAmount, e1.getValue().totalAmount))
            .limit(3)
            .collect(Collectors.toList());

        // Display Results
        System.out.println("Top 3 Policies by Total Claim Amount:");
        for (Map.Entry<String, ClaimStats> entry : topPolicies) {
            System.out.println("Policy: " + entry.getKey() + " -> " + entry.getValue());
        }
    }
}
