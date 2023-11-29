package edu.nyu.cs;

import java.nio.file.Paths;
import java.util.ArrayList;

import org.apache.commons.lang3.SystemUtils;

import processing.core.*; // import the base Processing library
import processing.sound.*; // import the processing sound library

/**
 * This is Space Race! Two players can play at the same time, and the goal is to have the most points at the end of the
 * 60 second match. To score points, you have to reach the other side of the screen without hitting any of the passing 
 * asteroids. If you touch an asteroid, you are sent back to the beginning! To move up and down, Player 1 (on the left) 
 * can use the 'w' and 's' keys, while Player 2 (on the right) can use the UP and DOWN arrow keys. 
 * Note: watch out for the big asteroid that randomly spawns in the middle of the screen. It randomly chooses which way
 * (right or left) to go and will make the player lose a point if they crash into it!
 * 
 * @author Nicholas Meng 
 * @version 0.1
 */
public class Game extends PApplet {

  private SoundFile soundStartup; // will refer to a sound file to play when the program first starts
  private SoundFile soundCrash; // will refer to a sound file to play when the user crashes into an asteroid
  private SoundFile soundSuccess; // will refer to a sound file to play when the user scores a point
  private ArrayList<Asteroid> asteroids; // will hold an ArrayList of Asteroid objects
  private ArrayList<Asteroid> asteroidsLaunched; // will hold an ArrayList of Asteroid objects that are on the screen
  private ArrayList<Rocket> rockets; // will hold an ArrayList of Rocket objects
  private final int numAsteroids = 15; // the number of asteroids to create
  private final int totalTime = 60000; // the duration of the game in milliseconds
  private int score1 = 0; // player 1's score
  private int score2 = 0; // player 2's score
  private boolean up1 = false; // indicates if player 1 is moving up
  private boolean down1 = false; // indicates if player 1 is moving down
  private boolean up2 = false; // indicates if player 2 is moving up
  private boolean down2 = false; // // indicates if player 2 is moving down


	/**
	 * This method will be automatically called by Processing when the program runs.
   * - Use it to set up the initial state of any instance properties you may use in the draw method.
	 */
	public void setup() {
    // load up a sound file and play it once when program starts up
		String cwd = Paths.get("").toAbsolutePath().toString(); 
    String path = Paths.get(cwd, "sounds", "vibraphon.mp3").toString(); // filepath to the image/sound file we want
    this.soundStartup = new SoundFile(this, path);
    this.soundStartup.play();

    // load up a sound file and play it once when the user crashes into an asteroid
		path = Paths.get(cwd, "sounds", "crash.wav").toString(); 
    this.soundCrash = new SoundFile(this, path); 

    // load up a sounds file and play it once when the user gets to the other side
    path = Paths.get(cwd, "sounds", "success.mp3").toString(); 
    this.soundSuccess = new SoundFile(this, path);

    // create some asteroids, starting life on the left or right side of the screen, and put them in an ArrayList
    asteroids = new ArrayList<Asteroid>();
    asteroidsLaunched = new ArrayList<Asteroid>();
    path = Paths.get(cwd, "images", "asteroid.png").toString(); // e.g "images/asteroid.png" on Mac/Unix vs. "images\asteroid.png" on Windows
    for (int i=0; i<this.numAsteroids; i++) {
      int randHeight = (int) (Math.random() * 725); // random y-coordinate to place the asteroid at
      int randOrientation = (int) (Math.random() * 2); // random direction for the asteroid to be moving in (left or right)
      int randInterval = (int) (Math.random() * 4); // random time interval for when the asteroid enters the screen
      randInterval = randInterval * 1000;
      if(randOrientation == 0){
        Asteroid asteroid = new Asteroid(this, path, this.width, randHeight, "Left", randInterval);
        this.asteroids.add(asteroid);
      }
      else {
        Asteroid asteroid = new Asteroid(this, path, 0, randHeight, "Right", randInterval);
        this.asteroids.add(asteroid);
      }
    }
    // Create the big asteroid and add it to the asteroids ArrayList
    path = Paths.get(cwd, "images", "big_asteroid.png").toString();
    int randOrientation = (int) (Math.random() * 2);
    int randInterval = (int) (Math.random() * 4);
      randInterval = randInterval * 1000;
    if(randOrientation == 0) {
      Asteroid bigAsteroid = new Asteroid(this, path, "Left", randInterval);
      this.asteroids.add(bigAsteroid);
    }
    else {
      Asteroid bigAsteroid = new Asteroid(this, path, "Right", randInterval);
      this.asteroids.add(bigAsteroid);
    }
    // Create the rockets
    path = Paths.get(cwd, "images", "rocket.png").toString();
    rockets = new ArrayList<Rocket>();
    Rocket rocket1 = new Rocket(this, path, this.width/4, this.height - 25);
    this.rockets.add(rocket1);
    Rocket rocket2 = new Rocket(this, path, (this.width/4) * 3, this.height - 25);
    this.rockets.add(rocket2);
	}

