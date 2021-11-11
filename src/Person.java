import java.util.Date;

public class Person implements Comparable<Person> {

  public int getIndex() {
    return index;
  }

  public void setIndex(int index) {
    this.index = index;
  }

  private int index;
  private final String firstName;
  private final String surname;
  private final Date birthdate;

  public Person(Integer index, String firstName, String surname, Date birthdate) {
    this.firstName = firstName;
    this.surname = surname;
    this.birthdate = birthdate;
    this.index = index;
  }

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
    return "Person{"
        + "firstName='"
        + firstName
        + '\''
        + ", surname='"
        + surname
        + '\''
        + ", birthdate="
        + birthdate
        + '}';
  }

  @Override
  public int compareTo(Person otherPerson) {
    // natural order based on:
    // (1) surname;
    // (2) first name;
    // (3) birth date.
    return  compare(this.index, otherPerson.index) +
            surname.compareTo(otherPerson.getSurname()) +
            firstName.compareTo(otherPerson.getFirstName())+
            birthdate.compareTo(otherPerson.getBirthdate());
  }


  public static int compare(int x, int y) {
    return (x < y) ? 1 : ((x == y) ? 0 : 1);
  }
}