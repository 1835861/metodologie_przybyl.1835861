/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class MyAnnotation {
        static main(args) {
            $(document).ready(() => {
                new MyAnnotation().start();
                return null;
            });
        }
        start() {
            let h1 = document.createElement("h1");
            let form = document.createElement("form");
            form.method = "POST";
            form.action = MyAnnotation.redirect;
            let divB = document.createElement("div");
            let submit = document.createElement("input");
            submit.type = "submit";
            submit.name = "submit_button";
            submit.className = "btn btn-primary";
            submit.value = "Avanti";
            let skip = document.createElement("input");
            skip.type = "submit";
            skip.name = "submit_button";
            skip.className = "btn btn-primary";
            skip.value = "Skip";
            $(skip).css("float", "right");
            $(divB).append(submit, skip);
            $.getJSON(MyAnnotation.REST_URL + "?task=MYANNOTATION", ((form, h1, divB) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["words"]);
                    $(form).append(h1);
                    for (let i = 0; i < sWord.length; i++) {
                        {
                            let div = document.createElement("div");
                            let l = document.createElement("label");
                            let textArea = document.createElement("textarea");
                            textArea.name = "wordName";
                            textArea.id = new String(i).toString();
                            textArea.style.height = "30px";
                            textArea.placeholder = "scrivi la traduzione qui..";
                            l.htmlFor = new String(i).toString();
                            l.textContent = sWord[i];
                            l.style.fontSize = "15px";
                            $(div).append(l, textArea);
                            div.style.paddingTop = "10px";
                            $(form).append(div);
                        }
                        ;
                    }
                    $(form).append(divB);
                    return null;
                };
            })(form, h1, divB));
            h1.innerText = "Translate the following words into your mother tongue:";
            h1.style.fontSize = "18px";
            $("body").append(form);
        }
    }
    MyAnnotation.REST_URL = "RichiestaJSON";
    MyAnnotation.redirect = "myAnnotation.jsp";
    quickstart.MyAnnotation = MyAnnotation;
    MyAnnotation["__class"] = "quickstart.MyAnnotation";
})(quickstart || (quickstart = {}));
quickstart.MyAnnotation.main(null);
