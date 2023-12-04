import java.util.ArrayList;
import java.util.List;

public class Client {
    private Server rideMediator;
    private int clientLocation;

    public Client(Server rideMediator, int clientLocation) {
        this.rideMediator = rideMediator;
        this.clientLocation = clientLocation;
    }

    public int getClientLocation() {
        return clientLocation;
    }
    public void setClientLocation(int clientLocation) {
        this.clientLocation = clientLocation;
    }

    public void chooseOption(int clientLocation, String choice) {
        List<Vehicle> availableVehicles = rideMediator.getAvailableVehicles(clientLocation, choice);

        if(!availableVehicles.isEmpty()){
            switch (choice.toLowerCase()) {
                case "car":
                        System.out.println("Available cars : ");
                        for (Vehicle vehicle : availableVehicles) {
                            System.out.println("Car: " + vehicle.getDistance());
                        }
                        Vehicle closestCar = getClosestCar(clientLocation, availableVehicles);
                        rideMediator.sendRequest(closestCar);
                        closestCar.chooseOption();
                        closestCar.setAvailable(false);

                        rideMediator.sendResponse("Car located at: " + closestCar.getDistance() + " accepted");

                    break;
                case "scooter":
                        System.out.println("Available scooters : ");
                        for (Vehicle vehicle : availableVehicles) {
                            System.out.println("Scooter: " + vehicle.getChargeLevel());
                        }
                        Vehicle furthestScooter = getFurthestScooter(availableVehicles);
                        rideMediator.sendRequest(furthestScooter);
                        furthestScooter.chooseOption();
                        furthestScooter.setAvailable(false);

                        rideMediator.sendResponse("Scooter located at: " + furthestScooter.getChargeLevel() + " accepted");
                    break;
                default:
                    System.out.println("Invalid choice");
            }
        }
        else {
            System.out.println("No vehicles available");
        }
    }

    public Vehicle getClosestCar(int clientLocation, List<Vehicle> cars){
        Vehicle closestCar = null;
        int minDistance = Integer.MAX_VALUE;

        for(Vehicle vehicle : cars){
            if(vehicle instanceof Car){
                int distance = Math.abs(clientLocation - vehicle.getDistance()) % 100;

                if(distance < minDistance){
                    minDistance = distance;
                    closestCar = vehicle;
                }
            }
        }

        return closestCar;
    }

    private Vehicle getFurthestScooter(List<Vehicle> scooters) {
        Vehicle furthestScooter = null;
        double maxChargeLevel = 0;

        for (Vehicle vehicle : scooters) {
            if (vehicle instanceof Scooter) {
                if(((Scooter) vehicle).getChargeLevel() > maxChargeLevel) {
                    maxChargeLevel = ((Scooter) vehicle).getChargeLevel();
                    furthestScooter = vehicle;
                }
            }
        }
        return furthestScooter;
    }
}
