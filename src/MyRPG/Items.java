package MyRPG;

import java.util.ArrayList;

/**
 * Created by Maniak on 30.08.2017.
 */
public class Items {
    static ArrayList<String> Equipment = new ArrayList<>();

    boolean equipment(String item){
        if(Equipment.contains(item)){
            System.out.println("Already equipped");
            return false;
        }else {
            Equipment.add(item);
        }
        return true;
    }
}
