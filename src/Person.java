import java.util.Objects;

public class Person {



    private String firstName;
    private String lastName;

    public Person(String firstName,String lastName){
        Objects.requireNonNull(firstName,"FirstName should not be null!!");
        Objects.requireNonNull(lastName,"FirstName should not be null!!");
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

}
