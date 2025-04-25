import java.util.*;
import java.util.stream.Collectors;

class PolicyHolder {
    String holderId;
    String name;
    int age;
    String policyType;
    double premiumAmount;

    public PolicyHolder(String holderId, String name, int age, String policyType, double premiumAmount) {
        this.holderId = holderId;
        this.name = name;
        this.age = age;
        this.policyType = policyType;
        this.premiumAmount = premiumAmount;
    }
}

class RiskAssessment {
    String holderId;
    String name;
    double riskScore;
    String riskCategory;

    public RiskAssessment(String holderId, String name, double riskScore, String riskCategory) {
        this.holderId = holderId;
        this.name = name;
        this.riskScore = riskScore;
        this.riskCategory = riskCategory;
    }

    @Override
    public String toString() {
        return name + " (ID: " + holderId + ") - Risk Score: " + String.format("%.2f", riskScore)
                + " [" + riskCategory + "]";
    }
}

public class PolicyHolderRiskAssessment {
    public static void main(String[] args) {
        List<PolicyHolder> holders = Arrays.asList(
            new PolicyHolder("H001", "Alice", 65, "Life", 400.0),
            new PolicyHolder("H002", "Bob", 70, "Health", 500.0),
            new PolicyHolder("H003", "Charlie", 62, "Life", 350.0),
            new PolicyHolder("H004", "Diana", 75, "Life", 600.0),
            new PolicyHolder("H005", "Edward", 59, "Life", 300.0)
        );

        // 1. Filter: Life policy and age > 60
        List<PolicyHolder> filtered = holders.stream()
            .filter(h -> h.policyType.equalsIgnoreCase("Life") && h.age > 60)
            .collect(Collectors.toList());

        // 2. Transform: RiskAssessment with riskScore = premium / age
        List<RiskAssessment> assessments = filtered.stream()
            .map(h -> {
                double score = h.premiumAmount / h.age;
                String category = (score > 0.5) ? "High Risk" : "Low Risk";
                return new RiskAssessment(h.holderId, h.name, score, category);
            })
            .collect(Collectors.toList());

        // 3. Sort by riskScore descending
        assessments.sort((a, b) -> Double.compare(b.riskScore, a.riskScore));

        // 4. Print all risk assessments
        System.out.println("Risk Assessment Results:");
        assessments.forEach(System.out::println);
    }
}
