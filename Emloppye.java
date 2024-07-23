package veer.com;


import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.DoubleSummaryStatistics;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.OptionalInt;
import java.util.stream.Collectors;
import java.util.stream.Stream;

class Employee {
    private int id;
    private String name;
    private int age;
    private long salary;
    private String gender;
    private String deptName;
    private String city;
    private int yearOfJoining;

    public Employee(int id, String name, int age, long salary, String gender, 
                    String deptName, String city, int yearOfJoining) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.salary = salary;
        this.gender = gender;
        this.deptName = deptName;
        this.city = city;
        this.yearOfJoining = yearOfJoining;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", gender='" + gender + '\'' +
                ", deptName='" + deptName + '\'' +
                ", city='" + city + '\'' +
                ", yearOfJoining='" + yearOfJoining + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public long getSalary() {
        return salary;
    }

    public void setSalary(long salary) {
        this.salary = salary;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public int getYearOfJoining() {
        return yearOfJoining;
    }

    public void setYearOfJoining(int yearOfJoining) {
        this.yearOfJoining = yearOfJoining;
    }
}
public class Emloppye {
	public static void main(String[] args) {
		List<Employee> empList = Arrays.asList(new Employee(1, "abc", 28, 123, "F", "HR", "Blore", 2020),
				new Employee(2, "xyz", 29, 120, "F", "HR", "Hyderabad", 2015),
				new Employee(3, "efg", 30, 115, "M", "HR", "Chennai", 2014),
				new Employee(4, "def", 32, 125, "F", "HR", "Chennai", 2013),
				new Employee(5, "ijk", 22, 150, "F", "IT", "Noida", 2013),
				new Employee(6, "mno", 27, 140, "M", "Nusre", "Gurugram", 2017),
				new Employee(7, "uvw", 26, 130, "F", "software engineer", "Pune", 2016),
				new Employee(8, "pqr", 23, 145, "M", "IT", "Trivandam", 2015),
				new Employee(9, "stv", 25, 160, "M", "IT", "Blore", 2010),
				new Employee(10, "stv", 26, 167, "M", "IT", "Blore", 2010));
	
 
		// Group the employees by city
		Map<String, List<Employee>> empByCity;
		empByCity = empList.stream().collect(Collectors.groupingBy(Employee::getCity));
		System.out.println("Employees grouped by city :: \n" + empByCity);

		// Group the Employees by age.

		Map<Integer, List<Employee>> emByAge = empList.stream().collect(Collectors.groupingBy(Employee::getAge));
		System.out.println(emByAge);

		// count the female and male

		Map<String, Long> numberOfMale = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));

		System.out.print(numberOfMale);

		// Print the names of all deparment in the orgNIZATION

		empList.stream().map(Employee::getDeptName).distinct().forEach(System.out::println);

		// print emloyes whoes age is greater than 28

		empList.stream().filter(e -> e.getAge() < 28).collect((Collectors.toList())).forEach(System.out::println);
		empList.stream().filter(e -> e.getAge() > 28).collect((Collectors.toList())).forEach(System.out::println);

		// find maxium age of emplooyee;

		OptionalInt max1 = empList.stream().mapToInt(Employee::getAge).max();
		if (max1.isPresent())
			System.out.println(max1.getAsInt());

		// find maxium age of emplooyee
		Employee maxAge = empList.stream().max(Comparator.comparingInt(Employee::getAge)).orElseThrow();
		System.out.print(maxAge);

		// find MINIMUM age of emplooyee;

		OptionalInt mini1 = empList.stream().mapToInt(Employee::getAge).min();
		if (mini1.isPresent())
			System.out.println(mini1.getAsInt());

		// find MINIUM age of emplooyee
		Employee minAge = empList.stream().min(Comparator.comparingInt(Employee::getAge)).orElseThrow();
		System.out.print(minAge);

		// Print the average age of male and female

		Map<String, Double> Averagre = empList.stream()
				.collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
		System.out.println(Averagre);

		// print the number of employees in each department;

