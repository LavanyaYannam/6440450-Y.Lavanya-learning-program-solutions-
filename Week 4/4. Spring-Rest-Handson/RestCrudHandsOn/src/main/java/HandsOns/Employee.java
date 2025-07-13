package HandsOns;

import jakarta.validation.constraints.*;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDate;

public class Employee {

    private int id;

    @NotBlank(message = "Name must not be blank")
    private String name;

    @NotBlank(message = "Department must not be blank")
    private String department;

    @Min(value = 10000, message = "Salary must be at least 10000")
    @Max(value = 100000, message = "Salary must be less than 100000")
    private double salary;

    @NotNull(message = "Joining date is required")
    @JsonFormat(pattern = "yyyy-MM-dd") // for JSON <-> Java mapping
    private LocalDate joiningDate;

    // ----- Getters and Setters -----

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public LocalDate getJoiningDate() {
        return joiningDate;
    }

    public void setJoiningDate(LocalDate joiningDate) {
        this.joiningDate = joiningDate;
    }
}
