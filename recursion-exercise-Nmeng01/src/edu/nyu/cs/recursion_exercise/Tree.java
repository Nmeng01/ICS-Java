package edu.nyu.cs.recursion_exercise;

import processing.core.PApplet;

/**
 * This class uses PApplet, a class from the Processing library, to draw
 * a fractal tree using the recursive method, drawFractal. The tree is drawn
 * by recursively drawing shorter branches at random angles until a certain
 * number of recursions have occurred. 
 * 
 * @author Foo Barstein, with comments by Nicholas Meng (ndm9914)
 */
 
public class Tree extends PApplet {
    
    /**
     * The maximum angle that a branch can be drawn at.
     * This is used when calculating the random angles for 
     * the recursively drawn branches to ensure that the angle
     * parameter of drawFractal does not exceed 360.
     */
    public static final int maxAngle = 360;
    /**
     * The x-coordinate for where the tree trunk initially stems from.
     * This variable will be used in the parameter, x, 
     * when drawFractal is first called in the draw method.
     */
    public static final int startX = 600;
    /**
     * The y-coordinate for how tall the tree trunk is.
     * This variable will be used in the parameter, y, 
     * when drawFractal is first called in the draw method.
     */
    public static final int startY = 800;
    /**
     * The maximum number of times that the drawFractal method
     * can recursively be called. This variable decreases each
     * time drawFractal is recursively called until it equals
     * the Detail variable, at which point the base case of
     * drawFractal is achieved.
     */
    public static final int numOfRecursions = 9;
    /**
     * The starting angle at which to draw the tree initially.
     * This variable will be used in the parameter, angle, 
     * when drawFractal is first called in the draw method.
     */
    public static final int startAngle = 0;
    /**
     * The base of the exponent used to calculate the length
     * of the tree's branches and sub-branches
     */
    public static final double treeSize = 2;
    /**
     * The amount of recursions that do not happen. The level of detail
     * in the fractal tree increases as this variable decreases. When 
     * the parameter, n, of drawFractal eventually equals 
     * this variable, the base case will be achieved.
     */
    public static final int Detail = 3;
    /**
     * The upper bound for the random integers generated when
     * calculating the new angles for the recursively drawn sub-branches
     */
    public static final int randFact = 30;
    /**
     * An array of constant integers used when assigning 
     * random angles to variables. Each item in the array
     * is used for four sub-branches of each parent branch. 
     */
    public static final int[] constFact = {-60, 05, -50, 45};
     /**
      * An array of integers that will represent the 'r' value
      * of a color represented in rgb terms. drawFractal uses this
      * array by randomly selecting an 'r' value for the stroke color
      * of each level of branches. 
      */
    public static int[] red =   {0, 0, 0, 0, 7, 15, 23, 31, 39, 47, 55, 43};
    /**
      * An array of integers that will represent the 'g' value
      * of a color represented in rgb terms. drawFractal uses this
      * array by randomly selecting an 'g' value for the stroke color
      * of each level of branches. 
      */
    public static int[] green = {171, 159, 147, 135, 123, 111, 99, 87, 75, 63, 51, 43};
    /**
      * An array of integers that will represent the 'b' value
      * of a color represented in rgb terms. drawFractal uses this
      * array by randomly selecting an 'b' value for the stroke color
      * of each level of branches. 
      */
    public static int[] blue =  {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0};   
    
    /**
     * This method converts an angle measured in degrees to radians.
     * It does so by using basic math conversion skills. In this case,
     * it multiplies the parameter by pi and divides by 180 to get
     * the radians.
     * @param deg the angle measured in degrees
     * @return the angle measured in radians
     */
    public static double degToRad(int deg) {
        return deg * Math.PI / 180;
    }
    
