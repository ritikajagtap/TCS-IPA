import java.util.*;

public class Chess{
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        scanner.nextLine();
        ChessPlayer[] chs = new ChessPlayer[n];
        for(int i=0;i<n; i++){
            int id = scanner.nextInt();
            scanner.nextLine();
            String skill = scanner.nextLine();
            String level = scanner.nextLine();
            int pts = scanner.nextInt();
            scanner.nextLine();
            chs[i] = new ChessPlayer(id, skill, level, pts);
        }
        // for(int i=0; i<n; i++){
        //     System.out.println("ID: " + chs[i].getPlayerId());
        //     System.out.println("Skill: " + chs[i].getSkill());
        //     System.out.println("Level: " + chs[i].getLevel());
        //     System.out.println("Points: " + chs[i].getPoints());
        // }
        System.out.println("Enter the Skill you want to calculate total sum of point for: ");
        String sk = scanner.nextLine();
        int ans1 = findPointsForGivenSkill(chs, sk);
        System.out.println("Total Score for skill " + sk + "is: " + ans1);
        System.out.println("Enter the Skill and the Level: ");
        String sk2 = scanner.nextLine();
        String lvl = scanner.nextLine();
        System.out.println("Player with given skill and level is of ID: " + getPlayerBasedOnLevel(chs, sk2, lvl));
        

    }
    public static int findPointsForGivenSkill(ChessPlayer[] chs, String skill){
        int cnt = 0;
        for(int i=0; i<chs.length; i++){
            if(chs[i].getSkill().equalsIgnoreCase(skill)){
                cnt += chs[i].getPoints();
            }
        }
        return cnt;
    }
    public static int getPlayerBasedOnLevel(ChessPlayer[] chs, String skill, String level){
        for(int i=0; i<chs.length; i++){
            if(chs[i].getSkill().equalsIgnoreCase(skill) && chs[i].getLevel().equalsIgnoreCase(level) && chs[i].getPoints()>20){
                return chs[i].getPlayerId();
            }
        }
        return -1;
    }

}
class ChessPlayer{
//     playerId - int 
// skill - String 
// level - String 
// points - int
    private int playerId;
    private String skill;
    private String level;
    private int points;
    public ChessPlayer( int playerId, String skill, String level, int points){
        this.playerId = playerId;
        this.skill = skill;
        this.level = level;
        this.points = points;
    }

    // getters
    public int getPlayerId(){
        return this.playerId;
    }
    public String getSkill(){
        return this.skill;
    }
    public String getLevel(){
        return this.level;
    }
    public int getPoints(){
        return this.points;
    }

}