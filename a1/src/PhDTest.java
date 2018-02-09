import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PhDTest {

	@Test
	void testConstructor1() {
		PhD dr = new PhD("Gries", 12, 1966);
		
		
		assertEquals("Gries", dr.name());
		assertEquals(12, dr.month());
		assertEquals(1966, dr.year());
		assertEquals(null, dr.advisor1());
		assertEquals(null, dr.advisor2());
		assertEquals(0, dr.numAdvisees());
	}
	
	@Test
	void testGroupB() {
		// TODO: test numadvisees
		PhD ramya = new PhD("Ramya", 9, 2059);
		PhD attell = new PhD("Kevin", 3, 1980);
		ramya.setAdvisor1(attell);
		assertEquals(1, attell.numAdvisees());
		assertEquals(attell, ramya.advisor1());
		
		PhD gries = new PhD("Gries", 12, 1966);
		ramya.setAdvisor2(gries);
		gries.setAdvisor1(attell);
		assertEquals(1, gries.numAdvisees());
		assertEquals(2, attell.numAdvisees());
		assertEquals(gries, ramya.advisor2());
		assertEquals(attell, gries.advisor1());
	}
	
	@Test
	void testGroupCC() {
		PhD stoer = new PhD("Joseph", 4, 1919);
		PhD karen = new PhD("Karen", 10, 2018);
		PhD bauer = new PhD("Friedrich", 2, 1927, stoer);
		
		//start test with constructor 2 
		assertEquals("Friedrich", bauer.name());
		assertEquals(2, bauer.month());
		assertEquals(1927, bauer.year());
		assertEquals(stoer, bauer.advisor1());
		assertEquals(null, bauer.advisor2());
		assertEquals(0, bauer.numAdvisees());

		PhD dr = new PhD("Gries", 12, 1966, bauer, stoer);
		//start test constructor 3
		assertEquals("Gries", dr.name());
		assertEquals(12, dr.month());
		assertEquals(1966, dr.year());
		assertEquals(bauer, dr.advisor1());
		assertEquals(stoer, dr.advisor2());
		assertEquals(0, dr.numAdvisees());
	}
	
	@Test
	void testGroupD() {
		PhD stoer = new PhD("Joseph", 4, 1919);
		PhD bauer = new PhD("Friedrich", 4, 1919, stoer);
		PhD gries = new PhD("Gries", 3, 1919, bauer, stoer);
		PhD ramya = new PhD("cheese", 5, 1919);
		PhD denice = new PhD("Denice", 3, 1918);
		PhD dave = new PhD("Happy", 2, 1918);
		PhD attell = new PhD("Kevin", 4, 1918);
		PhD karen = new PhD("Zhang", 3, 1920);
		PhD shreya = new PhD("A+", 2, 1920);
		PhD jannie = new PhD("A++", 4, 1920);
		
		//test hasAdvisee
		assertEquals(true, stoer.hasAdvisee());
		assertEquals(true, bauer.hasAdvisee());
		assertEquals(false, gries.hasAdvisee());
		
		//test gotAfter
		assertEquals(false, stoer.gotAfter(null));
		
		assertEquals(false, stoer.gotAfter(bauer));
		assertEquals(true, stoer.gotAfter(gries)); 
		assertEquals(true, ramya.gotAfter(gries));
		
		assertEquals(false, denice.gotAfter(gries));
		assertEquals(false, dave.gotAfter(gries));
		assertEquals(true, attell.gotAfter(denice));
		
		assertEquals(true, karen.gotAfter(gries));
		assertEquals(true, shreya.gotAfter(gries));
		assertEquals(true, jannie.gotAfter(gries));
		
				
		//test areSiblings
		PhD griesBro = new PhD("GriesBro", 12, 1966, bauer);
		PhD crying = new PhD("sobbing", 12, 1955, bauer, stoer);
		PhD existential = new PhD("crisis", 12, 1929, stoer);
		PhD confused = new PhD("assignment", 12, 1231, griesBro, stoer);
		
		assertEquals(false, bauer.areSiblings(bauer));
		assertEquals(false, ramya.areSiblings(denice));
		assertEquals(true, crying.areSiblings(griesBro));
		assertEquals(true, crying.areSiblings(existential));
		assertEquals(true, confused.areSiblings(existential));
		assertEquals(true, crying.areSiblings(confused));
				
	}
	

}
