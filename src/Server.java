import java.util.ArrayList;
import java.util.List;

interface Server {
    void sendOptions(List<String> options);
    void sendRequest(Vehicle vehicle);
    void sendResponse(String response);
    void addVehicle(Vehicle vehicle);
    List<Vehicle> getAvailableVehicles(int clientLocation, String clientChoice);

}
