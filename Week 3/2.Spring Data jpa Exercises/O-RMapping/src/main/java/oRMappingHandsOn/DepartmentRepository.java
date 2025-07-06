package oRMappingHandsOn;

import oRMappingHandsOn.Department;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DepartmentRepository extends JpaRepository<Department, Long> {
}