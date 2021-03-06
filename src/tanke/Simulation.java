package tanke;

import java.util.ArrayList;

/**
 * Die Haupklasse des Programms, quasi ein Universum, in der sich die Tankstelle befindet.
 * Sie enthaelt drei Zapfsaeulen, eine Kasse, einen Sekundenzaehler und einen Taktzaehler,
 * der den Takt der Ausgabe des Protokolls angibt. In dieser Klasse findet Tanken, Bezahlen
 * und Raeumen der Autos an der Tankstelle statt.
 */
public class Simulation {
    /**
     * Zapfsaeulen der Tankstelle.
     */
    private ArrayList<Schlange> zapfsaeulen = new ArrayList<>();
    /**
     * Kasse der Tankstelle.
     */
    private Schlange kasse = new Schlange();
    /**
     * Aktuelle Zeit, in der die Simulation laeuft (Sekunden).
     */
    private int tick = 0;
    /**
     * Zeit fuer die Protokollausgabe.
     */
    private int takt = 0;
    /**
     * Parameter, die fuer die Simulation gebraucht werden.
     */
    private Parameter parameter = new Parameter();

    /**
     * Konstruktor fuer die Klasse Simulation.
     */
    public Simulation(Parameter parameter) {
        zapfsaeulen.add(new Schlange());
        zapfsaeulen.add(new Schlange());
        zapfsaeulen.add(new Schlange());
        this.parameter = parameter;
    }

    /**
     * Die Hauptfunktion des Programms, die den Ablauf der Simulation bestimmt. <br>
     * Folgende Funktionen werden jede Sekunde aufgerufen:
     * <ul>
     * <li> Ankommen von den Autos</li>
     * <li> Tanken an den Tankstellen</li>
     * <li> Bezahlung an den Kassen</li>
     * <li> Ausgabe des Protokolls</li>
     * </ul>
     */
    public void ticken() {

        for (int i = 0; i < parameter.getSimulationszeit(); i++) {

            tick++;

            double r = Math.random();
            if (r < 1 / (double) parameter.getAbstandAutos()) {
                autoKommt();
            }

            startTanken();
            endTanken();
            startZahlen();
            endZahlen();
            end();

            if (i % parameter.getProtokolltakt() == 0) {
                takt = i / 60;
                protokollErweitern();
            }
        }

        takt = parameter.getSimulationszeit() / 60;
        protokollErweitern();

        for(Schlange zapfsaeule : zapfsaeulen){
            zapfsaeule.wartezeitenEinsammelnZapfsaeulen(tick);
        }

        kasse.wartezeitenEinsammelnKasse(tick);
    }

    /**
     * Simuliert das Ankommen von Autos an die Tankstelle. Die Autos fahren zu der Zapfsaeule, die am wenigstens besetzt ist.
     */
    private void autoKommt() {

        Auto auto = new Auto(tick, parameter);
        auto.setStatus("an Zapfsaeule Warten");
        if (zapfsaeulen.get(0).laenge() <= zapfsaeulen.get(1).laenge() &&
                zapfsaeulen.get(0).laenge() <= zapfsaeulen.get(2).laenge()) {
            zapfsaeulen.get(0).addAuto(auto);
        } else if (zapfsaeulen.get(1).laenge() <= zapfsaeulen.get(2).laenge()) {
            zapfsaeulen.get(1).addAuto(auto);
        } else {
            zapfsaeulen.get(2).addAuto(auto);
        }

    }

    /**
     * Simuliert den Start des Tankens an den Zapfsaeulen.
     */
    private void startTanken() {
        for (Schlange zapfsaeule : zapfsaeulen) {
            if (zapfsaeule.laenge() > 0) {
                Auto erstes = zapfsaeule.getAuto();
                if (erstes.getStatus().equals("an Zapfsaeule Warten")) {
                    zapfsaeule.aktualisiereWartezeit(tick - erstes.getStatusZeit());
                    erstes.setStatusZeit(tick);
                    erstes.setStatus("Tanken");
                }
            }
        }
    }

    /**
     * Simuliert das Ende des Tankens.
     */
    private void endTanken() {
        for (Schlange zapfsaeule : zapfsaeulen) {
            if (zapfsaeule.laenge() > 0) {
                Auto erstes = zapfsaeule.getAuto();
                if ((erstes.getStatus().equals("Tanken")) && (tick - erstes.getStatusZeit()) >= erstes.getTankZeit()) {
                    erstes.setStatusZeit(tick);
                    erstes.setStatus("an Kasse Warten");
                    kasse.addAuto(erstes);
                }
            }
        }
    }

    /**
     * Simuliert den Start der Bezahlung an der Kasse.
     */
    private void startZahlen() {
        if (kasse.laenge() > 0) {
            Auto erstes = kasse.getAuto();
            if (erstes.getStatus().equals("an Kasse Warten")) {
                kasse.aktualisiereWartezeit(tick - erstes.getStatusZeit());
                erstes.setStatusZeit(tick);
                erstes.setStatus("Zahlen");

            }
        }
    }

