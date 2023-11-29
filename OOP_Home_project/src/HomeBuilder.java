package edu.nyu.cs.exam3;

import java.util.Arrays;

/**
 * A useful class for instantiating and performing batch operations on Homes.
 * You will need to modify this file.
 * 	- implement the buildAFewHomes( ) method declared and documented within the Examinable interface.
 *  - implement the upgradeAllCottages( ) method declared and documented within the Examinable interface.
 *  - implement the addHome( ) method declared and documented within the Examinable interface.
 */
public class HomeBuilder implements Examinable {
	
	public Home[] buildAFewHomes() {
		try {
			Cottage c1 = new Cottage(1, 50);
			c1.setNumBathrooms(0);
			Cottage c2 = new Cottage(2, 75);
			c2.setNumBathrooms(0);
			MobileHome m1 = new MobileHome(1, 1, 2);
			MobileHome m2 = new MobileHome(2, 1, 4);
			Home[] homes = {c1, c2, m1, m2};
			return homes;
		}
		catch(InvalidHomeException e) {
			System.out.println(e);
		}
		return new Home[] {};
	}

	public void upgradeAllCottages(Home[] homes) {
			for(Home h1 : homes) {
				if(h1 instanceof Cottage) {
					try {
						h1.setNumBedrooms(h1.getNumBedrooms() + 1);
						h1.setNumBathrooms(h1.getNumBathrooms() + 0.5);
					}
					catch(InvalidHomeException e) {
						System.out.println(e);
					}
				}
			}
	}

	public Home[] addHome(Home[] homes, Home home) {
		Home[] newHomes = Arrays.copyOf(homes, homes.length + 1);
		newHomes[newHomes.length - 1] = home;
		return newHomes;
	}
}
