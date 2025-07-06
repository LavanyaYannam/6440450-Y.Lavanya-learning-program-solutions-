package jpa_query_demo_HandsOn;

import org.springframework.data.jpa.repository.JpaRepository;
import jpa_query_demo_HandsOn.Employee;
import java.util.*;

public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // 1. Containing text
    List<Employee> findByNameContaining(String keyword);

    // 2. Sorted by name
    List<Employee> findByNameContainingOrderByNameAsc(String keyword);

    // 3. Starting with text
    List<Employee> findByNameStartingWith(String prefix);

    // 4. Between join dates
    List<Employee> findByJoinDateBetween(Date start, Date end);

    // 5. Greater/Less than salary
    List<Employee> findBySalaryGreaterThan(double salary);
    List<Employee> findBySalaryLessThan(double salary);

    // 6. Top 3 by salary
    List<Employee> findTop3ByOrderBySalaryDesc();
}
