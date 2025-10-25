package veer.com;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    int id;
    String name;
    int age;
    String gender;
    String department;
    int yearOfJoining;
    double salary;

    public Employee(int id, String name, int age, String gender, String department, int yearOfJoining, double salary) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.department = department;
        this.yearOfJoining = yearOfJoining;
        this.salary = salary;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public int getAge() { return age; }
    public String getGender() { return gender; }
    public String getDepartment() { return department; }
    public int getYearOfJoining() { return yearOfJoining; }
    public double getSalary() { return salary; }

    @Override
    public String toString() {
        return "Id: " + id + ", Name: " + name + ", Age: " + age +
                ", Gender: " + gender + ", Department: " + department +
                ", Year Of Joining: " + yearOfJoining + ", Salary: " + salary;
    }
}

public class Emplooyes {
    public static void main(String[] args) {

        List<Employee> employeeList = Arrays.asList(
            new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0),
            new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0),
            new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0),
            new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0),
            new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0),
            new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0),
            new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0),
            new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0),
            new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0),
            new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5),
            new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0),
            new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0),
            new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0),
            new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5),
            new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0),
            new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0),
            new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0)
        );

        // ✅ 1. Second and Third Highest Salaries
        List<Double> topSalaries = employeeList.stream()
                .map(Employee::getSalary)
                .distinct()
                .sorted(Comparator.reverseOrder())
                .collect(Collectors.toList());

        if (topSalaries.size() >= 2)
            System.out.println("🔹 Second Highest Salary: ₹" + topSalaries.get(1));

        if (topSalaries.size() >= 3)
            System.out.println("🔸 Third Highest Salary: ₹" + topSalaries.get(2));

        // ✅ 2. Count of Male and Female Employees
        Map<String, Long> genderCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("\nGender Count: " + genderCount);

        // ✅ 3. All Department Names
        System.out.println("\nDepartments:");
        employeeList.stream().map(Employee::getDepartment).distinct().forEach(System.out::println);

        // ✅ 4. Employees Joined After 2015
        System.out.println("\nEmployees Joined After 2015:");
        employeeList.stream()
                .filter(e -> e.getYearOfJoining() > 2015)
                .map(Employee::getName)
                .forEach(System.out::println);

        // ✅ 5. Sort by Salary
        System.out.println("\nSorted by Salary:");
        employeeList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary))
                .forEach(e -> System.out.println(e.getName() + " - ₹" + e.getSalary()));

        // ✅ 6. Sort by Age
        System.out.println("\nSorted by Age:");
        employeeList.stream()
                .sorted(Comparator.comparingInt(Employee::getAge))
                .forEach(e -> System.out.println(e.getName() + " - Age: " + e.getAge()));

        // ✅ 7. Count of Employees in Each Department
        Map<String, Long> departmentCount = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        System.out.println("\nDepartment Count: " + departmentCount);

        // ✅ 8. Gender Count in Sales And Marketing
        Map<String, Long> genderInSales = employeeList.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("Sales And Marketing"))
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        System.out.println("\nGender in Sales And Marketing: " + genderInSales);

        // ✅ 9. Average Salary by Gender
        Map<String, Double> avgSalaryByGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("\nAverage Salary by Gender: " + avgSalaryByGender);

        // ✅ 10. Average Salary by Department
        Map<String, Double> avgSalaryByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        System.out.println("\nAverage Salary by Department:");
        avgSalaryByDept.forEach((dept, avgSal) -> System.out.println(dept + ": ₹" + avgSal));

        // ✅ 11. Employees in Each Department
        Map<String, List<String>> employeesByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())));
        System.out.println("\nEmployees in Each Department: " + employeesByDept);

        // ✅ 12. Total and Average Salary of the Organization
        DoubleSummaryStatistics stats = employeeList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("\nTotal Salary: ₹" + stats.getSum());
        System.out.println("Average Salary: ₹" + stats.getAverage());

        // ✅ 13. Group by Age
        Map<Integer, List<Employee>> employeesByAge = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getAge));
        System.out.println("\nEmployees Grouped by Age: " + employeesByAge.keySet());

        // ✅ 14. Gender Count by Department
        Map<String, Map<String, Long>> genderCountByDept = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getGender, Collectors.counting())));
        System.out.println("\nGender Count by Department:");
        genderCountByDept.forEach((dept, genderMap) -> {
            System.out.println("Department: " + dept);
            genderMap.forEach((gender, count) ->
                    System.out.println("  " + gender + ": " + count));
        });

        // ✅ 15. Average Age by Department and Gender
        Map<String, Map<String, Double>> avgAgeByDeptAndGender = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment,
                        Collectors.groupingBy(Employee::getGender,
                                Collectors.averagingInt(Employee::getAge))));
        System.out.println("\nAverage Age by Department and Gender:");
        avgAgeByDeptAndGender.forEach((dept, genderMap) -> {
            genderMap.forEach((gender, avgAge) ->
                    System.out.println("Department: " + dept + ", Gender: " + gender + ", Avg Age: " + avgAge));
        });

        // ✅ 16. Finance & IT Employees - High Salary Order, Unique Names
        System.out.println("\nFinance & IT Employees (Unique, High Salary Order):");
        employeeList.stream()
                .filter(e -> e.getDepartment().equalsIgnoreCase("Account And Finance")
                          || e.getDepartment().equalsIgnoreCase("Infrastructure"))
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .map(Employee::getName)
                .distinct()
                .forEach(System.out::println);
    }
}