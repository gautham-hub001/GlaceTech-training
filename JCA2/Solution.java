import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.time.Period;

public class Solution {
    public static void main(String[] args) {
        List<Employee> employees = Employees.getEmployees();

        // 4 Map<Integer, List<Employee>> ein, list of employees -> last field in employees.txt is company id
        Map<Integer, List<Employee>> employeesMap = new HashMap();   
        employeesMap = employees.stream()
                            .collect(Collectors.toMap(e->e.getEin(), e-> {List<Employee> emp = new ArrayList<Employee>(); emp.add(e); return emp;},
                            (oldValue, newValue) -> {
                                List<Employee> emp = new ArrayList<Employee>();
                                if(oldValue instanceof Employee) { 
                                emp.add(oldValue.get(0));
                                emp.add(newValue.get(0));
                                return emp;
                                }
                                else{ // instanceof ArrayList<Employee>
                                    oldValue.add(newValue.get(0));
                                    return oldValue;
                                }
                            }));
        for(Map.Entry<Integer,List<Employee>> e: employeesMap.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            System.out.println();
        }
         
        // 5 
        List<Company> companies = Companies.getCompanies();
        Map<Integer, String> companiesMap = new HashMap();
        companiesMap = companies.stream()
                .collect(Collectors.toMap(e -> e.getEin(), e -> e.getCompanyName(), (oldValue, newValue) -> newValue));
        System.out.println(companiesMap);

        // 6
        // filtering all the females
        // employeesMap.entrySet()
        //         .stream()
        //         .map(e-> {
        //             List<Employee> currenEmployees= e.getValue();
        //             // only females count
        //             Long count = currenEmployees.stream()
        //                     .filter(e-> e.getGender() == "F")
        //                     .count();
        //             Map.Entry<Integer, Integer> m = new HashMap<>();
        //             m.add()
        //         })

        // 7
        // <firstName, lastName, current age, company name>
        List<Employee> employees1 = employees.stream()
                .filter(e -> Period.between(e.getDob(), LocalDate.now()).getYears() > 35)
                .collect(Collectors.toList());

        for(Employee e: employees1) {
        System.out.println("<" + e.getFirstName() +"," + e.getLastName() + "," +
        Period.between(e.getDob(),LocalDate.now()).getYears() + "," + ">");
        }

        //  8
        // a. [companyName, ein, firstName, lastName, email, employeeId] - sorted by
        // FirstName
        Collections.sort(employees, (o1, o2) -> o1.getFirstName().compareTo(o2.getFirstName()));
        for(Employee e: employees) {
        System.out.println("[ " + e.getEin() +", " + e.getFirstName() +", " +
        e.getLastName() +", " + e.getEmail() + ", " + e.getEmployeeId() +" ]");
        }
        // b. [companyName, ein, firstName, lastName, email, employeeId] - sorted by
        // LastName
        Collections.sort(employees, (o1, o2) -> o1.getLastName().compareTo(o2.getLastName()));
        for(Employee e: employees) {
        System.out.println("[ " + e.getEin() +", " + e.getFirstName() +", " +
        e.getLastName() +", " + e.getEmail() + ", " + e.getEmployeeId() +" ]");
        }
        // c. [companyName, ein, firstName, lastName, email, employeeId] - sorted by
        // EmployeeId
        Collections.sort(employees, (o1, o2) -> o1.getEmployeeId().compareTo(o2.getEmployeeId()));
        

                // 9
                // a
        List<Integer> no_of_employeees = employeesMap.entrySet()
        .stream()
        .map(e->e.getValue().size())
        .collect(Collectors.toList());

        // b
        
        

        System.out.println(no_of_employeees);
                 }
    }

    