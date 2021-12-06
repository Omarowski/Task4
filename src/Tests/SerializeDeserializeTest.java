package Tests;

import PersonFields.InputParser;
import PersonFields.Person;
import PersonFields.PersonDatabase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class SerializeDeserializeTest {
    FileReader input;
    SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    PersonDatabase personDatabase;
    FileOutputStream outputStream;
    DataOutputStream personDataOutputStream;


    @Test
    void serializeOutput() throws Exception {
        String file = "src/txtFiles/output.txt";
        input = new FileReader(file);
        List<Person> people = InputParser.readFromInputStream(input);
        PersonDatabase personDatabase = new PersonDatabase(people);
        outputStream = new FileOutputStream(file + ".bit");
        personDataOutputStream = new DataOutputStream(outputStream);
        personDatabase.serialize(personDataOutputStream);
        Assertions.assertEquals(file, "src/txtFiles/output.txt");
    }


    @Test
    void deserializeOutput() throws Exception {
        String file = "src/txtFiles/output.txt.bit";
        FileInputStream fin = new FileInputStream(file);
        DataInputStream dataInputStream = new DataInputStream(fin);
        PersonDatabase actual = PersonDatabase.deserialize(dataInputStream);
        actual.getPeople().stream().forEach(e -> System.out.println(e.toString()));
        Assertions.assertEquals(actual.getPeople().get(0).toString(), "Omar Omarowiski 23/10/1991;");
        Assertions.assertEquals(actual.getPeople().get(2).toString(), "Uno Omarowiski 20/10/1991;");
        Assertions.assertEquals(actual.getPeople().size(), 6);
    }
}