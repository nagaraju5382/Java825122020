import java.util.*;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

import static jdk.nashorn.internal.objects.NativeArray.reduce;

public class ReduceExample {
    public static void main(String[] args) {
        Person p = new Person("name","lastName",3);
        Person p2 = new Person("naga","gunji",34);
        Person p3 = new Person("naga","galvin",43);
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

        List<Integer> listInt = Arrays.asList(1,2,3,4,5,6,7,8,9);

        BinaryOperator<Integer> sum2 = (i1,i2)->i1+i2;

        int reduction = (int) reduce(listInt,0,sum2);

        int sum = personList.stream().filter(Objects::nonNull)
                .filter(b -> b.getFirstName().equalsIgnoreCase("naga") )
                .mapToInt(b -> b.getAge())
                .sum();
        System.out.print("Sum of Ages with name Naga: "+sum);

        int sumReducebinary = personList.stream().map(per->per.getAge()).reduce(0,(x,y)->x+y);
        System.out.println("Reduce Binary Sum: "+sumReducebinary);

        OptionalDouble avg = personList.stream().filter(Objects::nonNull)
                .filter(b -> b.getFirstName().equalsIgnoreCase("naga") )
                .mapToInt(b -> b.getAge())
                .average();
        Double avgs = avg.isPresent() ?avg.getAsDouble():0d;
        avg.ifPresent((s)-> {personList.get(0).setAge(2);}                 );
        System.out.print("Avg: "+ avgs);

        List<Integer> intList = personList.stream().map(e->e.getAge()).collect(Collectors.toList());

        Optional<Integer> ss = intList.stream().reduce( (a1, a2)-> a1 + a2);

        BinaryOperator<Integer> op1 = (i1,i3) ->Integer.max(i1,i3);

        Optional<Integer> ese = intList.stream().reduce(op1);
        System.out.println("max of ages: "+ese.get());

    }
}
