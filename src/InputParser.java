import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public final class InputParser {

    // 1. Use regular expressions (Pattern) for validating input data
    // 2. Convert input string representing date using SimpleDateFormat "yyyy-MM-dd"



    public static List<Person> parse(File file) throws FileNotFoundException {
        String regPattern = "";
        List<Person> list = new ArrayList<Person>();
        for (Scanner s = new Scanner(file);s.hasNextLine();) {
            list.add(s.nextLine());
        }

        return list;
    }
}