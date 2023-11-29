package edu.nyu.cs.exam3;

/**
 * An abstract representation of a home.
 * You will need to modify this file to add validation to the setters in the Home class.  
 * 	- The numBedrooms, numBathrooms, and lot size must be 0 or greater. 
 * 	- If any of these setters receive a number less than zero, they must throw an InvalidHomeException - you must complete the code for this exception class in order for this to work.  
 *  - Your program must not crash when an exception is thrown, and should instead output EXACTLY the text, "Sorry, you have attempted to create an invalid home!"
 * 	- Your code must follow good object-oriented design, including private properties, setters, getters and any common-sense validation to avoid non-sensical values being set.
 */
public abstract class Home {
	
	/**
	 * Constructor with arguments
	 * @param numBedrooms How many bedrooms this home has
	 * @param numBathrooms How many bathrooms this home has
	 * @param lotSize Amount of land this home sits on, in square meters
	 * @throws InvalidHomeException if any of the settings are invalid.
	 */
	public Home(int numBedrooms, double numBathrooms, int lotSize) throws InvalidHomeException {
		//set the properties
		this.setNumBedrooms(numBedrooms);
		this.setNumBathrooms(numBathrooms);
		this.setLotSize(lotSize);
	}
	
	//some properties of all Homes
	private int numBedrooms;
	private double numBathrooms;
	private int lotSize;
	private boolean cozy = true;

	/**
	 * Setter for the numBedrooms property
	 * @param numBedrooms How many bedrooms this home has
	 */
	public void setNumBedrooms(int numBedrooms) throws InvalidHomeException {
		if(numBedrooms >= 0) {
			this.numBedrooms = numBedrooms;
		}
		else {
			throw new InvalidHomeException();
		}
	}
	
	/**
	 * Getter for the numBedrooms property
	 * @return the number of bedrooms in this home
	 */
	public int getNumBedrooms() {
		return this.numBedrooms;
	}

	/**
	 * @return the numBathrooms
	 */
	public double getNumBathrooms() {
		return numBathrooms;
	}

	/**
	 * @param numBathrooms the numBathrooms to set
	 */
	public void setNumBathrooms(double numBathrooms) throws InvalidHomeException {
		if(numBathrooms >= 0) {
			this.numBathrooms = numBathrooms;
		}
		else {
			throw new InvalidHomeException();
		}
	}

	/**
	 * @return the lotSize
	 */
	public int getLotSize() {
		return lotSize;
	}

	/**
	 * @param lotSize the lotSize to set
	 */
	public void setLotSize(int lotSize) throws InvalidHomeException {
		if(lotSize >= 0) {
			this.lotSize = lotSize;
		}
		else {
			throw new InvalidHomeException();
		}
	}

	/**
	 * @return the cozy
	 */
	public boolean isCozy() {
		return cozy;
	}

	/**
	 * @param cozy the cozy to set
	 */
	public void setCozy(boolean cozy) {
		this.cozy = cozy;
	}
	
}
