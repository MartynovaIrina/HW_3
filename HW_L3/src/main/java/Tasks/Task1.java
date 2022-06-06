package Tasks;

import Other.Employee;
import Other.Office;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task1 {
    public static void main(String[] args) throws IOException {
        //Task 1
        String filename = "src/employee.xml";
        String name = "Ivan";
        String surname = "Ivanov";
        String middleName = "Petrovich";
        int age = 25;
        String experience = "driver";
        int salary = 40000;
        int id = 1;

        ObjectMapper mapper = new XmlMapper();

        Employee employee = new Employee(name, surname, middleName, age, experience, salary, id);
        FileWriter fileWriter = new FileWriter(filename);
        mapper.writeValue(fileWriter, employee);

        FileReader fileReader = new FileReader(filename);
        employee = mapper.readValue(fileReader, Employee.class);
        System.out.println(employee.toString());
    }
}
