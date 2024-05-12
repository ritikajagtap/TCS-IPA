import java.util.*;
/* Ritika Jagtap */

public class printNElementsFromMid{
    public static void main(String[] args){
      Scanner scanner = new Scanner(System.in);
      System.out.println("Enter the string: ");
      String str = scanner.nextLine();
      int n  = scanner.nextInt();
      int mid = str.length()/2;
      //System.out.println("mid of string is : " + mid + " " + str.charAt(mid));
      int ind = Math.min(mid+n, str.length());
      System.out.println(str.substring(mid, ind));
    }
}
