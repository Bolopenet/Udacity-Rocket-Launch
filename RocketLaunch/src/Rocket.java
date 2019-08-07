 public class Rocket implements  SpaceShip {

     int rocketCost;
     int rocketWeight;
     int currentWeight;
     int maxWeight;
     double launchExplosion;
     double landingCrash;

        public boolean launch(){ return  true; }
        public boolean land(){ return true; }

        public final boolean canCarry(Item item){ return this.currentWeight+item.weight<=maxWeight;}

        public final int carry(Item item){
            this.currentWeight +=item.weight;
            return this.currentWeight;
        }


}
