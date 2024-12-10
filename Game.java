import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Game {
    private Map<String, Location> locations;
    private Location currentLocation;
    private Player player;
    private boolean isRunning;
    private Map<String, Enemy> enemies;

    public Game() {
        locations = new HashMap<>();
        enemies = new HashMap<>();
        isRunning = true;
    }

    public void setup() {
        // Artefacts initialization
        Artefacts diadem = new Artefacts("Rowena Ravenclaw's diadem");
        Artefacts locket = new Artefacts("Salazar Slytherin's locket");
        Artefacts cup = new Artefacts("Helga Hufflepuff's cup");
        Artefacts ring = new Artefacts("Marvolo Gaunt's ring");
        Artefacts diary = new Artefacts("Tom Riddle's diary");
        Artefacts wand = new Artefacts("The Elder Wand");
        Artefacts snake = new Artefacts("Nagini");

        // Locations list
        Location hogwarts = new Location("Hogwarts", "The castle of witchcraft and wizardry.", diadem);
        Location greatHall = new Location("Great Hall", "The main dining hall of Hogwarts.", null);
        Location diagonAlley = new Location("Diagon Alley", "A bustling street with magical shops.", null);
        Location forbiddenForest = new Location("Forbidden Forest", "A dark and dangerous forest.", null);
        Location gringotts = new Location("Gringotts Bank", "A vault of unimaginable treasures.", cup);
        Location malfoyManor = new Location("Malfoy Manor", "A dark and twisted estate. Death Eater's residence", locket);
        Location littleHangleton = new Location("Little Hangleton", "The resting place of a cursed ring.", ring);
        Location chamberSecrets = new Location("Chamber of Secrets", "A hidden chamber beneath Hogwarts created by Salazar Slytherin.", diary);
        Location hogsmeade = new Location("Hogsmeade Village", "A cozy wizarding village.", wand);
        Location graveyard = new Location("Graveyard", "Tom Marvolo Riddle senior's grave. Nagini's lair.", snake);

        // Connection of locations
        hogwarts.connect("north", greatHall);
        hogwarts.connect("east", diagonAlley);
        hogwarts.connect("west", forbiddenForest);
        hogwarts.connect("south", littleHangleton);
        greatHall.connect("south", hogwarts);
        greatHall.connect("east", gringotts);
        diagonAlley.connect("west", hogwarts);
        diagonAlley.connect("north", gringotts);
        diagonAlley.connect("south", hogsmeade);
        hogsmeade.connect("east", littleHangleton);
        hogsmeade.connect("north", diagonAlley);
        hogsmeade.connect("south", graveyard);
        gringotts.connect("south", diagonAlley);
        gringotts.connect("east", greatHall);
        forbiddenForest.connect("east", hogwarts);
        forbiddenForest.connect("south", malfoyManor);
        malfoyManor.connect("east", littleHangleton);
        malfoyManor.connect("north", forbiddenForest);
        littleHangleton.connect("north", hogwarts);
        littleHangleton.connect("south", chamberSecrets);
        littleHangleton.connect("east", malfoyManor);
        littleHangleton.connect("west", hogsmeade);
        chamberSecrets.connect("west", graveyard);
        chamberSecrets.connect("north", littleHangleton);
        graveyard.connect("north", hogsmeade);
        graveyard.connect("east", chamberSecrets);

        // Storing locations
        locations.put("Hogwarts", hogwarts);
        locations.put("Great Hall", greatHall);
        locations.put("Diagon Alley", diagonAlley);
        locations.put("Forbidden Forest", forbiddenForest);
        locations.put("Gringotts Bank", gringotts);
        locations.put("Malfoy Manor", malfoyManor);
        locations.put("Little Hangleton", littleHangleton);
        locations.put("Chamber of Secrets", chamberSecrets);
        locations.put("Hogsmeade Village", hogsmeade);
        locations.put("Graveyard", graveyard);

        // Enemies tied to locations
        enemies.put("Malfoy Manor", new Enemy("Bellatrix Lestrange", 50));
        enemies.put("Graveyard", new Enemy("Nagini", 30));
        enemies.put("Chamber of Secrets", new Enemy("Basilisk", 70));
        enemies.put("Little Hangleton", new Enemy("Fenrir Greyback", 40));

        // Player initialization
        currentLocation = hogwarts;
        player = new Player("Hero Wizard");
    }

    public void start() {
        System.out.println("Welcome to The Wizard's Journey!");
        printGameRules();
        currentLocation.describe();

        Scanner scanner = new Scanner(System.in);

        while (isRunning) {
            System.out.print("> ");
            String command = scanner.nextLine();
            parseCommand(command);
        }

        scanner.close();
    }

    private void printGameRules() {
        System.out.println("Game Rules:");
        System.out.println("1. Explore the world by using commands like 'go [direction]'.");
        System.out.println("2. Collect artefacts by using 'take'.");
        System.out.println("3. Fight enemies using spells (e.g., 'spell Stupefy').");
        System.out.println("4. Use 'status' to check your health and inventory.");
        System.out.println("5. If you do not cast a spell when encountering an enemy, you will lose health.");
        System.out.println("Available Spells: Stupefy, Expelliarmus, Lumos, Confringo, Reducto");
        System.out.println("Type 'quit' to end the game.");
    }

    private void parseCommand(String command) {
        String[] parts = command.toLowerCase().split(" ");
        if (parts.length == 0) {
            System.out.println("You must enter a command!");
            return;
        }

        String verb = parts[0];
        switch (verb) {
            case "go":
                if (parts.length > 1) {
                    String direction = parts[1];
                    Location nextLocation = currentLocation.getConnection(direction);
                    if (nextLocation != null) {
                        currentLocation = nextLocation;
                        currentLocation.describe();

                        Enemy enemy = enemies.get(currentLocation.getName());
                        if (enemy != null) {
                            System.out.println("You encountered " + enemy.getName() + "!");
                            System.out.println("Use a spell immediately or lose health.");
                        }
                    } else {
                        System.out.println("You can't go that way!");
                    }
                } else {
                    System.out.println("Go where?");
                }
                break;
            case "spell":
                if (parts.length > 1) {
                    String spell = command.substring(command.indexOf(" ") + 1);
                    Enemy enemy = enemies.get(currentLocation.getName());
                    if (enemy != null) {
                        if (player.getSpells().contains(spell)) {
                            System.out.println("You defeated " + enemy.getName() + " with " + spell + "!");
                            enemies.remove(currentLocation.getName());
                        } else {
                            System.out.println("Spell failed! You lose health.");
                            player.reduceHealth(enemy.getDamage());
                        }
                    } else {
                        System.out.println("No enemies here.");
                    }
                } else {
                    System.out.println("Use what spell?");
                }
                break;
            case "take":
                Artefacts artefact = currentLocation.getArtefact();
                if (artefact != null) {
                    player.addArtefact(artefact);
                    currentLocation.removeArtefact(); // Remove artefact after collection
                } else {
                    System.out.println("No artefacts here.");
                }
                break;
            case "status":
                player.showStatus();
                break;
            case "quit":
                System.out.println("Thanks for playing!");
                isRunning = false;
                break;
            default:
                // Penalize if player doesn't cast a spell while encountering an enemy
                Enemy enemy = enemies.get(currentLocation.getName());
                if (enemy != null) {
                    System.out.println("You didn't cast a spell! The enemy attacks!");
                    player.reduceHealth(enemy.getDamage());
                } else {
                    System.out.println("I don't understand that command.");
                }
        }
    }
}
