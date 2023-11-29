package edu.nyu.cs.exam3;

/**
 * A test class.
 * No need to modify this file.
 *  
 * If you have completed all code correctly, running this program
 *  should output the following text:
 *    A 2-bedroom 0.5-bathroom cottage with fireplace on 50 square meters of land
 *    A 3-bedroom 0.5-bathroom cottage with fireplace on 75 square meters of land
 *    A 1-bedroom 1.0-bathroom mobile home with 2 wheels and no land included
 *    A 2-bedroom 1.0-bathroom mobile home with 4 wheels and no land included
 *    A 3-bedroom 1.0-bathroom mobile home with 2 wheels and no land included
 */
public class App {
	
	public static void main(String[] args) {
		
		// create an object that will help us build and play with some homes
		HomeBuilder hb = new HomeBuilder();
		
		// build a few homes
		Home[] homes = hb.buildAFewHomes();
		
		// upgrade the cottages
		hb.upgradeAllCottages(homes);
		
		// add a new mobile home to the end of the list
		try {
			homes = hb.addHome(homes, new MobileHome(3, 1, 2));
		}
		catch (InvalidHomeException e) {
			System.out.println("Sorry, you have attempted to create an invalid home!");		
		}
		
		// output details of each home
		for (Home home : homes) {
			System.out.println(home);
		}
		
	}

}