    /**
     * Simuliert das Ende der Bezahlung an der Kasse.
     */
    private void endZahlen() {
        if (kasse.laenge() > 0) {
            Auto erstes = kasse.getAuto();
            if (erstes.getStatus().equals("Zahlen") && (tick - erstes.getStatusZeit()) >= erstes.getZahlZeit()) {
                erstes.setStatusZeit(tick);
                erstes.setStatus("Tankstelle Raeumen");
                kasse.removeAuto();
            }
        }

    }

    /**
     * Simuliert Aufraeumen der Autos von der Tankstelle.
     */
    private void end() {
        for (Schlange zapfsaeule : zapfsaeulen) {
            if (zapfsaeule.laenge() > 0) {
                Auto erstes = zapfsaeule.getAuto();
                if (erstes.getStatus().equals("Tankstelle Raeumen") && (tick - erstes.getStatusZeit()) >= erstes.getRaeumZeit()) {
                    erstes.setStatus("fertig");
                    zapfsaeule.removeAuto();
                }
            }
        }

    }



    /**
     * Druckt den Header fuer die Protokoll-Tabelle.
     */
    public void header() {

        System.out.format("+------+---------------+---------------+---------------+---------------+\n");
        System.out.format("| Zeit | Warteschlange | Warteschlange | Warteschlange | Warteschlange |\n");
        System.out.format("|      | Zapfsaeule 1  | Zapfsaeule 2  | Zapfsaeule 3  | Kasse         |\n");
        System.out.format("+------+---------------+---------------+---------------+---------------+\n");

    }

    /**
     * Hinzufuegt die Zeilen fuer das Protokoll.
     */
    private void protokollErweitern() {

        int[] warteschlangeLaenge = new int[4];
        int i = 0;
        for (Schlange schlange : zapfsaeulen) {
            warteschlangeLaenge[i] = schlange.schlangeLaengeBerechnen();
            i++;
        }
        warteschlangeLaenge[3] = kasse.schlangeLaengeBerechnen();

        String leftAlignFormat = "| %-4d | %-13d | %-13d | %-13d | %-13d |\n";
        System.out.format(leftAlignFormat, takt, warteschlangeLaenge[0], warteschlangeLaenge[1], warteschlangeLaenge[2], warteschlangeLaenge[3]);

    }

    /**
     * Druckt die durchschnittlichen und maximalen Werte fuer die Wartezeit an den Zapfsaeulen und an der Kasse.
     */
    public void output() {

        double durchschnittlicheWartezeitZapfsaeule1 = (double) (zapfsaeulen.get(0).getGesamtWartezeit()) / (double) (zapfsaeulen.get(0).getAutoZaehler());
        double durchschnittlicheWartezeitZapfsaeule2 = (double) (zapfsaeulen.get(1).getGesamtWartezeit()) / (double) (zapfsaeulen.get(1).getAutoZaehler());
        double durchschnittlicheWartezeitZapfsaeule3 = (double) (zapfsaeulen.get(2).getGesamtWartezeit()) / (double) (zapfsaeulen.get(2).getAutoZaehler());
        double durchschnittlicheWartezeitAnDerKasse = (double) (kasse.getGesamtWartezeit()) / (double) (kasse.getAutoZaehler());

        System.out.println();
        System.out.println("Durchschnittliche Wartezeit an Zapfsaeule 1 betraegt: " + String.format("%.1f", durchschnittlicheWartezeitZapfsaeule1 / 60) + " Minuten\n");
        System.out.println("Durchschnittliche Wartezeit an Zapfsaeule 2 betraegt: " + String.format("%.1f", durchschnittlicheWartezeitZapfsaeule2 / 60) + " Minuten\n");
        System.out.println("Durchschnittliche Wartezeit an Zapfsaeule 3 betraegt: " + String.format("%.1f", durchschnittlicheWartezeitZapfsaeule3 / 60) + " Minuten\n");
        System.out.println("Durchschnittliche Wartezeit an der Kasse betraegt: " + String.format("%.1f", durchschnittlicheWartezeitAnDerKasse / 60) + " Minuten\n");
        System.out.println();
        System.out.println("Maximale Wartezeit Zapfsaeule 1 betraegt: " + zapfsaeulen.get(0).getMaximaleWartezeit() / 60 + "min " + zapfsaeulen.get(0).getMaximaleWartezeit() % 60 + "s" + "\n");
        System.out.println("Maximale Wartezeit Zapfsaeule 2 betraegt: " + zapfsaeulen.get(1).getMaximaleWartezeit() / 60 + "min " + zapfsaeulen.get(1).getMaximaleWartezeit() % 60 + "s" + "\n");
        System.out.println("Maximale Wartezeit Zapfsaeule 3 betraegt: " + zapfsaeulen.get(2).getMaximaleWartezeit() / 60 + "min " + zapfsaeulen.get(2).getMaximaleWartezeit() % 60 + "s" + "\n");

        System.out.println("Maximale Wartezeit an der Kasse betraegt: " + kasse.getMaximaleWartezeit() / 60 + "min " + kasse.getMaximaleWartezeit() % 60 + "s" + "\n");

    }

    /**
     * Druckt den Footer fuer die Protokoll-Tabelle.
     */
    public void footer() {
        System.out.format("+------+---------------+---------------+---------------+---------------+\n");
    }


}