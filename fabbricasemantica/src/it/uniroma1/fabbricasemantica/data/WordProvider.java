package it.uniroma1.fabbricasemantica.data;

import java.util.Iterator;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.PointerUtils;

public class WordProvider {
	
	public WordProvider() {}
	
	/*
	 * @return parola casuale dall'enumerazione Words
	 */
	public static Words getRandomWord() {
		
		int rand = new Random().nextInt(Words.values().length)+1;
		for(Words w : Words.values())
			if(w.getId() == rand) return w;
		
		return null;
	}
	
	/*
	 * @param numero di parole che si vuole restituire
	 * @return Iterator di parole casuali
	 */
	public Iterator getWords(int numberOfWords) {
		
		Set<String> set = new TreeSet<String>();
		while(set.size() != numberOfWords)
			set.add(getRandomWord().getWord() );
		
		return set.iterator();
	}
	
	private String[] getGloss(Words word) throws JWNLException { 
		return PointerUtils.getHypernymTree(word.getIndexWord()).getRootNode().getSynset().getGloss().split(";");
		}
	
	
	/*
	 * @param parola di cui si vuole ottenere la descrizione
	 * @return descrizione della parola presa in input
	 */
	public String getDescription(Words word) throws JWNLException {
		return getGloss(word)[0];
	}
	
	/*
	 * @param parola di cui si vuole sapere l'iperonimo
	 * @return iperonimo della parola presa in input
	 */
	public String getHypernym(Words word) throws JWNLException {
		return PointerUtils.getDirectHypernyms(word.getIndexWord()).element().getSynset().getWords().get(0).getLemma();
	}
	
	/*
	 * @param parola di cui si vuole ottenere l'esempio
	 * @return esempio della parola presa in input
	 */
	public String getExample(Words word) throws JWNLException{ 
		String return_string = "";
		int index = 0;
		try {
			while(!return_string.contains("\"")) {
				return_string = getGloss(word)[index];
				index+=1;
			}
		}catch(ArrayIndexOutOfBoundsException e) { }
			
		return return_string;
	}
	
	/*
	 * @param parola di cui si vuole sapere il senso con il numero di sensi da restituire
	 * @return Iterator di sensi casuali (compreso quello della parola presa in input)
	 * 
	 */
	public Iterator getSenses(Words word, int numberOfSenses) throws JWNLException {
		Set<String> set = new TreeSet<String>();
		String sense = getGloss(word)[0];
		set.add(sense);
		while(set.size() != numberOfSenses)
			set.add(getGloss(getRandomWord())[0] );
		
		return set.iterator();
	}
}
