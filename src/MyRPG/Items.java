package MyRPG;

import java.util.ArrayList;

/**
 * Created by Maniak on 30.08.2017.
 */
class Items {
    static ArrayList<String> Equipment = new ArrayList<>();
    Inventory inventory = null;
    Character character = null;

    boolean equipment(String item){
        inventory = new Inventory();
        character = new Character();
        if(inventory.unequip){
            Equipment.remove(item);
            inventory.unequip = false;
            System.out.println(item+" unequipped");
        }else {
            if (Equipment.contains(item)) {
                System.out.println(item+" already equipped");
                return false;
            } else {
                System.out.println(item+" equipped");
                Equipment.add(item);
            }
        }
        return true;
    }
}
