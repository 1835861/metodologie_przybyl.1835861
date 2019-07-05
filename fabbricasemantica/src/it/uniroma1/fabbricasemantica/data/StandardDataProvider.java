package it.uniroma1.fabbricasemantica.data;

import java.util.Iterator;
import java.util.NoSuchElementException;

import net.sf.extjwnl.JWNLException;

/**
 * Questa classe restituisce i dati necessari per il task ricevuto in input.
 * Il metodo {@link #getData(Task)} restituira' una stringa in formato JSON
 * che le pagine in JSweet andranno a formattare.
 * N.B. Il proprio {@link DataProvider} dovrebbe evitare di avere stringhe codificate, questo e' solo un esempio.
 * */
public class StandardDataProvider implements DataProvider<String> {
	
	private WordProvider wp = new WordProvider();
	
	@Override 
	public String getData(Task task){
		if (task == StandardTask.TRANSLATION_ANNOTATION) {
				
			Words randWord = WordProvider.getRandomWord();
			try {
				return String.format("{" +
						"\"word\": \"%s\"," +
						"\"description\": \"%s\"" +
						"}", randWord.getWord(), wp.getDescription(randWord));
			} catch (JWNLException e) {
				e.printStackTrace();
			}

			
		}else if (task == StandardTask.WORD_ANNOTATION) {
			
			
			Words randWord = WordProvider.getRandomWord();
			try {
				return String.format("{" +
						"\"description\": \"%s\"" +
						"}", wp.getDescription(randWord));
			} catch (JWNLException e) {
				e.printStackTrace();
			}

			
		}else if (task == StandardTask.DEFINITION_ANNOTATION) {	
			
			Words randWord = WordProvider.getRandomWord();				
			try {
				String hypernym = wp.getHypernym(randWord);
				
				return 	String.format("{" +
						"\"word\": \"%s\"," +
						"\"hypernym\": \"%s\"" +
						"}", randWord.getWord(), hypernym);
			} catch (NoSuchElementException | JWNLException e) {
				return getData(task);
			}
			
			
		}else if (task == StandardTask.SENSE_ANNOTATION) {
			
			Words randWord = WordProvider.getRandomWord();	
			try {
				String description = wp.getExample(randWord);
				if(!description.contains("\"")) description = String.format("\"%s\"", description);
				Iterator it = wp.getSenses(randWord, 4);
				
				return String.format("{" + 
						"\"word\":\"%s\"," +
						"\"description\":%s," + 
						"\"senses\": [\"%s\", \"%s\", \"%s\", \"%s\"]" + 
						"}",randWord.getWord(), description, it.next(), it.next(), it.next(), it.next());
			} catch (JWNLException e) {
				e.printStackTrace();
			}
			
		}else if (task == StandardTask.TRANSLATION_VALIDATION) {
			return "{" +
					"\"word\": \"rock\"," +
					"\"description\": \"A lump or mass of hard consolidated mineral matter\"," + 
					"\"translations\": [\"Un grumo o una massa di materia minerale consolidata dura\"," +
										"\"Materiale costituito dall'aggregato di minerali come quelli che formano la crosta terrestre\"," +
										"\"Un'associazione non ufficiale di persone o gruppi\"]" +
					"}";
			
		}else if (task == StandardTask.SENSE_VALIDATION) {
			
			Words randWord = WordProvider.getRandomWord();
			try {
				String description = wp.getExample(randWord);
				if(!description.contains("\"")) description = String.format("\"%s\"", description);
				Iterator it = wp.getSenses(randWord, 1);
				
				return String.format("{" + 
						"\"word\": \"%s\"," +
						"\"example\": %s," +
						"\"sense\": \"%s\"" +
						"}", randWord.getWord(), description, it.next());
			} catch (JWNLException e) {
				e.printStackTrace();
			}
		}else if (task == StandardTask.MYANNOTATION) {
			
			Words randWord = WordProvider.getRandomWord();
			try {
				String description = wp.getExample(randWord);
				Iterator it = wp.getWords(7);
				
				return String.format("{" + 
						"\"words\": [\"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\", \"%s\"]"+
						"}", it.next(), it.next(), it.next(), it.next(), it.next(), it.next(), it.next());
			} catch (JWNLException e) {
				e.printStackTrace();
			}
		}
		
		return null; 
	}
	

}
