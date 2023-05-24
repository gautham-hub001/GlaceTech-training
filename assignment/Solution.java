import java.io.*;
import java.util.stream.Collectors;

public class Solution {
    public static void main(String[] args) throws Exception {
        print_lines();
        map_classes(no_of_lines());
    }

    public static void map_classes(int lines) throws Exception {
        File file = new File("./companies.txt");
        FileReader fi = new FileReader(file);
        BufferedReader br = new BufferedReader(fi);

        Company[] companies = new Company[lines];
        for (int i = 0; i < lines; i++) {
            String l = br.readLine();
            String[] line = l.split(", ", -1);
            companies[i] = new Company(line[0], Integer.parseInt(line[1]), Integer.parseInt(line[2]), line[3], line[4],
                    line[5], line[6], line[7], Integer.parseInt(line[8]), line[9]);
        }

        // companies that start with A
        System.out.println("companies that start with A");
        for (int i = 0; i < lines; i++) {
            if (companies[i].name.startsWith("A")) {
                System.out.println(companies[i].name);
            }
        }

        // Get all companies where no of employees greater than 200000
        System.out.println();
        System.out.println("all companies where no of employees greater than 200000");
        for (int i = 0; i < lines; i++) {
            if (companies[i].noOfEmployess > 200000) {
                System.out.println(companies[i].name + " " + companies[i].noOfEmployess);
            }
        }

        // Get all companies in zip code: 50020
        System.out.println();
        System.out.println("Get all companies in zip code: 50020");
        for (int i = 0; i < lines; i++) {
            if (companies[i].zipcode == 50020) {
                System.out.println(companies[i].name);
            }
        }

        // Print all companies in the below format.
        // [companyName, ein, ticker]
        System.out.println();
        System.out.println("Print all companies in the below format: [companyName, ein, ticker]");
        for (int i = 0; i < lines; i++) {
            System.out.println(companies[i]);
        }

        // 8. [companyName, address1, address2, address3, state, city, zip]
        System.out.println();
        System.out.println("[companyName, address1, address2, address3, state, city, zip]");

        for (int i = 0; i < lines; i++) {
            System.out
                    .println("[" + companies[i].name + "," + companies[i].address1 + "," + companies[i].address2 + "," +
                            companies[i].address3 + "," + companies[i].state + "," + companies[i].city + ","
                            + companies[i].zipcode + "]");
        }

        // 9. Calculate total no of employees working in all companies
        System.out.println();
        System.out.println("total no of employees working in all companies");
        int total_no_of_employees = 0;
        int lowest_no_of_employees = companies[0].noOfEmployess;
        String lowest_company = companies[0].name;
        int highest_no_of_employees = companies[0].noOfEmployess;
        String highest_company = companies[0].name;
        for (int i = 0; i < lines; i++) {
            total_no_of_employees += companies[i].noOfEmployess;
            if (companies[i].noOfEmployess < lowest_no_of_employees) {
                lowest_no_of_employees = companies[i].noOfEmployess;
                lowest_company = companies[i].name;
            }

            if (companies[i].noOfEmployess > highest_no_of_employees) {
                highest_no_of_employees = companies[i].noOfEmployess;
                highest_company = companies[i].name;
            }
        }
        System.out.println(total_no_of_employees);

        // Find the company with highest and lowest no of employees.
        System.out.println("Highest no of employees working in all companies:");
        System.out.println(highest_company + " " + highest_no_of_employees);

        System.out.println("lowest no of employees working in all companies:");
        System.out.println(lowest_company + " " + lowest_no_of_employees);
        br.close();
    }

    public static int no_of_lines() throws Exception {
        File file = new File("./companies.txt");
        FileReader fi = new FileReader(file);
        BufferedReader br = new BufferedReader(fi);
        int lines = 0;
        String l;
        while ((l = br.readLine()) != null) {
            lines++;
        }
        br.close();
        return lines;
    }

    public static void print_lines() throws Exception {
        File file = new File("./companies.txt");
        FileReader fi = new FileReader(file);
        BufferedReader br = new BufferedReader(fi);
        br.lines().forEach(line -> System.out.println(line));
        br.close();
    }

}
