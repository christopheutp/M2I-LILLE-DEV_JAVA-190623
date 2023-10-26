import { sayHi } from "./other.js";
sayHi();

type MonType = string | number

let maVariable: MonType = "Valeur"
const uneConstante = "Valeur"

maVariable = "25"

type MonTuple = [number, number, string, boolean]

let monTableau: MonTuple = [14, 25, "A", true]

type TypeDuTableau = typeof monTableau

let autreTableau: TypeDuTableau = [25, 14, "Titi", false]

type RaceDeChien = "Doberman" | "Berger Allemand" | "Chihuahua"

let uneRaceDeChien: RaceDeChien = "Chihuahua"

let variableInconnue: null | string = null

let result = false

if (result) {
    variableInconnue = "Message"
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

const monTexte = 0
const uneValeur = !!monTexte

// if (!!prompt("Donnez moi du texte")) {
//     console.log(variableInconnue?.toUpperCase().toLowerCase());
// }

const autreVariable = variableInconnue?.toUpperCase()

const desNombres = [1, 2, 3, 4, 5]

const unNombe3 = desNombres.find(n => n === 3)!

console.log(unNombe3.toFixed(2));

const paragrapheElement = document.querySelector('#mon-paragraphe')!

paragrapheElement.textContent = "Toto"

const inputElement = document.querySelector('#mon-input') as HTMLInputElement

console.log(inputElement.value);

 // maVariable = 255
