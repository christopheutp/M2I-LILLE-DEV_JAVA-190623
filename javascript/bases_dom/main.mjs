/*
    Pour séparer notre code en plusieurs parties, on va avoir recourt en Javascript à des modules.

    export default NomElement // Pour exporter un élément par défaut
    export { ElementA, ElementB } // Pour exporter X éléments importables à souhaite à l'avenir

    Les modules vont exporter des choses, soit via des exports par défaut (un seul), soit via des export sous la forme d'objet composé d'X éléments, soit les deux (un export par défaut + X exports dans un objet )

    La récupération passera par plusieurs syntaxes:

    import NomElement from './chemin/vers/script.js' pour importer l'export par défaut
    import { NomElementA, NomElementB } from './chemin/vers/script.js' pour importer les X éléments de l'export sous forme d'objet
    import * as NomRegroupement from './chemin/vers/script.js' pour importer tous les éléments de l'export sous forme d'objet possédant les valeurs exportées en tant que propriétés
*/

import Person from './Person.js'

/*
    Pour obtenir en Javascript les éléments HTML de notre page, on va se servir du DOM (Document Object Model)

    Ce DOM est une version abstraite de notre page HTML, une sorte de mirroir en objets Javascript en quelque sorte.

    Pour piocher dedans, on a plusieurs façon: 

    * document.getElementByName() pour obtenir les éléments d'un nom de balise
    * document.getElementByClassName() pour obtenir les éléments à partir d'une classe
    * document.getElementById() pour obtenir un élément avec son ID
    
    * document.querySelector() pour obtenir un élément (le premier) correspondant à un sélecteur CSS
    * document.querySelectorAll() pour obtenir les éléments correspondant à un sélecteur CSS  

*/

const monH1 = document.querySelector('main > h1')
const monParagraphe = document.querySelector("p#cet-id")
const monBouton = document.querySelector('button')
const maListe = document.querySelector("#ma-liste")

let monCompteur = 1

// Les Evenements

/*
    Une fois recéptionnés dans le Javascript, les éléments du DOM peuvent être manipulés. Par exemple, on peut leur ajouter des fonction qui se déclencheront à la levée de tel ou tel evènement du Navigateur pour cet élément HTML  particulier. En fonction de si on a besoin de récupérer l'évènement ou pas, on va, dans notre fonction fléchée, demander un paramètre ou non (ce premier paramètre sera forcément l'évènement levé par le navigateur)
*/

monBouton.addEventListener('click', () => {

    /*
        Création et ajout d'élément à notre page

        Via les méthode de document, il est possible de créer des version abstraites d'éléments HTML, pour par la suite les ajouter réellement au rendu du navigateur. Pour cela, on va passer par 

        document.createElement(typeElement) pour créer un objet Javascript de tel élément HTML donné

        document.appendChild(elementAbstrait) pour ajouter en fin d'une balise ouvrante / fermante l'élément donné
    */
    const unLI = document.createElement('li')
    const valeurCompteur = monCompteur++
    unLI.textContent = `Element n°${valeurCompteur}`
    unLI.addEventListener('click', () => {
        console.log("On a cliqué sur l'élément n° " + valeurCompteur);
    })
    maListe.appendChild(unLI)
})


const monFormulaire = document.querySelector('form')

const firstnameInput = document.querySelector('input#firstname')

firstnameInput.addEventListener('input', (event) => {
    console.log(event.target.value);
})

monFormulaire.addEventListener('submit', (event) => {
    event.preventDefault()
    console.log(event);
    const nouvellePersonne = new Person(
        document.querySelector('input#firstname').value, 
        document.querySelector('input#lastname').value
        )
    console.log(nouvellePersonne);
})