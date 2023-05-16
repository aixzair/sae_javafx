package main.java.fr.but.info.sae122;

public class IncoherentSuccessivityException extends Exception{
	
	/**
	 * raised when two edge are not linked to each other
	 * used in Path class
	 */
	
	public IncoherentSuccessivityException() {
		
	}
	
	public IncoherentSuccessivityException(String message) {
		super(message);
	}

}
