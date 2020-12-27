import java.util.*;

public class MainAPICollectionMap {
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

        City newyork = new City("newyork");
        City paris = new City("paris");
        City shangai = new City("shangai");

        Map<City,List<Person>> cityListMap = new HashMap<City,List<Person>>();
        cityListMap.putIfAbsent(paris,new ArrayList<>());
        cityListMap.get(paris).add(p2);

        cityListMap.computeIfAbsent(newyork,city -> new ArrayList<>()).add(p3);

        System.out.println("People from paris: "+cityListMap.get(paris));
        System.out.println("People from paris: "+cityListMap.getOrDefault(paris, Collections.EMPTY_LIST));
        System.out.println("People from newyork: "+cityListMap.getOrDefault(newyork, Collections.EMPTY_LIST));


    }
}
