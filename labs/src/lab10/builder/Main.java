package lab10.builder;

public class Main {

    public static void main(String[] args) {
        House simpleHouse = new House.HouseBuilder("Bucharest", 2, "Wood heating", 6)
                .build();
        House complexHouse = new House.HouseBuilder("Focsani", 5, "Solar", 42)
                .energySupplier("ENEL")
                .acBrand("Samsung")
                .poolType("Infinity Pool")
                .securitySystem("Private guards")
                .build();

        System.out.println("-----------------------Simple House-------------------------");
        System.out.println(simpleHouse);

        System.out.println("-----------------------Complex House-------------------------");
        System.out.println(complexHouse);
    }
}
