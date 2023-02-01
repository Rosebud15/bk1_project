import java.io.IOException;
import java.util.*;
public class Player {
    private int time = 0;
    private int Player_HP = 100;
    private String name = "";
    private String [] actions = {"reading.JPG", "arcTutor.JPG", "google.jpg"};
   
    public Player (String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }

    public int getPlayer_HP(){
        return Player_HP;
    }
    public int getTime(){
        return time;
    }

    public String getAction(int num){
        return actions[num-1];
    }

    public void action(int num){
        if (num == 1) {
            System.out.println("Enemy's HP decreased!");
        }
        else if (num == 2) {
            if (getTime() <=10 ) {
                System.out.println("Your HP increased!");
                Player_HP+=10;
            }
            else System.out.println("To late to call for help!");
        }
        else if (num==3){
            System.out.println("Your HP increased!");
            Player_HP+=5;
        }
        time ++;
        
    }

    public void setHP(int atk){
        Player_HP = Player_HP - atk;
    }

}
