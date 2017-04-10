package tanke;

import java.util.ArrayList;

public class Schlange {
    
    private int autoZaehler = 0;
    private int gesamtWartezeit = 0;
    private int maximaleWartezeit = 0;
    private ArrayList<Auto> autos = new ArrayList<>();
    
    public void addAuto (Auto auto){
        autoZaehler++;
        autos.add(auto);
    }
    
    public int laenge(){
        return autos.size();
    }

    public void removeAuto(){
        autos.remove(0);
    }

    public Auto getAuto(){
        return autos.get(0);
    }
    
    public int getGesamtWartezeit(){
        return gesamtWartezeit;
    }
    
    public int getMaximaleWartezeit(){
        return maximaleWartezeit;
    }
    
    public int getAutoZaehler(){
        return autoZaehler;
    }


    public void aktualisiereWartezeit(int wartezeit){
        gesamtWartezeit = gesamtWartezeit + wartezeit;
        if (maximaleWartezeit < wartezeit){
            maximaleWartezeit = wartezeit;
        }
    }
    
    /**
     * Berechnet die Anzahl der Autos in Warteschlange.<br>
     * Wenn die Laenge der Schlange > 1 ist, muss man das Auto, die gerade bedient wurde, in der Warteschlangenlaenge nicht beruecksichtigen.
     *
     * @param schlange
     * @return Autoanzahl in der Warteschlange
     */
    public int schlangeLaengeBerechnen() {
        int autoanzahl = laenge();
        return (autoanzahl == 0 || autoanzahl == 1) ? 0 : autoanzahl - 1;
    }

    
}