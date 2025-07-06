package NativeQueryHandson;

import NativeQueryHandson.Employee;
import NativeQueryHandson.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class NativeQueriesApplication implements CommandLineRunner {

    @Autowired
    private EmployeeService employeeService;

    public static void main(String[] args) {
        SpringApplication.run(NativeQueriesApplication.class, args);
    }

    @Override
    public void run(String... args) {
        System.out.println("Start");
        employeeService.saveSampleData();

        System.out.println("All Employees:");
        for (Employee e : employeeService.getAllEmployeesUsingNative()) {
            System.out.println(e);
        }
        System.out.println("End");
    }
}
