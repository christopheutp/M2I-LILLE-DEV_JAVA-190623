type Person = {
    firstname: string
    lastname: string
}

type MonTuple = [number, number]

interface PersonInterface {
    firstname: string
    lastname: string
}

class PersonClass implements PersonInterface {
    firstname: string
    lastname: string
    email: string

    constructor(firstname: string, lastname: string) {
        this.firstname = firstname
        this.lastname = lastname
        this.email = "Blabla"
    }
}

// interface MonTuple [number, number]

const unObject: PersonInterface = {
    firstname: "John",
    lastname: "DUPONT"
}

const unAutreObject = new PersonClass("Maria", "DUPONT")

// A ne pas faire
function gereDesPersonnesAny (element: any) {
    console.log(element.firstname);
}

// Privilégier
function gereDesPersonnes (element: PersonInterface) {
    console.log(element.firstname);
    return element
}

// Ou
function gereDesOnSaitPasQuoi<T extends PersonInterface> (element: T) {
    console.log(element.firstname)
    return element
}

const premierRetour = gereDesPersonnes(unAutreObject)
// premierRetour.email
const monRetour = gereDesOnSaitPasQuoi(unAutreObject)
// monRetour.email

type animal = {
    name: string
    breed: string
    age?: number
}

const unChien: animal = {
    name: "Bernie",
    breed: "Chihuahua"
}

type animalAvecChampsObligatoire = Required<animal>
type animalAvecChampsNonObligatoires = Partial<animal>
type animalSansLaRace = Omit<animal, 'breed' | 'age'>

type UnRecord = Record<string, {
    firstname: string
    lastname: string
}>

const uneHashMap: UnRecord = {
    'titi': {
        firstname: "Titi",
        lastname: "DUPONT"
    },
    'toto': {
        firstname: "Toto",
        lastname: "SMITH"
    }
}

const monElement = uneHashMap['titi']

const response = await fetch("http://localhost:8080/api/blabla")
const data = await response.json()

