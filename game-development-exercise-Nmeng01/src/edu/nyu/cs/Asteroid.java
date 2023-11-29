package edu.nyu.cs;

import processing.core.PApplet;
import processing.core.PImage;  

public class Asteroid {
    // instance properties
    private Game app; // will hold a reference to the main Game object
    private PImage img; // will hold a reference to an image of a star
    private int x; // will hold the x coordinate of this object on the screen
    private int y; // will hold the y coordinate of this object on the screen
    private String orientation; // will hold the direction that asteroid will move in
    private int interval; // will hold the time intervals in which the asteroid will first appear on the screen.
    private String size; // will hold the size of the asteroid (Big or Normal)

    /**
     * Constructor to create an Asteroid object at a specific position on the screen at a certain time and going in a certain direction
     * @param app a reference to the Game object that created this object
     * @param imgFilePath a filepath to an image within this project
     * @param x the x coordinate of this object on the screen
     * @param y the y coordinate of this object on the screen
     * @param orientation the direction the asteroid will move in
     * @param interval the amount of time before the asteroid first appears on the screen
     */
    public Asteroid(Game app, String imgFilePath, int x, int y, String orientation, int interval) {
        this.app = app; 
        this.img = app.loadImage(imgFilePath);
        this.x = x;
        this.y = y;
        this.orientation = orientation;
        this.interval = interval;
        this.size = "Normal";
    }
    
    /**
     * Constructor for Asteroid objects that do not specify a specific position on the screen to spawn. These
     * asteroids will be larger than the normal ones.
     * @param app a reference to the Game object that created this object
     * @param imgFilePath a filepath to an image within this project
     * @param orientation the direction the asteroid will move in
     * @param interval the amount of time before the asteroid first appears on the screen
     */
    public Asteroid(Game app, String imgFilePath, String orientation, int interval) {
        this.app = app;
        this.img = app.loadImage(imgFilePath);
        this.x = app.width/2;
        this.y = app.height/2;
        this.orientation = orientation;
        this.interval = interval;
        this.size = "Big"; 
    }

    /**
     * Draw this asteroid's image to the screen at the appropriate coordinates
     */
    public void draw() {
        this.app.imageMode(PApplet.CENTER);
        this.app.image(this.img, this.x, this.y);
    }

    /**
     * Moves the asteroid to the left.
     */
    public void moveLeft() {
        this.x -= 5;
    }

    /**
     * Moves the asteroid to the right.
     */
    public void moveRight() {
        this.x += 5;
    }

    /**
     * Retrieves the orientation of the asteroid
     * @return left if the asteroid is moving left, right otherwise
     */
    public String getOrientation() {
        return this.orientation;
    }

    /**
     * Retrieves the amount of time before the asteroid appears on the screen
     * @return integer representing milliseconds of time
     */
    public int getInterval() {
        return this.interval;
    }

    /**
     * Retrieves the size of the asteroid
     * @return 'big' if the asteroid did not specify an (x,y) coordinate, 'normal' otherwise
     */
    public String getSize() {
        return this.size;
    }
    /**
     * Determines whether a given x, y coordinate overlaps with this asteroid.
     * @param x The x coordinate of interest.
     * @param y The y coordinate of interest.
     * @return Boolean true if the x,y coordinate overlaps with this asteroid, false otherwise.
     */
    public boolean checkCrash(int x, int y) {
        // get the coordinates of all edges of this Asteroid's image
        int left = this.x - this.img.width/2 - 8; // the left edge's x coordinate
        int right = this.x + this.img.width/2 + 8; // the right edge's x coordinate
        int top = this.y - this.img.height/2 - 20; // the top edge's y coordinate
        int bottom = this.y + this.img.height/2 + 20; // the bottom edge's y coordinate
        // return whether the x,y coordinates are within the bounds of this asteroid's image
        return (x > left && x < right && y > top && y < bottom);
    }

}
