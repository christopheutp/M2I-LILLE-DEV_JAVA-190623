import { sayHi } from "./other.js";
sayHi();
let maVariable = "Valeur";
const uneConstante = "Valeur";
maVariable = "25";
let monTableau = [14, 25, "A", true];
let autreTableau = [25, 14, "Titi", false];
let uneRaceDeChien = "Chihuahua";
let variableInconnue = null;
let result = false;
if (result) {
    variableInconnue = "Message";
}
/*
    TRUTHY values:
        * nombre != 0
        * true
        * chaine de caractère non vide
        * []
        * {}
        
    FALSY values:
        * nombre == 0
        * chaine de caractère vide
        * null
        * undefined

*/
const monTexte = 0;
const uneValeur = !!monTexte;
// if (!!prompt("Donnez moi du texte")) {
//     console.log(variableInconnue?.toUpperCase().toLowerCase());
// }
const autreVariable = variableInconnue?.toUpperCase();
const desNombres = [1, 2, 3, 4, 5];
const unNombe3 = desNombres.find(n => n === 3);
console.log(unNombe3.toFixed(2));
const paragrapheElement = document.querySelector('#mon-paragraphe');
paragrapheElement.textContent = "Toto";
const inputElement = document.querySelector('#mon-input');
console.log(inputElement.value);
const leBouton = document.querySelector('#mon-bouton');
leBouton.addEventListener('click', (event) => {
    console.log(event);
    console.log("Hello world");
});
// maVariable = 255
