/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class DefinitionAnnotation {
        static main(args) {
            $(document).ready(() => {
                new DefinitionAnnotation().start();
                return null;
            });
        }
        start() {
            let word = document.createElement("label");
            let hypernym = document.createElement("label");
            let paragrafo = document.createElement("p");
            let definition = document.createElement("textarea");
            definition.name = "definition";
            definition.className = "form-control";
            definition.placeholder = "Scrivi la definizione qui...";
            definition.style.height = "200px";
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
            $.getJSON(DefinitionAnnotation.REST_URL + "?task=DEFINITION_ANNOTATION", ((paragrafo, hypernym, word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sHypernym = (json["hypernym"]);
                    word.textContent = sWord;
                    hypernym.textContent = sHypernym;
                    paragrafo.textContent = word.textContent + "-" + hypernym.textContent;
                    return null;
                };
            })(paragrafo, hypernym, word));
            let form = document.createElement("form");
            form.method = "POST";
            form.action = DefinitionAnnotation.redirect;
            $(form).append(paragrafo);
            $(form).append(definition);
            $(form).append(submit);
            $(form).append(skip);
            $("body").append(form);
        }
    }
    DefinitionAnnotation.REST_URL = "RichiestaJSON";
    DefinitionAnnotation.redirect = "definitionAnnotation.jsp";
    quickstart.DefinitionAnnotation = DefinitionAnnotation;
    DefinitionAnnotation["__class"] = "quickstart.DefinitionAnnotation";
})(quickstart || (quickstart = {}));
quickstart.DefinitionAnnotation.main(null);
