package tanke;

/**
 * Simuliert ein Auto. Ein Auto ist gleich mit dem Autofahrer (z.B. an der Kasse) assoziiert.
 */
public class Auto {
    private String status = "an Zapfsaeule Warten"; // an Zapfsaeule Warten , Tanken, an Kasse Warten, Zahlen, Raeumen der Tankstelle
    private int statusZeit;
    private int tankZeit;
    private int zahlZeit;
    private int raeumZeit;

    /**
     * Konstruktor fuer die Klasse Auto.
     *
     * @param aktuelleZeit Zeit der Erzeugung des Autos
     * @param parameter Parameter zum Festlegen der tankZeit, zahlZeit und raeumZeit
     */
    public Auto(int aktuelleZeit, Parameter parameter) {
        statusZeit = aktuelleZeit;
        tankZeit = (int) (Math.random() * (parameter.getZeitTankenMax() - parameter.getZeitTankenMin()) + parameter.getZeitTankenMin());
        zahlZeit = (int) (Math.random() * (parameter.getZeitZahlenMax() - parameter.getZeitZahlenMin()) + parameter.getZeitZahlenMin());
        raeumZeit = (int) (Math.random() * (parameter.getZeitRaeumenMax() - parameter.getZeitRaeumenMin()) + parameter.getZeitRaeumenMin());

    }

    /**
     * Set-Methode fuer statusZeit.
     *
     * @param aktuelleZeit
     */
    public void setStatusZeit(int aktuelleZeit) {
        statusZeit = aktuelleZeit;
    }

    /**
     * Erhoeht den aktuellen Statuswert um eins.
     */
    public void setStatus(String neuerStatus) {
        status = neuerStatus;
    }

    /**
     * Get-Methode fuer statusZeit.
     *
     * @return statusZeit
     */
    public int getStatusZeit() {
        return statusZeit;
    }

    /**
     * Get-Methode fuer status.
     *
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Get-Methode fuer tankZeit.
     *
     * @return tankZeit
     */
    public int getTankZeit() {
        return tankZeit;
    }

    /**
     * Get-Methode fuer zahlZeit.
     *
     * @return zahlZeit
     */
    public int getZahlZeit() {
        return zahlZeit;
    }

    /**
     * Get-Methode fuer raeumZeit.
     *
     * @return raeumZeit
     */
    public int getRaeumZeit() {
        return raeumZeit;
    }

}