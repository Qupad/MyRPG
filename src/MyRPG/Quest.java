package MyRPG;

/**
 * Created by Maniak on 26.08.2017.
 */
class Quest {
    boolean mushroomQ = false;
    void MushroomQuest(){
        if (Inventory.Inventory.contains("Mushroom")) {
            System.out.println("Oh ma, yeee, thx to u young man. This is urs.");
            Inventory.Inventory.remove("Mushroom");
            Inventory.Inventory.add("Mushroom's elixir");
            Inventory.money += 10;
            mushroomQ = false;
        } else {
            System.out.println("Pls bring me some mushrooms from forest. And I'll do my mushroom elixir for you.");
            mushroomQ = true;
        }
    }
}
