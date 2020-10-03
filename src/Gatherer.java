// Store the x,y-coordinate of gatherers
public class Gatherer {
    private double gathererWidth;
    private double gathererHeight;
    private int gathererDirection;
    // constructor for Gatherer's class
    public Gatherer() {
        this.gathererWidth = gathererWidth;
        this.gathererHeight = gathererHeight;
    }
    // retrieve x-coordinate of gatherer
    public double getGathererWidth() {
        return gathererWidth;
    }
    // retrieve y-coordinate of gatherer
    public double getGathererHeight() {
        return gathererHeight;
    }
    // set the x-coordinate of gatherer
    public void setGathererWidth(double gathererWidth) {
        this.gathererWidth = gathererWidth;
    }
    // set the y-coordinate of gatherer
    public void setGathererHeight(double gathererHeight) {
        this.gathererHeight = gathererHeight;
    }
    // retrieve the direction that gatherer moves
    public int getGathererDirection() {
        return gathererDirection;
    }
    // set the direction that gatherer moves
    public void setGathererDirection(int gathererDirection) {
        this.gathererDirection = gathererDirection;
    }
}
