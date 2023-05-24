import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.time.Period;

public class Solution {
    public static void main(String[] args) {
        List<Employee> employees = Employees.getEmployees();
        Map<Integer, Employee> employeesMap = new HashMap();

        employeesMap = employees.stream()
                .collect(Collectors.toMap(e -> e.getEin(), e -> e, (oldValue, newValue) -> newValue));
        // System.out.println(employeesMap);

        List<Company> companies = Companies.getCompanies();

        Map<Integer, String> companiesMap = new HashMap();
        companiesMap = companies.stream()
                .collect(Collectors.toMap(e -> e.getEin(), e -> e.getCompanyName(), (oldValue, newValue) -> newValue));
        // System.out.println(companiesMap);

        // <firstName, lastName, current age, company name>
        List<Employee> employees1 = employees.stream()
                .filter(e -> Period.between(e.getDob(), LocalDate.now()).getYears() > 35)
                .collect(Collectors.toList());

        // for(Employee e: employees1) {
        // System.out.println("< " + e.getFirstName() +", " + e.getLastName() + ", " +
        // Period.between(e.getDob(),LocalDate.now()).getYears() + ", " + ">");
        // }

        // a. [companyName, ein, firstName, lastName, email, employeeId] - sorted by
        // FirstName
        // Collections.sort(employees, (o1, o2) ->
        // o1.getFirstName().compareTo(o2.getFirstName()));
        // for(Employee e: employees) {
        // System.out.println("[ " + e.getEin() +", " + e.getFirstName() +", " +
        // e.getLastName() +", " + e.getEmail() + ", " + e.getEmployeeId() +" ]");
        // }
        // b. [companyName, ein, firstName, lastName, email, employeeId] - sorted by
        // FirstName
        Collections.sort(employees, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        // for(Employee e: employees) {
        // System.out.println("[ " + e.getEin() +", " + e.getFirstName() +", " +
        // e.getLastName() +", " + e.getEmail() + ", " + e.getEmployeeId() +" ]");
        // }
        // c. [companyName, ein, firstName, lastName, email, employeeId] - sorted by
        // FirstName
        Collections.sort(employees, (o1, o2) -> o1.getEmployeeId().compareTo(o2.getEmployeeId()));
        for (Employee e : employees) {
            System.out.println("[ " + e.getEin() + ", " + e.getFirstName() + ", " + e.getLastName() + ", "
                    + e.getEmail() + ", " + e.getEmployeeId() + " ]");
        }
    }
}