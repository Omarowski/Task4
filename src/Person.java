import java.util.Date;

public class Person implements Comparable<Person> {

    private final String firstName;
    private final String surname;
    private final Date birthdate;

    public Person(String firstName, String surname, Date birthdate) {
        this.firstName = firstName;
        this.surname = surname;
        this.birthdate = birthdate;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getSurname() {
        return surname;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    @Override
    public String toString() {
        return "Person{" +
                "firstName='" + firstName + '\'' +
                ", surname='" + surname + '\'' +
                ", birthdate=" + birthdate +
                '}';
    }

    @Override
    public int compareTo(Person otherPerson) {
        // natural order based on:
        // (1) surname;
        // (2) first name;
        // (3) birth date.
        return   surname.compareTo(otherPerson.getSurname()) +
                 firstName.compareTo(otherPerson.getFirstName())+
                 birthdate.compareTo(otherPerson.getBirthdate());
    }
}