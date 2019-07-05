package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

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

public class TranslationValidation {

	private static final String REST_URL = "RichiestaJSON";
	private static final String redirect = "translationValidation.jsp";
	
	public static void main(String[] args) {
			
		$(document).ready(()->{
			new TranslationValidation().start();
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
		
		
		$.getJSON(REST_URL+"?task=TRANSLATION_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sDescription = json.$get("description");
			String[] sTranslations = json.$get("translations");
			headText.textContent = sWord;
			description.textContent = sDescription;

			$(form).append(h1);
			$(form).append(description);
			
			for(int i = 0; i<= sTranslations.length; i++) {
				HTMLLabelElement l = document.createElement(StringTypes.label);
				HTMLInputElement checkBox = document.createElement(StringTypes.input);
				HTMLDivElement div = document.createElement(StringTypes.div);
				if(i == sTranslations.length) {
					checkBox.type = "checkbox";
					checkBox.name = "radioButtonValue";
					checkBox.value = "nessuna";
					l.textContent = "nessuna";
					checkBox.style.paddingTop = String.valueOf(i)+"3px";
					checkBox.appendChild(l);
					$(div).append(checkBox, l);
					div.style.paddingTop = "10px";
				}else {
					checkBox.type = "checkbox";
					checkBox.name = "radioButtonValue";
					checkBox.value = sTranslations[i];
					l.textContent = sTranslations[i];

					checkBox.style.paddingTop = String.valueOf(i)+"3px";
					checkBox.appendChild(l);
					$(div).append(checkBox, l);
					div.style.paddingTop = "10px";
				}
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
