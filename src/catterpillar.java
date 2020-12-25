import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class catterpillar {

    public static void main(String args[]) {

        System.out.println(ingredients("Just Desserts,-strawberry,-peanut"));
    }

    public static List<String> ingredients(String A) {

        String [] classic ={"strawberry", "banana", "pineapple", "mango", "peach", "honey"};
        String [] freezie ={"blackberry", "blueberry", "black currant", "grape juice", "frozen yogurt"};
        String[] greeie = {"green apple", "lime", "avocado", "spinach", "ice", "apple juice"};
        String[] justDesserts = {"banana", "ice cream", "chocolate", "peanut", "cherry"};
        List<String> Classic =Arrays.asList(classic);
        List<String> freez = Arrays.asList(freezie);
        List<String> greeni = Arrays.asList(greeie);
        List<String> jd = Arrays.asList(justDesserts);
        String[] inputArray= A.split(",");
        ArrayList<String> allegic = new ArrayList<>();
        ArrayList<String> addition = new ArrayList<>();
        for(int i=1;i<inputArray.length;i++){
            if(inputArray[i].startsWith("-")){
                allegic.add(inputArray[i].substring(1));
            }else{
                addition.add(inputArray[i]);
            }
        }
        ArrayList<String > finalList = new ArrayList<>();

        if(inputArray[0].contains("classic")){
            Classic.removeAll(allegic);
        }else if(inputArray[0].contains("freezie")){
            freez.removeAll(allegic);
        }else if(inputArray[0].contains("Greenie")){
            greeni.removeAll(allegic);
        }else if(inputArray[0].contains("Just Desserts")){
            jd.removeAll(allegic);
        }



        return Classic;
    }
}