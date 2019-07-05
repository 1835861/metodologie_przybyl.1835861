/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    /**
     * This class is used within the webapp/index.html file.
     *
     *
     * /**
     * This class is used within the webapp/index.html file.
     * @class
     */
    class LogIn {
        static main(args) {
            $(document).ready(() => {
                $("body").css("background-image", "url(" + LogIn.IMG + ")").css("background-size", "100% 100%").css("background-repeat", "no-repeat");
                new LogIn().start();
                return null;
            });
        }
        start() {
            let h2 = document.createElement("h2");
            h2.style.color = "blue";
            h2.innerText = "Log in";
            let username = document.createElement("input");
            username.type = "text";
            username.name = "username";
            username.placeholder = "Username";
            let password = document.createElement("input");
            password.type = "password";
            password.name = "psw";
            password.placeholder = "Password";
            let div = document.createElement("div");
            let form = document.createElement("form");
            form.method = "POST";
            form.action = LogIn.SERVER_URL;
            let inputLogIn = document.createElement("input");
            inputLogIn.value = "submit";
            inputLogIn.type = "submit";
            let label = document.createElement("label");
            label.textContent = "Non sei registrato?";
            let link = document.createElement("a");
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
            $(inputLogIn).css("border", "none").css("width", "190px").css("background", "white").css("color", "#000").css("font-size", "16px").css("line-height", "25px").css("padding", "10px 0").css("margin-top", "20%").css("border-radius", "15px").css("cursor", "pointer");
            $(div).css("background", "rgba(44,62,80,0.7)").css("padding", "50px").css("margin", "0 auto").css("margin-top", "10%").css("width", "350px").css("height", "500px").css("border-radius", "3px");
            $(form).css("width", "240px").css("text-align", "center");
            $(username).css("width", "240px").css("text-align", "center").css("background", "transparent").css("border", "none").css("border-bottom", "1px solid #fff").css("font-family", "\'Play\', sans-serif").css("font-size", "16px").css("font-weight", "250px").css("padding", "8px 0").css("margin-top", "20%").css("transition", "border 0.5s").css("outline", "none").css("color", "#fff");
            $(password).css("width", "240px").css("text-align", "center").css("background", "transparent").css("border", "none").css("border-bottom", "1px solid #fff").css("font-family", "\'Play\', sans-serif").css("font-size", "16px").css("font-weight", "250px").css("padding", "8px 0").css("margin-top", "15%").css("transition", "border 0.5s").css("outline", "none").css("color", "#fff");
            $("body").append(div);
        }
    }
    LogIn.SERVER_URL = "logIn.jsp";
    LogIn.IMG = "imagine.jpg";
    quickstart.LogIn = LogIn;
    LogIn["__class"] = "quickstart.LogIn";
})(quickstart || (quickstart = {}));
quickstart.LogIn.main(null);
