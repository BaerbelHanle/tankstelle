package tanke;

/**
 * Festgelegte Parameter, die fuer die Simulation noetig sind.
 */
public class Parameter {
    /**
     * Zeit, die der Fahrer mindetstens zum Tanken braucht in Sekunden.
     */
    private int zeitTankenMin;

    /**
     * Zeit, die der Fahrer hoechstens zum Tanken braucht in Sekunden.
     */
    private int zeitTankenMax;

    /**
     * Zeit, die der Fahrer mindetstens zum Zahlen braucht in Sekunden.
     */
    private int zeitZahlenMin;

    /**
     * Zeit, die der Fahrer hoechstens zum Zahlen braucht in Sekunden.
     */
    private int zeitZahlenMax;

    /**
     * Zeit, die der Fahrer mindetstens zum Rausfahren braucht in Sekunden.
     */
    private int zeitRaeumenMin;

    /**
     * Zeit, die der Fahrer hoechstens zum Rausfahren braucht in Sekunden.
     */
    private int zeitRaeumenMax;

    /**
     * Durchschnittlicher Zeitabstand ankommender Autos in Sekunden.
     */
    private int abstandAutos;

    /**
     * Zeit ueber die der Tankstellenablauf simuliertwerden soll.
     */
    private int simulationszeit;

    /**
     * Zeitabstand in Sekunden, in dem das Protokoll aktualisiert werden soll.
     */
    private int protokolltakt;

    /**
     * Get-Methode fuer zeitTankenMin.
     * @return zeitTankenMin.
     */
    public int getZeitTankenMin() {
        return zeitTankenMin;
    }

    /**
     * Get-Methode fuer zeitTankenMax.
     * @return zeitTankenMax
     */
    public int getZeitTankenMax() {
        return zeitTankenMax;
    }

    /**
     * Get-Methode fuer zeitZahlenMin
     * @return zeitZahlenMin
     */
    public int getZeitZahlenMin() {
        return zeitZahlenMin;
    }

    /**
     * Get-Methode fuer zeitZahlenMax
     * @return zeitZahlenMin
     */
    public int getZeitZahlenMax() {
        return zeitZahlenMax;
    }

    /**
     * Get-Methode fuer zeitRaeumenMin
     * @return zeitZahlenMax
     */
    public int getZeitRaeumenMin() {
        return zeitRaeumenMin;
    }

    /**
     * Get-Methode fuer zeitRaeumenMax
     * @return zeitRaeumenMax
     */
    public int getZeitRaeumenMax() {
        return zeitRaeumenMax;
    }

    /**
     * Get-Methode fuer abstandAutos
     * @return abstandAutos
     */
    public int getAbstandAutos() {
        return abstandAutos;
    }

    /**
     * Get-Methode fuer simulationszeit
     * @return simulationszeit
     */
    public int getSimulationszeit() {
        return simulationszeit;
    }

    /**
     * Get-Methode fuer protokolltakt
     * @return protokolltakt
     */
    public int getProtokolltakt() {
        return protokolltakt;
    }

    /**
     * Set-Methode fuer setZeitTankenMin
     * @param zeitTankenMin minimale Zeit zum Tanken
     */
    public void setZeitTankenMin(int zeitTankenMin) {
        this.zeitTankenMin = zeitTankenMin;
    }

    /**
     * Set-Methode fuer setZeitTankenMax
     * @param zeitTankenMax maximale Zeit zum Tanken
     */
    public void setZeitTankenMax(int zeitTankenMax) {
        this.zeitTankenMax = zeitTankenMax;
    }

    /**
     * Set-Methode fuer  zeitZahlenMin
     * @param zeitZahlenMin minimale Zeit zum Zahlen
     */
    public void setZeitZahlenMin(int zeitZahlenMin) {
        this.zeitZahlenMin = zeitZahlenMin;
    }

    /**
     * Set-Methode fuer zeitZahlenMax
     * @param zeitZahlenMax maximale Zeit zum Zahlen
     */
    public void setZeitZahlenMax(int zeitZahlenMax) {
        this.zeitZahlenMax = zeitZahlenMax;
    }

    /**
     * Set-Methode fuer zeitRaeumenMin
     * @param zeitRaeumenMin minimale Zeit zum Raeumen der Tankstelle
     */
    public void setZeitRaeumenMin(int zeitRaeumenMin) {
        this.zeitRaeumenMin = zeitRaeumenMin;
    }

    /**
     * Set-Methode fuer zeitRaeumenMax
     * @param zeitRaeumenMax maximale Zeit zum Raeumen der Tankstelle
     */
    public void setZeitRaeumenMax(int zeitRaeumenMax) {
        this.zeitRaeumenMax = zeitRaeumenMax;
    }

    /**
     * Set-Methode fuer abstandAutos
     * @param abstandAutos Abstand, in dem Autos ankommen
     */
    public void setAbstandAutos(int abstandAutos) {
        this.abstandAutos = abstandAutos;
    }

    /**
     * Set-Methode fuer simulationszeit
     * @param simulationszeit die Laenge der Simulation
     */
    public void setSimulationszeit(int simulationszeit) {
        this.simulationszeit = simulationszeit;
    }

    /**
     * Set-Methode fuer protokolltakt
     * @param protokolltakt die Zeit, in der Protokoll ausgegeben wird
     */
    public void setProtokolltakt(int protokolltakt) {
        this.protokolltakt = protokolltakt;
    }
}