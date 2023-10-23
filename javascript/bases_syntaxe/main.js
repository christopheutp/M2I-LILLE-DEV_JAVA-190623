
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

for (let i = 1; i <= 10; i++) {
    console.log(i + "ème itération");
}

// DO...WHILE...

let monNom = ""

do {
    monNom = prompt("Veuillez entrer votre nom:")
} while (monNom == "");

// WHILE...

let unNombre = 0

while (unNombre <= 0) {
    unNombre = prompt("Veuillez entrer un nombre strictement positif:")
}