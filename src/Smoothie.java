import java.util.*;
import java.util.stream.Collectors;

public class Smoothie {

    static HashMap<String, ArrayList<String>> menuMap = new HashMap<>();
    static ArrayList<String> classicList = new ArrayList<>(Arrays.asList(" strawberry, banana, pineapple, mango, peach, honey".split(",")));
    static ArrayList<String> freezieList = new ArrayList<>(Arrays.asList(" blackberry, blueberry, black currant, grape juice, frozen yogurt".split(",")));
    static ArrayList<String> greenieList = new ArrayList<>(Arrays.asList(" green apple, lime, avocado, spinach, ice, apple juice".split(",")));
    static ArrayList<String> dessertList = new ArrayList<>(Arrays.asList(" banana, ice cream, chocolate, peanut, cherry".split(",")));

    public static void main(String args[]) {
        fetchMenu();
        ingredients("Classic, -strawberry, -peanut");
        ingredients("Classic, chocolate");
        ingredients("Vitamin smoothie");
    }

    private static void fetchMenu() {
        menuMap.put("Classic", classicList);
        menuMap.put("Freezie", freezieList);
        menuMap.put("Greenie", greenieList);
        menuMap.put("Just Desserts", dessertList);
    }

    private static String ingredients(String menu) {
        String[] menuItem = menu.split(",");
        if (menuMap.containsKey(menuItem[0])) {
            for (int i = 1; i < menuItem.length; i++) {
                if (menuItem[i].contains("-")) {
                    menuItem[i] = menuItem[i].replace("-", "");
                } else {
                    throw new IllegalArgumentException("Illegal arguments");
                }
            }
            List<String> ingredientList = new ArrayList<>(Arrays.asList(menuMap.get(menuItem[0]).stream().sorted(
                    (s1, s2) -> s1.compareTo(s2)
            ).toArray(String[]::new)));

            Arrays.stream(menuItem).forEach(ingredient -> {
                if (ingredientList.contains(ingredient.toString())) {
                    ingredientList.remove(ingredient);
                }
            });

            System.out.println(ingredientList.stream().collect(Collectors.joining(",")).toString().replace(" ", ""));
            return ingredientList.stream().collect(Collectors.joining(",")).toString().replace(" ", "");
        } else {
            throw new IllegalArgumentException("Illegal arguments");
        }
    }
}