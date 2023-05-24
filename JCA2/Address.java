public class Address {

    private String address1;
    private String address2;
    private String address3;
    private String city;
    private String state;
    private Integer zip;

    public Address() {

    }

    public Address(String address1, String address2, String address3, String city, String state, Integer zip) {
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.state = state;
        this.zip = zip;
    }

    public String getAddress1() {
        return address1;
    }

    public Address setAddress1(String address1) {
        this.address1 = address1;
        return this;
    }

    public String getAddress2() {
        return address2;
    }

    public Address setAddress2(String address2) {
        this.address2 = address2;
        return this;
    }

    public String getAddress3() {
        return address3;
    }

    public Address setAddress3(String address3) {
        this.address3 = address3;
        return this;
    }

    public String getCity() {
        return city;
    }

    public Address setCity(String city) {
        this.city = city;
        return this;
    }

    public String getState() {
        return state;
    }

    public Address setState(String state) {
        this.state = state;
        return this;
    }

    public Integer getZip() {
        return zip;
    }

    public Address setZip(Integer zip) {
        this.zip = zip;
        return this;
    }

    @Override
    public String toString() {
        return "Address{" +
                "address1='" + address1 + '\'' +
                ", address2='" + address2 + '\'' +
                ", address3='" + address3 + '\'' +
                ", city='" + city + '\'' +
                ", state='" + state + '\'' +
                ", zip=" + zip +
                '}';
    }
}
