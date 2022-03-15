package examen.model;

import java.util.ArrayList;
import java.util.List;

public class Client {

    private Integer idClient;
    private String identification;
    private String name;
    private String lastName;
    private String phone;
    private String genero;

    private List<Vehicle> vehicle = new ArrayList<>();

    public Client() {
    }

    public Integer getIdClient() {
        return idClient;
    }

    public void setIdClient(Integer idClient) {
        this.idClient = idClient;
    }

    public String getIdentification() {
        return identification;
    }

    public void setIdentification(String identification) {
        this.identification = identification;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
    
    public List<Vehicle> getVehicle() {
        return vehicle;
    }

    public void setVehicle(List<Vehicle> vehicle) {
        this.vehicle = vehicle;
    }

    public void addVehicle(Vehicle vehicleOpt){
        this.vehicle.add(vehicleOpt);
    }
    
    @Override
    public String toString() {
        return "Client{" + "identification=" + identification + ", name=" + name + ", lastName=" + lastName + ", phone=" + phone + ", genero=" + genero + ", vehicles=" + vehicle + '}';
    }
    
}
