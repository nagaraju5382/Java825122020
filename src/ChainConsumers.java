import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

public class ChainConsumers {
    public static void main(String[] args) {
     List<String> stringList = Arrays.asList("one","two","three","four","five");

        Consumer<String> printout = System.out::println;
        List<String> result = new ArrayList<String>();
        Consumer<String> add = result::add;
        //stringList.forEach(printout);
        stringList.forEach(printout.andThen(add));

        System.out.println("Array Size: "+result.size());

    }

}
