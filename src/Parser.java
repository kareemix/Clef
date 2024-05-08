import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;

public class Parser {

    public void parse(File inputFile) {

        try {

            Scanner parseScanner = new Scanner(inputFile);

            Music inputFileObject = new Music();

            for (int lineNumber = 1; parseScanner.hasNextLine(); lineNumber++) {

                String[] lineSplit = parseScanner.nextLine().split(" ", 2);

                switch (lineSplit[0]) {

                    case "title":

                        inputFileObject.title = lineSplit[1].substring(1, lineSplit[1].length() - 1);
                        break;

                    case "composer":

                        inputFileObject.composer = lineSplit[1].substring(1, lineSplit[1].length() - 1);
                        break;

                    case "tempo":

                        String tempoPreParsed = lineSplit[1];
                        int tempo = Integer.parseInt(tempoPreParsed);

                        inputFileObject.tempo = tempo;

                        break;

                    case "meter":

                        String[] meterPreParsed = lineSplit[1].split(":", 2);
                        int meterTemp = Integer.parseInt(meterPreParsed[0]);

                        inputFileObject.meterNumer = meterTemp;

                        meterTemp = Integer.parseInt(meterPreParsed[1]);

                        inputFileObject.meterDenom = meterTemp;

                        break;

                    // case "measures":
                    //
                    // String measuresPreParsed = lineSplit[1];
                    // int measuresTemp = Integer.parseInt(measuresPreParsed);
                    //
                    // inputFileObject.measures = measuresTemp;
                    //
                    // break;

                    case "instrument":

                        Instrument tempInstrument = new Instrument(
                                lineSplit[1].substring(1, lineSplit[1].length() - 1));
                        inputFileObject.instruments.add(tempInstrument);

                        break;

                    default:

                        System.out.println("Invalid Symbol - Line " + lineNumber + " - Symbol " + lineSplit[0]);
                        System.exit(1);

                        break;

                }

            }

            parseScanner.close();
            inputFileObject.test();

        } catch (FileNotFoundException e) {

            System.out.println("File Not Found");
            System.exit(1);

        }

    }

}
