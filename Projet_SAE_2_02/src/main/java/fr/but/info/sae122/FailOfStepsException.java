
package fr.but.info.sae122;

public class FailOfStepsException extends Exception{
	
	/**
	 * throwed when a fail in the AugmentingPath operation appears
	 * used in AugmentingPath class
	 */
	public FailOfStepsException() {
		
	}
	
	public FailOfStepsException(String message) {
		
		super(message);
	}

}
