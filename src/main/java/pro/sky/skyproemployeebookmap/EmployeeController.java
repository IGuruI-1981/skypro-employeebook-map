package pro.sky.skyproemployeebookmap;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

public class EmployeeController {
    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping(path = "/hello")
    public String hello() {
        return employeeService.hello();
    }

    @GetMapping(path = "/allEmployee")                                         //все сотрудники
    public String allEmployee() {
        return employeeService.allEmployee();
    }

    @GetMapping(path = "/add")                                         //добавление сотрудника
    public String addEmployee(@RequestParam("firstName") String firstName,
                              @RequestParam("lastName") String lastName) {
        return "Employee added" +  employeeService.addEmployee(firstName, lastName);
    }

    @GetMapping(path = "/remove")                                      // удаление сотрудника
    public String removeEmployee(@RequestParam("firstName") String firstName,
                                 @RequestParam("lastName") String lastName) {
        return "Employee deleted" + employeeService.removeEmployee(firstName,lastName);
    }

    @GetMapping(path = "/find")                                      // поиск  сотрудника
    public String findEmployee(@RequestParam("firstName") String firstName,
                               @RequestParam("lastName") String lastName) {
        return "Employee find" + employeeService.findEmployee(firstName,lastName);
    }

}
