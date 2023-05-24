public class Company {

    private String companyName;
    private Integer ein;
    private Integer noOfEmployees;
    private Address address;
    private String ticker;

    public Company() {

    }

    public Company(String companyName, Integer ein, Integer noOfEmployees, Address address, String ticker) {
        this.companyName = companyName;
        this.ein = ein;
        this.noOfEmployees = noOfEmployees;
        this.address = address;
        this.ticker = ticker;
    }

    public String getCompanyName() {
        return companyName;
    }

    public Company setCompanyName(String companyName) {
        this.companyName = companyName;
        return this;
    }

    public Integer getEin() {
        return ein;
    }

    public Company setEin(Integer ein) {
        this.ein = ein;
        return this;
    }

    public Integer getNoOfEmployees() {
        return noOfEmployees;
    }

    public Company setNoOfEmployees(Integer noOfEmployees) {
        this.noOfEmployees = noOfEmployees;
        return this;
    }

    public Address getAddress() {
        return address;
    }

    public Company setAddress(Address address) {
        this.address = address;
        return this;
    }

    public String getTicker() {
        return ticker;
    }

    public Company setTicker(String ticker) {
        this.ticker = ticker;
        return this;
    }

    @Override
    public String toString() {
        return "Company{" +
                "companyName='" + companyName + '\'' +
                ", ein=" + ein +
                ", noOfEmployees=" + noOfEmployees +
                ", address=" + address +
                ", ticker='" + ticker + '\'' +
                '}';
    }
}