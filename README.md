
# fabbricasemantica_lucas
Questo progetto ha l’obiettivo di creare una piattaforma collaborativa di annotazione e validazione di dati linguistici e visuali.
L'utente una volta essersi registrato ed effetuato il login potra accedere alla home dove verranno visualizzate diverse pagine coinvolte
nell'interazione con l'utente, quest'ultimo potrà effettuare diverse operazioni 
(come annotazioni, scelta di qualche preferenza in un catalogo predisposto, validazione di un dato...)
le quali, una volta terminate, verranno salvate in un database. 

Lato front-end, ovvero per quanto riguarda la componente che si occupa di presentare le pagine all’utente,
viene fatto uso di JSweet, una libreria per la creazione di pagine HTML a partire da codice Java e che permette di integrare al suo interno anche JavaScript e JQuery. 
tutte le interfacce delle pagine, implementate tramite JSweet, si trovano nella Directory /fabbricasemantica/ con estensione .java ( es LogIn.java, SenseValidation.java...)
le relative pagine HTML, le quali contengo solo una riga di codice che rappresenta il link alle relative pagine implementate poi in Java (es. <script type="text/javascript" src="js/DefinitionAnnotation.js">), si trovano nella Directory /fabbricasemantica/WebContent 

La componente back-end fornisce all’utente i dati per i task di annotazione e validazione e gestisce i dati ricevuti dall’utente
e li salva. Questa componente gestisce anche le sessioni degli utenti assicurandosi che un utente,
una volta effettuato l’accesso alla piattaforma, resti autenticato fino al logout.
L’accesso alle pagine di annotazione e validazione sarà quindi consentito ai soli utenti autenticati.
tutti i file relativi al backend : gestione database, connessione server, gestione dati degli utenti si trova nel percorso -> src/it/uniroma1/fabbricasemantica/servlet

Infine, nella directory src/it/uniroma1/fabbricasemantica/data si trova l'implementazione del Data Provider il quale fa uso della libreria net.sf.extjwnl.data...le pagine Words.Java e WordProvider.Java contengono rispettivamente la selezione di un dizionario di parole e la loro gestione(le specifiche di ogni metodo vengono descritte nei commenti del codice)
