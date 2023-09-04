import java.util.*;

class Employee {
    private String employeeID;
    private String name;
    private int age;
    private double salary;

    public Employee(String employeeID, String name, int age, double salary) {
        this.employeeID = employeeID;
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return String.format("%-8s %-10s %-3d %-8.2f", employeeID, name, age, salary);
    }
}

class EmployeeComparator implements Comparator<Employee> {
    private int sortBy;

    public EmployeeComparator(int sortBy) {
        this.sortBy = sortBy;
    }

    @Override
    public int compare(Employee emp1, Employee emp2) {
        switch (sortBy) {
            case 1:
                return Integer.compare(emp1.getAge(), emp2.getAge());
            case 2:
                return emp1.getName().compareTo(emp2.getName());
            case 3:
                return Double.compare(emp1.getSalary(), emp2.getSalary());
            default:
                throw new IllegalArgumentException("Invalid sorting parameter");
        }
    }
}

public class assignment__04 {
    public static void main(String[] args) {
        List<Employee> employees = new ArrayList<>();
        employees.add(new Employee("161E90", "Raman", 41, 56000));
        employees.add(new Employee("161F91", "Himadri", 38, 67500));
        employees.add(new Employee("161F99", "Jaya", 51, 82100));
        employees.add(new Employee("171E20", "Tejas", 30, 55000));
        employees.add(new Employee("171G30", "Ajay", 45, 44000));

        Scanner scanner = new Scanner(System.in);
        System.out.println("Sort Employee Table by:");
        System.out.println("1. Age");
        System.out.println("2. Name");
        System.out.println("3. Salary");
        System.out.print("Enter your choice: ");
        int sortBy = scanner.nextInt();

        Collections.sort(employees, new EmployeeComparator(sortBy));

        System.out.println("Sorted Employee Table:");
        System.out.println("Employee ID Name      Age Salary (PM)");
        System.out.println("-----------------------------------");
        for (Employee emp : employees) {
            System.out.println(emp);
        }
    }
}
