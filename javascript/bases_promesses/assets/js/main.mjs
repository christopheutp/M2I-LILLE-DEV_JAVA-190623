let maVariable

const faitDansXSecondes = (seconds, quoiFaire) => {
    setTimeout(quoiFaire, seconds * 1000)
}

document.querySelector('button').addEventListener('click', () => {
    console.log("Du code avant");
    
    faitDansXSecondes(4, () => {
        maVariable = "Toto"

        
        faitDansXSecondes(2, () => {
            maVariable += " et Titi"
            document.querySelector('span').textContent = maVariable
        })
    })
})

/*
    Une promesse, en Javascript, est un objet permettant de traiter de l'asynchrone de par sa possibilité d'avoir trois états: 

    - Pending: C'est en court
    - Fullfilled: C'est fini et ça a marché
    - Rejected: C'est fini et ça n'a pas marché

    Pour passer d'un état de pending à un autre, on va provoquer l'éxecution de la premiere fonction ou de la deuxieme en lui passant des données
*/

// const maPromesses = new Promise((res, rej) => {
//     // Du code plus ou moins long
//     if (Math.random() >= 0.5) {
//         res("C'est bon")
//     } else {
//         rej("C'est pas bon")
//     }
// })

// console.log(maPromesses);

const maFonctionAsynchrone = (seconds) => {
    return new Promise((res, rej) => {
        setTimeout(() => {
            // Ton code métier

            if (Math.random() >= 0.5) res("C'est bon")
            else rej("C'est pas bon")
        }, seconds * 1000)
    })
} 

// console.log("Avant");

// maFonctionAsynchrone(2)
// .then(() => maFonctionAsynchrone(1))
// .then(result => console.log(result))
// .catch(error => console.error(error))

// console.log("Après");


async function maFonction() {
    console.log("Avant");
    try {
        const result = await maFonctionAsynchrone(2)
    } catch (err) {
        console.error(err);
    }
    console.log("Après");
}

maFonction()

const maFonctionConstante = async () => {
    console.log("Avant");
    try {
        const result = await maFonctionAsynchrone(2)
    } catch (err) {
        console.error(err);
    }
    console.log("Après");
}

maFonctionConstante()

