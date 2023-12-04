import java.util.ArrayList;
import java.util.List;

public class ServerImp implements Server {
    private List<String> carOptions = new ArrayList<>();
    private List<String> scooterOptions = new ArrayList<>();
    private List<Vehicle> vehicles = new ArrayList<>();

    @Override
    public void sendOptions(List<String> options) {
        System.out.println("Server received options: " + options);
    }

    @Override
    public void sendRequest(Vehicle option) {
        System.out.println("Server received request: " + option.getDistance());
    }

    @Override
    public void sendResponse(String response) {
        System.out.println("Server received response: " + response);
    }

    @Override
    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
    }
    @Override
    public List<Vehicle> getAvailableVehicles(int clientLocation, String clientChoice){
        ArrayList<Vehicle> availableVehicles = new ArrayList<>();

        for(Vehicle vehicle : vehicles) {
            if (clientChoice.equals("car")) {
                if (vehicle instanceof Car) {
                    if(vehicle.isAvailable()) {
                        availableVehicles.add(vehicle);
                    }
                }
            } else if (clientChoice.equals("scooter")) {
                if (vehicle instanceof Scooter) {
                    if(vehicle.isAvailable()) {
                        availableVehicles.add(vehicle);
                    }
                }
            }
        }

        return availableVehicles;
    }
}
