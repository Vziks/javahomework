package info.vziks.homework11;

import info.vziks.homework11.employee.Employee;
import info.vziks.homework11.employee.comparator.EmployeeAgeComparator;
import info.vziks.homework11.employee.comparator.EmployeeCompanyComparator;
import info.vziks.homework11.employee.comparator.EmployeeNameComparator;
import info.vziks.homework11.employee.comparator.EmployeeSalaryComparator;
import info.vziks.utils.Command;

import java.util.Comparator;
import java.util.Iterator;
import java.util.List;


public class Task111Command implements Command {
    @Override
    public void execute() {

        Comparator<Employee> employeeComparator1 = new EmployeeNameComparator();

        List<Employee> employees1 = Employee.employeeGenerator(20);
        employees1.sort(employeeComparator1);

        outputList(employees1);

        Comparator<Employee> employeeNameComparator2 = new EmployeeNameComparator().thenComparing(new EmployeeSalaryComparator());

        List<Employee> employees2 = Employee.employeeGenerator(20);
        employees2.sort(employeeNameComparator2);

        outputList(employees2);

        Comparator<Employee> employeeNameComparator3 = new EmployeeNameComparator()
                .thenComparing(
                        new EmployeeSalaryComparator()
                                .thenComparing(
                                        new EmployeeAgeComparator()
                                                .thenComparing(
                                                        new EmployeeCompanyComparator()
                                                )
                                )
                );

        List<Employee> employees3 = Employee.employeeGenerator(100);
        employees3.sort(employeeNameComparator3);

        outputList(employees3);

    }

    private static void outputList(List<Employee> employees) {
        for (Employee item :
                employees) {
            System.out.println(item);
        }
    }
}
