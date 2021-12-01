package PersonFields;

import java.util.Comparator;


public final class BirthdateComparator implements Comparator<Person> {



    @Override
    public int compare(Person person1, Person person2) {
        if(person1.compareTo(person2) > 0) {
            person2.getBirthdate();
        } else if(person1.compareTo(person2) < 0) {
            person1.getBirthdate();
        } else if(person1.compareTo(person1) == 0) {
            person1.getBirthdate();
        }
        return person1.getBirthdate().compareTo(person2.getBirthdate());

    }
}