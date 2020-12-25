import javafx.scene.shape.Path;

import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StreamExample {

    public static void main(String[] args) {
        Person p = new Person("name","lastName",3);
        Person p2 = new Person("naga","gunji",34);
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
        //Build Stream pattern 4
        //Stream<String> ss = stringStream.iterate("+", s -> s+ "+");

        IntStream streamint = "hello".chars();
        streamint.forEach(System.out::println);

        //A stream on regular expression
        Stream<String> words = Pattern.compile("[^abcs$]{2,9}").splitAsStream("book");

        //Stream<String> lines = Files.lines(Path.BASELINE_OFFSET_SAME_AS_HEIGHT); Path class should be pass as parameter

        //The StreamBuilder pattern
        //First buld a Stream.Builder
        Stream.Builder<String> builder = Stream.builder();

        //adding data to builder
        builder.add("one").add("two").add("three");
        //or by calling accept
        builder.accept("four");

        Stream<String> stream = builder.build();// stream has same order of insertion
        /*
        Exception in thread "main" java.lang.IllegalStateException
	        at java.util.stream.Streams$StreamBuilderImpl.accept(Streams.java:373)
	        at java.util.stream.Streams$StreamBuilderImpl.add(Streams.java:378)
	        at StreamExample.main(StreamExample.java:48)
         */
        //builder.add("five");
        //A build stream will throw an exception on an add() or accept() after build call

        //The map() call can change the type of a stream
        //The filter call does not change the type of a stream
        s.
                map(x->x.getFirstName()).
                peek(System.out::print).
                filter(Objects::nonNull).
                filter(x->x.equalsIgnoreCase("naga")).
                forEach(System.out::println);




    }
}
