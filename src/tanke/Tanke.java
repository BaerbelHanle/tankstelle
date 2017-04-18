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
        parameter.setZeitTankenMin(scanOneInt(scan));

        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer hoechstens zum Tanken braucht");
        parameter.setZeitTankenMax(scanSecondInt(parameter.getZeitTankenMin(), scan));

        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer mindestens zum Zahlen braucht");
        parameter.setZeitZahlenMin(scanOneInt(scan));
        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer hoechstens zum Zahlen braucht");
        parameter.setZeitZahlenMax(scanSecondInt(parameter.getZeitZahlenMin(), scan));

        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer mindestens zum Raeumen  der Tankstelle braucht");
        parameter.setZeitRaeumenMin(scanOneInt(scan));
        System.out.println("Geben Sie die Zeit in Sekunden an, die ein Fahrer hoechstens zum Raeumen der Tankstelle braucht");
        parameter.setZeitRaeumenMax(scanSecondInt(parameter.getZeitRaeumenMin(), scan));

        System.out.println("Geben Sie den durchschnittlichen Zeitabstand in Sekunden an, in dem ein neues Auto ankommen soll");
        parameter.setAbstandAutos(scanOneInt(scan));

        System.out.println("Geben Sie die Zeit in Sekunden an, ueber die Sie den Ablauf simulieren lassen wollen");
        parameter.setSimulationszeit(scanOneInt(scan));

        System.out.println("Geben Sie den Zeitabstand in Sekunden an, in dem Sie wuenschen, dass das Protokoll aktualisiert wird");
        parameter.setProtokolltakt(scanOneInt(scan));

        Simulation simulation = new Simulation(parameter);
        simulation.header();
        simulation.ticken();
        simulation.footer();
        simulation.output();
        double r = Math.random();

        System.out.println("---------------------------------");

    }

    /**
     * Eingabe fuer einen Int
     * @param scan Scanner fuer die Benutzerantwort
     * @return integer number
     */
    private static int scanOneInt(Scanner scan){

        boolean nochmal = true;
        int number = 0;

        while (nochmal){
            if (scan.hasNextInt()){
                number=scan.nextInt();
                if (number >0) nochmal=false;
                else {
                    System.out.println("Geben Sie bitte eine natuerliche Zahl ein!");
                }
            } else {
                System.out.println("Geben Sie bitte eine natuerliche Zahl ein!");
                scan.next();
                continue;
            }
        }
        return number;
    }

    /**
     * Eingabe fuer den zweiten Int
     * @param firstInt erstes Integer
     * @param scan Scanner
     * @return integer
     */
    private static int scanSecondInt(int firstInt, Scanner scan){
        boolean nochmal = true;
        int number = 0;

        while (nochmal){
            if (scan.hasNextInt()){
                number=scan.nextInt();
                if (number >=firstInt) nochmal=false;
                else {
                    System.out.println("Geben Sie bitte eine natuerliche Zahl ein, die groesser ist, als die letzte Zahl, die sie eingegeben haben!");
                }
            } else {
                System.out.println("Geben Sie bitte eine natuerliche Zahl ein, die groesser ist, als die letzte Zahl, die sie eingegeben haben!");
                scan.next();
                continue;
            }
        }
        return number;
    }

}