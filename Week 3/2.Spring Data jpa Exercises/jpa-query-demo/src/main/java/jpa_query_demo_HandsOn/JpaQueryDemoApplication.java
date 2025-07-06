package jpa_query_demo_HandsOn;

import jpa_query_demo_HandsOn.Employee;
import jpa_query_demo_HandsOn.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@SpringBootApplication
public class JpaQueryDemoApplication implements CommandLineRunner {

    @Autowired
    private EmployeeRepository repo;

    public static void main(String[] args) {
        SpringApplication.run(JpaQueryDemoApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // 🟡 Insert sample data
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        repo.save(new Employee("Lavanya", 60000, sdf.parse("2021-06-01")));
        repo.save(new Employee("Lalitha", 40000, sdf.parse("2022-01-15")));
        repo.save(new Employee("Anil", 80000, sdf.parse("2023-04-10")));
        repo.save(new Employee("Lakshmi", 50000, sdf.parse("2021-12-20")));
        repo.save(new Employee("Ajay", 90000, sdf.parse("2020-11-11")));

        // 🔍 1. Containing text
        System.out.println("Employees with 'la' in name:");
        List<Employee> result1 = repo.findByNameContaining("la");
        result1.forEach(System.out::println);

        // 🔍 2. Sorted by name
        System.out.println("\nEmployees with 'la' in name sorted:");
        List<Employee> result2 = repo.findByNameContainingOrderByNameAsc("la");
        result2.forEach(System.out::println);

        // 🔍 3. Name starts with 'A'
        System.out.println("\nEmployees whose name starts with 'A':");
        List<Employee> result3 = repo.findByNameStartingWith("A");
        result3.forEach(System.out::println);

        // 🔍 4. Joined between 2021 and 2022
        Date from = sdf.parse("2021-01-01");
        Date to = sdf.parse("2022-12-31");
        System.out.println("\nEmployees joined between 2021 and 2022:");
        List<Employee> result4 = repo.findByJoinDateBetween(from, to);
        result4.forEach(System.out::println);

        // 🔍 5. Salary greater than 50000
        System.out.println("\nEmployees with salary > 50000:");
        List<Employee> result5 = repo.findBySalaryGreaterThan(50000);
        result5.forEach(System.out::println);

        // 🔍 6. Salary less than 60000
        System.out.println("\nEmployees with salary < 60000:");
        List<Employee> result6 = repo.findBySalaryLessThan(60000);
        result6.forEach(System.out::println);

        // 🔍 7. Top 3 employees by salary
        System.out.println("\nTop 3 highest paid employees:");
        List<Employee> result7 = repo.findTop3ByOrderBySalaryDesc();
        result7.forEach(System.out::println);
    }
}
