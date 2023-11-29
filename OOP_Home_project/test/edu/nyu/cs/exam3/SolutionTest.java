package edu.nyu.cs.exam3;

// import junit 4 testing framework
import org.junit.Test;
import org.apache.commons.lang3.StringUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.ClassRule;
import org.junit.Rule;
import static org.junit.Assert.*;
import org.junit.contrib.java.lang.system.SystemOutRule; // system rules lib - useful for capturing system output
import org.junit.contrib.java.lang.system.TextFromStandardInputStream;
import static org.junit.contrib.java.lang.system.TextFromStandardInputStream.*;
// import static org.mockito.Mockito.*;

import java.util.Arrays;

import edu.nyu.cs.exam3.Cottage;
import edu.nyu.cs.exam3.Home;
import edu.nyu.cs.exam3.HomeBuilder;
import edu.nyu.cs.exam3.InvalidHomeException;
import edu.nyu.cs.exam3.MobileHome;

public class SolutionTest {

	static HomeBuilder hb;
	static Cottage c1;
	static MobileHome m1;
	

	@Before
	public void setUp() throws Exception {
		try {
			// create test objects
			c1 = new Cottage(1, 50);
			m1 = new MobileHome(1, 1, 2);
		}
		catch (InvalidHomeException e) {
			fail("Total failure.  Couldn't make objects");
		}		
	}

	@After
	public void tearDown() throws Exception {
	}
	
	@Test
	public void testHomeBathroomValidation() {
		
		// test 0 or 1 bathrooms... should be valid
		try {
			
			// 0 bathrooms!
			c1.setNumBathrooms(0);
			assertEquals("Failed to set 0 cottage bathrooms", 0, c1.getNumBathrooms(), 0.5);

			m1.setNumBathrooms(0);
			assertEquals("Failed to set 0 mobile home bathrooms", 0, m1.getNumBathrooms(), 0.5);

			// 1 bathroom
			c1.setNumBathrooms(1);
			assertEquals("Failed to set 1 cottage bathroom", 1, c1.getNumBathrooms(), 0.5);
			
			m1.setNumBathrooms(1);
			assertEquals("Failed to set 1 mobile home bathroom", 1, m1.getNumBathrooms(), 0.5);
		}
		catch (InvalidHomeException e) {
			fail("Incorrectly threw an exception!");
		}
		
		// test negative bathrooms... should be invalid
		Exception e1 = assertThrows("Failed to throw exception for <0 cottage bathrooms", InvalidHomeException.class, () -> {
			c1.setNumBathrooms(-1);
	    });	

		Exception e2 = assertThrows("Failed to throw exception for <0 mobile home bathrooms", InvalidHomeException.class, () -> {
			m1.setNumBathrooms(-1);
	    });	
	}
	
	@Test
	public void testHomeBedroomValidation() {
		
		// test 0 or 1 bedrooms... should be valid
		try {
			
			// 0 bedrooms!
			c1.setNumBedrooms(0);
			assertEquals("Failed to set 0 cottage bedrooms", 0, c1.getNumBedrooms());

			m1.setNumBedrooms(0);
			assertEquals("Failed to set 0 mobile home bedrooms", 0, m1.getNumBedrooms());

			// 1 bedroom
			c1.setNumBedrooms(1);
			assertEquals("Failed to set 1 cottage bedroom", 1, c1.getNumBedrooms());
			
			m1.setNumBedrooms(1);
			assertEquals("Failed to set 1 mobile home bedroom", 1, m1.getNumBedrooms());
			
		}
		catch (InvalidHomeException e) {
			fail("Incorrectly threw an exception!");
		}
		
		// test negative bedrooms... should be invalid
		Exception e1 = assertThrows("Failed to throw exception for <0 cottage bedrooms", InvalidHomeException.class, () -> {
			c1.setNumBedrooms(-1);
	    });	
		
		Exception e2 = assertThrows("Failed to throw exception for <0 mobile home bedrooms", InvalidHomeException.class, () -> {
			m1.setNumBedrooms(-1);
	    });	
	}

