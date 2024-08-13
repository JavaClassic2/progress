package lms;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Department<E> implements Iterable<E>{
    private int departmentNo;
    private String departmentName;
    private List<E> list;
    
    public Department(int departmentNo, String departmentName) {
        this.departmentNo = departmentNo;
        this.departmentName = departmentName;
        this.list = new ArrayList<>();
    }

    public int getDepartmentNo() {
        return departmentNo;
    }

    public String getDepartmentName() {
        return departmentName;
    }

    public void addStudent(E element) {
        list.add(element);
    }

    public List<E> getList() {
        return list;
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
}
