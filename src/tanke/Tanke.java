package tanke;

import java.util.Scanner;

/**
 * Die Klasse, die zum Vorfuehren dient.
 */
public class Tanke {

    /**
     * Main-Methode fuer die Simulation einer Tankestelle.
     *
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        Parameter parameter = new Parameter();

        System.out.println("Geben Sie durch Leerzeichen die Zeiten in Sekunden an, die ein Fahrer mindestens/hoechstens zum Tanken braucht");
        parameter.setZeitTankenMin(scan.nextInt());
        parameter.setZeitTankenMax(scan.nextInt());

        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer mindestens/hoechstens zum Zahlen braucht");
        parameter.setZeitZahlenMin(scan.nextInt());
        parameter.setZeitZahlenMax(scan.nextInt());

        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer mindestens/hoechstens zum Raeumen der Tankstelle braucht");
        parameter.setZeitRaeumenMin(scan.nextInt());
        parameter.setZeitRaeumenMax(scan.nextInt());

        System.out.println("Geben Sie den durchschnittlichen Zeitabstand in Sekunden an, in dem ein neues Auto ankommen soll");
        parameter.setAbstandAutos(scan.nextInt());

        System.out.println("Geben Sie die Zeit in Sekunden an, ueber die Sie den Ablauf simulieren lassen wollen");
        parameter.setSimulationszeit(scan.nextInt());

        System.out.println("Geben Sie den Zeitabstand in Sekunden an, in dem Sie wuenschen, dass das Protokoll aktualisiert wird");
        parameter.setProtokolltakt(scan.nextInt());

        Simulation simulation = new Simulation(parameter);
        simulation.header();
        simulation.ticken();
        simulation.footer();
        simulation.output();
        double r = Math.random();

        System.out.println("---------------------------------");

    }

}