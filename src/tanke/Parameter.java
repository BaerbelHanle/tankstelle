package tanke;

/**
 * Festgelegte Parameter, die fuer die Simulation noetig sind.
 */
public class Parameter {

    private int zeitTankenMin; // Zeit, die der Fahrer mindetstens zum Tanken braucht in Sekunden
    private int zeitTankenMax; // Zeit, die der Fahrer hoechstens zum Tanken braucht in Sekunden
    private int zeitZahlenMin; // Zeit, die der Fahrer mindetstens zum Zahlen braucht in Sekunden
    private int zeitZahlenMax; // Zeit, die der Fahrer hoechstens zum Zahlen braucht in Sekunden
    private int zeitRaeumenMin; // Zeit, die der Fahrer mindetstens zum Rausfahren braucht in Sekunden
    private int zeitRaeumenMax; // Zeit, die der Fahrer hoechstens zum Rausfahren braucht in Sekunden
    private int abstandAutos; // durchschnittlicher Zeitabstand ankommender Autos in Sekunden
    private int simulationszeit; // Zeit ueber die der Tankstellenablauf simuliertwerden soll
    private int protokolltakt; // Zeitabstand in Sekunden, in dem das Protokoll aktualisiert werden soll


    public int getZeitTankenMin() {
        return zeitTankenMin;
    }

    public int getZeitTankenMax() {
        return zeitTankenMax;
    }

    public int getZeitZahlenMin() {
        return zeitZahlenMin;
    }

    public int getZeitZahlenMax() {
        return zeitZahlenMax;
    }

    public int getZeitRaeumenMin() {
        return zeitRaeumenMin;
    }

    public int getZeitRaeumenMax() {
        return zeitRaeumenMax;
    }

    public int getAbstandAutos() {
        return abstandAutos;
    }

    public int getSimulationszeit() {
        return simulationszeit;
    }

    public int getProtokolltakt() {
        return protokolltakt;
    }

    public void setZeitTankenMin(int zeitTankenMin) {
        this.zeitTankenMin = zeitTankenMin;
    }

    public void setZeitTankenMax(int zeitTankenMax) {
        this.zeitTankenMax = zeitTankenMax;
    }

    public void setZeitZahlenMin(int zeitZahlenMin) {
        this.zeitZahlenMin = zeitZahlenMin;
    }

    public void setZeitZahlenMax(int zeitZahlenMax) {
        this.zeitZahlenMax = zeitZahlenMax;
    }

    public void setZeitRaeumenMin(int zeitRaeumenMin) {
        this.zeitRaeumenMin = zeitRaeumenMin;
    }

    public void setZeitRaeumenMax(int zeitRaeumenMax) {
        this.zeitRaeumenMax = zeitRaeumenMax;
    }

    public void setAbstandAutos(int abstandAutos) {
        this.abstandAutos = abstandAutos;
    }

    public void setSimulationszeit(int simulationszeit) {
        this.simulationszeit = simulationszeit;
    }

    public void setProtokolltakt(int protokolltakt) {
        this.protokolltakt = protokolltakt;
    }
}