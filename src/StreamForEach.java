import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.UnaryOperator;

public class StreamForEach {
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
        List<Integer> ages = new ArrayList<>();

        List<Person> newwayTocreateList = new ArrayList<>(Arrays.asList(p,p2,p3,p4,p5,p6));
        System.out.println("newwayTocreateList size: " + newwayTocreateList.size());
        personList.stream().forEach(System.out::println);
        Consumer<Integer> x = ages::add;
        Consumer<Integer> y = System.out::println;
        //consumer
        personList.stream()
                .map(pi->pi.getAge())
                .filter(po->po>6).forEach(x.andThen(y));
        System.out.println("Size of ages: "+ages.size());

        newwayTocreateList.removeIf(people->people.getAge()>40);
      //  newwayTocreateList.replaceAll(pew->new Person(pew.getFirstName().toUpperCase(),pew.getLastName(),pew.getAge()));

        UnaryOperator<Person> ooop = (p0) -> { if(p0.getAge() == 34){return  new Person(p0.getFirstName().toUpperCase(),p0.getLastName(),p0.getAge());}else {
        return  new Person(p0.getFirstName(), p0.getLastName(), p0.getAge());}
        };


        newwayTocreateList.forEach(System.out::println);
        newwayTocreateList.replaceAll(ooop);
        newwayTocreateList.forEach(System.out::println);
    }
}
