import java.util.*;
/* Ritika Jagtap */
public class ValidIndex{
    public static void main(String args[]){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the length of array : ");
        List<String> arr = new ArrayList<>();
        int n = scanner.nextInt();
        scanner.nextLine(); 
        for(int i=0; i<n; i++){
            arr.add(scanner.nextLine());
        }
        String str = scanner.nextLine();
        Solution sol = new Solution();
        System.out.println("The index of the target string is: " + sol.f(arr, str));
        scanner.close();
    }
}
class Solution{
    public Integer f(List<String> arr, String str){
        for(int i=0; i<arr.size(); i++){
            String tmp = arr.get(i);
            if(tmp.equals(str)){
                return i;
            }
        }
        return -1;
    }
}
