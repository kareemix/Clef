import java.io.File;

public class Main {

    public static void main(String[] args) {

        if (args.length <= 0 || args.length > 1) {

            System.out.println("Invalid Input");
            System.exit(1);

        }

        File input_file = new File(args[0]);

    }

}