		Map<String, Long> CountbyDeperment = empList.stream()
				.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));

		for (Map.Entry<String, Long> entry : CountbyDeperment.entrySet()) {
			System.out.print(entry.getKey() + " " + entry.getValue());

			// how many employees are there in each deparment ;

			Map<String, Long> employooeachdeprmet1 = empList.stream()
					.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
			System.out.println(employooeachdeprmet1);
			// Find the employee count in every deprarment

			Map<String, Long> employooeachdeprmet = empList.stream()
					.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
			System.out.println(employooeachdeprmet);

			// Sort by Age

			List<Employee> SortBye = empList.stream().sorted(Comparator.comparingInt(Employee::getAge))
					.collect(Collectors.toList());

			SortBye.forEach(System.out::println);

			// Sort by City
			List<Employee> SortCity = empList.stream().sorted(Comparator.comparing(Employee::getCity))
					.collect(Collectors.toList());

			SortCity.forEach(System.out::println);

			// Sort by Name

			List<Employee> SortName = empList.stream().sorted(Comparator.comparing(Employee::getName))
					.collect(Collectors.toList());

			SortName.forEach(System.out::println);

			// Sort by salary

			List<Employee> Sortsalary = empList.stream().sorted(Comparator.comparingDouble(Employee::getSalary))
					.collect(Collectors.toList());

			Sortsalary.forEach(System.out::println);

			// sort by salary by using descending order
			List<Employee> Sortsalaryrec = empList.stream()
					.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).collect(Collectors.toList());

			Sortsalaryrec.forEach(System.out::println);

			// Sort by depremt

			List<Employee> SortNameDepmanet = empList.stream().sorted(Comparator.comparing(Employee::getDeptName))
					.collect(Collectors.toList());

			SortNameDepmanet.forEach(System.out::println);

			// sort by decorsding using revrse department

			List<Employee> SortNameDepmanet1 = empList.stream()
					.sorted(Comparator.comparing(Employee::getDeptName).reversed()).collect(Collectors.toList());

			SortNameDepmanet1.forEach(System.out::println);

			// sort by decorsding using revrse Name
			List<Employee> SortName1 = empList.stream().sorted(Comparator.comparing(Employee::getName).reversed())
					.collect(Collectors.toList());

			SortName1.forEach(System.out::println);

			// sort by decorsding using revrse city

			List<Employee> Sortcity1 = empList.stream().sorted(Comparator.comparing(Employee::getDeptName).reversed())
					.collect(Collectors.toList());

			SortCity.forEach(System.out::println);

			// sort bye age revesre oderes adcseing order

			List<Employee> Sortage1 = empList.stream().sorted(Comparator.comparingInt(Employee::getAge).reversed())
					.collect(Collectors.toList());

			Sortage1.forEach(System.out::println);

			// find the deparment name which has the highest number of emloyees

			Map.Entry<String, Long> maxnofemoploye = empList.stream()
					.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting())).entrySet().stream()
					.max(Map.Entry.comparingByValue()).get();

			System.out.print(maxnofemoploye.getKey());

			// find the if there any emlopyees from hr Deparment

			Optional<Employee> emphr = empList.stream().filter(e -> e.getDeptName().equalsIgnoreCase("HR")).findAny();
			emphr.ifPresent(employee -> System.out.println(employee));

			// number of emplosyess orgarztion

			System.out.print(empList.stream().count());

			// find the department which has the highest number of employees

			Map<String, Long> employooeachdeprmet11 = empList.stream()
					.collect(Collectors.groupingBy(Employee::getDeptName, Collectors.counting()));
			// System.out.println(employooeachdeprmet1);

			Optional<Map.Entry<String, Long>> Numberdepermhis = employooeachdeprmet11.entrySet().stream()
					.max(Map.Entry.comparingByValue());
			if (Numberdepermhis.isPresent()) {
				System.out.print(Numberdepermhis.get());
			}

			// HIGHEST EXPERINCED EMPLOYESS IN THE ORGAZNIZATION;
			Optional<Employee> seniorEmplooye = empList.stream()
					.sorted(Comparator.comparingInt(Employee::getYearOfJoining)).findFirst();
			System.out.print(seniorEmplooye.get());

			
			
			// ALL SALARY BASED QUESNTION IN ASK INTERVIEW QUESTIONS

			
			
			
			
			
			// PRINT AVERAGE SALARY AND T SUM OTAL SALARY OF THE ORGAZNIZATION

			DoubleSummaryStatistics empSalary = empList.stream()
					.collect(Collectors.summarizingDouble(Employee::getSalary));

			System.out.println(empSalary.getAverage());
			System.out.println(empSalary.getSum());

			// FIND THE SECOND SALARY HIGHEST SALARY IN THE ORGANISATION

			Optional<Employee> empHighest = empList.stream()
					.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(1).findFirst();
			System.out.println(empHighest.get().getSalary());

			// FIND THE THIRDHIEHSET SALARY HIGHEST SALARY IN THE ORGANISATION

			Optional<Employee> empHighest3 = empList.stream()
					.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(2).findFirst();
			System.out.println(empHighest3.get().getSalary());

			// FIND THE HIGHEST SALARY IN THE ORGANISATION
			Optional<Employee> empHighest2 = empList.stream()
					.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).findFirst();
			System.out.println(empHighest2.get().getSalary());

			// NTH HIEHSTEH SALARY

			int n = 10;
			Optional<Employee> ntheihste = empList.stream()
					.sorted(Comparator.comparingDouble(Employee::getSalary).reversed()).skip(n - 1).findFirst();
			System.out.print(ntheihste.get().getSalary());

			// FIND THE LOWSET PAID SALARY IN THE ORGRANIASTTION BASED IN THE ORGANISTION

			Map<String, Optional<Employee>> lowestPiad = empList.stream().collect(Collectors.groupingBy(
					Employee::getGender, Collectors.minBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));

			System.out.println(lowestPiad);

			// FIND THE LOWSET PAID SALARY IN THE ORGRANIASTTION BASED IN THE ORGANISTION

			
			 Optional<Employee> lowestPiad1 = empList.stream().maxBy(
			 Comparator.comparingInt(Employee::getSalary));
			
			 lowestPiad1.ifPresent(emp->{ 
			  System.out.println(emp.getName()+ " ==" +
			  emp.getDeptName() + emp.getSalary());
		

			// FIND THE Highets PAID SALARY IN THE ORGRANIASTTION BASED ON GENDER IN THE
			// ORGANISTION

			Map<String, Optional<Employee>> Hieshest = empList.stream().collect(Collectors.groupingBy(
					Employee::getGender, Collectors.maxBy((t1, t2) -> (int) (t1.getSalary() - t2.getSalary()))));
			System.out.println(Hieshest);

			// HIGHEST SALARY PAID EMPLOYEE BASED ON EACH DEPRMENT
			
			Map<String, Optional<Employee>> highestPaid = Employee.stream()
		            .collect(Collectors.groupingBy(Employee::getDepartment,
		                Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))));

		        for (Map.Entry<String, Optional<Employee>> entry : highestPaid.entrySet()) {
		            System.out.println("Department: " + entry.getKey() +
		                               ", Highest Salary: " + entry.getValue().get().getSalary());
		                               
		                               
		                               
		                               

			// PRINT LIST OF EMPLOYEE SECONDHISHEST RECORD BASED ON DEPARMENT
			
			
			  
			 Map<String, Optional<Employee>> secondHighestPaid = employees.stream()
            .collect(Collectors.groupingBy(Employee::getDepartment,Collectors.collectingAndThen(Collectors.toList(),
            		list -> list.stream().sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                        .skip(1)
                        .findFirst()
                )
            ));

        secondHighestPaid.forEach((department, employeeOpt) -> {
            if (employeeOpt.isPresent()) {
                System.out.println("Department: " + department + 
                                   ", Second Highest Salary Employee: " + employeeOpt.get());
            } else {
                System.out.println("Department: " + department + " does not have enough employees.");
            }
        });
			  
			 
			
			

			// SORT THE EMLOYEE SALARY IN ECH DEPRAMENT IN ASCEDING ORDER
			
			
			
			 Map<String, List<Employee>> sortedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary))
                                        .collect(Collectors.toList())
                        )
                ));

        sortedByDepartment.forEach((department, empList) -> {
            System.out.println("Department: " + department);
            empList.forEach(System.out::println);
        });
			 
			
			

			// SORT THE EMPLOYEE SALARY IN EACH DEPRAMENT IN DESCENDING ORDER

			
			
			 Map<String, List<Employee>> sortedByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .collect(Collectors.toList())
                        )
                ));

        sortedByDepartment.forEach((department, empList) -> {
            System.out.println("Department: " + department);
            empList.forEach(System.out::println);
        });
			 
			
			// FIND THE AVERAGE SALARY OF THE MALE AND FEMALE EMPLOYEE
			
			
			 
			 Map<String, Double> averageSalariesByGender = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        averageSalariesByGender.forEach((gender, avgSalary) -> 
                System.out.println("Gender: " + gender + ", Average Salary: " + avgSalary)
        );
			 

			// FIND THE AVAREGER SALARY EACH DEPERMENT
			
			
			 Map<String, Double> averageSalariesByDepartment = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.averagingDouble(Employee::getSalary)
                ));

        averageSalariesByDepartment.forEach((department, avgSalary) -> 
                System.out.println("Department: " + department + ", Average Salary: " + avgSalary)
        );
			 

			/// FIND THE HIGHEST PAID SALARY IN THE ORGANISTION PAID OR GENDER

			/// FIND THE LOWTEST PAID SALARY IN THE ORGANISTION PAID OR GENDER

			// TOP 3 SALARY BASE ON DEPARMENT

			// THIRED HIGHEST SALARY BASED ON DEPARMENT

			// TOP 3 SALARY BASED ON ORGANIZATION

			///
			
     // Find the highest paid salary in the organization by gender
        Map<String, Optional<Employee>> highestPaidByGender = employees.stream()
                .collect(Collectors.groupingBy(
                    Employee::getGender,
                    Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));

            highestPaidByGender.forEach((gender, employee) -> 
                System.out.println(gender + ": " + (employee.isPresent() ? employee.get() : "No employees"))
            );

        // Find the lowest paid salary in the organization by gender
            Map<String, Optional<Employee>> highestPaidByGender = employees.stream()
                    .collect(Collectors.groupingBy(
                        Employee::getGender,
                        Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))
                    ));

                highestPaidByGender.forEach((gender, employee) -> 
                    System.out.println(gender + ": " + (employee.isPresent() ? employee.get() : "No employees"))
                );
        // Find the top 3 salaries based on department
                Map<String, List<Employee>> top3SalariesByDepartment = employees.stream()
                        .collect(Collectors.groupingBy(
                            Employee::getDepartment,
                            Collectors.collectingAndThen(
                                Collectors.toList(),
                                list -> list.stream()
                                    .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                    .limit(3)
                                    .collect(Collectors.toList())
                            )
                        ));

                    top3SalariesByDepartment.forEach((department, top3Employees) -> {
                        System.out.println(department + ": ");
                        top3Employees.forEach(System.out::println);
                    });

        // Find the third highest salary based on department
                    Map<String, Optional<Employee>> thirdHighestSalaryByDepartment = employees.stream()
                            .collect(Collectors.groupingBy(
                                Employee::getDepartment,
                                Collectors.collectingAndThen(
                                    Collectors.toList(),
                                    list -> list.stream()
                                        .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                        .skip(2)
                                        .findFirst()
                                )
                            ));

                        thirdHighestSalaryByDepartment.forEach((department, employee) -> 
                            System.out.println(department + ": " + (employee.isPresent() ? employee.get() : "No third highest salary"))
                        );

        // Find the top 3 salaries in the organization
                        List<Employee> top3Salaries = employees.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .limit(3)
                                .collect(Collectors.toList());

                            top3Salaries.forEach(System.out::println);
                            
                            
                             
                             
                             // Print average salary and total salary of the organization
        DoubleSummaryStatistics empSalary = empList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary: " + empSalary.getAverage());
        System.out.println("Total Salary: " + empSalary.getSum());

        // Find the second highest salary in the organization
        Optional<Employee> secondHighest = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1).findFirst();
        System.out.println("Second Highest Salary: " + secondHighest.map(Employee::getSalary).orElse(null));

        // Find the third highest salary in the organization
        Optional<Employee> thirdHighest = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(2).findFirst();
        System.out.println("Third Highest Salary: " + thirdHighest.map(Employee::getSalary).orElse(null));

        // Find the highest salary in the organization
        Optional<Employee> highest = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .findFirst();
        System.out.println("Highest Salary: " + highest.map(Employee::getSalary).orElse(null));

        // Nth highest salary
        int n = 3; // example for the 3rd highest
        Optional<Employee> nthHighest = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(n - 1).findFirst();
        System.out.println(n + "th Highest Salary: " + nthHighest.map(Employee::getSalary).orElse(null));

        // Find the lowest paid salary by gender
        Map<String, Optional<Employee>> lowestPaidByGender = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getGender,
                    Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))
                ));
        System.out.println("Lowest Paid by Gender: " + lowestPaidByGender);

        // Find the highest paid salary by gender
        Map<String, Optional<Employee>> highestPaidByGender = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getGender,
                    Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));
        System.out.println("Highest Paid by Gender: " + highestPaidByGender);

        // Find the highest paid salary in each department
        Map<String, Optional<Employee>> highestPaidByDept = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDeptName,
                    Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));
        System.out.println("Highest Paid by Department: " + highestPaidByDept);

        // Find the second highest salary in each department
        Map<String, Optional<Employee>> secondHighestByDept = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDeptName,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .skip(1)
                                .findFirst()
                    )
                ));
        System.out.println("Second Highest by Department: " + secondHighestByDept);

        // Sort the employee salaries in each department in ascending order
        Map<String, List<Employee>> sortedByDeptAsc = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDeptName,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary))
                                .collect(Collectors.toList())
                    )
                ));
        System.out.println("Salaries by Department (Ascending): " + sortedByDeptAsc);

        // Sort the employee salaries in each department in descending order
        Map<String, List<Employee>> sortedByDeptDesc = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDeptName,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .collect(Collectors.toList())
                    )
                ));
        System.out.println("Salaries by Department (Descending): " + sortedByDeptDesc);

        // Find the average salary by gender
        Map<String, Double> avgSalaryByGender = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getGender,
                    Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println("Average Salary by Gender: " + avgSalaryByGender);

        // Find the average salary by department
        Map<String, Double> avgSalaryByDept = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDeptName,
                    Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println("Average Salary by Department: " + avgSalaryByDept);

        // Find the top 3 salaries in the organization
        List<Employee> top3Salaries = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Top 3 Salaries in Organization: " + top3Salaries);
    
                             
