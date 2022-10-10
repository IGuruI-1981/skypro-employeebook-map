package pro.sky.skyproemployeebookmap.exception;

public class EmployeeAlreadyAddedException extends RuntimeException {           //в массиве уже есть такой сотрудник
    public EmployeeAlreadyAddedException(String message) {
        super(message);
    }
}
