# PROGETTO PROGRAMMAZIONE AD OGGETTI
Studenti: **Carloni Marco, Cardinali Matteo**





## Avvisi sul progetto:

 - Il dataset contiene 32 campi e 198'524 record, perciò alcune procedure (in particolare il download al primo avvio) potrebbero richiedere anche diversi minuti. 
 - In particolare, in caso si vogliano visualizzare tutti i dati, si consiglia di utilizzare **Google Chrome** anzichè browsers che prevedono la formattazione **Json** (come **Mozilla Firefox** ); Il numero di record è così elevato da non permettere la visualizzazione di essi.
 

## Avvio del progetto

 - Importare il progetto come **Progetto Gradle**.
 - Aggiungere nel build path le librerie contenute all'interno della cartella **libs**.
 




## Descrizione del progetto
- L' applicazione si occupa,una volta volta aver effettuato il download di un file csv, di parsare i dati scaricati e, tramite opportune Api rest Get/Post, di restituire in formato Json statistiche ottenute da essi.
- L’applicazione è sviluppata in java con l’utilizzo del framework **Spring**.
## Ulteriori librerie: 
- **json-simple-1.1**
Utilizzata per la manipolazione dei Json.
- **opencsv-4.6**
Utilizzata per il parsing del dataset.
-  **commons-lang3-3.9**
Necessaria ad opencsv.


## Pattern utilizzato

Un **pattern** è una soluzione progettuale generale per un problema ricorrente, ovvero un modello logico da applicare per la risoluzione di un problema che può presentarsi in diverse situazioni.
L'applicazione segue il **Pattern MVC  ("model-View-Controller")** che prevede le seguenti componenti:

 - **Model:** Fornisce i metodi per accedere ai dati utili dell'applicazione.
 - **View:** Visualizza i dati contenuti nel model e si occupa dell'interazione con utenti e 			     		    	 	agenti.
 - **Controller:** Riceve i comandi dell'utente e li attua modificando lo stato degli altri due componenti.

 
## UML

 - **Class diagram** :
 - **Sequence diagram**:
 - **Use case diagram**:

# Comandi
Una volta avviato, il progetto mette a disposizione una serie di API all'indirizzo: http://127.0.0.1:8080/ 
 ## Visualizzazione di tutti i dati

- **Comando**: /data 
 - **Tipo di richiesta:** Get
 - **Descrizione:** Permette di visualizzare tutti i record contenuti nel file.
 

## Visualizzazione dei metadati
- **Comando**: /metadata 
 - **Tipo di richiesta:** Get
 - **Descrizione:** Permette di visualizzare tutti i nomi dei campi del file di partenza (sourcefield) , i corrispettivi della classe modellante(alias) e i tipi di dato (type).

