package HandsOns;

import jakarta.validation.Valid;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private static final List<Employee> employeeList = new ArrayList<>();

    public List<Employee> getAllEmployees() {
        return employeeList;
    }

    public Employee getEmployeeById(int id) {
        Optional<Employee> emp = employeeList.stream().filter(e -> e.getId() == id).findFirst();
        return emp.orElse(null); // You can throw custom exception instead
    }

    public Employee addEmployee(@Valid Employee employee) {
        employeeList.add(employee);
        return employee;
    }

    public Employee updateEmployee(int id, @Valid Employee newEmployee) {
        for (int i = 0; i < employeeList.size(); i++) {
            if (employeeList.get(i).getId() == id) {
                newEmployee.setId(id); // keep ID same
                employeeList.set(i, newEmployee);
                return newEmployee;
            }
        }
        return null; // Or throw an exception
    }

    public void deleteEmployee(int id) {
        employeeList.removeIf(e -> e.getId() == id);
    }
}
