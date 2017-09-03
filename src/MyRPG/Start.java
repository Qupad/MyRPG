package MyRPG;

import java.util.*;
/**
 * Created by Maniak on 21.08.2017.
 */
public class Start {
    public static void main(String[] args) {
        Map map = new Map();
        Ivent ivent = new Ivent();
        Inventory inventory = new Inventory();
        Character character = new Character();
        Scanner sc = new Scanner(System.in);
        map.setMap((int)(Math.random()*map.map.length),(int)(Math.random()*map.map.length));
        map.randomize();
        inventory.add("Map");
        inventory.add("Cocaine");
        inventory.add("Sword");
        character.mainCharacter();
        while (true) {
            Boolean n = false,w = false,e = false,s = false, wall = false;
            map.print();
            System.out.print("You are in ");
            ivent.position(map.getData(map.x,map.y));
            System.out.println();
            ivent.ivent();
            System.out.println("U see: ");
            if (map.x - 1 >= 0) {
                ivent.position(map.getData(map.x - 1,map.y));
                n = true;
            } else {
                System.out.print("giant black wall");
                wall = true;
            }
            System.out.println(" at North ");

            if (map.y - 1 >= 0) {
                ivent.position(map.getData(map.x,map.y-1));
                w = true;
            } else {
                System.out.print("giant black wall");
                wall = true;
            }
            System.out.println(" at West ");

            if (map.x + 1 < map.map.length) {
                ivent.position(map.getData(map.x + 1,map.y));
                s = true;
            } else {
                System.out.print("giant black wall");
                wall = true;
            }
            System.out.println(" at South ");

            if (map.y + 1 < map.map.length){
                ivent.position(map.getData(map.x,map.y+1));
                e = true;
            } else {
                System.out.print("giant black wall");
                wall = true;
            }
            System.out.println(" at East ");

            String chose = sc.next();
                if (w && chose.equals("W")) {
                    map.clearData();
                    map.setMap(map.x, map.y - 1);
                } else if (e && chose.equals("E")) {
                    map.clearData();
                    map.setMap(map.x, map.y + 1);
                } else if (s && chose.equals("S")) {
                    map.clearData();
                    map.setMap(map.x + 1, map.y);
                } else if (n && chose.equals("N")) {
                    map.clearData();
                    map.setMap(map.x - 1, map.y);
                } else if (chose.equals("I"))
                    inventory.InventoryMenu();
                else
                    System.out.println("Wrong");
        }
    }
}
