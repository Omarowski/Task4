package PersonFields;

import Assignment08_Classes.Assignment08Exception;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class Person implements Comparable<Person> {

    private final String firstName;
    private final String surname;
    private final Date birthdate;
    private int index;


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


    public static Person deserialize(DataInputStream input) throws Exception {
        try {

            String name = input.readUTF();
            String surname = input.readUTF();
            Date birthdayAndTime = new Date(input.readLong());
            return new Person(name, surname, birthdayAndTime);
        } catch (IOException e) {
            throw new Assignment08Exception("An error appeared ", e);
        }

    }

    public static int compare(int x, int y) {
        return (x < y) ? 1 : ((x == y) ? 0 : 1);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }


    // assignment 8
    public void serialize(DataOutputStream output) throws Assignment08Exception {
        // serialize birth date with getTime() method
        // encapsulate IOException in Assignment08Exception

        try {
            output.writeUTF(firstName);
            output.writeUTF(surname);
            output.writeLong(birthdate.getTime());

        } catch (IOException e) {
            throw new Assignment08Exception("An error appeared ", e);
        }
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
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return firstName
                + " "
                + surname
                + " "
                + formatter.format(birthdate)
                + ";";
    }

    @Override
    public int compareTo(Person otherPerson) {

        return compare(this.index, otherPerson.index) +
                surname.compareTo(otherPerson.getSurname()) +
                firstName.compareTo(otherPerson.getFirstName()) +
                birthdate.compareTo(otherPerson.getBirthdate());
    }
}