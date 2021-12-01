package PersonFields;

import java.io.BufferedReader;
import java.io.FileReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public final class InputParser {

  // 1. Use regular expressions (Pattern) for validating input data
  // 2. Convert input string representing date using SimpleDateFormat "yyyy-MM-dd"

  public static List<Person> readFromInputStream(FileReader input)
          throws Exception {
    Pattern pattern = Pattern.compile("[a-zA-Z]+\\s+[a-zA-Z]+\\s+[0-9]{4}-[0-9]{2}-[0-9]{2}");
    BufferedReader bufRead = new BufferedReader(input);
    String myLine = null;
    Person person;
    List<Person> people = new ArrayList<>();
    int value= 0;
    while ((myLine = bufRead.readLine()) != null) {
       value++;
      Matcher matcher = pattern.matcher(myLine);
      if (!matcher.matches()){
        throw new Exception("Wrong Format line");
      }
      String[] array1 = myLine.split(" ");
      person =
          new Person(value, array1[0], array1[1], new SimpleDateFormat("yyyy-MM-dd").parse(array1[2]));
      people.add(person);
     }
    return people;
  }

}
