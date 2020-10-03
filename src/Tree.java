// Store the x,y coordinates of trees
public class Tree {
    private double treeWidth;
    private double treeHeight;

    // Constructor
    public Tree(double treeWidth,double treeHeight ) {
        this.treeWidth = treeWidth;
        this.treeHeight = treeHeight;
    }

    // Get Tree's x-coordinate
    public double getTreeWidth() {
        return treeWidth;
    }
    // Get Tree's y-coordinate
    public double getTreeHeight() {
        return treeHeight;
    }

}
