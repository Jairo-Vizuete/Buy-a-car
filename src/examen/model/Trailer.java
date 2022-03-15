package examen.model;

import java.time.LocalDate;
import java.util.Date;

public class Trailer extends Vehicle {

    public Trailer() {
    }

    public Trailer(Integer idVehicle, String color, String licensePlate, String brand, String model, LocalDate carSaleDate) {
        super(idVehicle, color, licensePlate, brand, model, carSaleDate);
    }

}
