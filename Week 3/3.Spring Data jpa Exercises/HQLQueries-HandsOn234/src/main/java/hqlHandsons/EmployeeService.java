package hqlHandsons;

import hqlHandsons.Employee;
import hqlHandsons.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repo;

    public List<Employee> getAllPermanentEmployees() {
        return repo.getAllPermanentEmployees();
    }

    public Double getAvgSalary() {
        return repo.getAverageSalary();
    }
}
