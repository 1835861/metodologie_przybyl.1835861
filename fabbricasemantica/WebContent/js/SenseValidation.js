/* Generated from Java with JSweet 2.3.0-SNAPSHOT - http://www.jsweet.org */
var quickstart;
(function (quickstart) {
    class SenseValidation {
        static main(args) {
            $(document).ready(() => {
                new SenseValidation().start();
                return null;
            });
        }
        start() {
            let form = document.createElement("form");
            form.method = "POST";
            form.action = SenseValidation.redirect;
            let divS = document.createElement("div");
            let divN = document.createElement("div");
            let word = document.createElement("label");
            let description = document.createElement("label");
            let sense = document.createElement("label");
            let paragrafo = document.createElement("p");
            let radioSi = document.createElement("input");
            radioSi.name = "radioButton";
            radioSi.type = "radio";
            radioSi.value = "Si";
            let radioNo = document.createElement("input");
            radioNo.name = "radioButton";
            radioNo.type = "radio";
            radioNo.value = "No";
            $(divS).append(radioSi, "Si");
            $(divN).append(radioNo, "No");
            let divB = document.createElement("div");
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
            $(divB).append(submit, skip);
            divB.style.paddingTop = "4px";
            $.getJSON(SenseValidation.REST_URL + "?task=SENSE_VALIDATION", ((paragrafo, description, sense, word) => {
                return (result, a, ctx) => {
                    let json = result;
                    let sWord = (json["word"]);
                    let sDescription = (json["example"]);
                    let sSense = (json["sense"]);
                    word.textContent = sWord;
                    description.textContent = sDescription;
                    sense.textContent = sSense;
                    paragrafo.textContent = word.textContent + " / " + description.textContent;
                    return null;
                };
            })(paragrafo, description, sense, word));
            sense.style.paddingTop = "5px";
            $(form).append(paragrafo);
            $(form).append(sense);
            $(form).append(divS, divN);
            $(form).append(divB);
            $("body").append(form);
        }
    }
    SenseValidation.REST_URL = "RichiestaJSON";
    SenseValidation.redirect = "senseValidation.jsp";
    quickstart.SenseValidation = SenseValidation;
    SenseValidation["__class"] = "quickstart.SenseValidation";
})(quickstart || (quickstart = {}));
quickstart.SenseValidation.main(null);
