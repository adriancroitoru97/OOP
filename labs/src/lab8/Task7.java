package lab8;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.TreeSet;

public class Task7 extends LinkedHashSet<Integer> {
    @Override
    public boolean add(Integer integer) {
        if (integer % 2 == 0) {
            return super.add(integer);
        }
        return false;
    }
}
