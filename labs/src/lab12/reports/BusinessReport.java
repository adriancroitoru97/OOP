package lab12.reports;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import lab12.entities.*;

public class BusinessReport {

    public static Map<Disability, List<Employee>> getEmployeesOnSameDisability(Business business) {
        // Get employees and map them on the type of disability they possess

        Map<Disability, List<Employee>> map = new HashMap<>();

        Set<Employee> employees = business.getEmployees();
        for (Employee e : employees) {
            if (map.containsKey(e.getDisability())) {
                map.get(e.getDisability()).add(e);
            } else {
                List<Employee> list = new ArrayList<>();
                list.add(e);
                map.put(e.getDisability(), list);
            }
        }

        return map;
    }

    public static long getNumberOfDifferentProjectsWorkedByCurrentFemaleEmployees(Business business) {
        // Get employees, filter by gender, get their projects without duplicates, count

        Set<Employee> employees = business.getEmployees();
        Set<Employee> femaleEmployees = employees
                .stream()
                .filter(e -> e.getGender().equals(Gender.FEMALE))
                .collect(Collectors.toSet());

        Set<Project> projects = new HashSet<>();
        for (Employee e : femaleEmployees) {
            projects.addAll(e.getProjects());
        }

        return projects.size();
    }

    public static Map<Religion, Map<Gender, List<Employee>>> getEmployeesOnSameReligionAndGender(Business business) {
        // Map the employees by religion (Map<Religion, List<Employee>>) then map each of the lists by city (Map<String, List<Employee>>)
        // Hint: use Collectors.groupingBy(Function, Collector)

        Map<Religion, Map<Gender, List<Employee>>> map = new HashMap<>();

        Set<Employee> employees = business.getEmployees();
        Map<Religion, List<Employee>> religionMap = new HashMap<>();
        for (Employee e : employees) {
            if (religionMap.containsKey(e.getReligion())) {
                religionMap.get(e.getReligion()).add(e);
            } else {
                List<Employee> list = new ArrayList<>();
                list.add(e);
                religionMap.put(e.getReligion(), list);
            }
        }

        for (Map.Entry<Religion, List<Employee>> entry : religionMap.entrySet()) {
            Map<Gender, List<Employee>> genderMap = entry.getValue()
                    .stream()
                    .collect(Collectors.groupingBy(
                            employee -> employee
                                    .getGender().equals(Gender.MALE) ? Gender.MALE : Gender.FEMALE
                    ));
            map.put(entry.getKey(), genderMap);
        }

        return map;
    }
}
