import java.util.*;
import java.util.stream.Collectors;

public final class PersonDatabase {
  private List<Person> people;
  FirstNameComparator firstNameComparator = new FirstNameComparator();
  BirthdateComparator birthdateComparator = new BirthdateComparator();

  public PersonDatabase(List<Person> people) {
    this.people = people;
  }

  public List<Person> sortedByFirstName() {
    Collections.sort(people, firstNameComparator);
    return people; // external rule for ordering (based on Comparator --- FirstNameComparator)
  }

  public List<Person> sortedBySurnameFirstNameAndBirthdate() {
    Collections.sort(people);
    return people; // natural order (Comparable)
  }

  public List<Person> sortedByBirthdate() {
    Collections.sort(people, birthdateComparator);

    return people;
  }

  public static List<Person> bornOnDay(Date date) {
    List<Person> people = new ArrayList<>();
    Map<Integer,Person> list = new HashMap<>();
    people.forEach(e-> list.put(e.getIndex(), e));

    return list.entrySet()
            .stream()
            .filter(p -> p.getValue().getBirthdate().equals(date))
            .map(Map.Entry::getValue)
            .collect(Collectors.toList());
  }
}
