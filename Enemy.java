/**
 * Represents an enemy in the game.
 * Each enemy has a name and a damage value indicating its attack strength.
 */
public class Enemy {
    private String name;
    private int damage;

    /**
     * Constructs an Enemy with the specified name and damage value.
     *
     * @param name   The name of the enemy.
     * @param damage The amount of damage the enemy can inflict.
     */
    public Enemy(String name, int damage) {
        this.name = name;
        this.damage = damage;
    }

    /**
     * Retrieves the name of the enemy.
     *
     * @return The name of the enemy.
     */
    public String getName() {
        return name;
    }

    /**
     * Retrieves the damage value of the enemy.
     *
     * @return The damage inflicted by the enemy.
     */
    public int getDamage() {
        return damage;
    }
}
