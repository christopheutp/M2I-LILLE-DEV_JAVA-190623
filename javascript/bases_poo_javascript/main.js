// CLASSES EN JAVASCRIPT

class Person {
    constructor(firstname, lastname) {
        this.firstname = firstname
        this.lastname = lastname
    }

    direBonjour () {
        console.log(`Bonjour je m'appelle ${this.firstname} ${this.lastname}`);
    }
}

let john = new Person("John", "DUPONT")
john.age = 25
// john['age'] = 25

// let monNomAttribute = prompt("Nom d'attribut ?")
// let laValeur = prompt("La valeur ?")

// john[monNomAttribute] = laValeur

console.log(john);

john.direBonjour()

let firstname = "John"
let lastname = "DUPONT"

const monObject = {
    firstname,
    lastname
}
// console.log(john.age);


// Pour lancer un dé de nombre de face X :
const rollDice = (diceValue) => Math.ceil(Math.random() * diceValue)

console.log(rollDice(20));