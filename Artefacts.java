import java.util.ArrayList;
import java.util.List;

/**
 * Represents an artefact in the game world.
 * Manages artefact collection status and maintains a list of collected artefacts.
 */
public class Artefacts {
    private String name;
    private boolean isCollected;
    private List<String> artefacts;

    /**
     * Constructs an Artefact object with the specified name.
     * The artefact is initially marked as not collected.
     *
     * @param name The name of the artefact.
     */
    public Artefacts(String name) {
        this.name = name;
        this.isCollected = false;
        this.artefacts = new ArrayList<>();
    }

    /**
     * Displays the status of the artefact, including its name and collection status.
     */
    public void showStatus() {
        System.out.println("Player: " + name);
        System.out.println("Did I collect this artefact: " + isCollected);
    }

    /**
     * Retrieves the name of the artefact.
     *
     * @return The name of the artefact.
     */
    public String getName() {
        return this.name;
    }

    /**
     * Checks and updates the collection status of artefacts.
     * If the total artefacts collected reaches 7, the artefact is marked as collected.
     *
     * @return True if the artefact collection is complete (7 items), otherwise false.
     */
    public Boolean getStatus() {
        if (artefacts.size() == 7) {
            this.isCollected = true;
        }
        return this.isCollected;
    }

    /**
     * Adds a new artefact to the artefacts list if it has not already been collected.
     *
     * @param item The name of the artefact to add.
     */
    public void addartefact(String item) {
        if (!artefacts.contains(item)) {
            artefacts.add(item);
            System.out.println(item + " added to your artefacts list.");
        } else {
            System.out.println(item + " is already in your list.");
        }
    }
}
