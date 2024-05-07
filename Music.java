import java.util.LinkedList;

import java.io.File;
import java.io.FileWriter;
import java.lang.Math;
import java.io.IOException;

public class Music {

    String title;
    String composer;
    int tempo;
    // int measures;
    LinkedList<Instrument> instruments = new LinkedList<Instrument>();
    int meterNumer;
    int meterDenom;

    public void test() {

        System.out.println(title);
        System.out.println(composer);
        System.out.println(tempo);
        // System.out.println(measures);
        System.out.println(meterNumer);
        System.out.println(meterDenom);

        System.out.println(instruments.size());

        createXML();

    }

    public void createXML() {

        try {

            int rand = (int) (Math.random() * 1000) + 1;

            File outputFile = new File(rand + ".xml");

            while (!outputFile.createNewFile()) {

                rand = (int) (Math.random() * 1000) + 1;

                outputFile = new File(rand + ".xml");

            }

            writeXML(outputFile);

        } catch (IOException e) {

            System.out.println("IOException Caught");
            System.exit(1);

        }

    }

    public void writeXML(File outputFile) {

        try {

            FileWriter xmlWriter = new FileWriter(outputFile);

            xmlWriter.write(
                    "<!DOCTYPE score-partwise PUBLIC \"-//Recordare//DTD MusicXML 3.1 Partwise//EN\" \"http://www.musicxml.org/dtds/partwise.dtd\">\n");
            xmlWriter.write("<score-partwise>\n");
            xmlWriter.write("\t<work><work-title>" + title + "</work-title></work>\n");
            xmlWriter.write("\t<identification><creator type=\"composer\">"
                    + composer + "</creator></identification>\n");

            xmlWriter.write(
                    "\t<defaults><scaling><millimeters>6.99912</millimeters><tenths>40</tenths></scaling><page-layout><page-height>1596.77</page-height><page-width>1233.87</page-width><page-margins type=\"even\"><left-margin>85.7251</left-margin><right-margin>85.7251</right-margin><top-margin>85.7251</top-margin><bottom-margin>85.7251</bottom-margin></page-margins><page-margins type=\"odd\"><left-margin>85.7251</left-margin><right-margin>85.7251</right-margin><top-margin>85.7251</top-margin><bottom-margin>85.7251</bottom-margin></page-margins></page-layout></defaults>\n");

            xmlWriter.write("\t<part-list>\n");

            for (int i = 0; i < instruments.size(); i++) {

                xmlWriter.write("\t<score-part id=\"P" + (i + 1) + "\">\n");
                xmlWriter.write("\t\t<part-name>" + instruments.get(i).instrumentName + "</part-name>\n");
                xmlWriter
                        .write("\t\t<part-abbreviation>" + instruments.get(i).instrumentAbr
                                + "</part-abbreviation>\n");

                xmlWriter.write(
                        "\t\t<score-instrument id=\"P" + (i + 1) + "-I1\">\n\t\t\t<instrument-name>"
                                + instruments.get(i).instrumentName + "</instrument-name>\n\t\t</score-instrument>\n");

                xmlWriter.write("\t</score-part>\n");

            }

            xmlWriter.write("\t</part-list>\n");

            for (int i = 0; i < instruments.size(); i++) {

                xmlWriter.write("\t<part id=\"P" + (i + 1) + "\">\n");
                xmlWriter.write("\t\t<measure number=\"1\">\n");
                xmlWriter.write("\t\t\t<attributes>\n");
                xmlWriter.write("\t\t\t\t<divisions>1</divisions>\n");
                xmlWriter.write("\t\t\t\t<key><fifths>0</fifths></key>\n");
                xmlWriter.write("\t\t\t\t<time><beats>" + meterNumer + "</beats><beat-type>" + meterDenom
                        + "</beat-type></time>\n");

                Instrument.InstrumentStaff tempInstrumentStaff = instruments.get(i).instrumentStaff;

                if (tempInstrumentStaff == Instrument.InstrumentStaff.TREBLE) {

                    xmlWriter.write("\t\t\t\t<clef>\n");
                    xmlWriter.write("\t\t\t\t\t<sign>G</sign>\n");
                    xmlWriter.write("\t\t\t\t\t<line>2</line>\n");
                    xmlWriter.write("\t\t\t\t</clef>\n");

                } else if (tempInstrumentStaff == Instrument.InstrumentStaff.BASS) {

                    xmlWriter.write("\t\t\t\t<clef>\n");
                    xmlWriter.write("\t\t\t\t\t<sign>F</sign>\n");
                    xmlWriter.write("\t\t\t\t\t<line>4</line>\n");
                    xmlWriter.write("\t\t\t\t</clef>\n");

                } else if (tempInstrumentStaff == Instrument.InstrumentStaff.GRAND) {

                    xmlWriter.write("\t\t\t\t<staves>2</staves>\n");
                    xmlWriter.write("\t\t\t\t<clef number=\"1\">\n");
                    xmlWriter.write("\t\t\t\t\t<sign>G</sign>\n");
                    xmlWriter.write("\t\t\t\t\t<line>2</line>\n");
                    xmlWriter.write("\t\t\t\t</clef>\n");
                    xmlWriter.write("\t\t\t\t<clef number=\"2\">\n");
                    xmlWriter.write("\t\t\t\t\t<sign>F</sign>\n");
                    xmlWriter.write("\t\t\t\t\t<line>4</line>\n");
                    xmlWriter.write("\t\t\t\t</clef>\n");

                }

                xmlWriter.write("\t\t\t\t<transpose>");
                xmlWriter.write("<diatonic>" + instruments.get(i).diatonicTranposition + "</diatonic>");
                xmlWriter.write("<chromatic>" + instruments.get(i).chromaticTransposition + "</chromatic>");
                xmlWriter.write("<octave-change>" + instruments.get(i).octaveChange + "</octave-change></transpose>\n");

                xmlWriter.write("\t\t\t</attributes>\n");

                if (i == 0) {

                    xmlWriter.write("\t\t\t<direction placement=\"above\"><direction-type>");
                    xmlWriter.write("<metronome parentheses=\"no\" default-x=\"-37.68\" relative-y=\"20.00\">");
                    xmlWriter.write("<beat-unit>quarter</beat-unit><per-minute>" + tempo + "</per-minute>");
                    xmlWriter.write("</metronome></direction-type>");
                    xmlWriter.write("<sound tempo=\"" + tempo + "\"/></direction>\n");

                }

            }

            xmlWriter.close();

        } catch (IOException e) {

            System.out.println("IOException Caught");
            System.exit(1);

        }

    }

}
