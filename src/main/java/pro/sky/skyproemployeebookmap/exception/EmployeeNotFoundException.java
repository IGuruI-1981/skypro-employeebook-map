package pro.sky.skyproemployeebookmap.exception;

public class EmployeeNotFoundException extends RuntimeException {               //если сотрудник не найден
    public EmployeeNotFoundException(String message) {
        super(message);
    }
}
