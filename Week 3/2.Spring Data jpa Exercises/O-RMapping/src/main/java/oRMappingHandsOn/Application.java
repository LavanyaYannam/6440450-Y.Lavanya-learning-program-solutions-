package oRMappingHandsOn;

import oRMappingHandsOn.Department;
import oRMappingHandsOn.DepartmentRepository;
import oRMappingHandsOn.Employee;
import oRMappingHandsOn.EmployeeRepository;
import oRMappingHandsOn.Project;
import oRMappingHandsOn.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    DepartmentRepository deptRepo;

    @Autowired
    EmployeeRepository empRepo;

    @Autowired
    ProjectRepository projRepo;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        // Create departments
        Department d1 = new Department();
        d1.setName("Engineering");
        deptRepo.save(d1);

        Department d2 = new Department();
        d2.setName("HR");
        deptRepo.save(d2);

        // Create projects
        Project p1 = new Project();
        p1.setProjectName("AI Chatbot");
        projRepo.save(p1);

        Project p2 = new Project();
        p2.setProjectName("Payroll System");
        projRepo.save(p2);

        // Create employees
        Employee e1 = new Employee();
        e1.setName("Lavanya");
        e1.setDepartment(d1);
        e1.setProjects(Arrays.asList(p1, p2));

        Employee e2 = new Employee();
        e2.setName("Ajay");
        e2.setDepartment(d2);
        e2.setProjects(Arrays.asList(p2));

        empRepo.saveAll(Arrays.asList(e1, e2));
    }
}
