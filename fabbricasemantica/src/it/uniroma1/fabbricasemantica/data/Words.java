package it.uniroma1.fabbricasemantica.data;

import net.sf.extjwnl.JWNLException;
import net.sf.extjwnl.data.IndexWord;
import net.sf.extjwnl.dictionary.Dictionary;
import net.sf.extjwnl.data.POS;
import net.sf.extjwnl.data.PointerTarget;
import net.sf.extjwnl.data.Synset;

public enum Words {

	COLD(1, POS.ADJECTIVE, "cold"),
	DOG(2, POS.NOUN, "dog"),
	HAND(3, POS.NOUN, "hand"),
	BOTTLE(4, POS.NOUN, "bottle"),
	FUNNY(5, POS.ADJECTIVE, "funny"),
	CAR(6, POS.NOUN, "car"),
	NOSE(7, POS.NOUN, "nose"),
	CAT(8, POS.NOUN, "cat"),
	WARM(9, POS.ADJECTIVE, "warm");
	
	private IndexWord indWord;
	private Dictionary dictionary;
	private int wordId;
	private String word;
	
	Words(int wordId, POS type, String word){
		this.word = word;
		this.wordId = wordId;
		try {	
			indWord = getInstance().lookupIndexWord(type, word);
		}catch(JWNLException e) { e.printStackTrace();}
	}
	
	private Dictionary getInstance() throws JWNLException {
		if(dictionary == null)
			dictionary = Dictionary.getDefaultResourceInstance();
		return dictionary;
	}
	
	public String getWord() { return word;}
	public int getId() { return wordId; }
	public Synset getIndexWord() {return indWord.getSenses().get(0);};
	
	
}