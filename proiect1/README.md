# Proiect OOP - Etapa 1 - Santa Claus is coming to ACS students

Proiect care simuleaza procesul lui Mos Craciun
de oferire de cadouri pentru copii.


## Implementare

Se incepe prin citirea datelor din fisierele JSON de intrare. Aceste date sunt
incarcate in clase speciale de input, care vor fi, in final, reunite sub
o singura clasa, **Input**. Aceasta contine atat datele din
database-ul initial, cat si schimbarile ce vor aparea pe toti anii
pe care se va realiza simularea.

Se incarca datele primite in **Database** si se porneste simularea
propriu-zisa, folosindu-se clasa speciala **Simulator**. Algoritmul este
acelasi, indiferent de anul simularii pentru care se aplica. Astfel, flow-ul
programului este de a actualiza in fiecare an database-ul cu noile informatii
primite, iar apoi de a rula simularea efectiva.

Dupa fiecare an simulat, o lista cu toti copiii este salvata sub forma unei
intrari dintr-o lista ce va contine, in final, listele de copii din fiecare an.
Clasa speciala **Writer** este folosita pentru salvarea informatiilor
ce in final vor fi printate in fisiere JSON de output.


## Design

### Database
Clasa de tip **Singleton** ce contine toate datele necesare flow-ului
programului - bugetul mosului, lista de copii si lista de cadouri.
Database-ul este unic si specific unui anumit an, el actualizandu-se in
fiecare an in functie de schimbarile primite in teste.

### Simulator
Clasa de tip **Singleton** care simuleaza flow-ul efectiv al programului.
Inainte de simularea pentru fiecare an, se incepe prin a se actualiza
database-ul in functie de schimbarile anuale primite in input.

### Tests
Clasa folosita pentru parsarea fiecarui test, incarcarea datelor in database,
simularea propriu-zisa, dar si scrierea datelor in fisiere JSON de output.

### Input&Writer
Clase folosite pentru citirea/scrierea informatiilor din/in fisiere JSON.
Atat citirea, cat si scrierea s-au facut cu ajutorul librariei **Jackson**, dar
si cu clase specializate de in/out.
Acest lucru s-a preferat pentru a spori safety-ul intregului proiect.


## Design pattern-uri
Pe langa design pattern-ul **Singleton**, care a fost folosit pentru a asigura
unicitatea claselor Database si Simulator, s-a optat (pentru calcularea Average
Score-ului aferent fiecarui copil) la utilizarea **Strategy Pattern**. Astfel,
pentru fiecare tip de copil exista o strategie de calculare a scorului.
Pentru a creste modularitatea codului si a-l face cat mai usor de reutilizat,
s-a folosit **Factory Pattern** pentru crearea strategiei corespunzatoare.


## License
[Adrian-Valeriu Croitoru](https://github.com/adriancroitoru97/)
