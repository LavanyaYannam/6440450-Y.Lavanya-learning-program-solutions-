package hqlHandsons;

import hqlHandsons.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // HQL: Fetch permanent employees with department and skills
    @Query("SELECT e FROM Employee e LEFT JOIN FETCH e.department d LEFT JOIN FETCH e.skillList WHERE e.permanent = true")
    List<Employee> getAllPermanentEmployees();

    // HQL: Get average salary of employees
    @Query("SELECT AVG(e.salary) FROM Employee e")
    Double getAverageSalary();
}
