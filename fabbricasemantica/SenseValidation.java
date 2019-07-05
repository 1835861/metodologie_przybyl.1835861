package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLParagraphElement;
import def.jquery.JQueryXHR;
import def.js.JSON;
import jsweet.util.StringTypes;

public class SenseValidation {
	private static final String REST_URL = "RichiestaJSON";
	private static final String redirect = "senseValidation.jsp";
	
	public static void main(String[] args) {
			
		$(document).ready(()->{
			new SenseValidation().start();
			return null;
		});
	}
	
	
	public void start() {
		
		HTMLFormElement form = document.createElement(StringTypes.form);
		form.method = "POST";
		form.action = redirect;
		
		HTMLDivElement divS = document.createElement(StringTypes.div);
		HTMLDivElement divN = document.createElement(StringTypes.div);
		
		HTMLLabelElement word = document.createElement(StringTypes.label);
		HTMLLabelElement description = document.createElement(StringTypes.label);
		HTMLLabelElement sense = document.createElement(StringTypes.label);
		HTMLParagraphElement paragrafo = document.createElement(StringTypes.p);
		
		HTMLInputElement radioSi = document.createElement(StringTypes.input);
		radioSi.name = "radioButton";
		radioSi.type = "radio";
		radioSi.value = "Si";
		
		HTMLInputElement radioNo = document.createElement(StringTypes.input);
		radioNo.name = "radioButton";
		radioNo.type = "radio";
		radioNo.value = "No";
		
		$(divS).append(radioSi, "Si");
		$(divN).append(radioNo, "No");
		
		HTMLDivElement divB = document.createElement(StringTypes.div);
		
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
		
		$(divB).append(submit, skip);
		divB.style.paddingTop = "4px";
		
		$.getJSON(REST_URL+"?task=SENSE_VALIDATION", (Object result, String a, JQueryXHR ctx) -> {
			JSON json = (JSON) result;
			String sWord = json.$get("word");
			String sDescription = json.$get("example");
			String sSense = json.$get("sense");
			word.textContent = sWord;
			description.textContent = sDescription;
			sense.textContent = sSense;
			paragrafo.textContent = word.textContent + " / " + description.textContent;
			return null;
		});
		
		sense.style.paddingTop = "5px";
		
		$(form).append(paragrafo);
		$(form).append(sense);
		$(form).append(divS, divN);
		$(form).append(divB);
		$("body").append(form);
		
	}
}
