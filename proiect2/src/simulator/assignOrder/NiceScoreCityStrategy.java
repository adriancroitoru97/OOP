package simulator.assignOrder;

import database.Child;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Comparator;
import java.util.ArrayList;
import java.util.stream.Collectors;

public final class NiceScoreCityStrategy implements AssignOrderStrategy {

    @Override
    public List<Child> getOrder(final List<Child> children) {
        /* two maps - one with <City, AverageScore>
           and one with <City, NumberOfChildren> */
        Map<String, Double> cityAverages = new HashMap<>();
        Map<String, Integer> cityChildren = new HashMap<>();

        /* for each child, its average score is added in the cityAverages map
           and the cityChildren value is increased with 1 for its city */
        for (Child child : children) {
            String city = child.getCity().toString();

            if (cityAverages.containsKey(city)) {
                Double sum = cityAverages.get(city);
                cityAverages.put(city, sum + child.getAverageScore());

                Integer num = cityChildren.get(city);
                cityChildren.put(city, num + 1);
            } else {
                cityAverages.put(city, child.getAverageScore());
                cityChildren.put(city, 1);
            }
        }

        /* for each city in cityAverages, the current
           value(the total average scores sum) is divided by
           the number of children living in that city(which value is hold
           in the cityChildren map) */
        for (Map.Entry<String, Double> e : cityAverages.entrySet()) {
            Double sum = e.getValue();
            Integer num = cityChildren.get(e.getKey());

            e.setValue(sum / num);
        }

        /* the cityAverage map is sorted firstly ascending by key(name)
           and secondly in reverse order by the average city score */
        Map<String, Double> sortedCities = cityAverages.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByKey())
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        sortedCities = sortedCities.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        Map.Entry::getValue,
                        (oldValue, newValue) -> oldValue, LinkedHashMap::new));

        /* the sorted map is then used to create a list of children
           sorted by their city */
        List<Child> sortedChildren = new ArrayList<>();
        for (Map.Entry<String, Double> e : sortedCities.entrySet()) {
            for (Child child : children) {
                if (child.getCity().toString().equals(e.getKey())) {
                    sortedChildren.add(child);
                }
            }
        }

        return sortedChildren;
    }
}
