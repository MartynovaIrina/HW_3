package Other;


import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlProperty;
import com.fasterxml.jackson.dataformat.xml.annotation.JacksonXmlRootElement;

@JacksonXmlRootElement(localName = "Employee")
public class Employee {
    public Employee() {
    }
    @JacksonXmlProperty(isAttribute = true)
    public String type;
    public int id;
    public static int idTotal;
    public String name;
    public String surname;
    public String middleName;
    public int age;
    public String experience;
    public int salary;


    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname=" + surname +
                ", middleName=" + middleName +
                ", age=" + age +
                ", experience=" + experience +
                ", salary=" + salary +
                '}';
    }
    public Employee(String name, String surname, String middleName, int age, String experience, int salary, int id) {
        ++idTotal;
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.middleName = middleName;
        this.age = age;
        this.experience = experience;
        this.salary = salary;
        this.type = this.getClass().getSimpleName();
    }
}
