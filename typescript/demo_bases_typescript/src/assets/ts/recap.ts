let unAge = 25

if (unAge >= 21) {
    console.log("Il est majeur aux USA");
} else if (unAge >= 18) {
    console.log("Il est majeur en France");
} else {
    console.log("Il est mineur en France et aux USA");
}

let laReponse = "A"

switch(laReponse) {
    case "A": 
        console.log("Vous avez choisi A");
        break;
    case "B":
        console.log("Vous avez choisi B");
        break;
    case "C":
        console.log("Vous avez choisi C");
        break;
    case "D":
        console.log("Vous avez choisi D");
        break;
    default:
        console.log("je n'ai pas compris");
        break;
}

for (let i = 0; i < 10; i++) {
    console.log("Je me répète");
}

const desPrenoms = ["John", "Michel", "Albert"]

for (let index = 0; index < desPrenoms.length; index++) {
    const element = desPrenoms[index];
    console.log(element);
}

for (const pre of desPrenoms) {
    console.log(pre);
}

function mafonction () {
    console.log("mafonction est lancée !");
}

mafonction()

function monAddition (nbA: number, nbB: number): number {
    return nbA + nbB
}

const monAdditionVariable = (nbA: number, nbB: number): number => {
    return nbA + nbB
}

type TypeDeFonctionAddition = typeof monAdditionVariable

const monOperation = (nbA: number, nbB: number, quelCalcul: TypeDeFonctionAddition) => {
    console.log("Je fais un calcul");

    return quelCalcul(nbA, nbB)
}

const unResultat = monOperation(10, 2, monAdditionVariable)