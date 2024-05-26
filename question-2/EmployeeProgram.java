import java.util.*;

public class EmployeeProgram{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
//         employeeld - int
// name - String
// branch - String
// rating - double
// company Transport - boolean
        System.out.println("Input the number n: ");
        int n = scanner.nextInt();
        scanner.nextLine();
        Employee[] emp = new Employee[n];
        for(int i=0; i<n; i++){
            System.out.println("Input the name: ");
            String name = scanner.nextLine();
            System.out.println("Input the branch: ");
            String branch = scanner.nextLine();
            System.out.println("Input the rating: ");
            double rating  = scanner.nextDouble();
            System.out.println("Input the tran: ");
            boolean transport = scanner.nextBoolean();
            scanner.nextLine();
            emp[i] = new Employee(name, branch, rating, transport);
        }
        // for(Employee employees : emp){
        //     System.out.println("Name: " + employees.getName());
        //     System.out.println("Branch: " + employees.getBranch());
        //     System.out.println("Rating: " + employees.getRating());
        //     System.out.println("Transport: " + employees.getTransport());
        // }
        System.out.println("Enter the string of branch : ");

        String br = scanner.nextLine();
        int ans1 = countOfEmployees(emp,br);
        if(ans1!=0)
        {
            System.out.println(ans1);
        }

        System.out.println("Employees with second highest rating are: ");
        Employee[] secHighestEmps = employeeWithSecondHighestRating(emp);
        for(Employee x: secHighestEmps){
            System.out.println(x.getName());
        }

    }
    public static int countOfEmployees(Employee[] emp, String br){
        int cnt = 0;
        for( Employee emps : emp){
            if(emps.getBranch().equalsIgnoreCase(br) && emps.getTransport() == true){
                cnt++;
            }
        }
        if(cnt>0){return cnt;}else{return 0;}
    }
    public static Employee[] employeeWithSecondHighestRating(Employee[] emp){
        double secHig = 0;
        double mx = 0;
        for(Employee x: emp){
            if(mx< x.getRating()){
                mx = x.getRating();
            }
        }
        for(Employee x: emp){
            if(x.getRating()>secHig && x.getRating() < mx){
                secHig = x.getRating();
            }
        }
        List<Employee> secondHighestRatedEmployees = new ArrayList<>();
        for (Employee e : emp) {
            if (e.getRating() == secHig) {
                secondHighestRatedEmployees.add(e);
            }
        }

        // Convert the list to an array and return
        return secondHighestRatedEmployees.toArray(new Employee[0]);

    }
}
class Employee{
    private String name;
    private String branch;
    private double rating;
    private boolean transport;

    public Employee(String name, String branch, double rating, boolean transport){
        this.name = name;
        this.branch = branch;
        this.rating = rating;
        this.transport = transport;
    }
    // getters
    public String getName(){
        return this.name;
    }
    public String getBranch(){
        return this.branch;
    }
    public double getRating(){
        return this.rating;
    }
    public boolean getTransport(){
        return this.transport;
    }
    // setters
    public void setName(String name){
        this.name = name;
    }
    public void setBranch(String branch){
        this.branch = branch;
    }
    public void setRating(double rating){
        this.rating = rating;
    }
    public void setTransport(boolean transport){
        this.transport = transport;
    }
}