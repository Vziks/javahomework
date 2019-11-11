package info.vziks.homework11.employee.comparator;

import info.vziks.homework11.employee.Employee;

import java.util.Comparator;

public class EmployeeCompanyComparator implements Comparator<Employee> {
    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getCompany().compareTo(o2.getCompany());
    }
}