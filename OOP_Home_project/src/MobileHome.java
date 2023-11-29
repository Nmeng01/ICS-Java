package edu.nyu.cs.exam3;

/**
 * A class that represents a prefabricated mobile home,
 * You will need to modify this file to at a minimum implement the constructor:
 * 	- You must not modify the given constructor method signature.
 * 	- MobileHomes must be able to be constructed with a specified number of bedrooms, bathrooms, and number of wheels, but no land.
 *  - MobileHomes have no land.  Any atttempt to set a different lot size should trigger an InvalidHomeException to be thrown.  Your program must not crash when an exception is thrown, and should instead output EXACTLY the text, "Sorry, you have attempted to create an invalid home!"
 *  - Modify the code such that when a MobileHome is directly printed, as in the statement, « System.out.println( h ) ; », where h is a MobileHome, a description of the home and its features is printed.  MobileHomes must produce a message EXACTLY following the following template, "A 1-bedroom 1.0-bathroom mobile home with 2 wheels and no land included".  The number of bedrooms, bathrooms, and the amount of land shown in this template should be substituted for the actual details of the home being printed.  The number of bathrooms must always be output with one decimal place.
 * 	- You must avoid code redundancy by calling the Home class's constructor to set up the properties shared by all Homes.
 * 	- Your code must follow good object-oriented design, including private properties, setters, getters and any common-sense validation to avoid non-sensical values being set.
 */
public class MobileHome extends Home {
	
	/**
	 * Construct a mobile home with the specified number of bedrooms, bathrooms, and wheels.
	 * Mobile homes do not come with any land lots.
	 * This constructor must call the Home class's constructor to set up properties shared by all Homes
	 * @param numBedrooms The number of bedrooms
	 * @param numBathrooms The number of bathrooms
	 * @param numWheels The number of wheels on the mobile home
	 * @throws InvalidHomeException if any of the settings are invalid.
	 */
	public MobileHome(int numBedrooms, double numBathrooms, int numWheels) throws InvalidHomeException  {
		super(numBedrooms, numBathrooms, 0);
		this.setNumWheels(numWheels);
	}

	@Override
	public void setLotSize(int lotSize) throws InvalidHomeException {
		if(lotSize != 0) {
			throw new InvalidHomeException();
		}
		super.setLotSize(lotSize);
	}

	// how many wheels this mobile home has
	private int numWheels;
	
	/**
	 * @return the numWheels
	 */
	public int getNumWheels() {
		return numWheels;
	}

	/**
	 * @param numWheels the numWheels to set... all mobile homes must have at least 2 wheels
	 */
	public void setNumWheels(int numWheels) throws InvalidHomeException{
		if(numWheels >= 2) {
			this.numWheels = numWheels;
		}
		else {
			throw new InvalidHomeException();
		}
	}

	@Override
	public String toString() {
		String bathrooms = String.format("%.1f", this.getNumBathrooms());
		String mobileString = 
		"A " + this.getNumBedrooms() + "-bedroom " + bathrooms + "-bathroom mobile home with " + this.getNumWheels() + " wheels and no land included";
		return mobileString;
	}

}
