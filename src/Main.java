import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        Server mediator = new ServerImp();

        Client client = new Client(mediator, 50);


        mediator.addVehicle(new Car());
        mediator.addVehicle(new Car());
        mediator.addVehicle(new Scooter(client.getClientLocation()));
        mediator.addVehicle(new Scooter(client.getClientLocation()));

        System.out.println("Client chooses a car:");
        client.chooseOption(client.getClientLocation(), "scooter");
    }
}