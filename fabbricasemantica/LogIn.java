package quickstart;

import static def.dom.Globals.alert;
import static def.dom.Globals.document;
import static def.jquery.Globals.$;

import def.dom.Document;
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

public class LogIn {
	
	public static final String SERVER_URL = "logIn.jsp";
	public static final String IMG = "imagine.jpg";

	public static void main(String[] args) {
		
		$(document).ready( ()->{
			$("body").css("background-image", "url("+IMG+")")
				.css("background-size", "100% 100%")
				.css("background-repeat", "no-repeat");
            new LogIn().start();
			return null;
		});
		
		
	}
	
	public void start() {
		
		HTMLHeadingElement h2 = document.createElement(StringTypes.h2);
		h2.style.color = "blue";
		h2.innerText = "Log in";
		
		HTMLInputElement username = document.createElement(StringTypes.input);
		username.type = "text";
		username.name = "username";
		username.placeholder = "Username";
		
		HTMLInputElement password = document.createElement(StringTypes.input);
		password.type = "password";
		password.name = "psw";
		password.placeholder = "Password";
		
		HTMLDivElement div = document.createElement(StringTypes.div);
		
		HTMLFormElement form = document.createElement(StringTypes.form);
		form.method = "POST";
		form.action = SERVER_URL;
		
		HTMLInputElement inputLogIn = document.createElement(StringTypes.input);
		inputLogIn.value = "submit";
		inputLogIn.type = "submit";
		
		HTMLLabelElement label = document.createElement(StringTypes.label);
		label.textContent = "Non sei registrato?";
		HTMLAnchorElement link = document.createElement(StringTypes.a);
		link.href = "signUp.html";
		link.text = "Registrati";
		link.style.marginRight = "0px";
		link.style.fontSize = "12px";
		label.appendChild(link);

		label.style.marginTop = "30%";
		
		$(h2).append(" ");
		$(form).append(h2);
		
		$(form).append(username);
		$(form).append(password);
		$(form).append(inputLogIn);
		$(form).append(label);
		$(div).append(form);
		
		
		$(inputLogIn).css("border", "none")
			.css("width", "190px")
			.css("background", "white")
			.css("color", "#000")
			.css("font-size", "16px")
			.css("line-height", "25px")
			.css("padding", "10px 0")
			.css("margin-top", "20%")
			.css("border-radius", "15px")
			.css("cursor", "pointer");
		
		$(div).css("background", "rgba(44,62,80,0.7)")
		.css("padding", "50px").css("margin", "0 auto")
		.css("margin-top", "10%").css("width", "350px").css("height", "500px")
		.css("border-radius", "3px");
		
        $(form).css("width", "240px")
        .css("text-align", "center");
        
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

	
		$("body").append(div);
		
	}

}

