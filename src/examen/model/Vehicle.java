package examen.model;

import java.time.LocalDate;
import java.util.Date;

public class Vehicle {

    private Integer idVehicle;
    private String color;
    private String licensePlate;
    private String brand;
    private String model;
    private LocalDate carSaleDate;

    public Vehicle() {
    }

    public Vehicle(Integer idVehicle, String color, String licensePlate, String brand, String model, LocalDate carSaleDate) {
        this.idVehicle = idVehicle;
        this.color = color;
        this.licensePlate = licensePlate;
        this.brand = brand;
        this.model = model;
        this.carSaleDate = carSaleDate;
    }

    public Integer getIdVehicle() {
        return idVehicle;
    }

    public void setIdVehicle(Integer idVehicle) {
        this.idVehicle = idVehicle;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public LocalDate getCarSaleDate() {
        return carSaleDate;
    }

    public void setCarSaleDate(LocalDate carSaleDate) {
        this.carSaleDate = carSaleDate;
    }

//    @Override
//    public String toString() {
//        return "Vehicle{" + "idVehicle=" + idVehicle + ", color=" + color + ", licensePlate=" + licensePlate + ", brand=" + brand + ", model=" + model + '}';
//    }

    @Override
    public String toString() {
        return "Vehicle{" + "idVehicle=" + idVehicle + ", color=" + color + ", licensePlate=" + licensePlate + ", brand=" + brand + ", model=" + model + ", carSaleDate=" + carSaleDate + '}';
    }
}
