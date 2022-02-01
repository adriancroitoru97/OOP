package lab6;

import java.util.Random;

public class Dealership {
    private class BrandOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            return switch (car.getType()) {
                case Audi -> (int) (0.05 * car.getPrice());
                case BMW -> (int) (0.10 * car.getPrice());
                case Porsche -> (int) (0.15 * car.getPrice());
            };
        }
    }

    private class DealerOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            return (2021 - car.getYear()) * 100;
        }
    }

    private class SpecialOffer implements Offer {
        @Override
        public int getDiscount(Car car) {
            return (new Random().nextInt(300) + 1);
        }
    }

    void getFinalPrice(Car car) {
        BrandOffer offer1 = new BrandOffer();
        DealerOffer offer2 = new DealerOffer();
        SpecialOffer offer3 = new SpecialOffer();

        int discount1 = offer1.getDiscount(car);
        System.out.println("Applying Brand discount: " + discount1 + " euros");
        int discount2 = offer2.getDiscount(car);
        System.out.println("Applying Dealer discount: " + discount2 + " euros");
        int discount3 = offer3.getDiscount(car);
        System.out.println("Applying Special discount: " + discount3 + " euros");

        car.setPrice(car.getPrice() - discount1 - discount2 - discount3);
    }

    void negotiate(Car car, Offer offer) {
        int applyOrNot = new Random().nextInt(2);

        if (applyOrNot == 1) {
            System.out.println("Applying Client discount: " + offer.getDiscount(car) + " euros" );
            car.setPrice(car.getPrice() - offer.getDiscount(car));
            System.out.println("Final price after negotiation: " + car.getPrice() + " euros");
        }
    }
}
