package Tests;

import PersonFields.InputParser;
import PersonFields.Person;
import PersonFields.PersonDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

class InputParserTest {
    FileReader input;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");

    @Test
    public void givenFileWithCorrectDataThenSuccess() throws Exception {
        String file = "src/output.txt";
        input = new FileReader(file);
        List<Person> people = InputParser.readFromInputStream(input);
        people.forEach(
                e ->
                        System.out.println(
                                e.getFirstName() + e.getSurname() + formatter.format(e.getBirthdate())));
    }

    @Test
    public void givenFileWithWrongDateThenFail() throws IOException, ParseException {
        String file = "src/wrongDateFormat.txt";
        input = new FileReader(file);
        Exception exception =
                Assertions.assertThrows(
                        Exception.class,
                        () -> {
                            InputParser.readFromInputStream(input);
                        });
        Assertions.assertEquals("Wrong Format line", exception.getMessage());
    }

    @Test
    public void givenListOfPeopleWithSameDataThenSuccess() throws Exception {
        String file = "src/listOfPeople.txt";
        input = new FileReader(file);
        List<Person> people = InputParser.readFromInputStream(input);
        Assertions.assertTrue(people.size() == 6);
    }

    @Test
    public void givenListOfPeopleWithSameDataVerifyCompareTo() throws Exception {
        String file = "src/listOfPeople.txt";
        input = new FileReader(file);
        List<Person> people = InputParser.readFromInputStream(input);
        Person person1 = people.get(0);
        Person person2 = people.get(1);
        Assertions.assertTrue(person1.compareTo(person2) == 1);
    }

    @Test
    public void givenListOfPeopleWithSameDataVerifyCompareToSame() throws Exception {
        String file = "src/listOfPeople.txt";
        input = new FileReader(file);
        List<Person> people = InputParser.readFromInputStream(input);
        Person person1 = people.get(0);
        Person person2 = people.get(0);
        Assertions.assertTrue(person1.compareTo(person2) == 0);
    }

    @Test
    public void givenListOfPeopleWithDifferentDataVerifyCompareTo() throws Exception {
        String file = "src/listOfPeople.txt";
        input = new FileReader(file);
        List<Person> people = InputParser.readFromInputStream(input);
        Person person1 = people.get(2);
        Person person2 = people.get(3);
        Assertions.assertTrue(person1.compareTo(person2) == 1);
    }

    @Test
    public void givenListOfPeopleWithDifferentFirstNameVerifyValidateSort() throws Exception {
        String file = "src/listOfPeopleForFirstNameComparator.txt";
        input = new FileReader(file);
        List<Person> people = InputParser.readFromInputStream(input);
        System.out.println("Before: ");
        people.forEach(
                e ->
                        System.out.println(
                                e.getFirstName() + e.getSurname()));
        PersonDatabase personDatabase = new PersonDatabase(people);
        System.out.println("after: ");
        personDatabase.sortedByFirstName().forEach(
                e ->
                        System.out.println(
                                e.getFirstName() + e.getSurname()));


    }

    @Test
    public void givenListOfPeopleWithDifferentDatesVerifyValidateSort() throws Exception {
        String file = "src/listOfPeopleForFirstNameComparator.txt";
        input = new FileReader(file);
        List<Person> people = InputParser.readFromInputStream(input);
        System.out.println("Before: ");
        people.forEach(
                e ->
                        System.out.println(
                                e.getFirstName() + e.getSurname()));
        PersonDatabase personDatabase = new PersonDatabase(people);
        System.out.println("after: ");
        personDatabase.sortedByBirthdate().forEach(
                e ->
                        System.out.println(
                                e.getFirstName() + " " + formatter.format(e.getBirthdate())));


    }
}