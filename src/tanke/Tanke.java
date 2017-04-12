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

        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer mindestens zum Tanken braucht");
        parameter.setZeitRaeumenMin(scan.nextInt());

        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer hoechstens zum Tanken braucht");
        parameter.setZeitRaeumenMax(scan.nextInt());

        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer mindestens zum Zahlen braucht");
        parameter.setZeitZahlenMin(scan.nextInt());

        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer hoechstens zum Zahlen braucht");
        parameter.setZeitZahlenMax(scan.nextInt());

        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer mindestens zum Raeumen der Tankstelle braucht");
        parameter.setZeitRaeumenMin(scan.nextInt());

        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer hoechstens zum Raeumen der Tankstelle braucht");
        parameter.setZeitRaeumenMin(scan.nextInt());

        System.out.println("Geben Sie den durchschnittlichen Zeitabstand in Seunden an, in dem ein neues Ato ankommen soll");
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