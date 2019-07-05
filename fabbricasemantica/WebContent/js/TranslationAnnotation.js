/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class TranslationAnnotation {
        static main(args) {
            $(document).ready(() => {
                new TranslationAnnotation().start();
                return null;
            });
        }
        start() {
            let word = document.createElement("label");
            let description = document.createElement("label");
            let paragrafo = document.createElement("p");
            let translation = document.createElement("textarea");
            translation.name = "translation";
            translation.className = "form-control";
            translation.placeholder = "Scrivi la traduzione qui...";
            translation.style.height = "200px";
            let submit = document.createElement("input");
            submit.type = "submit";
            submit.name = "submit_button";
            submit.className = "btn btn-primary";
            submit.value = "Avanti";
            submit.style.marginTop = "10px";
            let skip = document.createElement("input");
            skip.type = "submit";
            skip.name = "submit_button";
            skip.className = "btn btn-primary";
            skip.value = "Skip";
            skip.style.marginTop = "10px";
            $(skip).css("float", "right");
            $.getJSON(TranslationAnnotation.REST_URL + "?task=TRANSLATION_ANNOTATION", ((paragrafo, description, word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["description"]);
                    word.textContent = sWord;
                    description.textContent = sDescription;
                    paragrafo.textContent = word.textContent + " / " + description.textContent;
                    return null;
                };
            })(paragrafo, description, word));
            let form = document.createElement("form");
            form.method = "POST";
            form.action = TranslationAnnotation.redirect;
            $(form).append(paragrafo);
            $(form).append(translation);
            $(form).append(submit);
            $(form).append(skip);
            $("body").append(form);
        }
    }
    TranslationAnnotation.REST_URL = "RichiestaJSON";
    TranslationAnnotation.redirect = "translationAnnotation.jsp";
    quickstart.TranslationAnnotation = TranslationAnnotation;
    TranslationAnnotation["__class"] = "quickstart.TranslationAnnotation";
})(quickstart || (quickstart = {}));
quickstart.TranslationAnnotation.main(null);
