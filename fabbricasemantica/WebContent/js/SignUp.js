/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class SignUp {
        static main(args) {
            $(document).ready(() => {
                new SignUp().start();
                return null;
            });
        }
        start() {
            $("body").css("font-family", "Tahoma, Geneva, sans-serif").css("color", "#fff").css("background", "url(" + SignUp.IMG + ")").css("background-size", "cover");
            let div = document.createElement("div");
            $(div).css("background", "rgba(44,62,80,0.7)").css("padding", "50px").css("margin", "0 auto").css("margin-top", "10%").css("width", "350px").css("height", "500px").css("border-radius", "3px");
            let form = document.createElement("form");
            form.method = "POST";
            form.action = SignUp.SERVER_URL;
            $(form).css("width", "240px").css("text-align", "center");
            let h2 = document.createElement("h2");
            h2.textContent = "Sign Up";
            h2.style.color = "#fff";
            let username = document.createElement("input");
            username.name = "username";
            username.type = "text";
            username.placeholder = "first name";
            username.style.padding = "10px";
            let password = document.createElement("input");
            password.type = "password";
            password.placeholder = "password";
            password.style.padding = "10px";
            password.name = "password";
            let confirmPassword = document.createElement("input");
            confirmPassword.type = "password";
            confirmPassword.placeholder = "confirm password";
            confirmPassword.style.padding = "10px";
            confirmPassword.name = "confPass";
            let checkBoxIT = document.createElement("input");
            checkBoxIT.type = "checkbox";
            checkBoxIT.name = "lingua";
            checkBoxIT.value = "italiano";
            checkBoxIT.innerText = "IT";
            let checkBoxEN = document.createElement("input");
            checkBoxEN.type = "checkbox";
            checkBoxEN.name = "lingua";
            checkBoxEN.value = "inglese";
            checkBoxEN.innerText = "ENG";
            let labelIT = document.createElement("label");
            labelIT.innerText = "IT";
            labelIT.style.paddingLeft = "8px";
            labelIT.appendChild(checkBoxIT);
            let labelEN = document.createElement("label");
            labelEN.innerText = "ENG";
            labelEN.style.paddingLeft = "8px";
            labelEN.appendChild(checkBoxEN);
            let label = document.createElement("label");
            label.innerText = "Lingue parlate :   ";
            label.appendChild(labelIT);
            label.appendChild(labelEN);
            let signUp = document.createElement("input");
            signUp.type = "submit";
            signUp.value = "sign up";
            $(username).css("width", "240px").css("text-align", "center").css("background", "transparent").css("border", "none").css("border-bottom", "1px solid #fff").css("font-family", "\'Play\', sans-serif").css("font-size", "16px").css("font-weight", "250px").css("padding", "8px 0").css("margin-top", "20%").css("transition", "border 0.5s").css("outline", "none").css("color", "#fff");
            $(password).css("width", "240px").css("text-align", "center").css("background", "transparent").css("border", "none").css("border-bottom", "1px solid #fff").css("font-family", "\'Play\', sans-serif").css("font-size", "16px").css("font-weight", "250px").css("padding", "8px 0").css("margin-top", "15%").css("transition", "border 0.5s").css("outline", "none").css("color", "#fff");
            $(confirmPassword).css("width", "240px").css("text-align", "center").css("background", "transparent").css("border", "none").css("border-bottom", "1px solid #fff").css("font-family", "\'Play\', sans-serif").css("font-size", "16px").css("font-weight", "250px").css("padding", "8px 0").css("margin-top", "15%").css("transition", "border 0.5s").css("outline", "none").css("color", "#fff");
            $(signUp).css("border", "none").css("width", "190px").css("background", "white").css("color", "#000").css("font-size", "16px").css("line-height", "25px").css("padding", "10px 0").css("margin-top", "20%").css("border-radius", "15px").css("cursor", "pointer");
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
    SignUp.IMG = "imagine.jpg";
    SignUp.SERVER_URL = "signUp.jsp";
    quickstart.SignUp = SignUp;
    SignUp["__class"] = "quickstart.SignUp";
})(quickstart || (quickstart = {}));
quickstart.SignUp.main(null);
