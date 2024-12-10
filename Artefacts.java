import java.util.ArrayList;
import java.util.List;

public class Artefacts {
    private String name;
    private boolean isCollected;
    private List<String> artefacts; 

        public Artefacts(String name) {
            this.name = name;
            this.isCollected = false;
            this.artefacts = new ArrayList<>();
        }

        public void showStatus() {
            System.out.println("Player: " + name);
            System.out.println("Did I collect this artefact: " + isCollected);
        }


        public String getName(){
            return this.name;
        }

        public Boolean getStatus(){
            if (artefacts.size() == 7){
                this.isCollected = true;
            }
            return this.isCollected;
        }

        public void addartefact(String item) {
            if (artefacts.contains(item) == false){
                artefacts.add(item);
                System.out.println(item + " added to your artefacts list.");
            }else{
                System.out.println(item + " is already in your list.");
            }
            
        }
        


}
