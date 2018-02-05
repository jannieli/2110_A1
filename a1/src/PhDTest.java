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
		PhD ramya = new PhD("Ramya", 9, 2059);
		PhD attell = new PhD("Kevin", 3, 1980);
		ramya.setAdvisor1(attell);
		assertEquals(attell, ramya.advisor1());
		PhD gries = new PhD("Gries", 12, 1966);
		ramya.setAdvisor2(gries);
		assertEquals(gries, ramya.advisor2());
	}
	
	@Test
	void testGroupCC() {
		PhD stoer = new PhD("Joseph", 4, 1919);
		PhD bauer = new PhD("Friedrich", 2, 1927, stoer);
		PhD dr = new PhD("Gries", 12, 1966, bauer, stoer);
		
		//start test with constructor 2 
		assertEquals("Friedrich", bauer.name());
		assertEquals(2, bauer.month());
		assertEquals(1927, bauer.year());
		assertEquals(stoer, bauer.advisor1());
		
		//start test constructor 3
		assertEquals("Gries", dr.name());
		assertEquals(12, dr.month());
		assertEquals(1966, dr.year());
		assertEquals(bauer, dr.advisor1());
		assertEquals(stoer, dr.advisor2());
	}
	
	@Test
	void testGroupD() {
		PhD stoer = new PhD("Joseph", 4, 1919);
		PhD bauer = new PhD("Friedrich", 2, 1927, stoer);
		PhD gries = new PhD("Gries", 12, 1966, bauer, stoer);
		
		//test hasAdvisee
		assertEquals(true, stoer.hasAdvisee());
		assertEquals(true, bauer.hasAdvisee());
		assertEquals(false, gries.hasAdvisee());
		
		//test gotAfter
		assertEquals(true, gries.gotAfter(stoer));
		assertEquals(false, stoer.gotAfter(bauer));
		assertEquals(false, bauer.gotAfter(gries));
		
		//test areSiblings
		PhD griesBro = new PhD("GriesBro", 12, 1966, bauer);
		assertEquals(true, gries.areSiblings(griesBro));
		assertEquals(false, stoer.areSiblings(bauer));
		assertEquals(true, bauer.areSiblings(gries));
		
		
	}
	

}
