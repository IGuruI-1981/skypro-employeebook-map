package pro.sky.skyproemployeebookmap;

import pro.sky.skyproemployeebookmap.exception.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebookmap.exception.EmployeeNotFoundException;
import pro.sky.skyproemployeebookmap.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>(Map.of(
            "12334",new Employee("Иванов", "Виктор", "12334"),
            "23532",new Employee("Иванова", "Евгения","23532"),
            "23452",new Employee("Васильев", "Илья","23452")));

    public String hello() {
        return "HelloSkyPRO";
    }

    public String allEmployee() {
        return employees.toString();
    }

    @Override
    public String addEmployee(String firstName, String lastName, String passport) {
        Employee employee = new Employee(firstName, lastName, passport);
        for (Employee employee1 : employees.values()) {
            if (employee1.equals(employee)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть ");
            }
        }
        if (employees.size() == 10) {
            throw new EmployeeStorageIsFullException("Массив переполнен");
        } else {
            employees.put(employee.getPassport(),employee);
            return employee.toString();
        }
    }

    @Override
    public String removeEmployee(String firstName, String lastName, String passport) {
        Employee employee = new Employee(firstName, lastName, passport);
        for (Employee employee1 : employees.values()) {
            if (employee1.equals(employee)) {
                employees.remove(employee1);
                return employee.toString();
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");

    }

    @Override
    public String findEmployee(String firstName, String lastName, String passport) {
        Employee employee = new Employee(firstName, lastName, passport);
        for (Employee employee1 : employees.values()) {
            if (employee1.equals(employee)) {
                return employee.toString();
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден");
    }
}
