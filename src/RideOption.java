abstract class RideOption {

    private Server rideMediator;
    private boolean isAvailable;

    public RideOption(Server rideMediator) {
        this.rideMediator = rideMediator;
        this.isAvailable = true;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    public abstract void chooseOption();
}
