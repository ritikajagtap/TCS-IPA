import java.util.*;
/* Ritika Jagtap */
public class validInputString{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        String s1 = scanner.nextLine();
        String s2 = scanner.nextLine();
        Solution sol = new Solution();
        if(sol.f(s1, s2)){
            System.out.println("Input is valid.");
        }else{
            System.out.println("Input is invalid.");

        }
    }
}
class Solution{
    public boolean f(String s1, String s2){
        HashMap<Character, Integer> mp = new HashMap<>();
        for(int i=0; i<s2.length(); i++){
            char tmp = s2.charAt(i);
            mp.put(tmp, mp.getOrDefault(tmp, 0)+1);
        }
        for(int i=0; i<s1.length(); i++){
            char c = s1.charAt(i);
            if(!mp.containsKey(c)){return false;}
        }
        return true;
    }
}