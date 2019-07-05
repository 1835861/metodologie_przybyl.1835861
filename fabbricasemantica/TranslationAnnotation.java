package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLParagraphElement;
import def.dom.HTMLTextAreaElement;
import def.dom.Text;
import def.jquery.JQueryAjaxSettings;
import def.js.JSON;
import jsweet.util.StringTypes;
import def.jquery.JQueryXHR;

public class TranslationAnnotation {
	
	private static final String REST_URL = "RichiestaJSON";
	private static final String redirect = "translationAnnotation.jsp";
	
	public static void main(String[] args) {
			
		$(document).ready(()->{
			new TranslationAnnotation().start();
			return null;
		});
	}
	
	public void start() {
		
		HTMLLabelElement word = document.createElement(StringTypes.label);
		HTMLLabelElement description = document.createElement(StringTypes.label);
		HTMLParagraphElement paragrafo = document.createElement(StringTypes.p);
		
		HTMLTextAreaElement translation = document.createElement(StringTypes.textarea);
		translation.name = "translation"; 
		translation.className =  "form-control";
		translation.placeholder = "Scrivi la traduzione qui...";
		translation.style.height = "200px";
		
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
		
		
		$.getJSON(REST_URL+"?task=TRANSLATION_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sDescription = json.$get("description");
			word.textContent = sWord;
			description.textContent = sDescription;
			paragrafo.textContent = word.textContent + " / " + description.textContent;
			return null;
		});
		
		
		HTMLFormElement form = document.createElement(StringTypes.form);
		form.method = "POST";
		form.action = redirect;
		
		$(form).append(paragrafo);
		$(form).append(translation);
		$(form).append(submit);
		$(form).append(skip);
		$("body").append(form);
		
	}
	
}
