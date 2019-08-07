import java.io.FileNotFoundException;
import java.util.ArrayList;

public class Main {

        public static void main(String[] args) throws FileNotFoundException {

            Simulation sim = new Simulation(); // simulation object

            // Load Items for Phase-1 and Phase-2
            ArrayList<Item> phase1 = sim.loadItems("phase-1.txt");
            ArrayList<Item> phase2 = sim.loadItems("phase-2.txt");


            // Load a fleet of U1 rockets for Phase-1 and then Phase-2
            ArrayList<Rocket> U1numP1  = sim.loadU1(phase1);
            ArrayList<Rocket> U1numP2 = sim.loadU1(phase2);


            // U1 rockets and display the total budget required
            System.out.println("\nU1 rocket cost = 100 millions ");

            int budgetU1phase1 = sim.runSimulation(U1numP1);
            System.out.println("Budget of U1 number of rockets for phase 1 = " + budgetU1phase1 + " (millions)");

            int budgetU1phase2 = sim.runSimulation(U1numP2);
            System.out.println("Budget of U1 number of rockets for phase 2 = " + budgetU1phase2 + " (millions)");
            System.out.println("Total budget of U1 number of rockets = " + (budgetU1phase1 + budgetU1phase2) + " (millions)\n");


            // Repeat the same for U2 rockets and display the total budget
            ArrayList<Rocket> u2FleetPhase1 = sim.loadU2(phase1);
            ArrayList<Rocket> u2FleetPhase2 = sim.loadU2(phase2);

            System.out.println("\nU2 rocket cost = 120 millions ");

            int budgetU2phase1 = sim.runSimulation(u2FleetPhase1);
            System.out.println("Budget of U2 number of rockets for phase 1 = " + budgetU2phase1 + " (millions)");

            int budgetU2phase2 = sim.runSimulation(u2FleetPhase2);
            System.out.println("Budget of U2 number of rockets for phase 2 = " + budgetU2phase2 + " (millions)");
            System.out.println("Total budget of U2 number of rockets = " + (budgetU2phase1 + budgetU2phase2) + " (millions)\n");

        }
    }
