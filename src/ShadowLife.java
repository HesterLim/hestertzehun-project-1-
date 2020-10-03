// Import Libraries
import bagel.*;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Random;

public class ShadowLife extends AbstractGame {
    private final Image background;
    private final Image tree;
    private final Image gatherer;

    // The x,y coordinate for background image
    private final float backWidth = Window.getWidth() / 2;
    private final float backHeight = Window.getHeight() / 2 ;
    // Initialize the Tree Class with an array size of 10
    private final Tree[] treeInfo = new Tree[10];
    int numTree = 0;
    // Initialize the Gatherer Class with an array size of 10
    private final Gatherer[] gathererInfo = new Gatherer[10];
    int numGatherer = 0;
    // Initialize the system's current time in milliseconds
    private long time = System.currentTimeMillis();
    // Initialize the tick time for every 500 milliseconds
    final long TICK = 500;
    // to store the number of ticks
    int tick_counter = 1;

    // Initialise the movement direction
    final int RIGHT = 1;
    final int UP = 2;
    final int LEFT = 3;
    final int DOWN = 4;
    // Move One Tile
    final int MOVE = 64;

    public ShadowLife() {
        super(800, 600, "Shadow Life");
        // Initialize the Image Class for Background, Tree, Gatherer
        background = new Image("res/images/background.png");
        tree = new Image("res/images/tree.png");
        gatherer = new Image("res/images/gatherer.png");

        // Read the csv file
        try (BufferedReader br =
                     new BufferedReader(new FileReader("res/worlds/test.csv"))){

            String text;

            while ((text = br.readLine()) != null){
                // Split the data in each line by comma
                String [] data = text.split(",");
                // Check if the row of data is about tree
                if(data[0].equals("Tree")){
                    double treeWidth = Double.parseDouble(data[1]);
                    double treeHeight = Double.parseDouble(data[2]);
                    // Initialize the Tree class and store x,y-coordinate
                    treeInfo[numTree] = new Tree(treeWidth,treeHeight);
                    numTree++;
                }else if(data[0].equals("Gatherer")){ //Check if the row od data is about gatherer
                    double gathererWidth = Double.parseDouble(data[1]);
                    double gathererHeight = Double.parseDouble(data[2]);
                    // Initialize the Gatherer Class
                    gathererInfo[numGatherer] = new Gatherer();
                    // Set the x,y-coordinate of gatherer
                    gathererInfo[numGatherer].setGathererWidth(gathererWidth);
                    gathererInfo[numGatherer].setGathererHeight(gathererHeight);
                    numGatherer++;
                }
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * The entry point for the program.
     */
    public static void main(String[] args) {
        // Load the simulation
        ShadowLife game = new ShadowLife();
        game.run();
    }

    /**
     * Performs a state update. This simple example shows an image that can be controlled with the arrow keys, and
     * allows the game to exit when the escape key is pressed.
     */
    @Override
    public void update(Input input) {
        // Draw Background image
        background.draw(backWidth, backHeight);
        // Draw Tree image
        for(int count = 0; count < numTree; count++){
            tree.draw(treeInfo[count].getTreeWidth(), treeInfo[count].getTreeHeight());
        }

        int toggle = 0;
        // Check if 500 milliseconds has passed.
        if(System.currentTimeMillis() > (time + TICK)){
            toggle = 1;
        }

        if(toggle == 1) { // Move the gatherer every 500ms
            if(tick_counter > 4){ // Move random direction
                for (int gCount = 0; gCount < numGatherer; gCount++) {
                    tick_counter = 1;
                    // Initialize a random class
                    Random random = new Random();
                    // Generate a random number bounded between 0 and 4
                    int condition = random.nextInt(4);
                    if (condition == RIGHT) {
                        //Move right
                        gathererInfo[gCount].setGathererWidth(gathererInfo[gCount].getGathererWidth() + MOVE);
                        gatherer.draw(gathererInfo[gCount].getGathererWidth(), gathererInfo[gCount].getGathererHeight());
                        // Store the gatherer's direction - Move right
                        gathererInfo[gCount].setGathererDirection(RIGHT);
                    } else if (condition == UP) {
                        // Move up
                        gathererInfo[gCount].setGathererHeight(gathererInfo[gCount].getGathererHeight() + MOVE);
                        gatherer.draw(gathererInfo[gCount].getGathererWidth(), gathererInfo[gCount].getGathererHeight());
                        // Store the gatherer's direction - Move up
                        gathererInfo[gCount].setGathererDirection(UP);
                    } else if (condition == LEFT) {
                        // Move left
                        gathererInfo[gCount].setGathererWidth(gathererInfo[gCount].getGathererWidth() - MOVE);
                        gatherer.draw(gathererInfo[gCount].getGathererWidth(), gathererInfo[gCount].getGathererHeight());
                        // Store the gatherer's direction - Move left
                        gathererInfo[gCount].setGathererDirection(LEFT);
                    } else {
                        // Move down
                        gathererInfo[gCount].setGathererHeight(gathererInfo[gCount].getGathererHeight() - MOVE);
                        gatherer.draw(gathererInfo[gCount].getGathererWidth(), gathererInfo[gCount].getGathererHeight());
                        // Store the gatherer's direction - Move down
                        gathererInfo[gCount].setGathererDirection(DOWN);
                    }
                }
            }else{ // Move gatherer with same direction
                for (int gCount = 0; gCount < numGatherer; gCount++) {
                    if (gathererInfo[gCount].getGathererDirection() == RIGHT) {
                        //Move right
                        gathererInfo[gCount].setGathererWidth(gathererInfo[gCount].getGathererWidth() + MOVE);
                        gatherer.draw(gathererInfo[gCount].getGathererWidth(), gathererInfo[gCount].getGathererHeight());
                        // Store the gatherer's direction - Move right
                        gathererInfo[gCount].setGathererDirection(RIGHT);
                    } else if (gathererInfo[gCount].getGathererDirection() == UP) {
                        // Move up
                        gathererInfo[gCount].setGathererHeight(gathererInfo[gCount].getGathererHeight() + MOVE);
                        gatherer.draw(gathererInfo[gCount].getGathererWidth(), gathererInfo[gCount].getGathererHeight());
                        // Store the gatherer's direction - Move up
                        gathererInfo[gCount].setGathererDirection(UP);
                    } else if (gathererInfo[gCount].getGathererDirection() == LEFT) {
                        // Move left
                        gathererInfo[gCount].setGathererWidth(gathererInfo[gCount].getGathererWidth() - MOVE);
                        gatherer.draw(gathererInfo[gCount].getGathererWidth(), gathererInfo[gCount].getGathererHeight());
                        // Store the gatherer's direction - Move left
                        gathererInfo[gCount].setGathererDirection(LEFT);
                    } else {
                        // Move down
                        gathererInfo[gCount].setGathererHeight(gathererInfo[gCount].getGathererHeight() - MOVE);
                        gatherer.draw(gathererInfo[gCount].getGathererWidth(), gathererInfo[gCount].getGathererHeight());
                        // Store the gatherer's direction - Move left
                        gathererInfo[gCount].setGathererDirection(DOWN);
                    }
                }
            }
            // Increment the number of ticks
            tick_counter += 1;
            // Set a new timing after checking if 500ms has passed.
            time = System.currentTimeMillis();
        }else{ // Draw the Gatherer Image without movement
            for(int gCount = 0; gCount < numGatherer; gCount++) {
                gatherer.draw(gathererInfo[gCount].getGathererWidth(), gathererInfo[gCount].getGathererHeight());
            }
        }
    }
}