	/**
	 * This method is called automatically by Processing every 1/60th of a second by default.
   * Draws the asteroids and rockets onto the screen 
   * If the user crashes into an asteroid, they are sent back to the beginning
   * If the user makes it to the end, they score a point
   * If the user crashes into the big asteroid, they lose a point
	 */
   public void draw() {
    this.background(0, 0, 0);
    // Draw the rockets
    String cwd = Paths.get("").toAbsolutePath().toString();
    String path = Paths.get(cwd, "images", "rocket.png").toString();
    if(up1 == true) {
      rockets.get(0).moveUp();
    }
    if(down1 == true && rockets.get(0).getY() <= this.height - 25) {
      rockets.get(0).moveDown();
    }
    if(up2 == true) {
      rockets.get(1).moveUp();
    }
    if(down2 == true && rockets.get(1).getY() <= this.height - 25) {
      rockets.get(1).moveDown();
    }
    if(rockets.get(0).getY() <= 0) {
      this.soundSuccess.play();
      rockets.get(0).resetY();
      score1++;
    }
    if(rockets.get(1).getY() <= 0) {
      this.soundSuccess.play();
      rockets.get(1).resetY();
      score2++;
    }
    rockets.get(0).draw();
    rockets.get(1).draw();
    // Draw the asteroids
    path = Paths.get(cwd, "images", "asteroid.png").toString();
    for(int j = 0; j < this.asteroids.size(); j++) {
      Asteroid asteroid = this.asteroids.get(j);
      int randHeight = (int) (Math.random() * 725);
      int randOrientation = (int) (Math.random() * 2);
      int randInterval = (int) (Math.random() * 4);
      randInterval = (randInterval * 1000) + asteroid.getInterval();
      if(millis() > asteroid.getInterval()) {
        this.asteroidsLaunched.add(asteroid);
        if(randOrientation == 0) {
          if(asteroid.getSize().equals("Big")) {
            path = Paths.get(cwd, "images", "big_asteroid.png").toString();
            Asteroid newAsteroid = new Asteroid(this, path, "Left", randInterval);
            this.asteroids.set(asteroids.indexOf(asteroid), newAsteroid);
          }
          else {
            path = Paths.get(cwd, "images", "asteroid.png").toString();
            Asteroid newAsteroid = new Asteroid(this, path, this.width, randHeight, "Left", randInterval);
            this.asteroids.set(asteroids.indexOf(asteroid), newAsteroid);
          }
        }
        else {
          if(asteroid.getSize().equals("Big")) {
            path = Paths.get(cwd, "images", "big_asteroid.png").toString();
            Asteroid newAsteroid = new Asteroid(this, path, "Right", randInterval);
            this.asteroids.set(asteroids.indexOf(asteroid), newAsteroid);
          }
          else {
            path = Paths.get(cwd, "images", "asteroid.png").toString();
            Asteroid newAsteroid = new Asteroid(this, path, 0, randHeight, "Right", randInterval);
            this.asteroids.set(asteroids.indexOf(asteroid), newAsteroid);
          }
        }
      }
    }

    for(int i = 0; i < asteroidsLaunched.size(); i++) {
      Asteroid asteroid = this.asteroidsLaunched.get(i); 
      if(asteroid.getOrientation().equals("Left")) {
        asteroid.moveLeft(); 
      }
      else {
        asteroid.moveRight();
      }
      asteroid.draw();
      if(asteroid.checkCrash(rockets.get(0).getX(), rockets.get(0).getY())) {
        this.soundCrash.play();
        rockets.get(0).resetY();
        if(asteroid.getSize().equals("Big")) {
          this.score1--;
        }
      }
      if(asteroid.checkCrash(rockets.get(1).getX(), rockets.get(1).getY())) {
        this.soundCrash.play();
        rockets.get(1).resetY();
        if(asteroid.getSize().equals("Big")) {
          this.score2--;
        }
      }
    }

    // show the score at the bottom of the window
    String score1String = String.format("PLAYER 1 SCORE: %d", this.score1);
    String score2String = String.format("PLAYER 2 SCORE: %d", this.score2);
    textAlign(LEFT);
    text(score1String, 5, this.height-25);
    textAlign(RIGHT);
    text(score2String, this.width - 5, this.height-25);
    // Games ends after 60 seconds
    if(millis() >= totalTime) {
      background(51);
      textSize(128);
      textAlign(CENTER);
      text("GAME OVER!", this.width/2, this.height/2 - 250);
      textSize(100);
      text(score1String, this.width/2, (this.height/2) - 50);
      text(score2String, this.width/2, (this.height/2) + 150);
      if(this.score1 > this.score2) {
        text("PLAYER 1 WINS!", this.width/2, (this.height/2) + 350);
      }
      else if(this.score1 < this.score2) {
        text("PLAYER 2 WINS!", this.width/2, (this.height/2) + 350);
      }
      else {
        text("IT'S A TIE!", this.width/2, (this.height/2) + 350);
      }
      noLoop();
    }
	}

