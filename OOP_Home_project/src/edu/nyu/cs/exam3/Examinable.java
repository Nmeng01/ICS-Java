package edu.nyu.cs.exam3;

/**
 * Methods that must be implemented by the HomeBuilder class.
 * No need to modify this file.
 */
public interface Examinable {

	/**
	 * Implementations of this method must instantiate four objects and return them in an array.
	 *     A Cottage, with 1 bedroom, no bathroom, and 50 square meter lot size.
	 *     A Cottage, with 2 bedrooms, no bathroom, and 75 square meter lot size.
	 *     A MobileHome, with 1 bedroom, 1 bathroom, 0 square meter lot size, and 2 wheels.
	 *     A MobileHome, with 2 bedrooms, 1 bathroom, 0 square meter lot size, and 4 wheels.
	 * The order of objects in the array must follow the order of this list.
	 * @return An array containing these four objects.
	 */
	public abstract Home[] buildAFewHomes();
	
	/**
	 * Upgrade any cottages with the following additions:
	 * 		add one more bedroom
	 * 		add 1/2 more bathroom
	 * You are forbidden from hard-coding the number of bedrooms or bathrooms.
	 * @param homes An array with various types of Homes.
	 */
	public abstract void upgradeAllCottages(Home[] homes);
	
	/**
	 * Append a new Home to the end of an array of existing Homes.
	 * @param homes The array of current Homes
	 * @param home The new Home to add to the array of Homes
	 * @return The updated array of homes with the new home added at the end.
	 */
	public abstract Home[] addHome(Home[] homes, Home home);
	
}
