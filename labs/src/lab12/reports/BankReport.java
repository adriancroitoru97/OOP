package lab12.reports;

import lab12.entities.Account;
import lab12.entities.Bank;
import lab12.entities.Business;
import lab12.entities.Employee;

import java.util.*;
import java.util.stream.Collectors;

public class BankReport {
    // Customer = Employee of the Business
    // Business = a client of the Bank
    // Customers of the Bank = all the Employees that work for the Businesses that are clients of the Bank

    public static int getNumberOfCustomers(Bank bank) {
        // All the customers that have accounts at the bank

        int number = 0;

        Set<Business> businesses = bank.getClients();
        for (Business b : businesses) {
            number += b.getEmployees().size();
        }

        return number;
    }

    public static int getNumberOfAccounts(Bank bank) {
        // Accounts of all the customers of the bank

        int number = 0;

        Set<Business> businesses = bank.getClients();
        for (Business b : businesses) {
            Set<Employee> employees = b.getEmployees();
            for (Employee e : employees) {
                number += e.getAccounts().size();
            }
        }

        return number;
    }

    public static SortedSet<Employee> getCustomersSorted(Bank bank) {
        // Display the set of customers in alphabetical order

        Set<Employee> allEmployees = new HashSet<>();

        Set<Business> businesses = bank.getClients();
        for (Business b : businesses) {
            allEmployees.addAll(b.getEmployees());
        }

        return allEmployees
                .stream()
                .collect(Collectors.toCollection(
                        () -> new TreeSet<>(Comparator.comparing(Employee::getName))
                ));
    }

    public static double getTotalSumInAccounts(Bank bank) {
        // Sum of all customers' accounts balances

        double sum = 0.0;

        Set<Business> businesses = bank.getClients();
        for (Business b : businesses) {
            Set<Employee> employees = b.getEmployees();
            for (Employee e : employees) {
                Set<Account> accounts = e.getAccounts();
                for (Account a : accounts) {
                    sum += a.getBalance();
                }
            }
        }

        return sum;
    }

    public static SortedSet<Account> getAccountsSortedBySum(Bank bank) {
        // The set of all accounts, ordered by current account balance

        SortedSet<Account> accountsSortedSet = new TreeSet<>(Comparator
                .comparing(Account::getBalance)
                .thenComparing(Account::getId)
        );

        Set<Business> businesses = bank.getClients();
        for (Business b : businesses) {
            Set<Employee> employees = b.getEmployees();
            for (Employee e : employees) {
                Set<Account> accounts = e.getAccounts();
                accountsSortedSet.addAll(accounts);
            }
        }

        return accountsSortedSet;
    }

    public static Map<Employee, Collection<Account>> getCustomerAccounts(Bank bank) {
        // Return a map of all the customers with their respective accounts

        Map<Employee, Collection<Account>> map = new HashMap<>();

        Set<Business> businesses = bank.getClients();
        for (Business b : businesses) {
            Set<Employee> employees = b.getEmployees();
            for (Employee e : employees) {
                map.put(e, e.getAccounts());
            }
        }

        return map;
    }

    public static Map<String, List<Employee>> getCustomersByCity(Bank bank) {
        // Map all the customers to their respective cities

        Map<String, List<Employee>> map = new HashMap<>();

        Set<Business> businesses = bank.getClients();
        for (Business b : businesses) {
            Set<Employee> employees = b.getEmployees();
            for (Employee e : employees) {
                if (map.containsKey(e.getCity())) {
                    map.get(e.getCity()).add(e);
                } else {
                    List<Employee> list = new ArrayList<>();
                    list.add(e);
                    map.put(e.getCity(), list);
                }
            }
        }

        return map;
    }
}
