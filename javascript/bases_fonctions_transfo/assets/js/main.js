const users = [
    {
        firstname: "John",
        lastname: "DUPONT",
        age: 21
    },
    {
        firstname: "Maria",
        lastname: "DUPONT",
        age: 32
    },
    {
        firstname: "Chloée",
        lastname: "SMITH",
        age: 14
    },
    {
        firstname: "Martha",
        lastname: "GOMEZ", 
        age: 7
    }
]

console.log(users);

function getStartsWithS (blabla) {
    return blabla.startsWith("S")
}

/* Fonction FIND pour trouver parmi un listing un élément donné 
    demande en paramètre une fonction retournant un booléen et qui 
    recevra en paramètre un à un les éléments d'un itérable */

const userAvecNomCommencantParS = users.find(element => element.lastname.startsWith("S"))

console.log(userAvecNomCommencantParS);

/*
    Fonction MAP pour transformer un itérable en un autre itérable
    
    Va parcourir un par un les éléments d'un itérable et va récupérer le retour
    de sorte à constituer un nouvel itérable de même taille que le précédent
    et comportant les résultats de la transformation
*/

const tabNombre = [1, 2, 3, 4, 5]
const carreNombres = tabNombre.map(nombre => nombre * nombre)
console.log(carreNombres);

/*
    Fonction FOREACH pour parcourir chaque élément d'un itérable et 
    réaliser des instructions basées sur chaque élément
*/

// for (const element of users) {
//     console.log(element);
// }

const liUsers = users.map(element => {
    const newLI = document.createElement('li')
    newLI.textContent = element.firstname

    return newLI
}).forEach(liElement => {
    document.querySelector('ul#mon-listing').appendChild(liElement)
})

users.map(user => {
    const newTR = document.createElement('tr')
    const tdFirstname = document.createElement('td')
    const tdLastname = document.createElement('td')

    tdFirstname.textContent = user.firstname
    tdLastname.textContent = user.lastname
    newTR.appendChild(tdFirstname)
    newTR.appendChild(tdLastname)

    return newTR
}).forEach(trElement => {
    document.querySelector("table#mon-tableau > tbody").appendChild(trElement)
})

/*
    Fonction SORT pour trier les éléments d'un itérable

    Doit retourner un chiffre: 
     * Si positif, va trier par ordre croissante
     * Si négatif, va trier par ordre décroissant
     * Si 0, ne va pas trier
*/


console.log(users);

const usersSorted = users.sort((a, b) => {
    return b.age - a.age
})

console.log(usersSorted);

const today = new Date()
const yesterday = new Date(2023, 9, 23)

console.log(today.getMilliseconds() - yesterday.getMilliseconds())

/*
    Fonction REDUCE pour obtenir à partir d'un itérable une valeur provenant 
    d'une accumulation parcourant chaque élément.

    * A va valloir le premier élément de l'itérable puis 
    le résultat de l'opération d'accumulation

    * B va toujours valloir le prochain élément de l'itérable, qui 
    si undefined va stopper l'accumulation
*/

const listeNotes = [14, 15, 8, 20, 0]

const laSomme = listeNotes.reduce((a, b) => a + b)
console.log(laSomme);