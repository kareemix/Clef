public class Instrument {

    enum InstrumentStaff {

        TREBLE,
        BASS,
        GRAND,
        PERCUSSION

    }

    String instrumentName;
    InstrumentStaff instrumentStaff;

    int diatonicTranposition;
    int chromaticTransposition;
    int octaveChange;

    boolean isPerc;
    String instrumentAbr;

    Instrument(String instrumentName) {

        this.instrumentName = instrumentName;

        instrumentClassify();

    }

    private void instrumentClassify() {

        // weird instruments:
        // trombone - no transposition / octave
        switch (instrumentName) {

            case "Piccolo":
                setAll(InstrumentStaff.TREBLE, 0, 0, 0, false, "Picc.");
                break;
            case "Flute":
                setAll(InstrumentStaff.TREBLE, 0, 0, 0, false, "Fl.");
                break;
            case "Oboe":
                setAll(InstrumentStaff.TREBLE, 0, 0, 0, false, "Ob.");
                break;
            case "Bassoon":
                setAll(InstrumentStaff.BASS, 0, 0, 0, false, "Bsn.");
                break;
            case "Eb Clarinet":
                setAll(InstrumentStaff.TREBLE, 2, 3, 0, false, "Eb Cl.");
                break;
            case "Bb Clarinet":
                setAll(InstrumentStaff.TREBLE, -1, -2, 0, false, "Bb Cl.");
                break;
            case "Bass Clarinet":
                setAll(InstrumentStaff.TREBLE, 0, 0, -1, false, "B. Cl.");
                break;
            case "Alto Saxophone":
                setAll(InstrumentStaff.TREBLE, -5, -9, 0, false, "A. Sax.");
                break;
            case "Tenor Saxophone":
                setAll(InstrumentStaff.TREBLE, -1, -2, -1, false, "T. Sax.");
                break;
            case "Baritone Saxophone":
                setAll(InstrumentStaff.TREBLE, -5, -9, -1, false, "Bar. Sax.");
                break;
            case "Bb Trumpet":
                setAll(InstrumentStaff.TREBLE, -1, -2, 0, false, "Bb Tpt.");
                break;
            case "F Horn":
                setAll(InstrumentStaff.TREBLE, -4, -7, 0, false, "F Hn.");
                break;
            case "Trombone":
                setAll(InstrumentStaff.BASS, 0, 0, 0, false, "Tbn.");
                break;
            case "Euphonium":
                setAll(InstrumentStaff.BASS, 0, 0, 0, false, "Euph.");
                break;
            case "Tuba":
                setAll(InstrumentStaff.BASS, 0, 0, 0, false, "Tba.");
                break;
            case "Double Bass":
                setAll(InstrumentStaff.BASS, 0, 0, -1, false, "Db.");
                break;
            case "Timpani":
                setAll(InstrumentStaff.BASS, 0, 0, 0, false, "Timp.");
                break;
            case "Glockenspiel":
                setAll(InstrumentStaff.TREBLE, 0, 0, 2, false, "Glk.");
                break;
            case "Piano":
                setAll(InstrumentStaff.GRAND, 0, 0, 0, false, "Pno.");
                break;

            default:

                System.out.println("Instrument Not Found - " + instrumentName);
                System.exit(1);

                break;

        }

    }

    private void setAll(InstrumentStaff instrumentStaff, int diatonicTransposition, int chromaticTransposition,
            int octaveChange,
            boolean isPerc, String instrumentAbr) {

        this.instrumentStaff = instrumentStaff;
        this.diatonicTranposition = diatonicTransposition;
        this.chromaticTransposition = chromaticTransposition;
        this.octaveChange = octaveChange;
        this.isPerc = isPerc;
        this.instrumentAbr = instrumentAbr;

    }

}
