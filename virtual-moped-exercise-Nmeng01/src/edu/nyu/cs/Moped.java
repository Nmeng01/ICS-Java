package edu.nyu.cs;

/**
 * A virtual moped, roaming the streets of New York.
 * The signatures of a few methods are given and must be completed and used as indicated.
 * Create as many additional properties or methods as you want, as long as the given methods behave as indicated in the instructions.
 * Follow good object-oriented design, especially the principles of abstraction (i.e. the black box metaphor) and encapsulation (i.e. methods and properties belonging to specific objects), as we have learned them.
 * The rest is up to you.
 */
public class Moped {

    // properties

    private int[] axis = {10, 5};
    private String direction = "south";
    private int gas = 100;
    private boolean reverse = false;
    public boolean bruh = true;

    /**
     * Sets the orientation of the moped to a particular cardinal direction.
     * @param orientation A string representing which cardinal direction at which to set the orientation of the moped.  E.g. "north", "south", "east", or "west".
     */
    public void setOrientation(String orientation) {
        if(orientation.equals("north") || orientation.equals("south") || orientation.equals("east") || orientation.equals("west")) {
            this.direction = orientation;
        }
    }

    /**
     * Returns the current orientation of the moped, as a lowercase String.
     * E.g. "north", "south", "east", or "west".
     * @return The current orientation of the moped, as a lowercase String.
     */
    public String getOrientation() {
        return this.direction;      
    }

    /**
     * Prints the current location, by default exactly following the format:
     *      Now at 12th St. and 5th Ave, facing south.
     *
     * If the current location is associated with location-based advertising, this method should print exactly following format:
     *      Now at 12th St. and 4th Ave, facing west.  Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?
     * 
     * Note that the suffixes for the numbers must be correct: i.e. the "st" in "1st", "nd" in "2nd", "rd" in "3rd", "th" in "4th", etc, must be correct.
     */
    public void printLocation() {
        String street = "" + this.getLocation()[0];
        String avenue = "" + this.getLocation()[1];
        switch (this.getLocation()[0]) {
            case 1:
                street += "st";
                break;
            case 2:
                street += "nd";
                break;
            case 3:
                street += "rd";
                break;
            default:
                street += "th";
        }
        switch (this.getLocation()[1]) {
            case 1:
                avenue += "st";
                break;
            case 2:
                avenue += "nd";
                break;
            case 3:
                avenue += "rd";
                break;
            default:
                avenue += "th";
        }
        String printed = "Now at " + street + " St. and " + avenue + " Ave, facing " + this.getOrientation().substring(0, 1).toUpperCase() + this.getOrientation().substring(1) + ".";
        if(this.getLocation()[0] == 79 && this.getLocation()[1] == 8) {
            printed += " Did you know the American Museum of Natural History has remains of animals from thousands of years ago on display?";
        }
        else if(this.getLocation()[0] == 74 && this.getLocation()[1] == 1) {
            printed += " Did you know the Memorial Sloan Kettering offers information and treatment about cancer for all?";
        }
        else if(this.getLocation()[0] == 56 && this.getLocation()[1] == 3) {
            printed += " Did you know Tina's Cuban Cuisine offers 10% off your first online order?";
        }
        else if(this.getLocation()[0] == 12 && this.getLocation()[1] == 4) {
            printed += " Did you know The Strand has 18 Miles of new, used and rare books, and has been in business since 1927?";
        }
        else if(this.getLocation()[0] == 15 && this.getLocation()[1] == 8) {
            printed += " We have reached Xi'an Famous Foods.  Enjoy your noodles.";
        }
        System.out.println(printed);
    }

