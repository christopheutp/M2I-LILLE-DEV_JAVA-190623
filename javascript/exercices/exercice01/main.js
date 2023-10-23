const NOMBRE_MYSTERE = Math.ceil(Math.random() * 100)
let entreeUtilisateur = -1
let nbEssais = 0

while (entreeUtilisateur !== NOMBRE_MYSTERE) {
    // entreeUtilisateur = parseInt(prompt("Veuillez entrer un nombre entre 1 et 100 compris :"))
    entreeUtilisateur = +prompt("Veuillez entrer un nombre entre 1 et 100 compris :")
    nbEssais++

    if (entreeUtilisateur > NOMBRE_MYSTERE) {
        alert("TROP GRAND")
    } else if (entreeUtilisateur < NOMBRE_MYSTERE) {
        alert("TROP PETIT")
    }    
}

alert(`Bravo, vous avez gagné en ${nbEssais} essai${nbEssais > 1 ? 's' : ''}`)