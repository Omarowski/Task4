import java.util.Comparator;

public class FirstNameComparator implements Comparator<Person> {



    @Override
    public int compare(Person person1, Person person2) {
        // TODO Auto-generated method stub
        return person1.getFirstName().compareTo(person2.getFirstName());
    }
}
