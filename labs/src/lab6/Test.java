package lab6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        Car audiCar = new Car(7800, Car.CarType.Audi, 2019);
        Car bmwCar = new Car(22800, Car.CarType.BMW, 2014);
        Car porscheCar = new Car(48000, Car.CarType.Porsche, 2010);
        Dealership dealership = new Dealership();

        System.out.println("Initial price: " + audiCar.getPrice() + " euros");
        dealership.getFinalPrice(audiCar);
        System.out.println("Final price: " + audiCar.getPrice() + " euros");

        dealership.negotiate(audiCar, new Offer() {
            @Override
            public int getDiscount(Car car) {
                return 500;
            }
        });

        System.out.println("\n");


        /* Observ ca s-au generat clasele BrandOffer, DealerOffer, SpecialOffer,
         *  iar pentru clasa anonima nu s-a generat nimic. */


        List<Car> carList = new ArrayList<>(3);
        carList.add(audiCar);
        carList.add(bmwCar);
        carList.add(porscheCar);

        System.out.println("Initial: ");
        carList.forEach(System.out::println);

        System.out.println("\nAfter lambda: ");
        carList.removeIf((car) -> car.getPrice() >= 15000);
        carList.forEach(System.out::println);
    }
}




