import java.util.HashMap;
import java.util.Map;
/**
 * Represents a location in the game world.
 * Each location has a name, description, connections to other locations, and may contain an artefact.
 */
    public class Location {
        private String name;
        private String description;
        private Map<String, Location> connections;
        private Artefacts artefact;
        
        /**
        * Constructs a new Location with a specified name, description, and optional artefact.
        *
        * @param name        The name of the location.
        * @param description A brief description of the location.
        * @param artefact    An artefact present at the location, or null if none.
        */
        public Location(String name, String description, Artefacts artefact) {
            this.name = name;
            this.description = description;
            this.connections = new HashMap<>();
            this.artefact = artefact;
        }

        /**
        * Connects this location to another location in a specified direction.
        *
        * @param direction The direction to move towards the connected location (e.g., "north", "south").
        * @param location  The location to connect to in the specified direction.
        */
        public void connect(String direction, Location location) {
            connections.put(direction, location);
        }

        /**
        * Retrieves the name of the location.
        *
        * @return The name of the location.
        */
        public String getName() {
            return this.name;
        }

        /**
        * Prints the description of the location and lists available connections.
        */
        public void describe() {
            System.out.println("You are at " + name + ". " + description);
            if (!connections.isEmpty()) {
                System.out.println("You can go to:");
                connections.forEach((direction, location) -> 
                    System.out.println("- " + direction + ": " + location.getName())
                );
            }
        }


        /**
        * Retrieves the connected location in a specified direction.
        *
        * @param direction The direction of the desired connection.
        * @return The location connected in the specified direction, or null if no connection exists.
        */
        public Location getConnection(String direction) {
            return connections.get(direction);
        }

        /**
        * Retrieves the artefact present at this location.
        *
        * @return The artefact at this location, or null if no artefact is present.
        */
        public Artefacts getArtefact(){
            return this.artefact;
        }
        public void removeArtefact() {
            this.artefact = null; 
        }

    }