## Visualizzazione statistiche
- **Comando**: /stats/{field}
 - **Tipo di richiesta:** Get
 - **Descrizione:** Inserendo un campo di tipo intero o Double, verranno restituite : 
 Nome del campo, media, deviazione standard, massimo, minimo, somma e il contatore.
 - **Esempio:** 
 [http://127.0.0.1:8080/stats/Age](http://127.0.0.1:8080/stats/Age) 
 
				"field": "Age"
				,"avg": 23.488678893629455,
				"devStd": 2.53552238440033,
				"max": 90,
				"min": 17,
				"sum": 4663043,
				"count": 198523
				



## Contatore di stringhe
- **Comando**: /count/{field}/{name}
 - **Tipo di richiesta:** Get
 - **Descrizione:** Inserendo un campo di tipo stringa (field) seguito dal valore desiderato (name), verranno restituite : 
 Nome del campo e in quanti record il campo "field" ha valore pari a "name".
 - **Esempio:** 
 [http://127.0.0.1:8080/count/homeInstitution/UK NEWCAST01](http://127.0.0.1:8080/count/homeInstitution/UK%20NEWCAST01)
 
				"field": "homeInstitution",
				"count": 237



# Visualizzazione dati filtrati
Il progetto mette a disposizione dell'utente un elenco di filtri che permettono di visualizzare soltanto i dati che soddisfano certi requisiti.
- **Comando**: /filter/data
 - **Tipo di richiesta:** Post
 
| **Operatore**|**Descrizione**|**Tipi permessi** |
|--|--|--|
| $gt |Maggiore    | Intero, double |
| $it  |Minore  | Intero, double |
| $in | In  | Stringa/stringhe |
| $nin | Not in |Stringa/stringhe   |
- **Sintassi body - Conditional filters**

{"field"{"filter":value}}
**Esempio filtro: maggiore**
Visualizzo i record con studenti con un'età superiore a 85 anni.
{"age"{"$gt":85}}
      
        "homeInstitution": "D  BERLIN06",
        "countryHome": "DE",
        "age": 90,
        "sex": "M",
        "nationality": "DE",
        "subjectArea": "340",
        "levelStudy": "1",
        "yearsPrior": 1,
        "mobilityType": "S",
        "hostInstitution": "UK CHELMSF01",
        "countryHost": "UK",
        "workPlacement": "",
        "countryWP": "",
        "enterpriseSize": " ",
        "typeWorkSector": " ",
        "studyLenght": 9,
        "workLenght": 0,
        "shortDuration": " ",
        "studyStartDate": "09-2008",
        "workStartDate": "",
        "consortiumAgreementNumber": "",
        "totalCredits": 60,
        "sevSupplement": 0,
        "taughtHostLang": true,
        "languageTaught": "EN",
        "lingPreparation": "HM",
        "studyGrant": 1741.95,
        "workGrant": 0,
        "previousPartecipation": "N",
        "qualificationHost": "D",
        "ectscreditStudy": 60,
        "ectscreditWork": 0
**Esempio filtro: minore**
Visualizzo i record con studenti minorenni.
{"age"{"$it":18}}
   
   
        "homeInstitution": "E  TORRELA01",
        "countryHome": "ES",
        "age": 17,
        "sex": "M",
        "nationality": "ES",
        "subjectArea": "862",
        "levelStudy": "S",
        "yearsPrior": 2,
        "mobilityType": "P",
        "hostInstitution": "",
        "countryHost": "",
        "workPlacement": "FAIRTHORNE MANOR",
        "countryWP": "UK",
        "enterpriseSize": "S",
        "typeWorkSector": "S",
        "studyLenght": 0,
        "workLenght": 3.25,
        "shortDuration": " ",
        "studyStartDate": "",
        "workStartDate": "04-2009",
        "consortiumAgreementNumber": "ES/08/PAP-ERA/CON/17",
        "totalCredits": 0,
        "sevSupplement": 0,
        "taughtHostLang": true,
        "languageTaught": "EN",
        "lingPreparation": "HM",
        "studyGrant": 0,
        "workGrant": 1154.46,
        "previousPartecipation": "N",
        "qualificationHost": "N",
        "ectscreditStudy": 0,
        "ectscreditWork": 0
 .
    
        "homeInstitution": "I  VENEZIA01",
        "countryHome": "IT",
        "age": 17,
        "sex": "M",
        "nationality": "IT",
        "subjectArea": "226",
        "levelStudy": "1",
        "yearsPrior": 2,
        "mobilityType": "S",
        "hostInstitution": "F  PARIS004",
        "countryHost": "FR",
        "workPlacement": "",
        "countryWP": "",
        "enterpriseSize": " ",
        "typeWorkSector": " ",
        "studyLenght": 9,
        "workLenght": 0,
        "shortDuration": " ",
        "studyStartDate": "09-2008",
        "workStartDate": "",
        "consortiumAgreementNumber": "",
        "totalCredits": 0,
        "sevSupplement": 0,
        "taughtHostLang": true,
        "languageTaught": "FR",
        "lingPreparation": "NN",
        "studyGrant": 1800,
        "workGrant": 0,
        "previousPartecipation": "N",
        "qualificationHost": "N",
        "ectscreditStudy": 0,
        "ectscreditWork": 0
        
   - **Sintassi body - Logical filters**
   
   {"field"{"filter":["value1","value2"...]}}
   **Esempio filtro: in**
Visualizzo i record in cui il valore del campo "hostInstitution" è uguale ad uno dei valori passati nel filtro.
Qui di seguito sono riportati solo due dei vari record:
{"hostInstitution"{"$in":["UK LONDON067","F  STRASBO01"]}}


	{
        "homeInstitution": "A  KUFSTEI01",
        "countryHome": "AT",
        "age": 26,
        "sex": "M",
        "nationality": "AT",
        "subjectArea": "349",
        "levelStudy": "2",
        "yearsPrior": 2,
        "mobilityType": "S",
        "hostInstitution": "UK LONDON067",
        "countryHost": "UK",
        "workPlacement": "",
        "countryWP": "",
        "enterpriseSize": " ",
        "typeWorkSector": " ",
        "studyLenght": 8,
        "workLenght": 0,
        "shortDuration": " ",
        "studyStartDate": "09-2008",
        "workStartDate": "",
        "consortiumAgreementNumber": "",
        "totalCredits": 30,
        "sevSupplement": 0,
        "taughtHostLang": true,
        "languageTaught": "EN",
        "lingPreparation": "NN",
        "studyGrant": 0,
        "workGrant": 0,
        "previousPartecipation": "N",
        "qualificationHost": "N",
        "ectscreditStudy": 30,
        "ectscreditWork": 0
        }
 .

		{
        "homeInstitution": "A  GRAZ01",
        "countryHome": "AT",
        "age": 26,
        "sex": "M",
        "nationality": "AT",
        "subjectArea": "443",
        "levelStudy": "2",
        "yearsPrior": 5,
        "mobilityType": "S",
        "hostInstitution": "F  STRASBO01",
        "countryHost": "FR",
        "workPlacement": "",
        "countryWP": "",
        "enterpriseSize": " ",
        "typeWorkSector": " ",
        "studyLenght": 9,
        "workLenght": 0,
        "shortDuration": " ",
        "studyStartDate": "09-2008",
        "workStartDate": "",
        "consortiumAgreementNumber": "",
        "totalCredits": 27,
        "sevSupplement": 0,
        "taughtHostLang": true,
        "languageTaught": "FR",
        "lingPreparation": "HS",
        "studyGrant": 1800,
        "workGrant": 0,
        "previousPartecipation": "N",
        "qualificationHost": "N",
        "ectscreditStudy": 27,
        "ectscreditWork": 0
    }

   **Esempio filtro: not in**
Visualizzo i record in cui il valore del campo "consortiumAgreementNumber" non è uguale a nemmeno uno dei valori passati nel filtro.
Qui di seguito è riportato solo uno dei vari record:
{"consortiumAgreementNumber": {"$nin": ["","DE CP10","DE CP14","CONS-CRP"]}}
***ATTENZIONE:*** E' stato scelto questo particolare esempio in quanto il risultato dell'applicazione di questo particolare filtro con i rispettivi parametri dà come risultato un elenco di "ErasmusData" abbastanza ristretto da non dare problemi.

	{
        "homeInstitution": "A  WIEN03",
        "countryHome": "AT",
        "age": 28,
        "sex": "M",
        "nationality": "AT",
        "subjectArea": "629",
        "levelStudy": "2",
        "yearsPrior": 2,
        "mobilityType": "P",
        "hostInstitution": "",
        "countryHost": "",
        "workPlacement": "UNITED NATIONS DEVELOPMENT PROGRAMME BRATISLAVA REGIONAL CENTRE (EUROPE & CIS)",
        "countryWP": "SK",
        "enterpriseSize": "M",
        "typeWorkSector": "A",
        "studyLenght": 0,
        "workLenght": 6,
        "shortDuration": " ",
        "studyStartDate": "",
        "workStartDate": "06-2008",
        "consortiumAgreementNumber": "250308",
        "totalCredits": 0,
        "sevSupplement": 0,
        "taughtHostLang": false,
        "languageTaught": "EN",
        "lingPreparation": "NN",
        "studyGrant": 0,
        "workGrant": 1500,
        "previousPartecipation": "N",
        "qualificationHost": "N",
        "ectscreditStudy": 0,
        "ectscreditWork": 0
    }



