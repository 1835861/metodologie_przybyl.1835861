/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class Logout {
        static main(args) {
            $(document).ready(() => {
                new Logout().start();
                return null;
            });
        }
        start() {
            let form = document.createElement("form");
            form.method = "POST";
            form.action = Logout.redirect;
            form.id = "form-id";
            let div = document.createElement("div");
            let label = document.createElement("label");
            label.textContent = "Effettua il logout : ";
            let link = document.createElement("a");
            link.onclick = (e) => { return this.function(e); };
            link.text = "logout";
            link.style.fontSize = "20px";
            link.style.color = "blue";
            label.appendChild(link);
            $(div).append(label);
            $(form).append(div);
            $("body").append(form);
        }
        /*private*/ function(e) {
            let form = document.getElementById("form-id");
            form.submit();
            return true;
        }
    }
    Logout.redirect = "logOut.jsp";
    quickstart.Logout = Logout;
    Logout["__class"] = "quickstart.Logout";
})(quickstart || (quickstart = {}));
quickstart.Logout.main(null);
