package tanke;

/**
 * Simuliert ein Auto. Ein Auto ist gleich mit dem Autofahrer (z.B. an der Kasse) assoziiert.
 */
public class Auto {
    private String status = "an Zapfsaeule Warten"; // an Zapfsaeule Warten , Tanken, an Kasse Warten, Zahlen, Raeumen der Tankstelle
    private int statusZeit;
    private int tankZeit = (int) Math.random() * (Parameter.zeitTankenMax - Parameter.zeitTankenMin + 1) + Parameter.zeitTankenMin;
    private int zahlZeit = (int) Math.random() * (Parameter.zeitZahlenMax - Parameter.zeitZahlenMin + 1) + Parameter.zeitZahlenMin;
    private int raeumZeit = (int) Math.random() * (Parameter.zeitRaeumenMax - Parameter.zeitRaeumenMin + 1) + Parameter.zeitRaeumenMin;

    /**
     * Konstruktor fuer die Klasse Auto.
     * @param aktuelleZeit Zeit der Erzeugung des Autos
     */
    public Auto(int aktuelleZeit) {
        statusZeit = aktuelleZeit;

    }

    /**
     * Set-Methode fuer statusZeit.
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
     * @return statusZeit
     */
    public int getStatusZeit() {
        return statusZeit;
    }

    /**
     * Get-Methode fuer status.
     * @return status
     */
    public String getStatus() {
        return status;
    }

    /**
     * Get-Methode fuer tankZeit.
     * @return tankZeit
     */
    public int getTankZeit() {
        return tankZeit;
    }

    /**
     * Get-Methode fuer zahlZeit.
     * @return zahlZeit
     */
    public int getZahlZeit() {
        return zahlZeit;
    }

    /**
     * Get-Methode fuer raeumZeit.
     * @return raeumZeit
     */
    public int getRaeumZeit() {
        return raeumZeit;
    }

}