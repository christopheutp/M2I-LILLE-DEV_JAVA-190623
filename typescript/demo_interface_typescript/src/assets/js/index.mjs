class PersonClass {
    firstname;
    lastname;
    email;
    constructor(firstname, lastname) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.email = "Blabla";
    }
}
// interface MonTuple [number, number]
const unObject = {
    firstname: "John",
    lastname: "DUPONT"
};
const unAutreObject = new PersonClass("Maria", "DUPONT");
// A ne pas faire
function gereDesPersonnesAny(element) {
    console.log(element.firstname);
}
// Privilégier
function gereDesPersonnes(element) {
    console.log(element.firstname);
    return element;
}
// Ou
function gereDesOnSaitPasQuoi(element) {
    console.log(element.firstname);
    return element;
}
const premierRetour = gereDesPersonnes(unAutreObject);
// premierRetour.email
const monRetour = gereDesOnSaitPasQuoi(unAutreObject);
const unChien = {
    name: "Bernie",
    breed: "Chihuahua"
};
const uneHashMap = {
    'titi': {
        firstname: "Titi",
        lastname: "DUPONT"
    },
    'toto': {
        firstname: "Toto",
        lastname: "SMITH"
    }
};
const monElement = uneHashMap['titi'];
const response = await fetch("http://localhost:8080/api/blabla");
const data = await response.json();
export {};
