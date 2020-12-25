import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        Person p = new Person("name","lastName");
        Person p2 = new Person("naga","gunji");
        List<Person> personList = new ArrayList<Person>();
        personList.add(p);
        personList.add(p2);

        Stream<Person> s = personList.stream();
        // Build Stream pattern 1, it is useful for testing purpose
        Stream<Person> emptyStream = Stream.empty();
        //Build Stream pattern 2
        Stream<String> stringStream = Stream.of("one","two","three");
        //Build Stream pattern 3
        Stream<String> stringStreamGenerate = Stream.generate(()->"one");
        

    }
}
