package quickstart;

import static def.dom.Globals.alert;
import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.Document;
import def.dom.Event;
import def.dom.HTMLAnchorElement;
import def.dom.HTMLDivElement;
import def.dom.HTMLElement;
import def.dom.HTMLFormElement;
import def.dom.HTMLHeadElement;
import def.dom.HTMLHeadingElement;
import def.dom.HTMLInputElement;
import def.dom.HTMLLabelElement;
import def.dom.HTMLLinkElement;
import def.dom.HTMLTextAreaElement;
import def.dom.Image;
import def.dom.Text;

import java.util.ArrayList;
import java.util.List;
import jsweet.util.StringTypes;
import def.js.Array;
import def.jquery.JQuery;

public class SignUp {
	
	public static final String IMG = "imagine.jpg";
	
	public static final String SERVER_URL = "signUp.jsp";
	
	public static void main(String[] args) {
		
		$(document).ready(()->{
			new SignUp().start();
			return null;
		});
	}
	
	
	public void start() {
		
		
		$("body").css("font-family", "Tahoma, Geneva, sans-serif")
					.css("color", "#fff")
					.css("background", "url("+IMG+")")
					.css("background-size", "cover");
		
		
		HTMLDivElement div = document.createElement(StringTypes.div);
		
		$(div).css("background", "rgba(44,62,80,0.7)")
		.css("padding", "50px").css("margin", "0 auto")
		.css("margin-top", "10%").css("width", "350px").css("height", "500px")
		.css("border-radius", "3px");
		
		
		HTMLFormElement form = document.createElement(StringTypes.form);
		form.method = "POST";
		form.action = SERVER_URL;
		
        $(form).css("width", "240px")
        .css("text-align", "center");
		
		HTMLHeadingElement h2 = document.createElement(StringTypes.h2);
		h2.textContent = "Sign Up";
		h2.style.color = "#fff";
		
		HTMLInputElement username = document.createElement(StringTypes.input);
		username.name = "username";
		username.type = "text";
		username.placeholder = "first name";
		username.style.padding = "10px";
		
		
		HTMLInputElement password = document.createElement(StringTypes.input);
		password.type = "password";
		password.placeholder = "password";
		password.style.padding  = "10px";
		password.name = "password";
		
		HTMLInputElement confirmPassword = document.createElement(StringTypes.input);
		confirmPassword.type = "password";
		confirmPassword.placeholder = "confirm password";
		confirmPassword.style.padding = "10px";
		confirmPassword.name = "confPass";
		
		HTMLInputElement checkBoxIT = document.createElement(StringTypes.input);
		checkBoxIT.type = "checkbox";
		checkBoxIT.name = "lingua";
		checkBoxIT.value = "italiano";
		checkBoxIT.innerText = "IT";
		
		HTMLInputElement checkBoxEN = document.createElement(StringTypes.input);
		checkBoxEN.type = "checkbox";
		checkBoxEN.name = "lingua";
		checkBoxEN.value = "inglese";
		checkBoxEN.innerText = "ENG";
		
		HTMLLabelElement labelIT = document.createElement(StringTypes.label);
		labelIT.innerText = "IT";
		labelIT.style.paddingLeft = "8px";
		labelIT.appendChild(checkBoxIT);
		
		HTMLLabelElement labelEN = document.createElement(StringTypes.label);
		labelEN.innerText = "ENG";
		labelEN.style.paddingLeft = "8px";
		labelEN.appendChild(checkBoxEN);
		
		HTMLLabelElement label = document.createElement(StringTypes.label);
		label.innerText = "Lingue parlate :   ";
		label.appendChild(labelIT);
		label.appendChild(labelEN);
		
		HTMLInputElement signUp = document.createElement(StringTypes.input);
		signUp.type = "submit";
		signUp.value = "sign up";
		
        $(username).css("width", "240px")
        .css("text-align", "center")
        .css("background", "transparent")
        .css("border", "none")
        .css("border-bottom", "1px solid #fff")
        .css("font-family", "\'Play\', sans-serif")
        .css("font-size", "16px")
        .css("font-weight", "250px")
        .css("padding", "8px 0")
        .css("margin-top", "20%")
        .css("transition", "border 0.5s")
        .css("outline", "none")
        .css("color", "#fff");
        
        $(password).css("width", "240px")
        .css("text-align", "center")
        .css("background", "transparent")
        .css("border", "none")
        .css("border-bottom", "1px solid #fff")
        .css("font-family", "\'Play\', sans-serif")
        .css("font-size", "16px")
        .css("font-weight", "250px")
        .css("padding", "8px 0")
        .css("margin-top", "15%")
        .css("transition", "border 0.5s")
        .css("outline", "none")
        .css("color", "#fff");
        
        $(confirmPassword).css("width", "240px")
        .css("text-align", "center")
        .css("background", "transparent")
        .css("border", "none")
        .css("border-bottom", "1px solid #fff")
        .css("font-family", "\'Play\', sans-serif")
        .css("font-size", "16px")
        .css("font-weight", "250px")
        .css("padding", "8px 0")
        .css("margin-top", "15%")
        .css("transition", "border 0.5s")
        .css("outline", "none")
        .css("color", "#fff");
        
		$(signUp).css("border", "none")
		.css("width", "190px")
		.css("background", "white")
		.css("color", "#000")
		.css("font-size", "16px")
		.css("line-height", "25px")
		.css("padding", "10px 0")
		.css("margin-top", "20%")
		.css("border-radius", "15px")
		.css("cursor", "pointer");
	
		
		$(form).append(h2);
		$(form).append(username);
		$(form).append(password);
		$(form).append(confirmPassword);
		$(form).append(label);
		$(form).append(signUp);
		$(div).append(form);
		$("body").append(div);
		
	}
	
	
}

















