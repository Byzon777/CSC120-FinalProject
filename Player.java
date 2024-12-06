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
        this.spells = new ArrayList<>(Arrays.asList("Stupefy", "Expelliarmus", "Lumos", "Confringo", "Reducto"));
    }

    public void showStatus() {
        System.out.println("Player: " + name);
        System.out.println("Health: " + health);
        System.out.println("Inventory: " + (inventory.isEmpty() ? "Empty" : String.join(", ", inventory)));
        System.out.println("Spells: " + String.join(", ", spells));
    }

    public List<String> getSpells() {
        return this.spells;
    }

    public void reduceHealth(int amount) {
        this.health -= amount;
        System.out.println("You lost " + amount + " health. Current health: " + health);
        if (health <= 0) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }

    public void addArtefact(Artefacts artefact) {
        if (!inventory.contains(artefact.getName())) {
            inventory.add(artefact.getName());
            System.out.println(artefact.getName() + " collected!");
        } else {
            System.out.println("You already collected this artefact.");
        }

        if (inventory.size() == 7) {
            System.out.println("Congratulations! You have collected all Horcruxes and won the game!");
            System.exit(0);
        }
    }
}
