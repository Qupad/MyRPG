package MyRPG;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

/**
 * Created by Maniak on 26.08.2017.
 */
class Inventory {
    static ArrayList<String> Inventory = new ArrayList<>();
    static int money = 0;
    Items items = new Items();
    Character character = null;
    Scanner sc = new Scanner(System.in);
    String choice;
    int number;
    static boolean unequip = false;

    void InventoryMenu(){
        System.out.println("\n\tHP: " + character.hp + "\t\tAttack damage: " + character.mcattack + "\t\tMoney: " + money);
        if (Inventory.isEmpty()) {
            System.out.println("Empty");
        } else {
            for (int i = 0; i < Inventory.size(); i++)
                System.out.print(i + 1 + "-" + Inventory.get(i) + " ");
            System.out.println("\n1-Use item\n2-Drop item\n3-Equip\n4-Unequip\n5-Close backpack");
            try {
                number = sc.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Write decimal");
                sc.next();
                InventoryMenu();
            }
            if(number >= 1 && number <= 4) {
                System.out.print("Write number of item that u want to ");
                switch (number) {
                    case 1: System.out.println("use"); useItem(); break;
                    case 2: System.out.println("drop"); dropItem(); break;
                    case 3: System.out.println("equip"); equip(); break;
                    case 4: System.out.println("unequip"); unequip = true; equip(); break;
                }
            }
        }
    }
    void add(String stuff){
        Inventory.add(stuff);
    }
    void useItem(){
        try {
            number = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Write decimal");
            InventoryMenu();
        }
        number -= 1;
        if(number > Inventory.size() || number < 0){
            System.out.println("Wrong number");
            sc.next();
            InventoryMenu();
        }else {
            String item = Inventory.get(number);
            if(item.equals("Mushroom")||item.equals("Weed")){
                System.out.println("Shit, that's good");
                character.hp += 50;
                Inventory.remove(item);
                InventoryMenu();
            }else if(item.equals("Cocaine")){
                System.out.println("I'm in love with a co-co");
                character.hp += 100;
                Inventory.remove(item);
            }else if(item.equals("Mushroom's elixir")){
                System.out.println("U had heart attack, and get insult");
                character.hp -= 50;
                Inventory.remove(item);
            }
            else
                System.out.println("Can't use it");
        }

    }
    void dropItem(){
        try {
            number = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Write decimal");
            InventoryMenu();
        }
        number -= 1;
        if(number >= Inventory.size() || number < 0){
            System.out.println("Wrong number");
            InventoryMenu();
        } else {
            String item = Inventory.get(number);
            System.out.println("Drop "+ item+"?\n1-Yes\n2-No");
            choice = sc.next();
            if(choice.equals("1")){
                Inventory.remove(item);
                InventoryMenu();
            } else if(choice.equals("2"))
                InventoryMenu();
            else {
                System.out.println("Wrong answer");
                InventoryMenu();
            }
        }
    }
    void equip(){
        try {
            number = sc.nextInt();
        } catch (InputMismatchException e) {
            System.out.println("Write decimal");
            InventoryMenu();
        }
        String item = Inventory.get(number - 1);
        if(item.equals("Sword")){
            if(unequip) {
                items.equipment(item);
                character.mcattack -= 10;
            }
            else if (items.equipment(item))
                character.mcattack += 10;
        }else
            System.out.println("Can't equip this.");

    }
    String randomTreasure(){
        String[] treasure = {"Mushroom","Cocaine","Weed","Shit"};
        return treasure[(int)(Math.random()*treasure.length)];
    }
}
