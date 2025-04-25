import java.util.*;

abstract class WarehouseItem {
    String name;
    WarehouseItem(String name) { this.name = name; }
    public String toString() { return name; }
}

class Electronics extends WarehouseItem {
    Electronics(String name) { super(name); }
}

class Groceries extends WarehouseItem {
    Groceries(String name) { super(name); }
}

class Furniture extends WarehouseItem {
    Furniture(String name) { super(name); }
}

class Storage<T extends WarehouseItem> {
    private List<T> items = new ArrayList<>();
    void addItem(T item) { items.add(item); }
    List<T> getItems() { return items; }
}

public class SmartWarehouse {
    public static void displayAllItems(List<? extends WarehouseItem> items) {
        for (int i = 0; i < items.size(); i++) {
            System.out.println(items.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Storage<Electronics> electronicsStorage = new Storage<>();
        Storage<Groceries> groceriesStorage = new Storage<>();
        Storage<Furniture> furnitureStorage = new Storage<>();

        System.out.println("Enter number of electronics items:");
        int e = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < e; i++) electronicsStorage.addItem(new Electronics(sc.nextLine()));

        System.out.println("Enter number of groceries items:");
        int g = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < g; i++) groceriesStorage.addItem(new Groceries(sc.nextLine()));

        System.out.println("Enter number of furniture items:");
        int f = sc.nextInt(); sc.nextLine();
        for (int i = 0; i < f; i++) furnitureStorage.addItem(new Furniture(sc.nextLine()));

        System.out.println("\nElectronics:");
        displayAllItems(electronicsStorage.getItems());
        System.out.println("Groceries:");
        displayAllItems(groceriesStorage.getItems());
        System.out.println("Furniture:");
        displayAllItems(furnitureStorage.getItems());
    }
}

	