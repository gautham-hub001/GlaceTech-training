public class Company extends Address {
    String name;
    String ticker;
    int ein;
    int noOfEmployess;

    public Company(String name, int ein, int noOfEmployess, String address1, String address2, String address3,
            String city, String state, int zipcode, String ticker) {
        super(address1, address2, address3, city, state, zipcode);
        this.name = name;
        this.ein = ein;
        this.noOfEmployess = noOfEmployess;
        this.ticker = ticker;
    }

    public String toString() {
        return "[" + name + "," + ein + "," + ticker + "]";
    }
}