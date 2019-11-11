package info.vziks.homework11.employee;

import com.github.javafaker.Faker;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

// Создать список объетов List<Employee>
// и сортировать по:
// имени
// имени и зарплете
// имени, зарплете, возрасту и компании

public class Employee {
    private String name;
    private String company;
    private int salary;
    private int age;


    public Employee(String name, String company, int salary, int age) {
        this.name = name;
        this.company = company;
        this.salary = salary;
        this.age = age;
    }


    public static List<Employee> employeeGenerator(int num) {
        // метод для создания списка объектов класса Employee
        String[] names = {"Mike", "Tom", "Alex", "John", "Peter", "Jack", "Charlie", "Max", "Jenifer", "Linda", "Elizabeth"}; // массив с именами
        String[] companies = {"Microsoft", "IBM", "Google", "General Electric", "Siemens", "Samsung", "Apple"}; // массив с названиями компаний

        List<Employee> employees = new ArrayList<>(num);

        Random rand = new Random();
        Faker faker = new Faker();

        // добавление num объектов Employee в список (employees)
        for (int i = 0; i < num; i++) {
            employees.add(new Employee(
                    names[rand.nextInt(names.length)],
                    companies[rand.nextInt(companies.length)],
                    faker.number().numberBetween(100000, 200000) % 1000 * 1000,
                    rand.nextInt(60 - 21) + 21
            ));
        }
        return employees;
    }

    public String getName() {
        return name;
    }

    public String getCompany() {
        return company;
    }

    public int getSalary() {
        return salary;
    }

    public int getAge() {
        return age;
    }


    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Employee{");
        sb.append("name='").append(name).append('\'');
        sb.append(", company='").append(company).append('\'');
        sb.append(", salary=").append(salary);
        sb.append(", age=").append(age);
        sb.append('}');
        return sb.toString();
    }


}