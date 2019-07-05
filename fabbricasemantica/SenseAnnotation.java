package quickstart;

import static def.dom.Globals.alert;
import static def.dom.Globals.console;
import static def.dom.Globals.document;
import static def.jquery.Globals.$;
import static jsweet.util.Lang.typeof;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLParagraphElement;
import def.dom.Text;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

public class SenseAnnotation {
	private static final String REST_URL = "RichiestaJSON";
	private static final String redirect = "senseAnnotation.jsp";
	
	public static void main(String[] args) {
			
		$(document).ready(()->{
			new SenseAnnotation().start();
			return null;
		});
	}
	
	public void start() {
		
		HTMLLabelElement headText = document.createElement(StringTypes.label);
		HTMLLabelElement sense = document.createElement(StringTypes.label);
		HTMLHeadingElement h1 = document.createElement(StringTypes.h1);
		
		HTMLLabelElement description = document.createElement(StringTypes.label);
		
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
		
		
		$.getJSON(REST_URL+"?task=SENSE_ANNOTATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word"); //i.e. json.get("word")
			String sDescription = json.$get("description"); //i.e. json.get("description")
			String[] sSenses = json.$get("senses"); //i.e. json.get("description")
			headText.textContent = sWord;
			description.textContent = sDescription;

			$(form).append(h1);
			$(form).append(description);
			
			for(int i = 0; i< sSenses.length; i++) {
				HTMLLabelElement l = document.createElement(StringTypes.label);
				HTMLInputElement radioButton = document.createElement(StringTypes.input);
				HTMLDivElement div = document.createElement(StringTypes.div);
				radioButton.type = "radio";
				radioButton.name = "radioButtonValue";
				radioButton.value = sSenses[i];
				l.textContent = sSenses[i];

				radioButton.style.paddingTop = String.valueOf(i)+"3px";
				radioButton.appendChild(l);
				$(div).append(radioButton, l);
				div.style.paddingTop = "10px";
				$(form).append(div);
			}
			$(form).append(divB);
			return null;
		});
		
		
		headText.style.fontSize = "14px";
		h1.innerText = "Select the correct meaning of the word " + headText.textContent +" in the following sentences";
		h1.style.fontSize = "18px";
		
		$("body").append(form);
		
	}
	
}
