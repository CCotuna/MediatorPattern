public class Car implements Vehicle {
    private int distance;
    private boolean isAvailable;

    public Car() {
        this.distance = (int) (Math.random() * 100) + 1;
        this.isAvailable = true;
    }
    @Override
    public int getDistance() {
        return distance;
    }

    @Override
    public boolean isAvailable() {
        return isAvailable;
    }

    @Override
    public double getChargeLevel() {
        return 0;
    }

    @Override
    public void setAvailable(boolean available) {
        isAvailable = available;
    }
    @Override
    public void chooseOption() {
        System.out.println("Car chosen.");
    }
}
