import java.time.LocalDate;

public class Employee {
    private String firstName;
    private String lastName;
    private String gender;
    private LocalDate dob;
    private String email;
    private Integer employeeId;
    private Integer ein;

    public Employee() {

    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getDob() {
        return dob;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(Integer employeeId) {
        this.employeeId = employeeId;
    }

    public Integer getEin() {
        return ein;
    }

    public void setEin(Integer ein) {
        this.ein = ein;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "firstname='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", gender='" + gender + '\'' +
                ", dob=" + dob +
                ", email=" + email +
                ", employeeID=" + employeeId +
                ", ein=" + ein +
                '}';
    }

}
