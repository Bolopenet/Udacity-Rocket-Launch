public class U2 extends Rocket {
    public U2(){
        rocketCost =120;

        rocketWeight=10000;
        currentWeight=rocketWeight;
        maxWeight=18000;

        launchExplosion=0.0;
        landingCrash=0.0;
    }
    public boolean launch() {

        int random = (int)(Math.random() * 100 + 1);
        this.launchExplosion = 4.0 * (this.currentWeight - this.rocketWeight) / (this.maxWeight - this.rocketWeight);
        return this.launchExplosion <= random;
    }

    public boolean land() {

        int random = (int)(Math.random() * 100 + 1);
        this.landingCrash = 8.0 * (this.currentWeight - this.rocketWeight) / (this.maxWeight - this.rocketWeight);
        return this.landingCrash <= random;

    }
}
