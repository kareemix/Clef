import java.io.File;
import java.io.FileNotFoundException;

public class Main {

    public static void main(String[] args) {

        if (args.length <= 0 || args.length > 1) {

            System.out.println("Invalid Input");
            System.exit(1);

        }

        File inputFile = new File(args[0]);

        Parser inputFileParser = new Parser();
        inputFileParser.parse(inputFile);

        // System.getProperty("user.dir")

    }

}
