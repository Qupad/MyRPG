package MyRPG;

import java.util.Scanner;

/**
 * Created by Maniak on 27.08.2017.
 */
public class Character {
    Scanner sc = new Scanner(System.in);
    static int hp = 100;
    static int experience;
    static int mcattack = 30;
    static String enemy;
    static int enemyhp;
    static int enemyattack;
    Inventory reward = new Inventory();


    void mainCharacter(){
        hp = 100;
        mcattack = 10;
    }

    void Unicorn(){
        enemy = "Unicorn";
        enemyhp = 50;
        enemyattack = 20;
    }

    void fight(){
        if(hp <= 0) {
            System.out.println("\t\t\tU DIED");
            System.exit(0);
        }else if (enemyhp <= 0) {
            String rewardItem = reward.randomTreasure();
            reward.add(rewardItem);
            System.out.println("\t\t\tU win\nBody jst disappear and on the ground u found: "+rewardItem);
        }else {
            System.out.println("U fight against " + enemy +
                    "\nYour hp: " + hp + "\t\t\tEnemy hp: " + enemyhp +
                    "\n1-Attack\n2-Run");
            int choice = sc.nextInt();
            if (choice == 1) {
                enemyhp -= mcattack;
                hp -= enemyattack;
                fight();
            } else if (choice == 2) {
                System.out.println("U escape, but get hitted.");
                hp -= enemyattack;
            } else
                fight();
        }
    }

}
