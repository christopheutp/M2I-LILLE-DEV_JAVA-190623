
/*
    Pour afficher des messages en console, on se sert de la fonction console.log()
*/

console.log("Je suis une phrase");
console.log('Je suis aussi une phrase');


/* 
    Pour créer une variable, on a:

    nomVariable = valeur // Pour créer une variable globale
    var nomVariable = valeur // Pour créer une variable de script

    let maVariable = valeur // Pour créer une variable normale
    const MA_VARIABLE = valeur // Pour créer une constante
*/

// var maVariable = "Hole" // Ancienne méthode

let maVariable = 255
const MA_CONSTANTE = "Valeur"

// MA_CONSTANTE = "truc" // Impossible car constannte

// maVariable2 = "Hole" // Pas à faire

console.log(maVariable);

/*
    Pour discuter avec l'utilisateur, on a:

    alert(message) // Pour afficher un message

    confirm(message) // Pour obtenir une valeur booléenne

    prompt(message) // Pour obtenir une valeur textuelle
*/

// alert("Bonjour")

// let maValeur = confirm("Etes-vous sûr ?")

// alert("Vous avez choisi " + maValeur)

// let monPrenom = prompt("Quel est votre prénom ?")

// let monNombre = 125

// console.log(typeof monNombre);

// alert("Bonjour " + monPrenom)

let monNombreA = 25
let monNombreB = 10

console.log(monNombreA + monNombreB); // Addition
console.log(monNombreA - monNombreB); // Soustraction
console.log(monNombreA * monNombreB); // Multiplication
console.log(monNombreA / monNombreB); // Division
console.log(monNombreA % monNombreB); // Modulo
console.log(monNombreA ** monNombreB); // Puissance

console.log(monNombreA > monNombreB); // Supériorité stricte
console.log(monNombreA < monNombreB); // Infériorité stricte
console.log(monNombreA >= monNombreB); // Supériorité non stricte
console.log(monNombreA <= monNombreB); // Infériorité non stricte
console.log(monNombreA == monNombreB); // Egalité
console.log(monNombreA != monNombreB); // Différence

console.log(25 === '25'); // Egalité avec typage
console.log(25 !== '25'); // Différence avec typage

console.log('Ma phrase' == 'Ma phrase'); // 'string' est un primitif en Javascript

/*
    Pour les tables de vérité, on a les opérateurs logiques classiques
*/

// AND : &&

console.log(21 > 18 && 'Toto' != 'Titi');
console.log(21 < 18 && 'Toto' != 'Titi');

// OR: ||

console.log(21 > 18 || 'Toto' != 'Titi');
console.log(21 < 18 || 'Toto' != 'Titi');

// NOT: !

console.log(!(25 > 18));
console.log(!true);

// Le ternaire : <condition> ? <valeur si vrai> : <valeur si faux>

let sonAge = 25
let leTexte = sonAge >= 21 ? 'USA' : sonAge >= 18 ? 'France' :'Nulle part'

console.log('Il est majeur en ' + leTexte);

// Le si-null (null coarsing operator) pour avoir des valeurs par défaut

/*
    <valeur si présente> ?? <valeur par défaut>
*/

let maVariableTestee = null

let maValeur = maVariableTestee ?? 'Truc'

console.log(maValeur);

// Protection contre undefined : ?.

/* 
    <variable potentiellement undefined>?.<attribut ou méthode de l'élément>
*/

let monTexte = undefined

console.log(monTexte?.toUpperCase());

// STRUCTURES DE CONTROLE

// IF...ELSE IF....ELSE

let unAge = 25

if (unAge >= 21) {
    console.log("Il est majeur aux USA");
} else if (unAge >= 18) {
    console.log("Il est majeur en France");
} else {
    console.log("Il est mineur en France et aux USA");
}

// SWITCH...CASE...

let uneReponse = "D"

