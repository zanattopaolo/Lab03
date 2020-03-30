package it.polito.tdp.spellchecker.model;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class Dictonary2 {
	
private List<String> parole;
	
	public Dictonary2() {
		this.parole=new ArrayList<String>();
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

	
	/**
	 * Verione di spellcheck che effettua il medesimo compito ma con una ricerca linerare
	 * @param inputTextList
	 * @return	LinkedList di RichWord
	 */
	public List<RichWord> spellCheckTextLinear(List<String> inputTextList){
		List<RichWord> result=new LinkedList<RichWord>();
		
		for(String p:inputTextList) {
			p=p.toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]\n?", "");
			for(int i=0; i<this.parole.size(); i++) {
				if(this.parole.get(i).equals(p)){
					result.add(new RichWord(p, true));
				}
				
			}
			result.add(new RichWord(p, false));		//trovare dove aggiungerla
		}
		
		return result;
		
	}
	
	/**
	 * Verione di spellcheck che effettua il medesimo compito ma con una ricerca dicotomica
	 * @param inputTextList
	 * @return	LinkedList di RichWord
	 */
	public List<RichWord> spellCheckTextDicotomic(List<String> inputTextList){
		List<RichWord> result=new LinkedList<RichWord>();
		
		int low, high, mid;
		
		for(String p:inputTextList) {
			p=p.toLowerCase().replaceAll("[.,\\/#!$%\\^&\\*;:{}=\\-_`~()\\[\\]\"]\n?", "");

			low = 0;
			high = this.parole.size()-1;
			
			while (low<=high) {
				mid = (low+high)/2;
				if(this.parole.get(mid).equals(p)) {
					result.add(new RichWord(p, true));
			    }
				else if (this.parole.get(mid).compareTo(p)>0) {
					low = mid + 1;
				}
				else {
					high = mid - 1;
				}
			}
			result.add(new RichWord(p, false));
			
			}
		
		return result;
		
	}
	
	
	

	
}
