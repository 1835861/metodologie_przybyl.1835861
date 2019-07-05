package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLParagraphElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;
import jsweet.util.StringTypes.a;
import jsweet.util.StringTypes.section;

public class WordAnnotation {
	
	private static final String REST_URL = "RichiestaJSON";
	private static final String redirect = "wordAnnotation.jsp";
	
	public static void main(String[] args) {
		
		$(document).ready(()->{
			new WordAnnotation().start();
			return null;
		});
	}
	
	public void start() {
         
		HTMLLabelElement word = document.createElement(StringTypes.label);
		
		HTMLTextAreaElement description = document.createElement(StringTypes.textarea);
		description.name = "risposta"; 
		description.className =  "form-control";
		description.placeholder = "Scrivi la risposta qui...";
		description.style.height = "200px";
		
		
		HTMLInputElement submit = document.createElement(StringTypes.input);
		submit.type = "submit";
		submit.name = "submit_button";
		submit.className =  "btn btn-primary";
		submit.value = "Avanti";
		submit.style.marginTop = "10px";

		HTMLInputElement skip = document.createElement(StringTypes.input);
		skip.type = "submit";
		skip.name = "submit_button";
		skip.className =  "btn btn-primary";
		skip.value = "Skip";
		skip.style.marginTop = "10px";
		$(skip).css("float", "right"); 
		
		
		$.getJSON(REST_URL+"?task=WORD_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("description"); 
			word.textContent = sWord;
			return null;
		});
		
		
		HTMLFormElement form = document.createElement(StringTypes.form);
		form.method = "POST";
		form.action = redirect;
		
		$(form).append(word);
		$(form).append(description);
		$(form).append(submit);
		$(form).append(skip);
		$("body").append(form);
		
		
	}
	
}
