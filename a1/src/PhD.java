/** NetId: jl2578, ry86. Time spent: 02 hours, 30 minutes.
 An instance maintains info about the PhD of a person. */
public class PhD {

	/** Name of the person with a PhD, a String of length > 0.*/
	private String name; 
	
	/** month PhD was awarded. In 1..12, with 1 meaning January, etc*/
	private int month;  
	
	/** year PhD was awarded. Can be any integer.*/
	private int year;
	
	/** the first PhD advisor of this person —null if unknown*/
	private PhD advisor1;
	
	/** The second advisor of this person —null if unknown or if the
	 *  person has less than two advisors.*/
	private PhD advisor2;
	
	/** number of PhD advisees of this person. Can be any integer.*/
	private int numAdvisees;
	
	
	/**Constructor: an instance for a person with name n, PhD month m, 
	 * PhD year y. Its advisors are unknown, and it has no advisees.
	 * Precondition: n has at least 1 char and m is in 1..12.*/
	public PhD(String n, int m, int y) {
		name = n;
		month = m;
		year= y;
		assert n.length() > 0;
		assert n != null;
		assert m >= 1;
		assert m <= 12;
		// TODO: figure out if we need to initiate the other variables
	}
	
	/**Constructor: a PhD with name n, PhD month m, PhD year y, first advisor
	 * adv1, and no second advisor.
	 * Precondition: n has at least 1 char, m is in 1..12, and adv1 is not null*/
	public PhD(String n, int m, int y, PhD adv1) {
		name = n;
		month = m;
		year = y;
		advisor1 = adv1;
		adv1.numAdvisees++;
		assert n.length() > 0;
		assert n != null;
		assert m >= 1;
		assert m <= 12;
		assert adv1 != null;
		assert adv2 == null;
	}
	
	/** Constructor: a PhD with name n, PhD month m, PhD year y, first advisor
	 * adv1, and second advisor adv2.
	 * Precondition: n has at least 1 char, m is in 1..12,
	 * adv1 and adv2 are not null, and adv1 and adv2 are different.*/
	public PhD(String n, int m, int y, PhD adv1, PhD adv2) {
		name = n;
		month = m;
		year = y;
		advisor1 = adv1;
		advisor2 = adv2;
		adv1.numAdvisees++;
		adv2.numAdvisees++;
		assert n.length() > 0;
		assert n != null;
		assert m >= 1;
		assert m <= 12;
		assert adv1 != null;
		assert adv2 != null;
		assert adv1 != adv2;
	}
	
	/**Return the name of this person.*/
	public String name() {
		return name;
	}
	
	/**Return the month this person got their PhD.*/
	public int month() {
		return month;
	}
	
	/**Return the year this person got their PhD.*/
	public int year() {
		return year;
	}
	
	/**Return the first advisor of this PhD (null if unknown).*/
	public PhD advisor1() {
		return advisor1;
	}
	
	/**Return the second advisor of this PhD (null if unknown or 
	 * non-existent).*/
	public PhD advisor2() {
		return advisor2;
	}
	
	/**Return the number of PhD advisees of this person.*/
	public int numAdvisees() {
		return numAdvisees;
	}
	
	/**Add p as the first advisor of this person. 
	 * Precondition: the first advisor is unknown and p is not null.*/
	public void setAdvisor1(PhD p) {
		assert p != null;
		assert advisor1() == null;
		advisor1 = p;
		//TODO: Check if we should add an advisee to p
		p.numAdvisees++;
	}
	
	/**Add p as the second advisor of this person.
	 * Precondition: The first advisor (of this person) is known, the second advisor
	 * is unknown, p is not null, and p is different from the first advisor*/
	public void setAdvisor2(PhD p) {
		assert advisor1() != null;
		assert advisor2() == null;
		assert p != null;
		assert p != advisor1();
		advisor2 = p;
		//TODO: Check if we should add an advisee to p
		p.numAdvisees++;
	}
	
	/** Return value of "this PhD has at least one advisee", 
	 * i.e. true if this PhD has at least one advisee and false otherwise */
	public boolean hasAdvisee() {
		return numAdvisees() >= 1;
	}
	
	/** Return value of "p is not null and this person got the PhD after p.” */
	public boolean gotAfter(PhD p) {
		return (p != null) && (month() > p.month()) && (year() > p.year());
	}
	
	//TODO: explain intellectual siblings?
	/** Return value of "this person and p are intellectual siblings."
	 * Precondition: p is not null */
	public boolean areSiblings(PhD p) {
		assert p != null;
		return (this != p) && 
				((advisor1() != null) || (advisor2() != null)) &&
				((p.advisor1() == advisor1()) || (p.advisor2() == advisor2()) 
					|| p.advisor1() == advisor2() || p.advisor2() == advisor1());
	}

}
