import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Player { 
        private String name;
        private int health;
        private List<String> inventory;
        private List<String> spells;

        public Player(String name) {
            this.name = name;
            this.health = 100;
            this.inventory = new ArrayList<>();
            this.spells = new ArrayList<>(Arrays.asList("Stupefy", "Expelliarmus", "Lumos"));
        }

        public void showStatus() {
            System.out.println("Player: " + name);
            System.out.println("Health: " + health);
            System.out.println("Inventory: " + (inventory.isEmpty() ? "Empty" : String.join(", ", inventory)));
            System.out.println("Spells: " + String.join(", ", spells));
        }


        public String getName(){
            return this.name;
        }

        public Integer getHealth(){
            return this.health;
        }

        public List<String> getSpells(){
            return this.spells;
        }

        public void addItem(String item) {
            inventory.add(item);
            System.out.println(item + " added to your inventory.");
        }
    
}
