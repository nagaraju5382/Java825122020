import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.BinaryOperator;

public class BinaryOperatorExam {
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
        List<Integer> ints = Arrays.asList(1);
        int sum = 0;
        BinaryOperator<Integer> ss = (i1,i2)->i1+i2;
        for(int i:ints){
            sum = ss.apply(sum,i);
        }
        System.out.print("One element addition : "+sum);

    }
}
