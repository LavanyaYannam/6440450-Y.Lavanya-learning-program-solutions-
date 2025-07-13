package HandsOn2;

import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class EmployeeController {
    EmployeeDao employeeDao = new EmployeeDao();

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        return employeeDao.getAllEmployees();
    }
}
