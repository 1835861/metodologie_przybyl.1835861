package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLTextAreaElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

public class MyAnnotation {
	
	private static final String REST_URL = "RichiestaJSON";
	private static final String redirect = "myAnnotation.jsp";
	
	public static void main(String[] args) {
			
		$(document).ready(()->{
			new MyAnnotation().start();
			return null;
		});
	}
	
	public void start() {
		
		HTMLHeadingElement h1 = document.createElement(StringTypes.h1);
		
		HTMLFormElement form = document.createElement(StringTypes.form);
		form.method = "POST";
		form.action = redirect;
		
		HTMLDivElement divB = document.createElement(StringTypes.div);
		
		HTMLInputElement submit = document.createElement(StringTypes.input);
		submit.type = "submit";
		submit.name = "submit_button";
		submit.className =  "btn btn-primary";
		submit.value = "Avanti";
		

		HTMLInputElement skip = document.createElement(StringTypes.input);
		skip.type = "submit";
		skip.name = "submit_button";
		skip.className =  "btn btn-primary";
		skip.value = "Skip";

		$(skip).css("float", "right");
		
		$(divB).append(submit, skip);
		
		
		$.getJSON(REST_URL+"?task=MYANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String[] sWord = json.$get("words"); 

			$(form).append(h1);
			
			for(int i = 0; i< sWord.length; i++) {

				HTMLDivElement div = document.createElement(StringTypes.div);
				HTMLLabelElement l = document.createElement(StringTypes.label);
				HTMLTextAreaElement textArea = document.createElement(StringTypes.textarea);
				
				textArea.name = "wordName";
				textArea.id = String.valueOf(i);
				textArea.style.height = "30px";
				textArea.placeholder = "scrivi la traduzione qui..";
				
				l.htmlFor = String.valueOf(i);
				l.textContent = sWord[i];
				l.style.fontSize = "15px";
				
				$(div).append(l, textArea);
				div.style.paddingTop = "10px";
				

				$(form).append(div);
			}
			$(form).append(divB);
			return null;
		});
		
		h1.innerText = "Translate the following words into your mother tongue:";
		h1.style.fontSize = "18px";
		
		$("body").append(form);
	}
}
