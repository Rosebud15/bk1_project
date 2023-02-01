import java.util.*;
import java.util.Scanner;

public class BK1_game {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);

        System.out.println("Hello trainer! You have begun your college journey!");
        System.out.println("What is your name?");
        String playerName = keyboard.next();
        Player player = new Player(playerName);
        System.out.println("Hello, "+player.getName());

        int score = 0;
        Test test1 = new Test();
        System.out.println("You've encountered an enemy with " +test1.getHealth()+" hp!");
        Import(test1.getName(), test1.getHealth());
        do {
            System.out.println("You are in round: "+player.getTime());
            String[] attacked = test1.attack();
            player.setHP(Integer.parseInt(attacked[1]));
            System.out.println("You were attacked with: "+attacked[0]+"! You lost "+attacked[1]+" health!");
            System.out.println("You still have "+player.getPlayer_HP()+" hp remaining! Stay strong!");
            System.out.println();
            System.out.println("Which action to choose?");
            System.out.println("1. Do homework( Enemy's HP -10 )");
            System.out.println("2. Call TAs for help( Your HP +10 ) (Before Time 10)");
            System.out.println("3. Search information online( Your HP +5 )");
            System.out.println();
            int x = StdIn.readInt();
            if(x<=3){
            System.out.println("Your choice is "+x);
            }
            else{
                System.out.println("not a valid choice.");
                x = StdIn.readInt();
            }
            player.action(x);
            if(x==1){
                test1.hurt(10);
                System.out.println(test1.getHealth());
            }
            Import(test1.getName(), test1.getHealth());
            Import(player.getAction(x), player.getPlayer_HP(), 50);
            System.out.println("The enemy still has "+test1.getHealth()+" hp remaining!");
            System.out.println(test1.selfHeal());
            System.out.println();
            System.out.println();
        } while((player.getPlayer_HP() > 0 && test1.checkAlive()) && (player.getTime() <= 20));

        if (player.getPlayer_HP() <= 0 || player.getTime() > 20){
            System.out.println("You lost! Time to work late! Better luck next time!");
        }
        else{
            Import();
            System.out.println("Congrats! You passed! Go get some sleep.");
        }
    }

    public static void Import(String filename, int hp, int duration){
        StdDraw.setXscale(0,50);
        StdDraw.setYscale(0,50);
        double x= 15.0+(Math.random()*5);
        double y= 15.0+(Math.random()*5);

        StdDraw.picture(x,y,filename);
        StdDraw.text(x,y+5.0,"HP: "+hp);
        StdDraw.show(duration);
    }

    public static void Import(String filename, int hp){
        StdDraw.clear();
        StdDraw.setXscale(0,50);
        StdDraw.setYscale(0,50);
        double x= 35.0+(Math.random()*5);
        double y= 35.0+(Math.random()*5);

        StdDraw.picture(x,y,filename);
        StdDraw.text(x,y+5.0,"HP: "+hp);
        StdDraw.show();
    }

    public static void Import(){
        StdDraw.clear();
        StdDraw.setXscale(0,50);
        StdDraw.setYscale(0,50);
        double x= 25.0;
        double y= 25.0;

        StdDraw.picture(x,y,"getSleep.JPG");
        StdDraw.text(x,y+5.0,"ZZZZZZZZZZZZ");
        StdDraw.show();
    }


}
