import java.util.Iterator;
import java.util.List;

public class DepartmentManager implements Iterator<Student>{
    private List<Student> departmentList;
    private int index;

    public DepartmentManager(List<Student> departmentList) {
        this.departmentList = departmentList;
        this.index = 0;
    }
    
    @Override
    public boolean hasNext() {
        return departmentList.get(index+1) != null;
    }

    @Override
    public Student next() {
        return departmentList.get(index++);
    }
    
}
