import java.util.HashMap;
import java.util.*;
/* Ritika Jagtap */
public class twoSum{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        System.out.println("enter the number: ");
        int n = scanner.nextInt();
        List<Integer> nums = new ArrayList<>();
        for(int i=0; i<n; i++){
            nums.add(scanner.nextInt());
        }
        System.out.println("Enter the target sum: ");
        int target = scanner.nextInt();

        Solution sol = new Solution();
        List<Integer> ans = sol.f(nums, target);
        System.out.println(ans.get(0) + " " + ans.get(1));
        scanner.close();
    }
    
}
class Solution{
    public List<Integer> f(List<Integer> nums, int target){
        List<Integer> ans = new ArrayList<>();
        HashMap<Integer, Integer> mp = new HashMap<>();
        for(int i=0; i<nums.size(); i++){
            if(mp.containsKey(target-nums.get(i))){
                ans.add(mp.get(target-nums.get(i)));
                ans.add(i);
                break;
            }else{
                mp.put(nums.get(i), i);
            }
        }
        return ans;
    }
}