import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class Companies {

    public static List<Company> getCompanies() {
        List<Company> companies = new ArrayList<>();

        try {
            File file = new File(
                    "./companies.txt");
            FileReader fi = new FileReader(file);
            BufferedReader br = new BufferedReader(fi);
            // br.lines().forEach(line -> System.out.println(line));
            String line;
            while ((line = br.readLine()) != null) {
                // System.out.println(line);

                String[] attrs = line.split(",");

                if (attrs.length == 10) {
                    Address address = new Address()
                            .setAddress1(attrs[3].trim())
                            .setAddress2(attrs[4].trim())
                            .setAddress3(attrs[5].trim())
                            .setCity(attrs[6].trim())
                            .setState(attrs[7].trim())
                            .setZip(Integer.parseInt(attrs[8].trim()));

                    Company company = new Company()
                            .setCompanyName(attrs[0].trim())
                            .setEin(Integer.valueOf(attrs[1].trim()))
                            .setNoOfEmployees(Integer.valueOf(attrs[2].trim()))
                            .setAddress(address)
                            .setTicker(attrs[9].trim());

                    companies.add(company);
                }
            }
        } catch (Exception ex) {
            System.out.println("Exception while reading file" + ex);
        }
        return companies;
    }

}
