import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;



//Create an application which will read input data from the file of the following format:
//<FirstName> <Surname> <Birthdate>
//<FirstName> <Surname> <Birthdate>
//<FirstName> <Surname> <Birthdate>
//The contents of an example input file could be as follows:
//        John Smith 1980-01-03
//        Mark Brown 1976-02-02
//        A three composed of (1) first name,(2) surname and (3) birthdate do not uniquely identify each person – i.e. there may be multiple people of the same first name and surname and born on the same day.
//        The data entered from the input file should be stored in several collections:
//        1. sorted by first name;
//        2. sorted by surname, first name and birthdate;
//        3. sorted by birthdate;
//        4. collection which enables quick filtering of data of people born on a specific day.
//        NOTE: To enforce your custom sorting rules implement Comparable<TValue> and Comparator<TValue> interfaces.
//        For quick filtering feature use an implementation of Map<TKey, TValue> interface.
//        For storing birthdate use java.util.Date.


public class Main {

    public static void main(String[] args) throws IOException {
	// write your code here

//        BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\oatzo\\OneDrive\\Pulpit\\File.txt"));
//        writer.write("Omar ");
//        writer.write("Atzori ");
//        writer.write("1992-12-20\n");
//
//        writer.write("Diego ");
//        writer.write("Atzori ");
//        writer.write("1986-01-02\n");
//        writer.write("Omar ");
//        writer.write("Atzori ");
//        writer.write("1992-12-20\n");
//        writer.write("Zaneta ");
//        writer.write("Trybulska ");
//        writer.write("1984-10-10\n");
//
//        writer.close();
       Person p1= new Person("Omar","Atzori",new Date(1992,12,20));
       Person p2= new Person("Omar","Atzori",new Date(1992,12,20));
       Person p3= new Person("Omar","Atzori",new Date(1992,12,20));

        List<Person> person = new ArrayList<>();
        person.addAll(Arrays.asList(p1,p2,p3));


        System.out.println(person);
        System.out.println(p1.getBirthdate());
        System.out.println(PersonDatabase.bornOnDay(new Date(1992-10-01)));
    }
}
