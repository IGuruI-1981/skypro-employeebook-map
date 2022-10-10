package pro.sky.skyproemployeebookmap.exception;

public class EmployeeStorageIsFullException extends RuntimeException{           //массив сотрудников переполнен
    public EmployeeStorageIsFullException(String message) {
        super(message);
    }
}
