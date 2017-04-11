package tanke;

public class Tanke {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
  
        Simulation simulation = new Simulation();
        simulation.header();
        simulation.ticken(3600);
        simulation.footer();
        simulation.output();
        //one more staff
        double r = Math.random();

        System.out.println("---------------------------------");

    }
    
}