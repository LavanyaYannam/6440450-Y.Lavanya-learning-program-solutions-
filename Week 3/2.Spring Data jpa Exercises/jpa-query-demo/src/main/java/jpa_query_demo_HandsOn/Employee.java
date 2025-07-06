package jpa_query_demo_HandsOn;

import jakarta.persistence.*;
import java.util.Date;

@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private double salary;

    @Temporal(TemporalType.DATE)
    private Date joinDate;

    // 🔹 No-arg constructor (required by JPA)
    public Employee() {
    }

    // 🔹 All-arg constructor (used in CommandLineRunner)
    public Employee(String name, double salary, Date joinDate) {
        this.name = name;
        this.salary = salary;
        this.joinDate = joinDate;
    }

    // 🔹 Getters and Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getJoinDate() {
        return joinDate;
    }

    public void setJoinDate(Date joinDate) {
        this.joinDate = joinDate;
    }

    // 🔹 To string (for printing)
    @Override
    public String toString() {
        return "Employee{" +
               "id=" + id +
               ", name='" + name + '\'' +
               ", salary=" + salary +
               ", joinDate=" + joinDate +
               '}';
    }
}
