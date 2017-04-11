package tanke;

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

        Simulation simulation = new Simulation();
        simulation.header();
        simulation.ticken(3600);
        simulation.footer();
        simulation.output();
        double r = Math.random();

        System.out.println("---------------------------------");

    }

}