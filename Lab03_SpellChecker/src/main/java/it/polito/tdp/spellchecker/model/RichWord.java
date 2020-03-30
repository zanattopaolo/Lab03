package it.polito.tdp.spellchecker.model;

public class RichWord {
	
	private String word;
	private boolean correct;
	
	public RichWord(String p, boolean c) {
		this.word=p;
		this.correct=c;
	}
	
		
	public boolean isCorrect() {
		return correct;
	}
	public void setCorrect(boolean correct) {
		this.correct = correct;
	}


	public String getWord() {
		return word;
	}
	
	
	
	
	
	/**
	 * Verifica l'uguaglianza fra due {@link RichWord}, considerando uguali anche le parole con una lettera di differenza
	 * @param other
	 * @return vero se uguali o con una lettera di differenza
	 * falso se hanno due o più lettere di differenza
	 */
	/*public boolean equals(RichWord other) {
		
		//controllo se i due elementi sono uguali
		//se si: restituisco true e setto correct a true
		//se no ma hanno una lettera di differenza: restituisco true e lascio correct a false
		//se no ed hanno più di una lettera di differenza: restituisco false e lascio correct a false
		
		
		return false;
	}
	*/

}
