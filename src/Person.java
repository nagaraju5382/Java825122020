import java.util.Objects;

public class Person {



    private String firstName;
    private String lastName;
    private int age;

    public Person(String firstName,String lastName,int age){
        Objects.requireNonNull(firstName,"FirstName should not be null!!");
        Objects.requireNonNull(lastName,"lastName should not be null!!");
        Objects.requireNonNull(age,"Age should not be null!!");
        this.firstName = firstName;
        this.lastName = lastName;
        this.age=age;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                '}';
    }
}
