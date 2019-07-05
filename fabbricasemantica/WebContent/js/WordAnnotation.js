/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class WordAnnotation {
        static main(args) {
            $(document).ready(() => {
                new WordAnnotation().start();
                return null;
            });
        }
        start() {
            let word = document.createElement("label");
            let description = document.createElement("textarea");
            description.name = "risposta";
            description.className = "form-control";
            description.placeholder = "Scrivi la risposta qui...";
            description.style.height = "200px";
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
            $.getJSON(WordAnnotation.REST_URL + "?task=WORD_ANNOTATION", ((word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["description"]);
                    word.textContent = sWord;
                    return null;
                };
            })(word));
            let form = document.createElement("form");
            form.method = "POST";
            form.action = WordAnnotation.redirect;
            $(form).append(word);
            $(form).append(description);
            $(form).append(submit);
            $(form).append(skip);
            $("body").append(form);
        }
    }
    WordAnnotation.REST_URL = "RichiestaJSON";
    WordAnnotation.redirect = "wordAnnotation.jsp";
    quickstart.WordAnnotation = WordAnnotation;
    WordAnnotation["__class"] = "quickstart.WordAnnotation";
})(quickstart || (quickstart = {}));
quickstart.WordAnnotation.main(null);
