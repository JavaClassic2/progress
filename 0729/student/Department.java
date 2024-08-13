package student;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.stream.Collectors;

public class Department<E extends Comparable<E>> implements Iterable<E>{
    public int departmentNo;
    public String departmentName;
    public ArrayList<E> list;

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

    public void add(E e) {
        list.add(e);
    }

    public void sort() {
        Collections.sort(this.list);
    }

    public void sort(Comparator<E> comparator) {
        Collections.sort(this.list, comparator);
    }

    public List<E> filter(Stirng name) {
        return list.stream().filter((s -> (Student)s.getName().contians(name))).collect(Collectors.toList());
    }

    @Override
    public Iterator<E> iterator() {
        return list.iterator();
    }
    
}
