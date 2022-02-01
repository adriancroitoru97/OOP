# Proiect OOP - Etapa 2 - Santa Claus is coming to ACS students

Proiect care simuleaza procesul lui Mos Craciun de oferire de
cadouri pentru copii. Spre deosebire de etapa 1, se adauga
un **niceScoreBonus**, **elfii**, dar si mai multe
**strategii de asignare a cadourilor**, pentru fiecare runda de simulare.



## Implementare

Implementarea de baza ramane la fel cu cea de la etapa 1. Se mapeaza datele din
JSON-urile de input la obiectele corespunzatoare si se contruieste
un **Database**. Se foloseste o clasa speciala, **Simulator**, care va realiza
flow-ul efectiv al programului.
In final, datele sunt transferate in fisiere JSON de output.

Clasele au fost actualizate in conformitate cu enuntul.
Astfel, clasei Child i-au fost adaugate field-urile
**niceScoreBonus** si **elf** - elful actual al copilului.

Procesul de simulare a fost actualizat prin adaugarea bonusului de cumintenie
la fiecare copil imediat dupa calcularea averageScore-ului. De data aceasta,
bugetul asignat unui copil, pe langa modalitatea initiala de calculare, poate
fi influentat si de anumiti elfi. De asemenea, procesul de asignare de cadouri
sufera mici schimbari - **strategia de distribuire a cadourilor (ordinea)**
va fi oferita in input, iar elful galben va oferi cadourile sale dupa ce
intreg procesul standard de asignare de cadouri este finalizat.



## Design

A fost pastrata structura modulara prezentata in prima etapa - clase cat mai
specializate si independente una de cealalta (ex. procesul de input/output
este separat in clase speciale). Stocarea datelor pentru un anumit an se face
in **Database**, care este actualizat la fiecare etapa. Intreg flow-ul
programului este sustinut de **Simulator**, care face legatura intre
informatiile din Database si intreg procesul de atribuire de cadouri.



## Design pattern-uri

### Singleton
A fost folosit pentru a asigura o instantiere
unica a claselor **Database** si **Simulator**.

### Factory
Instantierea **strategiilor** de calculare a average score-ului, de determinare
a ordinii de asignare a cadourilor, dar si pentru crearea obiectului
de tip **ChildVisitor** - elful care va visita obiectul visitable - Child.
Acest pattern creste modularitatea codului
si-l face usor de reutilizat ulterior.

### Strategy
Folosit atat pentru definirea strategiilor de asignare a cadourilor
(mai precis, ordinea in care copiii vor primi cadourile), dar si pentru
calcularea average score-ului unui copil in functie de varsta sa.

### Visitor
Elfii sunt considerati obiectele Visitor, iar clasa Child reprezinta
obiectul Visitable. Astfel, in functie de ce elf are asignat in anul respectiv,
fiecare copil este vizitat si sufera anumite schimbari (fie bugetul alocat lui
din anul respectiv, fie poate sa primeasca un cadou dupa ce runda efectiva de
distrubuire de cadouri s-a incheiat). Creste caracterul reutilizabil al codului
si separa algoritmii efectivi de structura pe care sunt aplicati.

### Builder
Folosita in cadrul clasei Child, intrucat aceasta contine foarte multe campuri
obligatorii, dar si optionale (campul **niceScoreBonus**, spre exemplu).
Astfel, a fost crescuta siguranta, dar si lizibilitatea codului
si posibilitatea de extindere a acestuia.



## License
[Adrian-Valeriu Croitoru](https://github.com/adriancroitoru97/)