switch (uneReponse) {
    case "A":
        console.log("Vous avez choisi la réponse A");
        break;
    
    case "B":
        console.log("Vous avez choisi la réponse B");
        break;
    
    case "C":
            console.log("Vous avez choisi la réponse C");
            break;

    case "D":
        console.log("Vous avez choisi la réponse D");
        break;

    default:
        console.log("Vous avez choisi autre chose");
        break;
}

// Boucle FOR

// for (let i = 1; i <= 10; i++) {
//     console.log(i + "ème itération");
// }

// DO...WHILE...

// let monNom = ""

// do {
//     monNom = prompt("Veuillez entrer votre nom:")
// } while (monNom == "");

// WHILE...

// let unNombre = 0

// while (unNombre <= 0) {
//     unNombre = prompt("Veuillez entrer un nombre strictement positif:")
// }

/*
    Boucles d'affichage
*/

// FOR...OF...

const MON_TEXTE = "ABCDEFGHIJ"

for(const lettre of MON_TEXTE) {
    console.log(lettre);
}

// LES ARRAYS

/*
    Creation d'un array: let / const nomArray = [ ... valeurs de base ]

    Attention: Pas de typage non plus sur les tableaux, qui peuvent contenir tout type de variables
*/

let monTableau = [1, "Blabla", true, [1, 2, 3]]

// Un Array est itérable

for (const element of monTableau) {
    console.log(element);
}

// Ajout en fin d'Array
monTableau.push("Nouvel élément")

// Ajout en début d'Array
monTableau.unshift("Encore un")

console.log(monTableau);

// Retrait en fin d'Array
monTableau.pop()

console.log(monTableau);

// Retrait en début d'Array
monTableau.shift()

// SPREAD OPERATOR : ...

console.log(monTableau);

let tabA = [1, 2, 3]
let tabB = [4, 5, 6]

let result = [...tabA, ...tabB] // [1, 2, 3, 4, 5, 6]
console.log(result);

let autreTab = [...result, 7, 8, 9]
console.log(autreTab);

// DECONSTRUCTING

let [premierElement, secondElement, ...leReste] = autreTab

console.log(premierElement);
console.log(secondElement);
console.log(leReste);

// INVERSER DEUX VARIABLES VIA CONSTRUCTING / DECONSTRUCTING

let variableA = 25
let variableB = 12

console.log(variableA);
console.log(variableB);

[variableA, variableB] = [variableB, variableA]

console.log(variableA);
console.log(variableB);

// FONCTIONS

function sansParam() {
    console.log("Sans params");
}

function avecParam(param) {
    console.log("Avec paramètre :" + param);
}

function avecRetour() {
    return "Hello"
}

function addition(nbA, nbB) {
    return nbA + nbB
}

// Fonctions constantes multi-lignes

const maFonctionConstante = (a, b) => {
    console.log("je débute ma fonction");
    return a - b;
}

// Fonction constantes mono-ligne

const maSoustraction = (a, b) => a - b

console.log(maFonctionConstante(10, 2));

console.log(addition(1, 2));
console.log(addition("Truc", 25));

const mesPrenoms = [
    "Albert", "Bernard", "Chloée", "Elliot", "Babar"
]

console.log(mesPrenoms.find((prenom) => prenom.startsWith("B")));

// POUR EVITER DE FAIRE X FONCTIONS...

// function monAddition(a, b) { 
//     // Autant de code qu'on veut
//     return a + b
// }

// function maSoustraction(a, b) {
//     // Autant de code qu'on veut
//     return a - b
// }


/*
    Pour éviter de faire X fonction ayant le même code en commun, on peut créer une fonction qui va posséder le code en commun et ensuite retourner le retour d'une fonction dans son corps. 

    De la sorte, on met en commun un bloc de code tout en gardant la fonctionnalité spécifique
*/

function monOperation(a, b, operation) {
    // Autant de code qu'on veut
    console.log("Je fais une operation");
    return operation(a, b)
}

console.log(monOperation(4, 6, (a , b) => a + b));