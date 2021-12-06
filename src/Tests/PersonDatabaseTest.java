package Tests;

import PersonFields.InputParser;
import PersonFields.Person;
import PersonFields.PersonDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;

class PersonDatabaseTest {
    FileReader input;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    PersonDatabase personDatabase;
    FileOutputStream outputStream;
    DataOutputStream personDataOutputStream;

    @Test
    void sortedByFirstName() throws Exception {
        String file = "src/txtFiles/output.txt";
        input = new FileReader(file);
        List<Person> people = InputParser.readFromInputStream(input);
        Assertions.assertEquals(people.get(0).getFirstName(), "Omar");
        Assertions.assertEquals(people.get(people.size() - 1).getFirstName(), "four");

    }



    @Test
    void sortedBySurnameFirstNameAndBirthdate() throws Exception {
        String file = "src/txtFiles/output.txt";
        input = new FileReader(file);
        List<Person> people = InputParser.readFromInputStream(input);

        Assertions.assertEquals(people.get(0).getSurname(), "Omarowiski");
        Assertions.assertEquals(people.get(0).getFirstName(), "Omar");
        Assertions.assertEquals(people.get(1).getSurname(), "Omarowiski");
        Assertions.assertEquals(people.get(1).getFirstName(), "Omar");
        Assertions.assertTrue(people.get(1).getBirthdate() != people.get(2).getBirthdate());
    }

    @Test
    void sortedByBirthdate() throws Exception {
        String file = "src/txtFiles/output.txt";
        input = new FileReader(file);
        List<Person> peopleBornOnDate = InputParser.readFromInputStream(input);
        PersonDatabase personDatabase = new PersonDatabase(peopleBornOnDate);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        personDatabase.sortedByBirthdate().forEach(
                e -> formatter.format(e.getBirthdate()));
        Assertions.assertTrue(personDatabase.sortedByBirthdate().get(0).getBirthdate() != personDatabase.sortedByBirthdate().get(1).getBirthdate());

    }

    @Test
    void bornOnDay() throws Exception {
        String file = "src/txtFiles/output.txt";
        input = new FileReader(file);
        List<Person> peopleBornOnDate = InputParser.readFromInputStream(input);
        PersonDatabase personDatabase = new PersonDatabase(peopleBornOnDate);
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        personDatabase.sortedByBirthdate().forEach(
                e -> formatter.format(e.getBirthdate()));
        Assertions.assertEquals("30/10/1991", formatter.format(personDatabase.sortedByBirthdate().get(5).getBirthdate()));

    }
}