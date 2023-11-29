package edu.nyu.cs;

import processing.core.PApplet;
import processing.core.PImage;  

public class Rocket {
    // instance properties
    private Game app; // will hold a reference to the main Game object
    private PImage img; // will hold a reference to an image of a star
    private int x; // will hold the x coordinate of this object on the screen
    private int y; // will hold the y coordinate of this object on the screen

    /**
     * Constructor to create a Rocket object at a specific position
     * @param app a reference to the Game object that created this object
     * @param imgFilePath a filepath to an image within this project
     * @param x the x coordinate of this object on the screen
     * @param y the y coordinate of this object on the screen
     */
    public Rocket(Game app, String imgFilePath, int x, int y) {
        this.app = app;
        this.img = app.loadImage(imgFilePath);
        this.x = x;
        this.y = y;
    }

    /**
     * Draw this rocket's image to the screen at the appropriate coordinates
     */
    public void draw() {
        this.app.imageMode(PApplet.CENTER);
        this.app.image(this.img, this.x, this.y);
    }

    /**
     * Moves the asteroid up
     */
    public void moveUp() {
        this.y -= 5;
    }

    /**
     * Moves the asteroid down
     */
    public void moveDown() {
        this.y += 5;
    }

    /**
     * Retrieves the x-coordinate of the rocket
     * @return integer value representing the horizontal position of the rocket
     */
    public int getX() {
        return this.x;
    }

    /**
     * Places the rocket back at the beginning of the race
     */
    public void resetY() {
        this.y = app.height - 25;
    }

    /**
     * Retrieves the y-coordinate of the rocket
     * @return integer value representing the vertical position of the rocket
     */
    public int getY() {
        return this.y;
    }
}
