package lab6.task0;

interface Engine2 {
    public int getFuelCapacity2();
}

class Car2 {
    public Engine2 getEngine2(int fuelCapacity) {
        return new Engine2 () {
            private int fuelCapacity = 11;

            public int getFuelCapacity2() {
                return fuelCapacity;
            }
        };
    }
}

public class Test2 {
    public static void main(String[] args) {
        Car2 car2 = new Car2();

        System.out.println(car2.getEngine2(10).getFuelCapacity2());
    }
}