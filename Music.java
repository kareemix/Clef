import java.util.LinkedList;
import java.io.File;
import java.io.FileWriter;
import java.lang.Math;
import java.io.IOException;

public class Music {

    String title;
    String composer;
    int tempo;
    int measures;
    LinkedList<String> instruments = new LinkedList<String>();
    LinkedList<Boolean> isDrum = new LinkedList<Boolean>();
    int meterNumer;
    int meterDenom;

    public void test() {

        System.out.println(title);
        System.out.println(composer);
        System.out.println(tempo);
        System.out.println(measures);
        System.out.println(meterNumer);
        System.out.println(meterDenom);

        System.out.println(instruments.size());
        System.out.println(isDrum.size());

        createJson();

    }

    public void createJson() {

        try {

            int rand = (int) (Math.random() * 1000) + 1;

            File outputFile = new File(rand + ".json");

            while (!outputFile.createNewFile()) {

                rand = (int) (Math.random() * 1000) + 1;

                outputFile = new File(rand + ".json");

            }

            writeJson(outputFile);

        } catch (IOException e) {

            System.out.println("IOException Caught");
            System.exit(1);

        }

    }

    public void writeJson(File outputFile) {

        try {

            FileWriter jsonWriter = new FileWriter(outputFile);

            jsonWriter.write("{\n");

            jsonWriter.write("\t\"metadata\":\n");

            jsonWriter.write("\t{\n");

            jsonWriter.write("\t\t\"schema_version\": \"0.2\",\n");
            jsonWriter.write("\t\t\"title\": " + title + ",\n");
            jsonWriter.write("\t\t\"creators\": \n\t\t[\n\t\t\t" + composer + "\n\t\t],\n");

            // Source filename / Source format
            jsonWriter.write("\t\t\"source_filename\": " + title + ",\n");
            jsonWriter.write("\t\t\"source_format\": \"musescore\"\n");

            jsonWriter.write("\t},\n");

            jsonWriter.write("\t\"resolution\": 480,\n");
            jsonWriter.write("\t\"tempos\":\n\t[\n\t\t{\n\t\t\t\"time\": 0,\n\t\t\t\"qpm\": " + tempo + "\n");
            jsonWriter.write("\t\t}\n\t],\n");

            jsonWriter.write("\t\"time_signatures\":\n\t[\n\t\t{\n\t\t\t\"time\": 0,\n\t\t\t\"numerator\": "
                    + meterNumer + ",\n\t\t\t\"denominator\": " + meterDenom + "\n");
            jsonWriter.write("\t\t}\n\t],\n");

            jsonWriter.write("\t\"barlines\":\n");
            jsonWriter.write("\t[\n");

            for (int i = 0; i < measures; i++) {

                double j = (i * 1920 * (double) (meterNumer / meterDenom));
                jsonWriter.write("\t\t{\n\t\t\t\"time\": " + (int) j + "\n\t\t}");

                if (i < measures - 1) {

                    jsonWriter.write(",");

                }

                jsonWriter.write("\n");

            }

            jsonWriter.write("\t],\n");

            jsonWriter.write("\t\"tracks\":\n\t[\n");

            for (int i = 0; instruments.peekFirst() != null; i++) {

                jsonWriter.write("\t\t{\n\t\t\t\"program\": 0,\n\t\t\t\"is_drum\": " + isDrum.poll()
                        + ",\n\t\t\t\"name\": " + instruments.poll() + "\n\t\t}");

                if (i < instruments.size()) {

                    jsonWriter.write(",");

                }

                jsonWriter.write("\n");

            }

            jsonWriter.write("\t]\n");

            jsonWriter.write("}");

            jsonWriter.close();

        } catch (IOException e) {

            System.out.println("IOException Caught");
            System.exit(1);

        }

    }

}
