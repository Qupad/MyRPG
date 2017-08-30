package MyRPG;

import java.lang.*;
import java.util.Scanner;

/**
 * Created by Maniak on 22.08.2017.
 */
class Ivent {
    Map map = new Map();
    Quest quest = new Quest();
    Character character = new Character();
    Inventory inventory = new Inventory();
    Scanner sc = new Scanner(System.in);
    int choice;
    private int position;

    void position(int position){
        this.position = position;
        if(position == 1){
            System.out.print("forest");
        } else if (position == 0){
            System.out.print("mountain");
        } else if (position == 3){
            System.out.print("city");
        }
    }
    void ivent(){

        if(position == 1) {
            if (quest.mushroomQ) {
                System.out.println("1-Search for some mushrooms\n2-Do other stuff");
                choice = sc.nextInt();
                if (choice == 1) {
                    System.out.println("U found one mushroom!");
                    inventory.add("Mushroom");
                }
            } else {
                if (((int) (Math.random() * 2)) == 1) {
                    System.out.println("Unicorn has being appeared!");
                    iventUnicorn();
                } else if (((int) (Math.random() * 2)) == 0)
                    System.out.println("The band of rogue walk near u. Tshhh.");
                else
                    System.out.println("Nothing special here");
            }
        }
        if(position == 0){
            if(((int)(Math.random()*2)) == 1)
                System.out.println("Dragon!");
            else if (((int)(Math.random()*2)) == 0)
                System.out.println("Not a dragon.");
        }
        if(position == 3){
            System.out.println("Great old city.");
            iventCity();
        }
    }
    private void iventUnicorn(){
        System.out.println("1-Kill\n2-Pass");
        choice = sc.nextInt();
        if (choice == 1){
            character.Unicorn();
            character.fight();
        } else if (choice == 2){
            System.out.println("U successfully passed unicorn");
        } else{
            iventUnicorn();
        }
    }
    private void iventCity(){
        System.out.println("1-Buy stuff\n2-Talk with citizens\n3-Get out from the city");
        choice = sc.nextInt();
        if (choice == 1){
            shop();
        }else if (choice == 2){
            quest.MushroomQuest();
        }else
            System.out.println("Out");
    }
    void shop(){
        System.out.println("Welcome to \"Treasure & Shit\"\nLook at my stuff."+
        "\n1-Sword(10)\n2-Exit");
        choice = sc.nextInt();
        if(choice == 1){
            if(Inventory.money >= 10) {
                Inventory.Inventory.add("Sword");
                inventory.money -= 10;
                System.out.println("Thank u for purchase!");
                shop();
            }
            else {
                System.out.println("No enough money, son");
                shop();
            }
        }
        else if(choice == 2){}
        else{
            System.out.println("I don't have that");
            shop();
        }
    }
}