//
				// Find any employee from the HR department and print
        Optional<Employee> emphr = empList.stream()
                .filter(e -> e.getDeptName().equalsIgnoreCase("HR"))
                .findAny();
        emphr.ifPresent(employee -> System.out.println(employee));

        // Additional code for previous tasks
        // Print average salary and total salary of the organization
        DoubleSummaryStatistics empSalary = empList.stream()
                .collect(Collectors.summarizingDouble(Employee::getSalary));
        System.out.println("Average Salary: " + empSalary.getAverage());
        System.out.println("Total Salary: " + empSalary.getSum());

        // Find the second highest salary in the organization
        Optional<Employee> secondHighest = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(1).findFirst();
        System.out.println("Second Highest Salary: " + secondHighest.map(Employee::getSalary).orElse(null));

        // Find the third highest salary in the organization
        Optional<Employee> thirdHighest = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(2).findFirst();
        System.out.println("Third Highest Salary: " + thirdHighest.map(Employee::getSalary).orElse(null));

        // Find the highest salary in the organization
        Optional<Employee> highest = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .findFirst();
        System.out.println("Highest Salary: " + highest.map(Employee::getSalary).orElse(null));

        // Nth highest salary
        int n = 3; // example for the 3rd highest
        Optional<Employee> nthHighest = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .skip(n - 1).findFirst();
        System.out.println(n + "th Highest Salary: " + nthHighest.map(Employee::getSalary).orElse(null));

        // Find the lowest paid salary by gender
        Map<String, Optional<Employee>> lowestPaidByGender = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getGender,
                    Collectors.minBy(Comparator.comparingDouble(Employee::getSalary))
                ));
        System.out.println("Lowest Paid by Gender: " + lowestPaidByGender);

        // Find the highest paid salary by gender
        Map<String, Optional<Employee>> highestPaidByGender = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getGender,
                    Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));
        System.out.println("Highest Paid by Gender: " + highestPaidByGender);

        // Find the highest paid salary in each department
        Map<String, Optional<Employee>> highestPaidByDept = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDeptName,
                    Collectors.maxBy(Comparator.comparingDouble(Employee::getSalary))
                ));
        System.out.println("Highest Paid by Department: " + highestPaidByDept);

        // Find the second highest salary in each department
        Map<String, Optional<Employee>> secondHighestByDept = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDeptName,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .skip(1)
                                .findFirst()
                    )
                ));
        System.out.println("Second Highest by Department: " + secondHighestByDept);

        // Sort the employee salaries in each department in ascending order
        Map<String, List<Employee>> sortedByDeptAsc = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDeptName,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary))
                                .collect(Collectors.toList())
                    )
                ));
        System.out.println("Salaries by Department (Ascending): " + sortedByDeptAsc);

        // Sort the employee salaries in each department in descending order
        Map<String, List<Employee>> sortedByDeptDesc = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDeptName,
                    Collectors.collectingAndThen(
                        Collectors.toList(),
                        list -> list.stream()
                                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                                .collect(Collectors.toList())
                    )
                ));
        System.out.println("Salaries by Department (Descending): " + sortedByDeptDesc);

        // Find the average salary by gender
        Map<String, Double> avgSalaryByGender = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getGender,
                    Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println("Average Salary by Gender: " + avgSalaryByGender);

        // Find the average salary by department
        Map<String, Double> avgSalaryByDept = empList.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDeptName,
                    Collectors.averagingDouble(Employee::getSalary)
                ));
        System.out.println("Average Salary by Department: " + avgSalaryByDept);

        // Find the top 3 salaries in the organization
        List<Employee> top3Salaries = empList.stream()
                .sorted(Comparator.comparingDouble(Employee::getSalary).reversed())
                .limit(3)
                .collect(Collectors.toList());
        System.out.println("Top 3 Salaries in Organization: " + top3Salaries);
    }
}
