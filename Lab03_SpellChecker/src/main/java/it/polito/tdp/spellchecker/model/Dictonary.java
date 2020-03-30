package it.polito.tdp.spellchecker.model;

import java.io.*;
import java.util.*;

public class Dictonary {
	
	private Set<String> parole;
	
	public Dictonary() {
		this.parole=new HashSet<String>();
	}
	
	
	/**
	 * Questo metodo permette di caricare il dizionario della lingua desiderata
	 * @param language
	 */
	public void loadDictonary(String language) {
		
		try {
			FileReader fr = new FileReader("src/main/resources/"+language+".txt");
			BufferedReader br = new BufferedReader(fr);
			String word;
			
			while ((word = br.readLine()) != null) {
				// Aggiungere parola alla struttura dati
				this.parole.add(word);
			}
			
			br.close();
			} catch (IOException e){
			System.out.println("Errore nella lettura del file");
			}

	}
	
	
	/**
	 * Questo metodo esegue il controllo ortografico sul testo in input (rappresentato da una lista di parole)
	 * e restituisce una lista di RichWord. Per ogni elemento di inputTextList, spellCheckText
	 * controlla se la parola è presente nel dizionario. In caso affermativo, la RichWord corrispondente
	 * sarà corretta, altrimenti sarà errata. La lista delle RichWord viene restituita in output.
	 * @param inputTextList
	 * @return 
	 */
	public List<RichWord> spellCheckText(List<String> inputTextList){
		List<RichWord> result=new LinkedList<RichWord>();
		
		for(String p:inputTextList) {
			p=p.toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]\n?", "");
			if(this.parole.contains(p)){
				result.add(new RichWord(p, true));
			}
			else {
				result.add(new RichWord(p, false));
			}	
		}
		
		return result;
	}
	
}
