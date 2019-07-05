/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class SenseAnnotation {
        static main(args) {
            $(document).ready(() => {
                new SenseAnnotation().start();
                return null;
            });
        }
        start() {
            let headText = document.createElement("label");
            let sense = document.createElement("label");
            let h1 = document.createElement("h1");
            let description = document.createElement("label");
            let form = document.createElement("form");
            form.method = "POST";
            form.action = SenseAnnotation.redirect;
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
            $.getJSON(SenseAnnotation.REST_URL + "?task=SENSE_ANNOTATION", ((description, h1, headText, form, divB) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    let sSenses = (json["senses"]);
                    headText.textContent = sWord;
                    description.textContent = sDescription;
                    $(form).append(h1);
                    $(form).append(description);
                    for (let i = 0; i < sSenses.length; i++) {
                        {
                            let l = document.createElement("label");
                            let radioButton = document.createElement("input");
                            let div = document.createElement("div");
                            radioButton.type = "radio";
                            radioButton.name = "radioButtonValue";
                            radioButton.value = sSenses[i];
                            l.textContent = sSenses[i];
                            radioButton.style.paddingTop = new String(i).toString() + "3px";
                            radioButton.appendChild(l);
                            $(div).append(radioButton, l);
                            div.style.paddingTop = "10px";
                            $(form).append(div);
                        }
                        ;
                    }
                    $(form).append(divB);
                    return null;
                };
            })(description, h1, headText, form, divB));
            headText.style.fontSize = "14px";
            h1.innerText = "Select the correct meaning of the word " + headText.textContent + " in the following sentences";
            h1.style.fontSize = "18px";
            $("body").append(form);
        }
    }
    SenseAnnotation.REST_URL = "RichiestaJSON";
    SenseAnnotation.redirect = "senseAnnotation.jsp";
    quickstart.SenseAnnotation = SenseAnnotation;
    SenseAnnotation["__class"] = "quickstart.SenseAnnotation";
})(quickstart || (quickstart = {}));
quickstart.SenseAnnotation.main(null);
