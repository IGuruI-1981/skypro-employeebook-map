package pro.sky.skyproemployeebookmap;

import org.springframework.stereotype.Service;
import pro.sky.skyproemployeebookmap.exception.EmployeeAlreadyAddedException;
import pro.sky.skyproemployeebookmap.exception.EmployeeNotFoundException;
import pro.sky.skyproemployeebookmap.exception.EmployeeStorageIsFullException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    Map<String, Employee> employees = new HashMap<>(Map.of(
            "12334", new Employee("Иванов", "Виктор", "12334"),
            "23532", new Employee("Иванова", "Евгения", "23532"),
            "23452", new Employee("Васильев", "Илья", "23452")));

    public String hello() {
        return "HelloSkyPRO";
    }

    public String allEmployee() {
        return employees.toString();
    }

    @Override
    public String addEmployee(String firstName, String lastName, String passport) {
        Employee employee = new Employee(firstName, lastName, passport);
        final Employee empl = employees.get(passport);
        if (empl == null) {
            employees.put(passport, employee);
            return employees.get(passport).toString();
        }
        else {
            throw new EmployeeAlreadyAddedException("Такой сотрудник уже есть ");
        }
    }

    @Override
    public String removeEmployee(String firstName, String lastName, String passport) {
        //Employee employee = new Employee(firstName, lastName, passport);
        final Employee empl = employees.get(passport);
        if (empl == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        employees.remove(passport);
        return empl.toString();
    }


    @Override
    public String findEmployee(String firstName, String lastName, String passport) {
        // Employee employee = new Employee(firstName, lastName, passport);
        final Employee empl = employees.get(passport);
        if (empl == null) {
            throw new EmployeeNotFoundException("Сотрудник не найден");
        }
        return empl.toString();
    }
}



