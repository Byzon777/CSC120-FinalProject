import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;


    // The main game class handling the loop, parser, and narrative
    public  class Game {
        private Map<String, Location> locations;
        private Location currentLocation;
        private Player player;
        private boolean isRunning;
        private Artefacts diadem;
        private Artefacts none;

        public Game() {
            locations = new HashMap<>();
            isRunning = true;
        }

        public void setup() {
            
            // Locations list
            Location hogwarts = new Location("Hogwarts", "The castle of witchcraft and wizardry.", diadem);
            Location greatHall = new Location("Great Hall", "The main dining hall of Hogwarts.", none);
            Location diagonAlley = new Location("Diagon Alley", "A bustling street with magical shops.", none);
            Location forbiddenForest = new Location("Forbidden Forest", "A dark and dangerous forest.", none);

            // Initialization of player and starting location
            currentLocation = hogwarts;
            player = new Player("Hero Wizard");

            diadem = new Artefacts("Rowena Ravenclaw's diadem");
            none = new Artefacts("none");

            // Connection of locations
            hogwarts.connect("north", greatHall);
            hogwarts.connect("east", diagonAlley);
            hogwarts.connect("west", forbiddenForest);
            greatHall.connect("south", hogwarts);
            diagonAlley.connect("west", hogwarts);
            forbiddenForest.connect("east", hogwarts);

            // Storing locations
            locations.put("Hogwarts", hogwarts);
            locations.put("Great Hall", greatHall);
            locations.put("Diagon Alley", diagonAlley);
            locations.put("Forbidden Forest", forbiddenForest);

        }

        public void start() {
            System.out.println("Welcome to The Wizard's Journey!");
            currentLocation.describe();

            Scanner scanner = new Scanner(System.in);

            while (isRunning) {
                System.out.print("> ");
                String command = scanner.nextLine();
                parseCommand(command);
            }

            scanner.close();
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
                        } else {
                            System.out.println("You can't go that way!");
                        }
                    } else {
                        System.out.println("Go where?");
                    }
                    break;
                case "look":
                    currentLocation.describe();
                    break;
                case "status":
                    player.showStatus();
                    break;
                case "take":
                    if (parts.length > 1) {
                        String item = command.substring(command.indexOf(" ") + 1);
                        player.addItem(item);
                    } else {
                        System.out.println("Take what?");
                    }
                    break;
                case "quit":
                    System.out.println("Thanks for playing!");
                    isRunning = false;
                    break;
                /*case "artefact": 
                    if(currentLocation.getArtefact().getName()!="none"){
                        addartefact(currentLocation.getArtefact());
                    } else{
                        System.out.println("No artefacts here");
                    }*/
                    default:
                    System.out.println("I don't understand that command.");
            }
        }
    }