    /**
     * Handles the command, `go left`.
     * Moves the moped one block to the left, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goLeft() {
        if(this.getGasLevel() > 0) {    
            if(this.getOrientation().equals("north")) {
                int[] newAxis = {this.axis[0], this.axis[1] + 1};
                this.setLocation(newAxis);
                this.useGas(newAxis);
                if(reverse) {
                    this.setOrientation("east");
                }
                else {
                    this.setOrientation("west");
                }
            }
            else if(this.getOrientation().equals("south")) {
                int[] newAxis = {this.axis[0], this.axis[1] - 1};
                this.setLocation(newAxis);
                this.useGas(newAxis);
                if(reverse) {
                    this.setOrientation("west");
                }
                else {
                    this.setOrientation("east");
                }
            }
            else if(this.getOrientation().equals("west")) {
                int[] newAxis = {this.axis[0] - 1, this.axis[1]};
                this.setLocation(newAxis);
                this.useGas(newAxis);
                if(reverse) {
                    this.setOrientation("north");
                }
                else {
                    this.setOrientation("south");
                }
            }
            else {
                int[] newAxis = {this.axis[0] + 1, this.axis[1]};
                this.setLocation(newAxis);
                this.useGas(newAxis);
                if(reverse) {
                    this.setOrientation("south");
                }
                else {
                    this.setOrientation("north");
                }
            }
        }
    }

    /**
     * Handles the command, `go right`.
     * Moves the moped one block to the right, and causes the moped to face the appropriate new cardinal direction.
     * Consumes gas with each block moved, and doesn't move or turn unless there is sufficient gas, as according to the instructions.
     * If attempting to drive off the map, the moped will turn but not move a block.  Turns-only consume no gas.
     * This method must not print anything.
     */
    public void goRight() {
        if(this.getGasLevel() > 0) {    
            if(this.getOrientation().equals("north")) {
                int[] newAxis = {this.axis[0], this.axis[1] - 1};
                this.setLocation(newAxis);
                this.useGas(newAxis);;
                if(reverse) {
                    this.setOrientation("west");
                }
                else {
                    this.setOrientation("east");
                }
            }
            else if(this.getOrientation().equals("south")) {
                int[] newAxis = {this.axis[0], this.axis[1] + 1};
                this.setLocation(newAxis);
                this.useGas(newAxis);
                if(reverse) {
                    this.setOrientation("east");
                }
                else {
                    this.setOrientation("west");
                }
            }
            else if(this.getOrientation().equals("west")) {
                int[] newAxis = {this.axis[0] + 1, this.axis[1]};
                this.setLocation(newAxis);
                this.useGas(newAxis);
                if(reverse) {
                    this.setOrientation("south");
                }
                else {
                    this.setOrientation("north");
                }
            }
            else {
                int[] newAxis = {this.axis[0] - 1, this.axis[1]};
                this.setLocation(newAxis);
                this.useGas(newAxis);
                if(reverse) {
                    this.setOrientation("north");
                }
                else {
                    this.setOrientation("south");
                }
            }
        }
    }

    /**
     * Handles the command,`straight on`.
     * Moves the moped one block straight ahead.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goStraight() {
        if(this.getGasLevel() > 0) {    
            if(this.getOrientation().equals("north")) {
                int[] newAxis = {this.axis[0] + 1, this.axis[1]};
                this.setLocation(newAxis);
                this.useGas(newAxis);;
            }
            else if(this.getOrientation().equals("south")) {
                int[] newAxis = {this.axis[0] - 1, this.axis[1]};
                this.setLocation(newAxis);
                this.useGas(newAxis);
            }
            else if(this.getOrientation().equals("west")) {
                int[] newAxis = {this.axis[0], this.axis[1] + 1};
                this.setLocation(newAxis);
                this.useGas(newAxis);
            }
            else {
                int[] newAxis = {this.axis[0], this.axis[1] - 1};
                this.setLocation(newAxis);
                this.useGas(newAxis);
            }
            reverse = false;
        }
    }

    /**
     * Handles the command,`back up`.
     * Moves the moped one block backwards, but does not change the cardinal direction the moped is facing.
     * Consumes gas with each block moved, and doesn't move unless there is sufficient gas, as according to the instructions.
     * This method must not print anything.
     */
    public void goBackwards() {
        if(this.getGasLevel() > 0) {    
            if(this.getOrientation().equals("north")) {
                int[] newAxis = {this.axis[0] - 1, this.axis[1]};
                this.setLocation(newAxis);
                this.useGas(newAxis);;
            }
            else if(this.getOrientation().equals("south")) {
                int[] newAxis = {this.axis[0] + 1, this.axis[1]};
                this.setLocation(newAxis);
                this.useGas(newAxis);
            }
            else if(this.getOrientation().equals("west")) {
                int[] newAxis = {this.axis[0], this.axis[1] - 1};
                this.setLocation(newAxis);
                this.useGas(newAxis);
            }
            else {
                int[] newAxis = {this.axis[0], this.axis[1] + 1};
                this.setLocation(newAxis);
                this.useGas(newAxis);
            }
            reverse = true;
        }
    }

