package MyRPG;

import java.util.Scanner;

/**
 * Created by Maniak on 27.08.2017.
 */
class Character {
    Scanner sc = new Scanner(System.in);
    static int hp;
    static int experience;
    static int mcattack;
    static String enemy;
    static int enemyhp;
    static int enemyattack;
    Inventory reward = new Inventory();

    void enemy(String enemy){
        this.enemy = enemy;
        switch (enemy){
            case "Unicorn": enemyhp = 50; enemyattack = 20; break;
            case "Dragon": enemyhp = 200; enemyattack = 90; break;
        }
    }
    void mainCharacter(){
        hp = 100;
        mcattack = 10;
    }

    void fight(){
        if(hp <= 0) {
            System.out.println("\t\t\tU DIED");
            System.exit(0);
        }else if (enemyhp <= 0) {
            String rewardItem = reward.randomTreasure();
            reward.add(rewardItem);
            experience += 1;
            System.out.println("\t\t\tU win\nBody jst disappear and on the ground u found: "+rewardItem);
        }else {
            System.out.println("U fight against " + enemy +
                    "\nYour hp: " + hp + "\t\t\tEnemy hp: " + enemyhp +
                    "\n1-Attack\n2-Run");
            String choice = sc.next();
            if (choice.equals("1")) {
                enemyhp -= mcattack;
                hp -= enemyattack;
                fight();
            } else if (choice.equals("2")) {
                System.out.println("U escape, but get hitted. ");
                hp -= enemyattack;
                if (hp <= 0) {
                    System.out.println("\t\t\tU DIED");
                    System.exit(0);
                }
            } else
                fight();
        }
    }

}
