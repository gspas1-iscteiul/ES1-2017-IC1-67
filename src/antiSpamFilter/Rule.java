package antiSpamFilter;

/**
 * @author gspas1-iscteiul
 */
public class Rule {
	
	private String name;

	public Rule(String name) {
		this.name = name;
	}

	
	/**
	 * Method to return the id of the rule
	 * @return String - Id of the rule
	 */
	public String getName() {
		return name;
	}
}