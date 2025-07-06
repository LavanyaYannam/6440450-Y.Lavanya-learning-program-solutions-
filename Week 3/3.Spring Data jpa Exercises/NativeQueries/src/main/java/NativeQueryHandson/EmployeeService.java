package NativeQueryHandson;

import NativeQueryHandson.Employee;
import NativeQueryHandson.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    public void saveSampleData() {
        employeeRepository.save(new Employee(1, "Alice", 50000.0, true));
        employeeRepository.save(new Employee(2, "Bob", 40000.0, false));
        employeeRepository.save(new Employee(3, "Charlie", 60000.0, true));
    }

    public List<Employee> getAllEmployeesUsingNative() {
        return employeeRepository.getAllEmployeesNative();
    }
}
