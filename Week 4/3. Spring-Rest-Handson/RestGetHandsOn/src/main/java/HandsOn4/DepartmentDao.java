package HandsOn4;

import HandsOn4.Department;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public class DepartmentDao {

    public static List<Department> DEPARTMENT_LIST;

    @Autowired
    public DepartmentDao(List<Department> departmentList) {
        DEPARTMENT_LIST = departmentList;
    }

    public List<Department> getAllDepartments() {
        return DEPARTMENT_LIST;
    }
}