	@Test
	public void testHomeLotSizeValidation() {
		
		// test 0 or 500 square meter lot sizes... should be valid
		try {
			
			// 0 lot size!
			c1.setLotSize(0);
			assertEquals("Failed to set 0 cottage lot size", 0, c1.getLotSize());

			// 500 lot size
			c1.setLotSize(500);
			assertEquals("Failed to set >0 cottage lot size", 500, c1.getLotSize());
			
		}
		catch (InvalidHomeException e) {
			fail("Incorrectly threw an exception!");
		}
		
		// test negative lot size... should be invalid
		Exception e = assertThrows("Failed to throw exception for <0 cottage lot size", InvalidHomeException.class, () -> {
			c1.setLotSize(-1);
	    });	
		
	}
	
	@Test
	public void testCottageBathroomValidation() {
		
		// test 2 or more cottage bathrooms... should be invalid
		Exception e = assertThrows("Failed to throw exception for >1 cottage bathrooms", InvalidHomeException.class, () -> {
			c1.setNumBathrooms(2);
	    });	
		
	}
		
	@Test
	public void testMobileHomeLotSizeValidation() {
		
		// test a lot size for mobile home... should be invalid
		Exception e = assertThrows("Failed to throw exception for mobile home >0 lot size", InvalidHomeException.class, () -> {
			m1.setLotSize(500);
	    });	
		
	}
		
	@Test
	public void testCottageConstructor() {
		try {
			// a valid cottage
			Cottage c1 = new Cottage(1, 50);
			assertEquals( "Failed to construct valid Cottage with 1 bedroom", 1, c1.getNumBedrooms());
			assertEquals("Failed to construct valid Cottage with 0 bathrooms", 0, c1.getNumBathrooms(), 0.5);
			assertEquals("Failed to construct valid Cottage with >0 lot size", 50, c1.getLotSize());

			// an invalid num bedrooms
			Exception e1 = assertThrows("Failed to throw exception for invalid Cottage with <0 bedrooms", InvalidHomeException.class, () -> {
				Cottage c2 = new Cottage(-1, 100);
		    });	
			
			// an invalid lot size
			Exception e2 = assertThrows("Failed to throw exception for invalid Cottage with <0 lot size", InvalidHomeException.class, () -> {
				Cottage c3 = new Cottage(2, -50);
		    });	
		}
		catch (InvalidHomeException e) {
			fail("Cottage constructor failure.");
		}				
	}

	@Test
	public void testMobileHomeConstructor() {
		try {
			// a valid mobile home
			MobileHome m1 = new MobileHome(1, 1, 4);
			assertEquals("Failed to construct mobile home with 1 bedroom" , 1, m1.getNumBedrooms());
			assertEquals("Failed to construct mobile home with 1 bathroom", 1, m1.getNumBathrooms(), 0.5);
			assertEquals("Failed to construct mobile home with 4 wheels"  , 4, m1.getNumWheels());
			assertEquals("Failed to construct mobile home with 0 lot size", 0, m1.getLotSize());

			// an invalid num bedrooms
			Exception e1 = assertThrows("Failed to throw exception for invalid mobile home with -1 bedrooms", InvalidHomeException.class, () -> {
				MobileHome m2 = new MobileHome(-1, 1, 4);
		    });	
			
			// an invalid num bathrooms
			Exception e2 = assertThrows("Failed to throw exception for invalid mobile home with -1 bathrooms", InvalidHomeException.class, () -> {
				MobileHome m3 = new MobileHome(1, -1, 4);
		    });	
			
		}
		catch (InvalidHomeException e) {
			fail("Cottage constructor failure.");
		}				
	}
	
	@Test
	public void testMobileHomeToString() {
//		m1 = new MobileHome(1, 1, 2);
		assertEquals("Failed to convert mobile home to string", "A 1-bedroom 1.0-bathroom mobile home with 2 wheels and no land included", m1.toString());
	}

	@Test
	public void testCottageToString() {
//		c1 = new Cottage(1, 50);
		assertEquals("Failed to convert cottage to string", "A 1-bedroom 0.0-bathroom cottage with fireplace on 50 square meters of land", c1.toString());
	}

