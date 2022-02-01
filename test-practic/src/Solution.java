import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Solution {

    private final List<Animal> animals;

    private Solution() {
        animals = new LinkedList<>();
    }

    /**
     * Returns a list of all animals of a specified type.
     * @param type dog/cat/etc...
     * @return the animals
     */
    private List<Animal> getListOfAllAnimalsOfType (Class<?> type) {
        return animals
                .stream()
                .filter(type::isInstance)
                .collect(Collectors.toList());
    }

    /**
     * Adds an animal in the list.
     * @param type the type of animal
     * @param name the name
     */
    private void addAnimal(String type, String name) {
        if (type.equals("c")) {
            animals.add(new Dog(name));
        } else if (type.equals("p")) {
            animals.add(new Cat(name));
        }
    }

    /**
     * Uses getOldest method to receive the oldest animal of a type and removes
     * it from the LinkedList.
     * @param type the type of required animal
     */
    private void adoptOldest(String type) {
        Animal oldestAnimal = getOldest("a" + type);
        animals.remove(oldestAnimal);
    }

    /**
     * Gets a list of all animals of a type and returns the first element.
     * It also prints that animal.
     * @param a the type of required animal
     * @return the animal
     */
    private Animal getOldest(String a) {
        Animal oldestAnimal = null;

        switch (a) {
            case "ao" -> oldestAnimal = animals.get(0);
            case "ac" -> oldestAnimal = getListOfAllAnimalsOfType(Dog.class).get(0);
            case "ap" -> oldestAnimal = getListOfAllAnimalsOfType(Cat.class).get(0);
        }

        System.out.println(oldestAnimal);
        return oldestAnimal;
    }

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */

        Solution solution = new Solution();
        Scanner scan = new Scanner(System.in);

        while (scan.hasNextLine()) {
            String a = scan.next();
            String b = null;
            String c = null;

            if (a.equals("a")) {
                b = scan.next();
                c = scan.next();
                solution.addAnimal(b, c);
            } else if (a.length() == 1) {
                solution.adoptOldest(a);
            } else if (a.length() == 2) {
                solution.getOldest(a);
            }
        }

        scan.close();
    }
}