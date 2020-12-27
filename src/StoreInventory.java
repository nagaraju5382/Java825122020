import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BiFunction;

public class StoreInventory {
    Set<String> superCycleSet = new TreeSet<>();
    List<String> myStoreList = new ArrayList<>();

    public StoreInventory() {
        myStoreList.add("Bicycle");
        myStoreList.add("Tricycle");
        myStoreList.add("Scooter");
    }

    public void printStoreInventory() {
        myStoreList.forEach(i -> System.out.println("My Store item: " + i));
    }

    public void collectCycleItems() {

        myStoreList.stream().forEach( c-> {
            if(c.contains("cycle"))
            {superCycleSet.add(c);}
        });

        System.out.println();
    }

    public static void main(String[] args) {
        StoreInventory storeInventory = new StoreInventory();
        storeInventory.collectCycleItems();
    }
}
