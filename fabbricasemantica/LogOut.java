package quickstart;

import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.Event;
import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLLabelElement;
import jsweet.util.StringTypes;

public class LogOut {

	private static final String redirect = "logOut.jsp";
	
	public static void main(String[] args) {
			
		$(document).ready(()->{
			new LogOut().start();
			return null;
		});
	}
	
	public void start() {
		
		HTMLFormElement form = document.createElement(StringTypes.form);
		form.method = "POST";
		form.action = redirect;
		form.id = "form-id";
		
		HTMLDivElement div = document.createElement(StringTypes.div);
		
		HTMLLabelElement label = document.createElement(StringTypes.label);
		label.textContent = "Effettua il logout : ";
		HTMLAnchorElement link = document.createElement(StringTypes.a);
		link.onclick = this::function;
		link.text = "logout";
		link.style.fontSize = "20px";
		link.style.color = "blue";
		label.appendChild(link);
		
		$(div).append(label);
		$(form).append(div);
		$("body").append(form);
	}
	
	
	private boolean function(Event e) {
		
		HTMLFormElement form = (HTMLFormElement) document.getElementById("form-id");
		form.submit();
		
		return true;
	}
}

	