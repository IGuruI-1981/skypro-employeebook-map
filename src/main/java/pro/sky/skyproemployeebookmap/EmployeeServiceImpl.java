package pro.sky.skyproemployeebookmap;

import pro.sky.skyproemployeebookmap.exception.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebookmap.exception.EmployeeNotFoundException;
import pro.sky.skyproemployeebookmap.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.List;

public class EmployeeServiceImpl implements EmployeeService {
    List<Employee> employees = new ArrayList<>(List.of(new Employee("Иванов", "Виктор"),
            new Employee("Иванова", "Евгения"),
            new Employee("Васильев", "Илья")));

    public String hello() {
        return "HelloSkyPRO";
    }

    public String allEmployee() {
        return employees.toString();
    }

    @Override
    public String addEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (Employee employee1 : employees) {
            if (employee1.equals(employee)) {
                throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть ");
            }
        }
        if (employees.size() == 10) {
            throw new EmployeeStorageIsFullException("Массив переполнен");
        }else {
            employees.add(employee);
            return employee.toString();
        }
    }

    @Override
    public String removeEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (Employee employee1 : employees) {
            if (employee1.equals(employee)) {
                employees.remove(employee1);
                return employee.toString();
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден") ;

    }

    @Override
    public String findEmployee(String firstName, String lastName) {
        Employee employee = new Employee(firstName, lastName);
        for (Employee employee1 : employees) {
            if (employee1.equals(employee)) {
                return employee.toString();
            }
        }
        throw new EmployeeNotFoundException("Сотрудник не найден") ;
    }
}