    /**
     * This method draws a fractal tree at certain (x,y) coordinates
     * by recursively drawing branches and sub-branches.
     * The length of the branch (len) is calculated using tree-size
     * to the power of n. The length is then used to find the end-point (xn1, yn1)
     * of this branch. From this point, the start-points of
     * the four sub-branches are found (mid1x, mid1y, mid2x, mid2y, etc.). 
     * The recursion begins after these are found, as each of these sub-branches repeats this
     * process and creates its own new four sub-branches with the parameter, n, 
     * decrementing by 1. Those sub-branches go on to repeat the process again, 
     * and so on until drawFractal is called with an n equal to Detail. At this point,
     * the base case is achieved, and the recursion stops. Nothing is drawn in this drawFractal call
     * (as shown by the empty return statement), but the method is able to draw
     * lines using those start and end-points defined earlier in previous drawFractal calls 
     * using random colors afforded by choosing randomly from the red, blue, and green class arrays. 
     * This all eventually unravels itself, finally drawing the trunk of the tree once
     * the method has been completed.
     * @param x The starting x-coordinate of the branch
     * @param y The starting y-coordinate of the branch
     * @param n The number of recursions left, not taking Detail into account
     * @param angle The angle at which to draw the branch
     */
    public void drawFractal(int x, int y, int n, int angle) {
        if (n == Detail) return;
        // We use Math.pow() to get the length of the branch, and we pass treeSize and n-1
        // as arguments because it allows the size of the branches to consistently become smaller.
        // We use Math.round() to ensure that this value remains within reasonable bounds
        // if treeSize or n were to be very large. 
        int len = (int) Math.round(Math.pow(treeSize, n - 1));
        // In order to use Math.sin(), angle has to be measured in radians,
        // so we use the degToRad() method here, and we pass angle as the argument
        // because we assume it has been given in degrees. 
        // We use Math.round() here to ensure that these values are integers so that they
        // can be used to get the starting points of the sub-branches.
        int xn1 = (int) Math.round(x - (2 * len * Math.sin(degToRad(angle))));
        int yn1 = (int) Math.round(y - (2 * len * Math.cos(degToRad(angle))));
        int mid1x = (x + xn1) / 2;
        int mid1y = (y + yn1) / 2;
        int mid2x = (mid1x + xn1) / 2;
        int mid2y = (mid1y + yn1) / 2;
        int mid3x = (x + mid1x) / 2;
        int mid3y = (y + mid1y) / 2;
        int mid4x = (mid3x + mid1x) / 2;
        int mid4y = (mid3y + mid1y) / 2;

        java.util.Random randy = new java.util.Random();
        // Find the start and endpoints of four new sub-branches of the original branch
        // The purpose of recursion here is to continously define similar, smaller sub-branches
        // until a certain level of detail is reached.
        // The parameter, n, decrements because it keeps track of what level of recursion the method is on.
        // Once n equals the variable Detail, the recursion stops.
        // We call .nextInt() in this case to get a random integer, and we pass
        // randFact as the argument because we do not want the random integer to be too high.
        drawFractal(mid1x, mid1y, n - 1, (angle + randy.nextInt(randFact) + constFact[0]) % maxAngle);
        drawFractal(mid2x, mid2y, n - 1, (angle + randy.nextInt(randFact) + constFact[1]) % maxAngle);
        drawFractal(mid3x, mid3y, n - 1, (angle + randy.nextInt(randFact) + constFact[2]) % maxAngle);
        drawFractal(mid4x, mid4y, n - 1, (angle + randy.nextInt(randFact) + constFact[3]) % maxAngle);
         
        float r = Tree.red[(randy.nextInt() % 3) + n];
        float g = Tree.green[(randy.nextInt() % 3) + n];
        float b = Tree.blue[(randy.nextInt() % 3) + n];
        // These are both methods inherited from PApplet, a class from the Processing library
        // stroke() sets the color of the brush, line() draws the line from (x1,y1) to (x2,y2)
        this.stroke(r, g, b);
        this.line(x, y, xn1, yn1);
    }

    /**
     * This is called once to set up the window where the tree will be displayed. It uses the
     * size() method detailed below to achieve this purpose.
     */
    @Override
    public void settings() {
        // The size() method is used to set the dimensions of the window in which the program will show
        // We pass 1200, 1000 because it is a reasonable window size for most computers
        this.size(1200, 1000);
    }

    /**
     * This is called once to set the background to black and draw the first tree. It uses
     * the two methods calls detailed below to achieve this purpose
     */
    @Override
    public void setup() {
        // The background() method is used to set the background to black (0, 0, 0)
        background(0, 0, 0);
        // This method is used to draw the tree with the beginning specifications highlighted in the
        // class variables above
        drawFractal(startX, startY, numOfRecursions, startAngle);
    }
    
    /**
     * This is called repeatedly when the code is run, redrawing the tree every five seconds.
     * As the draw method runs over and over again, it checks the number of seconds that has passed
     * since the code started running, and if the number of seconds is a multiple of 5, the tree is
     * redrawn.
     */
    @Override
    public void draw() {
        // We use the second() method to check the number of seconds since the code started running.
        // This ensures that we can keep track of when to redraw the tree (every 5 seconds)
        if (PApplet.second() % 5 == 0) {
            // The background() method is used to reset the background to black every time before
            // the tree is redrawn
            background(0, 0, 0);
            // We use this method to redraw the tree using the same starting arguments as was used initially
            drawFractal(startX, startY, numOfRecursions, startAngle);
        }
    }
    
    /**
     * This is the main method which is automatically called to start the program when the code is run.
     * @param args any command line arguments (ignored)
     */
    public static void main(String args[]) {
        // PApplet's main method is called here to start the program in another window
        // edu.nyu.cs.recursion_exercise.Tree is passed as the argument because Processing
        // requires that the full package as well as the class name are provided to its main method.
        PApplet.main("edu.nyu.cs.recursion_exercise.Tree");
    }
}