import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Simulation {
    public Simulation() { }

    ArrayList<Item> loadItems(String fileName) throws FileNotFoundException {

        File file = new File(fileName);
        Scanner scan = new Scanner(file);
        ArrayList<Item> items = new ArrayList<>();

        while (scan.hasNextLine()) {
            String line = scan.nextLine();
            String[] oneItem = line.split("=");
            items.add(new Item(oneItem[0], Integer.valueOf(oneItem[1])));
        }
        System.out.println(fileName + " contains " + items.size() + " items");
        return items;
    }

    ArrayList<Rocket> loadU1(ArrayList<Item> list) {
            ArrayList<Rocket> nrrockets = new ArrayList<>();
            Rocket rok = new U1();

            int rocketCounter = 1;
            int itemCounter = 1;


            System.out.println("\nU1 Rocket weight = " + rok.currentWeight + "; maxWeight = " + rok.maxWeight);

            for (Item i : list) {

                while (!rok.canCarry(i)) {
                    rocketCounter++;
                    nrrockets.add(rok);
                    rok = new U1();
                }
                rok.carry(i);
            }
            itemCounter++;
            nrrockets.add(rok);
            System.out.println("U1 consists of " + nrrockets.size() + " rockets");
            return nrrockets;
    }

    ArrayList<Rocket> loadU2(ArrayList<Item> list) {

        ArrayList<Rocket> fleet = new ArrayList<>();
        Rocket rok = new U2();

        int itemCounter = 1;
        int rocketCounter = 1;

        System.out.println("U2 Rocket weight = " + rok.currentWeight + "; maxWeight = " + rok.maxWeight);

        for (Item i : list) {

            while (!rok.canCarry(i)) {
                rocketCounter++;
                fleet.add(rok);
                rok=  new U2();
            }
            rok.carry(i);
            itemCounter++;
        }
        fleet.add(rok);
        System.out.println("U2 consists of " + fleet.size() + " rockets\n");
        return fleet;
    }

    int runSimulation(ArrayList<Rocket> list) {

        int num = 0; //failed trials of launch/land
        int indexSuccess = 1;

        for (Rocket r : list) {

            while (!r.launch()) {
                r.launch();
                num++;
            }

            while (!r.land()) {
                r.land();
                num++;
            }

            indexSuccess++;
        }
        int budget = list.get(0).rocketCost * (list.size() + num);
        System.out.println(list.size() + " rockets and " + num + " extra trials = " + (list.size() + num) + " in total");
        return budget;
    }

    }

