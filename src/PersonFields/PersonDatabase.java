package PersonFields;

import Assignment08_Classes.Assignment08Exception;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public final class PersonDatabase {
    FirstNameComparator firstNameComparator = new FirstNameComparator();
    BirthdateComparator birthdateComparator = new BirthdateComparator();
    private static List<Person> people;

    public PersonDatabase(List<Person> people) {
        this.people = people;
    }

    public  List<Person> getPeople() {
        return people;
    }

    // assignment 8 - factory method based on deserialization
    public static PersonDatabase deserialize(DataInputStream input) throws Exception {
        String value = input.readLine();


        return new PersonDatabase(deserializeContent(String.valueOf(value)));
    }

    private static List<Person> deserializeContent(String content) throws Exception {
        Pattern pattern = Pattern.compile("[a-zA-Z]+\\s+[a-zA-Z]+\\s+[0-9]{2}/[0-9]{2}/[0-9]{4}");
        Person person;
        List<Person> people = new ArrayList<>();
        String[] tr = content.split(";");
        int value = 0;

        for (String p : tr) {
            value++;
            Matcher matcher = pattern.matcher(p);
            if (!matcher.matches()) {
                throw new Exception("Wrong Format line");
            }
            String[] array1 = p.split(" ");
            person =
                    new Person(value, array1[0], array1[1], new SimpleDateFormat("dd/MM/yyyy").parse(array1[2]));
            people.add(person);
        }

        return people;
    }


    // assignment 8
    public void serialize(DataOutputStream output) throws Assignment08Exception {

        try {
            for (Person p : people) {
                output.write(p.toString().getBytes());
            }

        } catch (IOException e) {
            throw new Assignment08Exception("An error appeared ", e);
        }

    }

    public static List<Person> sortedBySurnameFirstNameAndBirthdate() {
        Collections.sort(people);
        return people; // natural order (Comparable)
    }

    public static List<Person> bornOnDay(Date date) {
        List<Person> people = new ArrayList<>();
        Map<Integer, Person> list = new HashMap<>();
        people.forEach(e -> list.put(e.getIndex(), e));

        return list.entrySet()
                .stream()
                .filter(p -> p.getValue().getBirthdate().equals(date))
                .map(Map.Entry::getValue)
                .collect(Collectors.toList());
    }

    public List<Person> sortedByFirstName() {
        Collections.sort(people, firstNameComparator);
        return people; // external rule for ordering (based on Comparator --- PersonFields.FirstNameComparator)
    }

    public List<Person> sortedByBirthdate() {
        Collections.sort(people, birthdateComparator);
        return people;
    }
}
