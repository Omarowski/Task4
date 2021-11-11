import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TreeMap;
import java.util.stream.Collectors;

public final class PersonDatabase {




    public List<Person> sortedByFirstName() {


        return null; // external rule for ordering (based on Comparator --- FirstNameComparator)
    }

    public List<Person> sortedBySurnameFirstNameAndBirthdate() {

        return null; // natural order (Comparable)
    }

    public List<Person> sortedByBirthdate() {


        return null; // external rule for ordering (based on Comparator --- BirthdateComparator)
    }

    public static List<Person> bornOnDay(Date date) {
        List<Person> people = new ArrayList<>();
        return people
                .stream()
                .filter(p -> p.getBirthdate().equals(date))
                .collect(Collectors.toList());

    }
}