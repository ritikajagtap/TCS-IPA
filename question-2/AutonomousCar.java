import java.util.*;

public class AutonomousCar{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = 4;
        Car[] cr = new Car[4];
        for(int i=0; i<4; i++){
            int id = scanner.nextInt();
            scanner.nextLine();
            String brand = scanner.nextLine();
            int tests = scanner.nextInt();
            int testsPassed = scanner.nextInt();
            scanner.nextLine();
            String env = scanner.nextLine();
            // scanner.nextLine();
            cr[i] = new Car(id, brand, tests, testsPassed, env);
        }
        System.out.println("Enter the Environment: ");
        String en = scanner.nextLine();
        System.out.println("Total sum is: " + findTestPassedByEnv(cr, en));
        System.out.println("Enter the Brand: ");
        String br = scanner.nextLine();
        Car ans = updateCarGrade(cr, br);
        System.out.println("Grade : " + ans.getBrand() + "::" + ans.getGrade());


    }
    static int findTestPassedByEnv(Car[] cr, String env){
        int sm = 0;
        for(Car x: cr){
            if(x.getEnvironment().equalsIgnoreCase(env)){
                sm += x.getNoOfTestsPassed();
            }
        }
        return sm;
    }
    static Car updateCarGrade(Car[] cr, String brand){
        for(int i=0; i<4; i++){
            if(cr[i].getBrand().equalsIgnoreCase(brand)){
                int rating  = (cr[i].getNoOfTestsPassed()*100)/ cr[i].getNoOfTestsConducted();
                if(rating>=80){
                    cr[i].setGrade("A1");
                }else{
                    cr[i].setGrade("B1");
                }
                return cr[i];
            }
        }
        return null;
    }
}
class Car{
    private int carld;
    private String brand;
    private int noOfTestsConducted;
    private int noOfTestsPassed;
    private String environment;
    private String grade;
    public Car(int carld, String brand, int noOfTestsConducted, int noOfTestsPassed, String environment){
        this.carld = carld;
        this.brand = brand;
        this.noOfTestsConducted = noOfTestsConducted;
        this.noOfTestsPassed = noOfTestsPassed;
        this.environment = environment;
    }
    // getters
    public int getId(){return this.carld;}
    public String getBrand(){return this.brand;}
    public int getNoOfTestsConducted(){return this.noOfTestsConducted;}
    public int getNoOfTestsPassed(){return this.noOfTestsPassed;}
    public String getEnvironment(){return this.environment;}
    public String getGrade(){return this.grade;}
    //  setters
    public void setGrade(String grade){this.grade = grade;}
}