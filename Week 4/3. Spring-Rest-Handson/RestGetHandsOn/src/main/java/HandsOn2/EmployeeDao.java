package HandsOn2;

import java.util.List;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class EmployeeDao {
    public static List<Employee> EMPLOYEE_LIST;

    public EmployeeDao() {
        try (ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("employee1.xml")) {
            EMPLOYEE_LIST = (List<Employee>) context.getBean("employeeList");
        }
    }

    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
