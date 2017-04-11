package tanke;

import java.util.ArrayList;

public class Schlange {
    
    private int autoZaehler = 0;
    private int gesamtWartezeit = 0;
    private int maximaleWartezeit = 0;
    private ArrayList<Auto> autos = new ArrayList<>();

    /**
     * Konstruktor fuer die Klasse Schlange.
     * @param auto Auto, die der Schlange hinzugefuegt werden soll.
     */
    public void addAuto (Auto auto){
        autoZaehler++;
        autos.add(auto);
    }

    /**
     * Gibt die Laenge der Schlange zurueck.
     * @return die Laenge der Schlange
     */
    public int laenge(){
        return autos.size();
    }

    /**
     * Entfernt das erste Auto aus der Schlange.
     */
    public void removeAuto(){
        autos.remove(0);
    }

    /**
     * Get-Methode fuer das erste Auto in der Schlange.
     * @return erstes Auto
     */
    public Auto getAuto(){
        return autos.get(0);
    }

    /**
     * Get-Methode fuer die gesamte Wartezeit in der Schlange.
     * @return gesamtWartezeit
     */
    public int getGesamtWartezeit(){
        return gesamtWartezeit;
    }

    /**
     * Get-Methode fuer die maximale Wartezeit in der Schlange.
     * @return maximaleWartezeit
     */
    public int getMaximaleWartezeit(){
        return maximaleWartezeit;
    }

    /**
     * Get-Methode fuer die Anzahl der Autos in der Schlange.
     * @return autoZaehler
     */
    public int getAutoZaehler(){
        return autoZaehler;
    }

    /**
     * Aktualisiert die gesamte Wartezeit in der Schlange.
     * @param wartezeit
     */
    public void aktualisiereWartezeit(int wartezeit){
        gesamtWartezeit = gesamtWartezeit + wartezeit;
        if (maximaleWartezeit < wartezeit){
            maximaleWartezeit = wartezeit;
        }
    }
    
    /**
     * Berechnet die Anzahl der Autos in Warteschlange.<br>
     * Wenn die Laenge der Schlange > 1 ist, muss man das Auto, die gerade bedient wurde, in der Warteschlangenlaenge nicht beruecksichtigen.
     * @return Autoanzahl in der Warteschlange
     */
    public int schlangeLaengeBerechnen() {
        int autoanzahl = laenge();
        return (autoanzahl == 0 || autoanzahl == 1) ? 0 : autoanzahl - 1;
    }


}