  /**
   * Allows Player 1 to move their rocket using the 'w' and 's' keys
   * Allows Player 2 to move their rocket using the UP and DOWN arrow keys
   */
  public void keyPressed() {
    if(this.keyCode == UP) {
      up2 = true;
    }
    if(this.keyCode == DOWN) {
      down2 = true;
    }
    if(this.key == 'w'){
      up1 = true;
    }
    if(this.key == 's') {
      down1 = true;
    }
  }

  /**
   * Allows the players to stop moving once they release the movement keys
   */
  public void keyReleased() {
    if(this.keyCode == UP) {
      up2 = false;
    }
    if(this.keyCode == DOWN) {
      down2 = false;
    }
    if(this.key == 'w'){
      up1 = false;
    }
    if(this.key == 's') {
      down1 = false;
    }
  }

  /**
   * A method that can be used to modify settings of the window, such as set its size.
   * This method shouldn't really be used for anything else.  
   * Use the setup() method for most other tasks to perform when the program first runs.
   */
  public void settings() {
		size(1200, 800); // set the map window size, using the OpenGL 2D rendering engine
		System.out.println(String.format("Set up the window size: %d, %d.", width, height));    
  }

  /**
   * The main function is automatically called first in a Java program.
   * When using the Processing library, this method must call PApplet's main method and pass it the full class name, including package.
   * You shouldn't need to modify this method.
   * 
   * @param args An array of any command-line arguments.
   */
  public static void main(String[] args) {
    // make sure we're using Java 1.8
		System.out.printf("\n###  JDK IN USE ###\n- Version: %s\n- Location: %s\n### ^JDK IN USE ###\n\n", SystemUtils.JAVA_VERSION, SystemUtils.getJavaHome());
		boolean isGoodJDK = SystemUtils.IS_JAVA_1_8;
		if (!isGoodJDK) {
			System.out.printf("Fatal Error: YOU MUST USE JAVA 1.8, not %s!!!\n", SystemUtils.JAVA_VERSION);
		}
		else {
			PApplet.main("edu.nyu.cs.Game"); // do not modify this!
		}
  }

}
