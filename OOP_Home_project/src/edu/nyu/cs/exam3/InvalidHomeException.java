package edu.nyu.cs.exam3;

/**
 * Exceptions of this type must be thrown any time 
 * an invalid setting is applied to a Home object.
 */
public class InvalidHomeException extends Exception {
	public String toString() {
		return "Sorry, you have attempted to create an invalid home!";
	}
}

