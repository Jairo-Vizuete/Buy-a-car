package examen;

import examen.model.Bus;
import examen.model.Client;
import examen.model.Trailer;
import examen.model.Vehicle;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Scanner;

public class Examen {

    public static void main(String[] args) throws InterruptedException {

        Client client1 = new Client();
        client1.setIdClient(1);
        client1.setIdentification("1727281915");
        client1.setName("Jairo");
        client1.setLastName("Vizuete");
        client1.setPhone("0986244557");
        client1.setGenero("M");

        Client client2 = new Client();
        client2.setIdClient(2);
        client2.setIdentification("1727281907");
        client2.setName("Cristian");
        client2.setLastName("Pedraza");
        client2.setPhone("0986325478");
        client2.setGenero("M");

        List<Vehicle> vehicles = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        clients.add(client1);
        clients.add(client2);

        Scanner sc = new Scanner(System.in);
        Byte opt;
        do {
            System.out.println("MENU");
            System.out.println("1. Registrar vehículo");
            System.out.println("2. Registrar venta de vehículo");
            System.out.println("3. Mostrar clientes que han adquirido más de un vehículo al año");
            System.out.println("4. Mostrar clientes que han comprado una marca en especial");
            System.out.println("5. Exit");
            opt = sc.nextByte();

            switch (opt) {
                case 1:
                    vehicles = registerVehicle(vehicles);
                    System.out.println(vehicles);
                    break;
                case 2:
                    saleVehicle(vehicles, clients);
                    break;
                case 3:
                    clientsWithMoreThanOneCar(clients);
                    break;
                case 4:
                    clientsWhoPurchaseAVehicleWithSpecialBrand(clients);
                    break;
                case 5:
                    System.out.println("Thank you for using my app.!!");
                    System.exit(0);
                    break;
                default:
                    System.out.println("This option doesn't exist.!!");
            }

        } while (opt != 5);
    }

    public static List<Vehicle> registerVehicle(List<Vehicle> vehicle) {
        Scanner sc = new Scanner(System.in);
        byte vehicleOpt = 0;
        System.out.println("Qué tipo de vehículo es:\n1. Buseta\n2. Trailer");
        vehicleOpt = sc.nextByte();
        if (vehicleOpt == 1) {
            Bus bus = new Bus();
            System.out.print("Ingresar el Id del buseta: ");
            bus.setIdVehicle(sc.nextInt());
            System.out.print("Ingresar el color de la buseta: ");
            bus.setColor(sc.next());
            System.out.print("Ingresar la placa de la buseta: ");
            bus.setLicensePlate(sc.next());
            System.out.print("Ingresar la marca de la buseta: ");
            bus.setBrand(sc.next());
            System.out.print("Ingresar el modelo de la buseta: ");
            bus.setModel(sc.next());
            vehicle.add(bus);
        } else if (vehicleOpt == 2) {
            Trailer trailer = new Trailer();
            System.out.print("Ingresar el Id del trailer: ");
            trailer.setIdVehicle(sc.nextInt());
            System.out.print("Ingresar el color de la trailer: ");
            trailer.setColor(sc.next());
            System.out.print("Ingresar la placa de la trailer: ");
            trailer.setLicensePlate(sc.next());
            System.out.print("Ingresar la marca de la trailer: ");
            trailer.setBrand(sc.next());
            System.out.print("Ingresar el modelo de la trailer: ");
            trailer.setModel(sc.next());
            vehicle.add(trailer);
        }
        return vehicle;
    }

