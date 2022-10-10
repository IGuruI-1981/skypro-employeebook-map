package pro.sky.skyproemployeebookmap;

import java.util.Objects;

public class Employee {
    private String firstName;
    private String lastName;
    private String passport;

    public Employee(String firstName, String lastName, String passport) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.passport = passport;

    }

    public String getPassport() {
        return passport;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(firstName, employee.firstName) && Objects.equals(lastName, employee.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, passport);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
