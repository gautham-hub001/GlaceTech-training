import java.util.*;
import java.time.LocalDate;
import java.util.stream.Collectors;
import java.time.Period;

public class Solution {
    public static void main(String[] args) {
        List<Employee> employees = Employees.getEmployees();

        // 4. Map<Integer, List<Employee>> ein, list of employees -> last field in employees.txt is company id
        Map<Integer, List<Employee>> employeesMap = new HashMap();
        
       employeesMap = employees.stream()
                            .collect(Collectors.toMap(e->e.getEin(), e-> {List<Employee> emp = new ArrayList<Employee>(); emp.add(e); return emp;}, (oldValue, newValue) -> {
                                List<Employee> emp = new ArrayList<Employee>();
                                if(oldValue instanceof Employee) { 
                                emp.add(oldValue.get(0));
                                emp.add(newValue.get(0));
                                return emp;
                            }
                            else{ // instanceof List<Employee>
                                oldValue.add(newValue.get(0));
                                return oldValue;
                            }
                            
                        }));
        for(Map.Entry<Integer,List<Employee>> e: employeesMap.entrySet()) {
            System.out.println(e.getKey());
            System.out.println(e.getValue());
            System.out.println();
        }
         

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
        // for (Employee e : employees) {
        //     System.out.println("[ " + e.getEin() + ", " + e.getFirstName() + ", " + e.getLastName() + ", "
        //             + e.getEmail() + ", " + e.getEmployeeId() + " ]");
        // }
    }

    

     

    
    
            }
            
            
        
    

    
    

        

    


    