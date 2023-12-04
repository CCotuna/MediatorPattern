import java.util.Random;

public class Scooter implements Vehicle{
    private double chargeLevel;
    private boolean isAvailable;

    public Scooter(int distance) {
        this.chargeLevel = Math.round(new Random().nextDouble() * 0.9 * distance * 100.0 ) / 100.0;

    }
    @Override
    public int getDistance() {
        return 0;
    }

    @Override
    public boolean isAvailable() {
        return true;
    }

    @Override
    public void setAvailable(boolean available) {
        this.isAvailable = available;
    }

    public double getChargeLevel() {
        return chargeLevel;
    }

    @Override
    public void chooseOption() {
        System.out.println("Scooter chosen.");
    }
}
