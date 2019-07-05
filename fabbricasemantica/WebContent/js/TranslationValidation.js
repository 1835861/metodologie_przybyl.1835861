/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class TranslationValidation {
        static main(args) {
            $(document).ready(() => {
                new TranslationValidation().start();
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
            form.action = TranslationValidation.redirect;
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
            $.getJSON(TranslationValidation.REST_URL + "?task=TRANSLATION_VALIDATION", ((description, h1, headText, form, divB) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    let sTranslations = (json["translations"]);
                    headText.textContent = sWord;
                    description.textContent = sDescription;
                    $(form).append(h1);
                    $(form).append(description);
                    for (let i = 0; i <= sTranslations.length; i++) {
                        {
                            let l = document.createElement("label");
                            let checkBox = document.createElement("input");
                            let div = document.createElement("div");
                            if (i === sTranslations.length) {
                                checkBox.type = "checkbox";
                                checkBox.name = "radioButtonValue";
                                checkBox.value = "nessuna";
                                l.textContent = "nessuna";
                                checkBox.style.paddingTop = new String(i).toString() + "3px";
                                checkBox.appendChild(l);
                                $(div).append(checkBox, l);
                                div.style.paddingTop = "10px";
                            }
                            else {
                                checkBox.type = "checkbox";
                                checkBox.name = "radioButtonValue";
                                checkBox.value = sTranslations[i];
                                l.textContent = sTranslations[i];
                                checkBox.style.paddingTop = new String(i).toString() + "3px";
                                checkBox.appendChild(l);
                                $(div).append(checkBox, l);
                                div.style.paddingTop = "10px";
                            }
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
    TranslationValidation.REST_URL = "RichiestaJSON";
    TranslationValidation.redirect = "translationValidation.jsp";
    quickstart.TranslationValidation = TranslationValidation;
    TranslationValidation["__class"] = "quickstart.TranslationValidation";
})(quickstart || (quickstart = {}));
quickstart.TranslationValidation.main(null);
