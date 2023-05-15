public class Address {
    String address1;
    String address2;
    String address3;
    String city;
    String state;
    int zipcode;

    public Address(String address1, String address2, String address3, String city, String state, int zipcode) {
        this.address1 = address1;
        this.address2 = address2;
        this.address3 = address3;
        this.city = city;
        this.state = state;
        this.zipcode = zipcode;
    }

    public String toString() {
        return "[" + address1 + "," + address2 + "," + address3 + "," + state + "," + city + "," + zipcode + "]";
    }
}
