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
        Person p3 = new Person("peter","galvin",43);
        Person p4 = new Person("alex","sophie",64);
        Person p5 = new Person("kenneth","jenny",23);
        Person p6 = new Person("fredrik","tengroth",34);

        List<Person> personList = new ArrayList<Person>();
        personList.add(p);
        personList.add(p2);
        personList.add(p3);
        personList.add(p4);
        personList.add(p5);
        personList.add(p6);

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
                peek(System.out::println).
                filter(Objects::nonNull).
                filter(x->x.equalsIgnoreCase("naga")).
                forEach(System.out::println);
        // skip first 2 and get only 3
            /*
            Exception in thread "main" java.lang.IllegalStateException: stream has already been operated upon or closed
	at java.util.stream.AbstractPipeline.<init>(AbstractPipeline.java:203)
	at java.util.stream.ReferencePipeline.<init>(ReferencePipeline.java:94)
	at java.util.stream.ReferencePipeline$StatelessOp.<init>(ReferencePipeline.java:618)
	at java.util.stream.ReferencePipeline$3.<init>(ReferencePipeline.java:187)
	at java.util.stream.ReferencePipeline.map(ReferencePipeline.java:186)
	at StreamExample.main(StreamExample.java:77)

	// If you use same stream for multiple times.

	 s.
                map(x->x.getFirstName()).
                skip(2).
                limit(2).
                peek(System.out::println).
               // filter(Objects::nonNull).
                //filter(x->x.equalsIgnoreCase("naga")).
                forEach(System.out::println);
             */
        personList.stream().
                map(x->x.getFirstName()).
                skip(2).
                limit(2).
                peek(System.out::println).
               // filter(Objects::nonNull).
                //filter(x->x.equalsIgnoreCase("naga")).
                forEach(System.out::println);
        // Match Reduction operations

        // Three types of matchers:anyMatch(),allMatch() and noneMatch()
        // They are terminal operations that return a boolean
        boolean b = personList.stream().anyMatch(u -> u.getAge() > 20);
        System.out.println("At least one of  person age is > 20 : " + b);
        boolean allMatch = personList.stream().allMatch(u -> u.getAge() > 20);
        System.out.println("All  persons age is > 20 : " + allMatch);

        // These three matches may not evaluate the predicate for all the elements
        // They are called short-circuiting terminal operations

        // Find Reduction operations
        // findFirst() and findAny()

        // if the stream is empty Or if there is no value that matches the predicate
        //So they both return an Optional, that can be empty


        // Reduce Reduction
        //There are three types of reduction
        //if no identity element is provided, then an Optional is returned

        int sumOfAges = personList.stream().map(oi->oi.getAge()).reduce(0,(xs,swe)->xs+swe);
        System.out.print("Sum of Ages: "+sumOfAges);

        //Third version of reduce operation
        //identity element , accumlator, combiner
        /*List<Integer> ages = personList.stream().
                reduce(new ArrayList<Integer>(),(list,pw)->{list.add(pw.getAge());return  list;},(list1,list2)-{list1.addAll(list2);return list1;});*/
    }



}
