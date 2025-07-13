package HandsOn1;

import java.util.List;

import HandsOn1.Employee;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.bind.annotation.*;

@RestController
public class EmployeeController {

    private static final Logger LOGGER = LoggerFactory.getLogger(EmployeeController.class);

    @GetMapping("/employees")
    public List<Employee> getAllEmployees() {
        LOGGER.info("START - getAllEmployees");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        List<Employee> employeeList = (List<Employee>) context.getBean("employeeList");
        LOGGER.info("END - getAllEmployees");
        return employeeList;
    }

    @GetMapping("/employee/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        LOGGER.info("START - getEmployeeById");
        ApplicationContext context = new ClassPathXmlApplicationContext("employee.xml");
        List<Employee> employeeList = (List<Employee>) context.getBean("employeeList");

        for (Employee e : employeeList) {
            if (e.getId() == id) {
                LOGGER.info("END - getEmployeeById");
                return e;
            }
        }

        throw new RuntimeException("Employee not found with ID: " + id);
    }
}
