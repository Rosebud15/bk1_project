import java.util.*;
import java.util.Scanner;

public class Test{
        private String name = "";
        private int health = 0;
        private int initialHealth = 0;
        private String[] moveset = new String[4];
        private int[] damage = new int[4];
        private String[] enemies = {"test.JPG", "assignment.JPG","popQuiz.JPG"};
        
        public Test(int health, String moveA, String moveB, String moveC, String moveD){
            int enemynum = (int)(Math.random()*3);
            this.name = enemies[enemynum];
            this.health = health;
            this.initialHealth = health;
            this.moveset[0] = moveA;
            this.moveset[1] = moveB;
            this.moveset[2] = moveC;
            this.moveset[3] = moveD;
            for(int i=0; i<4; i++){
                this.damage[i] = (int)(Math.random()*15+5);
            }
        }

        public Test(){
            int enemynum = (int)(Math.random()*3);
            this.name = enemies[enemynum];
            this.health = 100;
            this.moveset[0] = "20 questions";
            this.moveset[1] = "no cheat sheet";
            this.moveset[2] = "5 minutes remaining!";
            this.moveset[3] = "you don't remember your notes!";
            for(int i=0; i<4; i++){
                this.damage[i] = (int)(Math.random()*5+5);
            }
        }

        public int getHealth(){
            return health;
        }
        public String getName(){
            return name;
        }

        public String[] attack(){
            int moveNum = (int)(Math.random()*3+1);
            String damage = damageTaken(moveNum);
            String[] move = {moveset[moveNum], damage};
            return move;
        }
        public String damageTaken(int i){
            return ""+damage[i];
        }

        public void hurt(int atk){
            this.health = this.health-atk;
        }

        public String selfHeal(){
            if(health < initialHealth*0.7){
                Random r = new Random();
                double d = r.nextDouble();
                if(d<0.5){
                    health = health+(int)(initialHealth*0.3);
                    return "The enemy just healed by "+(int)(initialHealth*0.3)+" hp!";
                }
            }
            return "The enemy tried to heal, but failed!";
        }

        public boolean checkAlive(){
            if(health > 0) return true;
            else return false;
        }

}
