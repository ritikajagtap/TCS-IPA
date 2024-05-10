import java.util.*;
/* Ritika Jagtap */
public class ValidString{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        List<String> arr = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine(); 
        for(int i=0; i<n; i++){
            arr.add(scanner.nextLine());
        }
        Solution s = new Solution();
        s.f(arr);
        scanner.close();
    }
}
class Solution{
    public void f(List<String> arr){
        int valid = 0;
        int invalid = 0;
        for(int i=0;i<arr.size(); i++){
            String tmp = arr.get(i);
            if(tmp.matches("[a-zA-Z ]+")){
                valid++;
            }else{
                invalid++;
            }
        }
        System.out.println("The number of valid strings: " + valid);
        System.out.println("The number of invalid strings: " + invalid);
    }
}