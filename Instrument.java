public class Instrument {

    enum InstrumentStaff {

        TREBLE,
        BASS,
        GRAND

    }

    String instrumentName;
    InstrumentStaff instrumentStaff;

    int diatonicTranposition;
    int chromaticTransposition;
    int octaveChange;

    boolean isPerc;

    Instrument(String instrumentName) {

        this.instrumentName = instrumentName;

        instrumentClassify();

    }

    private void instrumentClassify() {

        switch (instrumentName) {

            case "Piccolo":
                setAll(InstrumentStaff.TREBLE, 0, 0, 0, false);
                break;
            case "Flute":
                setAll(InstrumentStaff.TREBLE, 0, 0, 0, false);
                break;
            case "Oboe":
                setAll(InstrumentStaff.TREBLE, 0, 0, 0, false);
                break;
            case "Bassoon":
                setAll(InstrumentStaff.BASS, 0, 0, 0, false);
                break;
            case "Eb Clarinet":
                setAll(InstrumentStaff.TREBLE, 2, 3, 0, false);
                break;
            case "Bb Clarinet":
                setAll(InstrumentStaff.TREBLE, -1, -2, 0, false);
                break;
            case "Bass Clarinet":
                setAll(InstrumentStaff.TREBLE, 0, 0, -1, false);
                break;
            case "Alto Saxophone":
                setAll(InstrumentStaff.TREBLE, -5, -9, 0, false);
                break;
            case "Tenor Saxophone":
                setAll(InstrumentStaff.TREBLE, -1, -2, -1, false);
            case "Baritone Saxophone":
                setAll(InstrumentStaff.TREBLE, -5, -9, -1, false);
            case "Bb Trumpet":
                setAll(InstrumentStaff.TREBLE, -1, -2, 0, false);
            case "F Horn":
                setAll(InstrumentStaff.TREBLE, -4, -7, 0, false);

            default:

                break;

        }

    }

    private void setAll(InstrumentStaff instrumentStaff, int diatonicTransposition, int chromaticTransposition,
            int octaveChange,
            boolean isPerc) {

        this.instrumentStaff = instrumentStaff;
        this.diatonicTranposition = diatonicTransposition;
        this.chromaticTransposition = chromaticTransposition;
        this.octaveChange = octaveChange;
        this.isPerc = isPerc;

    }

}
