package Tasks;

import Other.Address;
import Other.Employee;
import Other.Office;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Task3_4 {
    public static void main(String[] args) throws IOException {
        //Task 3-4
        List<Office> listOfoffices = new ArrayList<>();
        int numberOfoffices = 100;
        int numberOfemployees = 10;
        String[] names = new String[]{"Katya", "Ivan", "Alexander"};
        String[] surnames = new String[]{"Lebedeva", "Karpov", "Sharov"};
        String[] middleNames = new String[]{"Petrova", "Alexandrovich", "Ivanovich"};
        String[] experience = new String[]{"cook", "engineer", "driver"};
        int salary;
        int age;
        String[] countries = new String[]{"Australia" , "Micronesia" , "Canada"};
        String[] cities = new String[]{"Gold Coast" , "Palikir" , "Toronto"};
        String[] streets = new String[]{"Surfers Paradise" , "National Government" , "Saint Patrick"};
        int building;
        int floor;
        int apartment;
        int random;

        for (int i = 1; i <= numberOfoffices; i++) {
            building = (int)(Math.random() * 20 + 1);
            floor = (int)(Math.random() * 15 + 1);
            apartment = (int)(Math.random() * 200 + 1);
            random = (int)(Math.random() * streets.length);
            Address address = new Address(countries[random],
                    cities[random], streets[random], building, floor, apartment);
            Office office = new Office(address);
            for (int j = 1; j <= numberOfemployees; j++) {
                random = (int)(Math.random() * streets.length);
                age = (int)(Math.random() * 50 + 18);
                salary = (int)(Math.random() * 60000 + 25000);
                Employee employee = new Employee(names[random], surnames[random],
                        middleNames[random], age, experience[random], salary, j);
                office.addEmployee(employee);
            }
            listOfoffices.add(office);
        }
        ObjectMapper mapper = new XmlMapper();

        FileWriter fileWriter = new FileWriter("src/listOfoffices.xml");
        mapper.writeValue(fileWriter, listOfoffices);

        FileReader fileReader = new FileReader("src/listOfoffices.xml");
        listOfoffices = mapper.readValue(fileReader, listOfoffices.getClass());
        System.out.println(listOfoffices.toString());
    }
}
