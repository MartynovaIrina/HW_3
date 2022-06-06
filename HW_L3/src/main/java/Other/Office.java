package Other;

import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlElementWrapper;

import java.util.ArrayList;
import java.util.List;

public class Office {
    @JacksonXmlElementWrapper(useWrapping = false)
    public List<Employee> employeeList = new ArrayList<>();
    public Address address;
    public static int idTotal;
    public int id;
    public Office() {
    }
    @Override
    public String toString() {
        return "Office{" + "id=" + id +
                ", " + address +
                ", employeeList=" + employeeList +
                '}';
    }
    public Office(Address address) {
        ++idTotal;
        this.id = idTotal;
        this.address = address;
        this.employeeList = employeeList;
    }
    public List<Employee> addEmployee(Employee employee) {
        employeeList.add(employee);
        return employeeList;
    }
}
