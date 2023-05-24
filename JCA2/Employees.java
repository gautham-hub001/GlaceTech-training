import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Employees {
    public static List<Employee> getEmployees() {
        List<Employee> employees = new ArrayList();
        try {
            File file = new File("./Employees.txt");
            FileReader fr = new FileReader(file);
            BufferedReader br = new BufferedReader(fr);

            String line;

            while ((line = br.readLine()) != null) {
                // System.out.println(line);
                String[] attrs = line.split(",");

                DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
                LocalDate date = LocalDate.parse(attrs[3].trim(), dtf);
                if (attrs.length == 7) {
                    Employee employee = new Employee();
                    employee.setFirstName(attrs[0].trim());
                    employee.setLastName(attrs[1].trim());
                    employee.setGender(attrs[2].trim());
                    employee.setDob(date);
                    employee.setEmail(attrs[4].trim());
                    employee.setEmployeeId(Integer.parseInt(attrs[5].trim()));
                    employee.setEin(Integer.parseInt(attrs[6].trim()));
                    employees.add(employee);
                }
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return employees;
    }
}
