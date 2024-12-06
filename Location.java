import java.util.HashMap;
import java.util.Map;

    public class Location {
        private String name;
        private String description;
        private Map<String, Location> connections;
        private Artefacts artefact;

        public Location(String name, String description, Artefacts artefact) {
            this.name = name;
            this.description = description;
            this.connections = new HashMap<>();
            this.artefact = artefact;
        }

        public void connect(String direction, Location location) {
            connections.put(direction, location);
        }

        public String getName() {
            return this.name;
        }

        public void describe() {
            System.out.println("You are at " + name + ". " + description);
            if (!connections.isEmpty()) {
                System.out.println("You can go to:");
                connections.forEach((direction, location) -> 
                    System.out.println("- " + direction + ": " + location.getName())
                );
            }
        }

        public Location getConnection(String direction) {
            return connections.get(direction);
        }

        public Artefacts getArtefact(){
            return this.artefact;
        }
    }