    public static void saleVehicle(List<Vehicle> vehicle, List<Client> clients) {
        Scanner sc = new Scanner(System.in);
        Integer clientOpt;
        Integer vehicleChoose;

        System.out.println("Seleccione el cliente que va a comprar un vehículo");
        for (Client clientObj : clients) {
            System.out.println(clientObj.getIdClient() + " -> " + clientObj.toString());
        }
        clientOpt = sc.nextInt();
        System.out.println("El cliente seleccionado es: " + getClientById(clients, clientOpt));

        System.out.println("Seleccione el vehículo que va a vender:");
        for (Vehicle vehicleOpt : vehicle) {
            System.out.println(vehicleOpt.getIdVehicle() + ".- color " + vehicleOpt.getColor() + " marca " + vehicleOpt.getBrand() + "\n");
        }
        vehicleChoose = sc.nextInt();
        System.out.println("El vehículo seleccionado es: " + getVehicleById(vehicle, vehicleChoose));

        for (int i = 0; i < clients.size(); i++) {
            if (clientOpt.equals(clients.get(i).getIdClient())) {
                clients.get(i).addVehicle(getVehicleById(vehicle, vehicleChoose));
            }
        }
        System.out.println(getClientById(clients, clientOpt));
    }

    public static Client getClientById(List<Client> clients, Integer id) {
        Client clientOpt = new Client();
        for (Client clientObj : clients) {
            if (Objects.equals(clientObj.getIdClient(), id)) {
                clientOpt.setIdClient(clientObj.getIdClient());
                clientOpt.setIdentification(clientObj.getIdentification());
                clientOpt.setName(clientObj.getName());
                clientOpt.setLastName(clientObj.getLastName());
                clientOpt.setPhone(clientObj.getPhone());
                clientOpt.setGenero(clientObj.getGenero());
                clientOpt.setVehicle(clientObj.getVehicle());
            }
        }
        return clientOpt;
    }

    public static Vehicle getVehicleById(List<Vehicle> vehicles, Integer id) {
        List<Vehicle> vehicle = new ArrayList<>();
        Vehicle vehicleOpt = new Vehicle();
        for (Vehicle vehicleObj : vehicles) {
            if (Objects.equals(vehicleObj.getIdVehicle(), id)) {
                vehicleOpt.setIdVehicle(vehicleObj.getIdVehicle());
                vehicleOpt.setLicensePlate(vehicleObj.getLicensePlate());
                vehicleOpt.setBrand(vehicleObj.getBrand());
                vehicleOpt.setModel(vehicleObj.getModel());
                vehicleOpt.setColor(vehicleObj.getColor());
                vehicleOpt.setCarSaleDate(LocalDate.now());
            }
        }
        vehicle.add(vehicleOpt);
        return vehicleOpt;
    }

    public static void clientsWithMoreThanOneCar(List<Client> clients) {
        for (Client clientObj : clients) {
            System.out.println("CLIENTE: " + clientObj.getName());
            boolean flag = false;
            String saleDate = "";
            if (clientObj.getVehicle().size() > 1) {
                List<String> datesToCompare = new ArrayList<>();
                for (Vehicle vehicleObj : clientObj.getVehicle()) {
                    String date = vehicleObj.getCarSaleDate().toString();
                    String[] year = date.split("-");
                    datesToCompare.add(year[0]);
                }
                for (int i = 0; i < datesToCompare.size(); i++) {
                    String aux = datesToCompare.get(i);
                    for (int j = 0; j < datesToCompare.size(); j++) {
                        if (aux.equals(datesToCompare.get(j))) {
                            flag = true;
                            saleDate = datesToCompare.get(j);
                        }
                    }
                }
                if (flag) {
                    System.out.println(clientObj.getName() + " " + clientObj.getLastName()
                            + " tiene más de un vehículo comprado el año: " + saleDate
                    );
                }
            } else {
                System.out.println(clientObj.getName() + " " + clientObj.getLastName() + " no tiene más de 2 vehículos comprados en un mismo año.");
            }
        }
    }

    public static void clientsWhoPurchaseAVehicleWithSpecialBrand(List<Client> clients) {
        Scanner sc = new Scanner(System.in);
        String brandRequired = sc.next();

        for (Client clientObj : clients) {
            boolean flag = false;
            for (Vehicle vehicle : clientObj.getVehicle()) {
                if (brandRequired.equals(vehicle.getBrand())) {
                    flag = true;
                }
            }
            if (flag) {
                System.out.println(clientObj.getName() + " " + clientObj.getLastName() + " ha comprado un vehículo de la marca: " + brandRequired
                );
            }
        }
    }
}