	@Test
	public void testHomeBuilderBuild() {
		hb = new HomeBuilder();
		Home[] homes = hb.buildAFewHomes();
		
		// should have 4 homes
		assertEquals("Failed to create array with 4 homes", 4, homes.length);
		
		// check contents of each home in array
		
//		new Cottage(1, 50),
		assertEquals("Expected the first element in the homes array to be a Cottage", true, homes[0] instanceof Cottage);
		assertEquals("Incorrect home in array position 1", 1, homes[0].getNumBedrooms());
		assertEquals("Incorrect home in array position 1", 0, homes[0].getNumBathrooms(), 0.5);
		assertEquals("Incorrect home in array position 1", 50, homes[0].getLotSize());
		
//		new Cottage(2, 75),
		assertEquals("Expected the second element in the homes array to be a Cottage", true, homes[1] instanceof Cottage);
		assertEquals("Incorrect home in array position 2", 2, homes[1].getNumBedrooms());
		assertEquals("Incorrect home in array position 2", 0, homes[1].getNumBathrooms(), 0.5);
		assertEquals("Incorrect home in array position 2", 75, homes[1].getLotSize());
		
//		new MobileHome(1, 1, 2),
		assertEquals("Expected the third element in the homes array to be a MobileHome", true, homes[2] instanceof MobileHome);
		assertEquals("Incorrect home in array position 3", 1, homes[2].getNumBedrooms());
		assertEquals("Incorrect home in array position 3", 1, homes[2].getNumBathrooms(), 0.5);
		assertEquals("Incorrect home in array position 3", 0, homes[2].getLotSize());
		try {
			assertEquals("Incorrect home in array position 3", 2, ((MobileHome) homes[2]).getNumWheels());
		}
		catch (Exception e) {
			fail("Failed to cast to MobileHome");
		}
		
//		new MobileHome(2, 1, 4)
		assertEquals("Incorrect home in array position 4", true, homes[3] instanceof MobileHome);
		assertEquals("Incorrect home in array position 4", 2, homes[3].getNumBedrooms());
		assertEquals("Incorrect home in array position 4", 1, homes[3].getNumBathrooms(), 0.5);
		assertEquals("Incorrect home in array position 4", 0, homes[3].getLotSize());
		try {
			assertEquals("Incorrect home in array position 4", 4, ((MobileHome) homes[3]).getNumWheels());
		}
		catch (Exception e) {
			fail("Failed to cast to MobileHome");
		}
		
	}

	@Test
	public void testHomeBuilderUpgrade() {
		hb = new HomeBuilder();
		Home[] homes = hb.buildAFewHomes();
		
		// do an upgrade on all cottages
		hb.upgradeAllCottages(homes);
		
		// check contents of each upgraded cottage in array
		
//		new Cottage(1, 50),
		assertEquals("Failed to upgrade home in array position 1", 2, homes[0].getNumBedrooms());
		assertEquals( "Failed to upgrade home in array position 1", 0.5, homes[0].getNumBathrooms(), 0.5);
		
//		new Cottage(2, 75),
		assertEquals("Failed to upgrade home in array position 2", 3, homes[1].getNumBedrooms());
		assertEquals( "Failed to upgrade home in array position 2", 0.5, homes[1].getNumBathrooms(), 0.5);
		
	}

	@Test
	public void testHomeBuilderAdd() {
		hb = new HomeBuilder();
		Home[] homes = hb.buildAFewHomes();

		// add a new mobile home
		try {
			homes = hb.addHome(homes, new MobileHome(3, 1, 2));
		} catch (InvalidHomeException e) {
			fail("Failed to add a new home");
		}

		// check contents of the last home in the array

		//		new MobileHome(3, 1, 2)
		Home lastHome = homes[homes.length - 1];
		assertEquals("Failed to add home to array", true, lastHome instanceof MobileHome);
		assertEquals("Failed to add home to array", 3, lastHome.getNumBedrooms());
		assertEquals("Failed to add home to array", 1, lastHome.getNumBathrooms(), 0.5);
		assertEquals("Failed to add home to array", 0, lastHome.getLotSize());
		try {
			assertEquals("Failed to add home to array", 2, ((MobileHome) lastHome).getNumWheels());
		} catch (Exception e) {
			fail("Failed to cast to MobileHome");
		}

	}
		
}