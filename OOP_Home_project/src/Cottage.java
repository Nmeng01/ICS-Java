package edu.nyu.cs.exam3;

/**
 * A class that represents rustic cottages, with no bathrooms.
 * You will need to modify this file to at a minimum implement the constructor:
 * 	- You must not modify the given constructor method signature.
 * 	- Cottages, must be able to be constructed with a specified number of bedrooms and lot size, but with no bathrooms.  
 *  - Cottages, in order to preserve their rustic charm, can have no more than 1 bathroom.  If any attempt is made to create more than 1 bathroom for a Cottage an InvalidHomeException must be thrown.  Your program must not crash when an exception is thrown, and should instead output EXACTLY the text, "Sorry, you have attempted to create an invalid home!"
 * 	- When a Cottage object is directly printed, as in the statement, « System.out.println( h ) ; », where h is either a Cottage object, a description of the home and its features is printed.  Cottages must print a message following EXACTLY the format, "A 2-bedroom 0.5-bathroom cottage with fireplace on 50 square meters of land".  The number of bedrooms, bathrooms, and the amount of land shown in this template should be substituted for the actual details of the home being printed.  The number of bathrooms must always be output with one decimal place.
 * 	- You must avoid code redundancy by calling the Home class's constructor to set up the properties shared by all Homes.
 * 	- Your code must follow good object-oriented design, including private properties, setters, getters and any common-sense validation to avoid non-sensical values being set.
 */
public class Cottage extends Home {
	
	/**
	 * Construct a cottage with the specified number of bedroom, lot size.
	 * Cottages do not come with bathrooms, by default.
	 * This constructor must call the Home class's constructor to set up properties shared by all Homes
	 * @param numBedrooms How many bedrooms this Home has
	 * @param lotSize Amount of land this home sits on, in square meters... all Cottages have at least 200 square meters of land
	 * @throws InvalidHomeException if any of the settings are invalid.
	 */
	public Cottage(int numBedrooms, int lotSize) throws InvalidHomeException {
		super(numBedrooms, 0, lotSize);
	}

	@Override
	public void setNumBathrooms(double numBathrooms) throws InvalidHomeException {
		if(numBathrooms > 1) {
			throw new InvalidHomeException();
		}
		super.setNumBathrooms(numBathrooms);
	}

	// whether this cottage has a fireplace
	private boolean hasFireplace = true;

	public void setFireplace(boolean fireplace) {
		this.hasFireplace = fireplace;
	}

	public boolean hasFireplace() {
		return this.hasFireplace;
	}

	@Override
	public String toString() {
		String bathrooms = String.format("%.1f", this.getNumBathrooms());
		String cottageString = 
		"A " + this.getNumBedrooms() + "-bedroom " + bathrooms + "-bathroom cottage " + ((this.hasFireplace()) ? "with fireplace" : "without fireplace") + " on " + this.getLotSize() + " square meters of land";
		return cottageString;
	}
	
}
