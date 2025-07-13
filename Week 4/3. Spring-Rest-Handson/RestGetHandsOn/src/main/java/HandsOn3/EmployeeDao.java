package HandsOn3;
import java.util.List;
import HandsOn3.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
@Component  // ✅ This is important to make it a Spring bean
public class EmployeeDao {
    public static List<Employee> EMPLOYEE_LIST;
    @Autowired
    public EmployeeDao(List<Employee> employeeList) {
        EMPLOYEE_LIST = employeeList;
    }
    public List<Employee> getAllEmployees() {
        return EMPLOYEE_LIST;
    }
}