    /**
     * This method must not print anything.
     * @return The current gas level, as an integer from 0 to 100.
     */
    public int getGasLevel() {
       return this.gas; 
    }

    /**
     * This method determines whether to use gas based on where the moped is
     * @param location The current location of the moped
     */
    public void useGas(int[] location) {
        if(location[0] < 201 && location[0] > 0 && location[1] < 11 && location[1] > 0) {
            this.gas -= 5;
        }
    }

    /**
     * Handles the command,`how we doin'?`.
     * Prints the current gas level, by default exactly following the format:
     *      The gas tank is currently 85% full.
     *
     * If the moped is out of gas, this method should print exactly following format:
     *      We have run out of gas.  Bye bye!
     */
    public void printGasLevel() {
        if(this.getGasLevel() > 0) {
            System.out.println("The gas tank is currently " + getGasLevel() + "% full.");
        }
        else {
            System.out.println("We have run out of gas. Bye bye!");
        }
    }

    /**
     * Handles the command, `fill it up`.
     * This method must not print anything.
     * Fills the gas level to the maximum.
     */
    public void fillGas() {
        this.gas = 100;
    }

    /**
     * Fills up the gas automatically
     */
    public void autoFill() {
        if(this.getGasLevel() == 0) {
            this.fillGas();
        }
    }

    /**
     * Handles the command, `park`.
     * This causes the program to quit.  
     * You can use System.exit(0); to cause a program to quit with status code 0, which indicates a normal graceful exit. 
     * (In case you were wondering, status code 1 represents quitting as a result of an error of some kind).
     */
    public void park() {
        System.exit(0);
    }

    /**
     * Handles the command, `go to Xi'an Famous Foods`
     * Causes the moped to self-drive, block-by-block, to 8th Ave. and 15th St.
     * Consumes gas with each block, and doesn't move unless there is sufficient gas, as according to the instructions.
     */
    public void goToXianFamousFoods() {
        if(this.getGasLevel() > 0) {
            if(this.getLocation()[0] == 15 && this.getLocation()[1] == 8) {
                printLocation();
            }
            reverse = false;
            if(this.getLocation()[0] > 15) {
                this.setOrientation("south");   
                int iterator = this.getLocation()[0] - 15;
                for(int i = 0; i < iterator; i++) {
                    this.goStraight();
                    this.autoFill();
                    this.printLocation();
                }
            }
            if(this.getLocation()[0] < 15) {
                this.setOrientation("north");
                int iterator = 15 - this.getLocation()[0];
                for(int i = 0; i < iterator; i++) {
                    this.goStraight();
                    this.autoFill();
                    this.printLocation();
                }
            }
            if(this.getLocation()[1] > 8) {
                this.setOrientation("east");
                int iterator = this.getLocation()[1] - 8;
                for(int i = 0; i < iterator; i++) {
                    this.goStraight();
                    this.autoFill();
                    this.printLocation();
                }
            }
            if(this.getLocation()[1] < 8) {
                this.setOrientation("west");
                int iterator = 8 - this.getLocation()[1];
                for(int i = 0; i < iterator; i++) {
                    this.goStraight();
                    this.autoFill();
                    this.printLocation();
                }
            }
        }                
    }

    /**
     * Generates a string, containing a list of all the user commands that the program understands.
     * @return String containing commands that the user can type to control the moped.
     */
    public String getHelp() {
        String help = "go left\ngo right\nstraight on\nback up\nfill it up\nhow we doin'?\ngo to Xi'an Famous Foods\npark";
        return help;        
    }

    /**
     * Sets the current location of the moped.
     * @param location an int array containing the new location at which to place the moped, in the order {street, avenue}.
     */
    public void setLocation(int[] location) {
        if(location[0] < 201 && location[0] > 0 && location[1] < 11 && location[1] > 0) {
            this.axis = new int[location.length];
            for(int i = 0; i < axis.length; i++) {
                this.axis[i] = location[i];
            }
        }
    }

    /**
     * Gets the current location of the moped.
     * @return The current location of the moped, as an int array in the order {street, avenue}.
     */
    public int[] getLocation() {
        return this.axis;
    }

}
