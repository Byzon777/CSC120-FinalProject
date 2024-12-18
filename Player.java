import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Represents a player in the game with attributes like name, health, inventory, and spells.
 * The player can collect artefacts, lose health, and display their current status.
 */

public class Player {
    private String name;
    private int health;
    private List<String> inventory;
    private List<String> spells;

    /**
     * Constructs a new Player with the specified name.
     * The player's initial health is set to 100, and the player starts with a predefined set of spells.
     *
     * @param name The name of the player.
     */
    public Player(String name) {
        this.name = name;
        this.health = 100;
        this.inventory = new ArrayList<>();
        this.spells = new ArrayList<>(Arrays.asList("Stupefy", "Expelliarmus", "Lumos", "Confringo", "Reducto"));
    }

    /**
     * Displays the current status of the player, including their name, health, inventory, and spells.
     */
    public void showStatus() {
        System.out.println("Player: " + name);
        System.out.println("Health: " + health);
        System.out.println("Inventory: " + (inventory.isEmpty() ? "Empty" : String.join(", ", inventory)));
        System.out.println("Spells: " + String.join(", ", spells));
    }

    /**
     * Retrieves the list of spells available to the player.
     *
     * @return A list of strings representing the player's spells.
     */
    public List<String> getSpells() {
        return this.spells;
    }

    /**
     * Reduces the player's health by a specified amount.
     * If the player's health drops to or below 0, the game ends.
     *
     * @param amount The amount of health to reduce. Must be a positive integer.
     */
    public void reduceHealth(int amount) {
        this.health -= amount;
        System.out.println("You lost " + amount + " health. Current health: " + health);
        if (health <= 0) {
            System.out.println("Game Over!");
            System.exit(0);
        }
    }
    
     /**
     * Adds an artefact to the player's inventory if it hasn't been collected already.
     * If the player collects all 7 artefacts, they win the game.
     *
     * @param artefact The artefact to add to the player's inventory.
     */
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
