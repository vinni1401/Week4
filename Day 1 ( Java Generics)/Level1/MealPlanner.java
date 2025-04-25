import java.util.*;

interface MealPlan {
    String getDetails();
}

class VegetarianMeal implements MealPlan {
    public String getDetails() { return "Vegetarian Plan: Includes fruits, grains, legumes."; }
}

class VeganMeal implements MealPlan {
    public String getDetails() { return "Vegan Plan: No animal products."; }
}

class KetoMeal implements MealPlan {
    public String getDetails() { return "Keto Plan: High fat, low carbs."; }
}

class Meal<T extends MealPlan> {
    T mealType;
    Meal(T mealType) { this.mealType = mealType; }
    void generatePlan() { System.out.println(mealType.getDetails()); }
}

public class MealPlanner {
    public static <T extends MealPlan> void generatePersonalizedPlan(T meal) {
        Meal<T> m = new Meal<>(meal);
        m.generatePlan();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose Meal Type: 1. Vegetarian 2. Vegan 3. Keto");
        int choice = sc.nextInt();

        switch (choice) {
            case 1: generatePersonalizedPlan(new VegetarianMeal()); break;
            case 2: generatePersonalizedPlan(new VeganMeal()); break;
            case 3: generatePersonalizedPlan(new KetoMeal()); break;
            default: System.out.println("Invalid choice.");
        }
    }
}
