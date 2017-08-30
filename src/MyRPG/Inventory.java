package MyRPG;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by Maniak on 26.08.2017.
 */
public class Inventory {
    static ArrayList<String> Inventory = new ArrayList<>();
    static int money = 0;
    Items items = new Items();
    Character character = null;
    Scanner sc = new Scanner(System.in);
    int choice;

    void InventoryMenu(){
        if (Inventory.isEmpty()) {
            System.out.println("Empty\nMoney: "+money);
        } else {
            for(int i = 0;i < Inventory.size();i++)
                System.out.print(i+1+"-"+Inventory.get(i)+" ");
            System.out.println("\n\tHP: "+character.hp+"\tMoney: "+money+"\n1-Use item\n2-Drop item\n3-Equip\n4-Close backpack");
            choice = sc.nextInt();
            if(choice == 1){
                System.out.println("Write number of item that u want to use");
                choice = sc.nextInt();
                useItem(choice-1);
            }else if(choice == 2){
                System.out.println("Write number of item that u want to drop");
                choice = sc.nextInt();
                dropItem(choice-1);
            }else if(choice == 3){
                System.out.println("Write number of item that u want to equip");
                choice = sc.nextInt();
                equip(Inventory.get(choice-1));
            }else if(choice == 4){
            }else
                InventoryMenu();
        }
    }
    void add(String stuff){

        Inventory.add(stuff);
    }
    void useItem(int itemNumb){
        if(itemNumb > Inventory.size() || itemNumb < 0){
            System.out.println("Wrong number");
            InventoryMenu();
        }else {
            String item = Inventory.get(itemNumb);
            if(item.equals("Mushroom")||item.equals("Weed")){
                System.out.println("Shit, that's good");
                character.hp += 50;
                Inventory.remove(item);
                InventoryMenu();
            }else if(item.equals("Cocaine")){
                System.out.println("I'm in love with a co-co");
                character.hp += 100;
                Inventory.remove(item);
            }
            else
                System.out.println("Can't use it");
        }

    }
    void dropItem(int itemNumb){
        if(itemNumb >= Inventory.size() || itemNumb < 0){
            System.out.println("Wrong number");
            InventoryMenu();
        } else {
            String item = Inventory.get(itemNumb);
            System.out.println("Drop "+ item+"?\n1-Yes\n2-No");
            choice = sc.nextInt();
            if(choice == 1){
                Inventory.remove(item);
                InventoryMenu();
            } else if(choice == 2)
                InventoryMenu();
            else {
                System.out.println("Wrong answer");
                dropItem(itemNumb);
            }
        }
    }
    void equip(String item){
        if(item.equals("Sword")){
            if(items.equipment(item))
                character.mcattack += 10;
        }else
            System.out.println("Can't equip this.");

    }
    String randomTreasure(){
        String[] treasure = {"Mushroom","Cocaine","Weed","Shit"};
        return treasure[(int)(Math.random()*treasure.length)];
    }
}
